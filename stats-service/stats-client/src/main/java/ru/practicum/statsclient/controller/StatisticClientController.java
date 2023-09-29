//package ru.practicum.statsclient.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import ru.practicum.statsclient.client.StatisticsClient;
//import ru.practicum.statsdto.RequestHitDto;
//
//import javax.validation.Valid;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static ru.practicum.statsdto.util.Constant.DATE_TIME_FORMAT;
//
//
//@Controller
//@RequiredArgsConstructor
//@Validated
//public class StatisticClientController {
//    private final StatisticsClient client;
//
//    @PostMapping("/hit")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> createHit(@RequestBody @Valid RequestHitDto hitDto) {
//        return client.postHit(hitDto);
//    }
//
//    @GetMapping("/stats")
//    public ResponseEntity<Object> getStats(@RequestParam(name = "start") @DateTimeFormat(fallbackPatterns = DATE_TIME_FORMAT) LocalDateTime start,
//                                           @RequestParam(name = "end") @DateTimeFormat(fallbackPatterns = DATE_TIME_FORMAT) LocalDateTime end,
//                                           @RequestParam(name = "uris", required = false) List<String> uris,
//                                           @RequestParam(name = "unique", defaultValue = "false") boolean unique) {
//        return client.getStats(start, end, uris, unique);
//    }
//}
