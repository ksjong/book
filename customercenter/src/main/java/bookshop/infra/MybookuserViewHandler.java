package bookshop.infra;

import bookshop.config.kafka.KafkaProcessor;
import bookshop.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MybookuserViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MybookuserRepository mybookuserRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view 객체 생성
            Mybookuser mybookuser = new Mybookuser();
            // view 객체에 이벤트의 Value 를 set 함
            mybookuser.setUserId(ordered.getUserId());
            mybookuser.setOrderId(ordered.getId());
            mybookuser.setBookName(ordered.getBookName());
            mybookuser.setQty(ordered.getQty());
            mybookuser.setOrderDate(ordered.getOrderDate());
            mybookuser.setOrderStatus(ordered.getStatus());
            // view 레파지 토리에 save
            mybookuserRepository.save(mybookuser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_2(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
