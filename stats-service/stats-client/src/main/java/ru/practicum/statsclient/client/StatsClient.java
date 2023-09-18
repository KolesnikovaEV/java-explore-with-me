//package ru.practicum.statsclient.client;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.web.util.DefaultUriBuilderFactory;
//import ru.practicum.statsdto.RequestHitDto;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//
//import static ru.practicum.statsdto.util.Constant.DATE_TIME_FORMATTER;
//
//@Service
//public class StatsClient extends BaseClient {
//
//    public StatsClient(@Value("${statistics.server.address}") String serverUrl, RestTemplateBuilder builder) {
//        super(builder
//                .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
//                .requestFactory(HttpComponentsClientHttpRequestFactory::new)
//                .build());
//    }
//
//    public ResponseEntity<Object> postHit(RequestHitDto hitDto) {
//        return post("/hit", hitDto);
//    }
//
//    public ResponseEntity<Object> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
//        Map<String, Object> parameters = Map.of(
//                "start", start.format(DATE_TIME_FORMATTER),
//                "end", end.format(DATE_TIME_FORMATTER),
//                "uris", String.join(", ", uris),
//                "unique", unique
//        );
//        return get("/stats?start={start}&end={end}&uris={uris}&unique={unique}", parameters);
//    }
//}
