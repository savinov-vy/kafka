package ru.savinov.producer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.savinov.producer.locations.Location;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(staticName = "of")
public class TemperatureDto {
    private int temperature;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;

    private Location location;

}