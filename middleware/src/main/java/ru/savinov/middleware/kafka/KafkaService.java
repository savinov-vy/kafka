package ru.savinov.middleware.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaService {

    @KafkaListener(topics = "basket", groupId = "group_id")
    public void consume(String message) {
        System.out.println(message);
    }

}