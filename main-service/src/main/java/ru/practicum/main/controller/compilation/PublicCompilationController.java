package ru.practicum.main.controller.compilation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.main.dto.compilation.CompilationDto;
import ru.practicum.main.service.CompilationService;
import ru.practicum.main.util.OffsetBasedPageRequest;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

import static ru.practicum.main.util.Constant.PAGE_DEFAULT_FROM;
import static ru.practicum.main.util.Constant.PAGE_DEFAULT_SIZE;


@RestController
@RequestMapping("/compilations")
@RequiredArgsConstructor
@Validated
public class PublicCompilationController {
    private final CompilationService compilationService;

    @GetMapping
    public Collection<CompilationDto> getAllCompilations(@RequestParam(defaultValue = PAGE_DEFAULT_FROM) @PositiveOrZero Integer from,
                                                         @RequestParam(defaultValue = PAGE_DEFAULT_SIZE) @Positive Integer size,
                                                         @RequestParam(required = false) Boolean pinned) {
        Pageable page = new OffsetBasedPageRequest(from, size);
        return compilationService.getAllCompilations(page, pinned);
    }

    @GetMapping("/{compId}")
    public CompilationDto getCompilationById(@Positive @PathVariable Long compId) {
        return compilationService.getCompilationById(compId);
    }
}
