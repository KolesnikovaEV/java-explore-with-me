package ru.practicum.stats.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.stats.model.HitEntity;
import ru.practicum.statsdto.RequestHitDto;


@UtilityClass
public class HitMapper {
    public HitEntity toHitEntityFromRequestHitDto(RequestHitDto hitDto) {
        return HitEntity.builder()
                .app(hitDto.getApp())
                .uri(hitDto.getUri())
                .ip(hitDto.getIp())
                .timestamp(hitDto.getTimestamp())
                .build();
    }
}
