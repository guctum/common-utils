package com.uctum.common.utils.service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class FileService {

    @Value("${amazon.accessKey")
    private String amazonAccessKey;

    @Value("${amazon.secretKey}")
    private String amazonSecretKey;

    private final String bucketName = "uctum-meme-bucket";// TODO: replace with env variable instead of hard code?

    private final BasicAWSCredentials credentials = new BasicAWSCredentials(amazonAccessKey, amazonSecretKey);

    public File retrieveMemeFromBucket() {
        File memeObject = null;
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion("us-east-2")
                .build();

        try {
            S3Object s3Object = s3.getObject(bucketName, "phil swift.jpg");
            S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
            FileOutputStream fileOutputStream = new FileOutputStream(new File("phil swift.jpg"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return memeObject;
    }

    public void uploadMemeToBucket(File meme) {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        try {
            s3.putObject(bucketName, "philSwift.jpg", meme);
        } catch (AmazonS3Exception e) {
            e.getLocalizedMessage();
        }
    }
}
