package donggun.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import donggun.config.kafka.KafkaProcessor;
import donggun.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileIndex'"
    )
    public void wheneverFileIndex_UserNoti(@Payload FileIndex fileIndex) {
        FileIndex event = fileIndex;
        System.out.println(
            "\n\n##### listener UserNoti : " + fileIndex + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VideoProcessed'"
    )
    public void wheneverVideoProcessed_UserNoti(
        @Payload VideoProcessed videoProcessed
    ) {
        VideoProcessed event = videoProcessed;
        System.out.println(
            "\n\n##### listener UserNoti : " + videoProcessed + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileUploaded'"
    )
    public void wheneverFileUploaded_UserNoti(
        @Payload FileUploaded fileUploaded
    ) {
        FileUploaded event = fileUploaded;
        System.out.println(
            "\n\n##### listener UserNoti : " + fileUploaded + "\n\n"
        );
        // Sample Logic //

    }
}
