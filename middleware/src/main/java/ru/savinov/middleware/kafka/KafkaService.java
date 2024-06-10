package ru.savinov.middleware.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaService {

    @KafkaListener(topics = "basket", groupId = "group_id")
    public void consume(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                        @Header(KafkaHeaders.OFFSET) long offset) {
        System.out.println(message);
        System.out.println("Partition: " + partition);
        System.out.println("Offset: " + offset);
    }

}