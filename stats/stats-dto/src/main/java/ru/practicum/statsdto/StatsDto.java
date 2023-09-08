package ru.practicum.statsdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

import static ru.practicum.statsdto.StatsCommonConfig.DATE_TIME_FORMAT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StatsDto {

    public Long id;

    @NotBlank
    public String app;

    @NotBlank
    public String uri;

    @NotBlank
    public String ip;

    @NotNull
    @PastOrPresent
    @JsonProperty("timestamp")
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    public LocalDateTime timeStamp;

}