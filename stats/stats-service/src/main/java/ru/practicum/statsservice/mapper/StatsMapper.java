package ru.practicum.statsservice.mapper;

import lombok.Builder;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import ru.practicum.statsdto.StatsDto;
import ru.practicum.statsservice.model.Stats;

@UtilityClass
public class StatsMapper {

    public Stats toModel(StatsDto dto) {
        return Stats.builder()
                .app(dto.getApp())
                .ip(dto.getIp())
                .uri(dto.getUri())
                .timeStamp(dto.getTimeStamp())
                .build();
    }

}
