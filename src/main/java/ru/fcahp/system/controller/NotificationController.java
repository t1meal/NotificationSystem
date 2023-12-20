package ru.fcahp.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.fcahp.system.dto.NotificationDto;
import ru.fcahp.system.mapper.NotificationMapper;
import ru.fcahp.system.service.NotificationService;
@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
@RequiredArgsConstructor
@Tag(name = "Уведомления", description = "Методы работы с уведомлениями")
public class NotificationController {

    private final NotificationService service;
    private final NotificationMapper mapper;

    @GetMapping
    @Operation(summary = "Поиск уведомлений GET запрос")
    public Page<NotificationDto> list(
            @RequestParam(name = "p", defaultValue = "1") @Parameter(description = "Номер страницы", required = true) String index,
            @RequestParam(name = "page_size", defaultValue = "10") @Parameter(description = "Количество 'элементов' на странице") Integer pageSize,
            @RequestParam(required = false, name = "search_string") @Parameter(description = "Строка поиска ") String searchString)
    {
        int pageIndex = 1;
        try {
           pageIndex = Integer.parseInt(index);
            if (pageIndex < 1) {
                pageIndex = 1;
            }
        } catch (NumberFormatException e) {
            log.warn("Incorrect page index {}", index);
        }
        return service.getAll(searchString, pageIndex, pageSize).map(mapper::toDto);
    }

    @Operation(summary = "Запрос на получение уведомления по Id")
    @GetMapping("/{id}")
    public NotificationDto findById(@PathVariable @Parameter(description = "Уникальный идентификатор", required = true) Long id) {
        return mapper.toDto(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Запрос на создание нового уведомления")
    public void create(@RequestBody @Validated NotificationDto dto) {
        service.create(mapper.fromDto(dto));
    }

    @PutMapping
    @Operation(summary = "Запрос на обновление уведомления из списка")
    public void update(@RequestBody @Validated NotificationDto dto) {
        service.update(mapper.fromDto(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Запрос на удаление уведомления из списка")
    public void deleteById(@PathVariable @Parameter(description = "Уникальный идентификатор", required = true) Long id) {
        service.deleteById(id);
    }
}
