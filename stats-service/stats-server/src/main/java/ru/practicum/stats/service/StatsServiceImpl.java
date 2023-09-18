package ru.practicum.stats.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.stats.mapper.HitMapper;
import ru.practicum.stats.repository.StatsRepository;
import ru.practicum.statsdto.RequestHitDto;
import ru.practicum.statsdto.ResponseHitDto;


import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StatsServiceImpl implements StatsService {
    private final StatsRepository repository;

    @Override
    public void createHit(RequestHitDto hitDto) {
        repository.save(HitMapper.toHitEntityFromRequestHitDto(hitDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseHitDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        return repository.getStats(start, end, uris, unique);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<ResponseHitDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
//        if (unique && uris != null) {
//            return repository.findUniqueStatsWithUris(start, end, uris);
//        } else if (unique) {
//            return repository.findUniqueStatsWithoutUris(start, end);
//        } else if (uris != null) {
//            return repository.findAllStatsWithUris(start, end, uris);
//        } else {
//            return repository.findAllStatsWithoutUris(start, end);
//        }
//    }
}
