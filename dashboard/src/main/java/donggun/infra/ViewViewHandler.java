package donggun.infra;

import donggun.config.kafka.KafkaProcessor;
import donggun.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ViewViewHandler {

    @Autowired
    private ViewRepository viewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            View view = new View();
            // view 객체에 이벤트의 Value 를 set 함
            view.setId(fileUploaded.getId());
            view.setSize(fileUploaded.getSize());
            view.setName(fileUploaded.getName());
            view.setPath(fileUploaded.getPath());
            view.setIsUploaded(true);
            // view 레파지 토리에 save
            viewRepository.save(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndex_then_UPDATE_1(@Payload FileIndex fileIndex) {
        try {
            if (!fileIndex.validate()) return;
            // view 객체 조회
            Optional<View> viewOptional = viewRepository.findById(
                Long.valueOf(fileIndex.getFileid())
            );

            if (viewOptional.isPresent()) {
                View view = viewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                view.setIsIndexed(true);
                // view 레파지 토리에 save
                viewRepository.save(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProcessed_then_UPDATE_2(
        @Payload VideoProcessed videoProcessed
    ) {
        try {
            if (!videoProcessed.validate()) return;
            // view 객체 조회
            Optional<View> viewOptional = viewRepository.findById(
                Long.valueOf(videoProcessed.getFileid())
            );

            if (viewOptional.isPresent()) {
                View view = viewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                view.setVideoUrl(videoProcessed.getUrl());
                // view 레파지 토리에 save
                viewRepository.save(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
