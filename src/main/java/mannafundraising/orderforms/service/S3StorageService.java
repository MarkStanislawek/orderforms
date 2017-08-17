package mannafundraising.orderforms.service;

import java.io.ByteArrayInputStream;

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
	@Value("${s3.keyName}")
	private String keyName;

	@Override
	public boolean store(byte[] file) {
		AmazonS3 s3client = AmazonS3ClientBuilder.standard().build();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("text/html");
		metadata.setContentLength(file.length);
		logger.info(String.format("attempting to put file with name %s to bucket %s", keyName, bucketName));
		PutObjectResult result = s3client.putObject(new PutObjectRequest(bucketName, keyName, new ByteArrayInputStream(file), metadata));
		logger.info(String.format("put %s (%d bytes) on bucket %s with md5: %s", keyName, file.length, bucketName, result.getContentMd5()));
		return true;
	}

}
