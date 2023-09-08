package ru.practicum.statsservice.service;

import ru.practicum.statsdto.GetStatsDto;
import ru.practicum.statsdto.StatsDto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface StatsService {

    void saveStats(StatsDto dto);

    Collection<GetStatsDto> findStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);

}