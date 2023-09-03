package ru.practicum.statsservice.service;

import ru.practicum.statsdto.GetStatsDto;
import ru.practicum.statsdto.StatsDto;

import java.time.LocalDateTime;
import java.util.Collection;

public interface StatsService {
    void saveStats(StatsDto dto);

    Collection<GetStatsDto> findStats(LocalDateTime start, LocalDateTime end, String[] uris, boolean unique);
}
