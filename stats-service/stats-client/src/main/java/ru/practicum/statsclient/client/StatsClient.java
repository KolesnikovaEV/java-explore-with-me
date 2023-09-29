package ru.practicum.statsclient.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.practicum.statsdto.RequestHitDto;
import ru.practicum.statsdto.ResponseHitDto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static ru.practicum.statsdto.util.Constant.DATE_TIME_FORMATTER;

@Service
@RequiredArgsConstructor
public class StatsClient {
    @Value("${stats-server.url}")
    private String serverUrl;

    private final RestTemplate restTemplate;


    public void postHit(RequestHitDto endpointHitRequestDto) {
        restTemplate.postForLocation(serverUrl.concat("/hit"), endpointHitRequestDto);
    }

    public List<ResponseHitDto> getStats(LocalDateTime start, LocalDateTime end,
                                         List<String> uris, boolean unique) {
        Map<String, Object> parameters = new HashMap<>(Map.of(
                "start", start.format(DATE_TIME_FORMATTER),
                "end", end.format(DATE_TIME_FORMATTER),
                "unique", unique));

        if (uris != null && !uris.isEmpty()) {
            parameters.put("uris", String.join(",", uris));
        }

        ResponseHitDto[] response = restTemplate.getForObject(
                serverUrl.concat("/stats?start={start}&end={end}&uris={uris}&unique={unique}"),
                ResponseHitDto[].class, parameters);

        return Objects.isNull(response)
                ? List.of()
                : List.of(response);
    }
}

