package ru.savinov.producer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.savinov.producer.dto.TemperatureDto;
import ru.savinov.producer.locations.Location;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@AllArgsConstructor
public class TemperatureService {

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    @Scheduled(fixedDelay = 2000)
    public void send() {
        TemperatureDto toHandle = TemperatureDto.of(5, LocalDateTime.now(), Location.BAIKAL);
        try {
            String toSend = objectMapper.writeValueAsString(toHandle);
            CompletableFuture<SendResult<String, String>> basket = kafkaTemplate.send("basket", toSend);
            System.out.println("Successfully send " + basket);
        } catch (Exception e) {
            log.info("Message not sent, with error: {}", e.getMessage());
        }
    }

}