package ru.practicum.stats.service;


import ru.practicum.statsdto.RequestHitDto;
import ru.practicum.statsdto.ResponseHitDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {

    void createHit(RequestHitDto hitDto);

    List<ResponseHitDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);
}
