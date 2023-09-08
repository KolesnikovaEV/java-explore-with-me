package ru.practicum.statsclient.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.practicum.statsdto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static ru.practicum.statsdto.StatsCommonConfig.DATE_TIME_FORMATTER;

public class StatsClient extends BaseClient {

    public StatsClient(RestTemplate rest) {
        super(rest);
    }

    public ResponseEntity<Object> saveStats(StatsDto dto) {
        return post("/hit", dto);
    }

    public ResponseEntity<Object> findStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        Map<String, Object> parameters = Map.of(
                "start", start.format(DATE_TIME_FORMATTER),
                "end", end.format(DATE_TIME_FORMATTER),
                "uris", String.join(", ", uris),
                "unique", unique
        );
        return get("/stats?start={start}&end={end}&uris={uris}&unique={unique}", parameters);
    }

}