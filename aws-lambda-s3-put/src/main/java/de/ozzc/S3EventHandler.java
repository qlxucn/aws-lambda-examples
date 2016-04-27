package de.ozzc;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.InputStream;
import java.net.URLDecoder;

public class S3EventHandler implements RequestHandler<S3Event, String> {

    @Override
    public String handleRequest(S3Event input, Context context) {
        LambdaLogger logger = context.getLogger();

        if (input != null) {
            if (input.getRecords() != null) {
                try {
                    for (S3EventNotification.S3EventNotificationRecord record : input.getRecords()) {
                        String srcBucket = record.getS3().getBucket().getName();
                        // Object key may have spaces or unicode non-ASCII characters.
                        String srcKey = record.getS3().getObject().getKey().replace('+', ' ');
                        srcKey = URLDecoder.decode(srcKey, "UTF-8");

                        AmazonS3 s3Client = new AmazonS3Client();
                        s3Client.setRegion(Region.getRegion(Regions.fromName(record.getAwsRegion())));
                        S3Object s3Object = s3Client.getObject(new GetObjectRequest(srcBucket, srcKey));
                        try (InputStream objectData = s3Object.getObjectContent()) {
                            PDDocument document = PDDocument.load(objectData);
                            PDDocumentInformation metadata = document.getDocumentInformation();
                            String title = metadata.getTitle();
                            if (title == null) {
                                title = "UNKNOWN TITLE";
                            }
                            String author = metadata.getAuthor();
                            if (author == null) {
                                author = "UNKNOWN AUTHOR";
                            }
                            String numberOfPages = String.valueOf(document.getNumberOfPages());
                            logger.log("Title : " + title);
                            logger.log("Author : " + author);
                            logger.log("Number of Pages : " + numberOfPages);
                        }
                    }
                    return "success";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return "failure";
    }
}
