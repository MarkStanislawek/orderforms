package mannafundraising.orderforms.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import mannafundraising.orderforms.OrderFormsApplicationConfig;

@Component
@Profile(OrderFormsApplicationConfig.PROFILE_STAGING)
public class S3StorageService implements StorageService {
	private Logger logger = Logger.getLogger(S3StorageService.class.getName());

	@Value("${s3.bucketName}")
	private String bucketName;
	@Value("${s3.html.keyName}")
	private String htmlKeyName;
	@Value("${s3.pdf.keyName}")
	private String pdfKeyName;
	@Value("${s3.png.keyName}")
	private String imageKeyName;

	@Override
	public void storePdf(byte[] file) {
		store("application/pdf", pdfKeyName, file);
	}

	@Override
	public void storeHtml(List<byte[]> files) {
		int pageNbr = 1;
		for (byte[] file : files) {
			store("text/html", String.format("%s-p%d.html", htmlKeyName, pageNbr++), file);
		}
	}

	@Override
	public void storeImages(List<byte[]> images) {
		int imageNbr = 1;
		for (byte[] image : images) {
			store("image/png", String.format("%s-p%d.png", imageKeyName, imageNbr++), image);
		}
	}

	private void store(String contentType, String keyName, byte[] file) {
		AmazonS3 s3client = AmazonS3ClientBuilder.standard().build();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(contentType);
		metadata.setContentLength(file.length);
		logger.info(String.format("attempting to put file with name %s to bucket %s", keyName, bucketName));
		PutObjectResult result = s3client
				.putObject(new PutObjectRequest(bucketName, keyName, new ByteArrayInputStream(file), metadata));
		logger.info(String.format("put %s (%d bytes) on bucket %s with md5: %s", keyName, file.length, bucketName,
				result.getContentMd5()));
	}
}
