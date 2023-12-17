package ru.fcahp.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.fcahp.system.dto.NotificationDto;
import ru.fcahp.system.entity.Notification;
import ru.fcahp.system.mapper.NotificationMapper;
import ru.fcahp.system.service.NotificationService;

@RestController
@RequestMapping("v1/notifications")
@RequiredArgsConstructor
@Tag(name = "Уведомления", description = "Методы работы с уведомлениями")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationMapper mapper;

    @GetMapping
    @Operation(summary = "Поиск уведомлений GET запрос")
    public Page<NotificationDto> list(
            @RequestParam(name = "p", defaultValue = "1") @Parameter(description = "Номер страницы", required = true) Integer pageIndex,
            @RequestParam(name = "page_size", defaultValue = "10") @Parameter(description = "Количество 'элементов' на странице") Integer pageSize,
//            @RequestParam(required = false, name = "property") @Parameter(description = "Фильтр по ") Integer property,
//            @RequestParam(required = false, name = "title") @Parameter(description = "Фильтр названию") String title)
    {

        Specification<Notification> specification = notificationService.createSpecByFilters(property, title);
        return notificationService.getAll(specification, pageIndex, pageSize).map(mapper::toDto);
    }

    @Operation(summary = "Запрос на получение уведомления по Id")
    @GetMapping("/{id}")
    public NotificationDto findById(@PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long id) {
        return mapper.toDto(notificationService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Запрос на создание нового уведомления")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody NotificationDto dto) {
        notificationService.create(mapper.fromDto(dto));
    }

    @PutMapping
    @Operation(summary = "Запрос на обновление уведомления из списка")
    public void updateProduct(@RequestBody NotificationDto dto) {
        notificationService.update(mapper.fromDto(dto));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Запрос на удаление уведомления из списка")
    public void deleteById(@PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long id) {
        notificationService.deleteById(id);
    }
}
