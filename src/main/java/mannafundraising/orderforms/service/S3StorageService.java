package mannafundraising.orderforms.service;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import mannafundraising.orderforms.OrderFormsApplicationConfig;

@Component
@Profile(OrderFormsApplicationConfig.PROFILE_REMOTE)
public class S3StorageService implements StorageService {

	@Value("${s3.bucketName}")
	private String bucketName;
	@Value("${s3.keyName}")
	private String keyName;
	@Value("${s3.uploadFileName}")
	private String uploadFileName;

	@Override
	public boolean store(byte[] file) {
		AmazonS3 s3client = AmazonS3ClientBuilder.standard().build();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("text/html");
		metadata.setContentLength(file.length);
		s3client.putObject(new PutObjectRequest(bucketName, keyName, new ByteArrayInputStream(file), metadata));
		return true;
	}

}
