package ru.fcahp.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.fcahp.system.dto.NotificationDto;
import ru.fcahp.system.mapper.NotificationMapper;
import ru.fcahp.system.service.NotificationService;

@RestController
@RequestMapping("v1/notifications")
@RequiredArgsConstructor
@Tag(name = "Уведомления", description = "Методы работы с уведомлениями")
public class NotificationController {

    @Autowired
    private NotificationService service;
    @Autowired
    private NotificationMapper mapper;

    @GetMapping
    @Operation(summary = "Поиск уведомлений GET запрос")
    public Page<NotificationDto> list(
            @RequestParam(name = "p", defaultValue = "1") @Parameter(description = "Номер страницы", required = true) Integer pageIndex,
            @RequestParam(name = "page_size", defaultValue = "10") @Parameter(description = "Количество 'элементов' на странице") Integer pageSize)
//            @RequestParam(required = false, name = "property") @Parameter(description = "Фильтр по ") Integer property,
//            @RequestParam(required = false, name = "title") @Parameter(description = "Фильтр названию") String title)
    {
//        Specification<Notification> specification = notificationService.createSpecByFilters(property, title);
        return service.getAll(pageIndex, pageSize).map(mapper::toDto);
    }

    @Operation(summary = "Запрос на получение уведомления по Id")
    @GetMapping("/{id}")
    public NotificationDto findById(@PathVariable @Parameter(description = "Уникальный идентификатор", required = true) Long id) {
        return mapper.toDto(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Запрос на создание нового уведомления")
    public void create(@RequestBody NotificationDto dto) {
        service.create(mapper.fromDto(dto));
    }

    @PutMapping
    @Operation(summary = "Запрос на обновление уведомления из списка")
    public void update(@RequestBody NotificationDto dto) {
        service.update(mapper.fromDto(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Запрос на удаление уведомления из списка")
    public void deleteById(@PathVariable @Parameter(description = "Уникальный идентификатор", required = true) Long id) {
        service.deleteById(id);
    }
}
