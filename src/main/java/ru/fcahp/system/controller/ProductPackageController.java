package ru.fcahp.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.fcahp.system.dto.ProductPackageDto;
import ru.fcahp.system.mapper.ProductPackageMapper;
import ru.fcahp.system.service.ProductPackageService;

@RequestMapping("/api/v1/product_packages")
@RequiredArgsConstructor
@Tag(name = "Пакет груза", description = "Методы работы с пакетами груза")
@RestController
public class ProductPackageController {

    private final ProductPackageService service;
    private final ProductPackageMapper mapper;

    @Operation(summary = "Запрос на получение продукта по Id")
    @GetMapping("/{id}")
    public ProductPackageDto findById(@PathVariable @Parameter(description = "Уникальный идентификатор", required = true) Long id) {
        return mapper.toDto(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Запрос на создание нового продукта")
    public void create(@RequestBody @Validated ProductPackageDto dto) {
        service.create(mapper.fromDto(dto));
    }

    @PutMapping
    @Operation(summary = "Запрос на обновление продукта из списка")
    public void update(@RequestBody @Validated ProductPackageDto dto) {
        service.update(mapper.fromDto(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Запрос на удаление продукта из списка")
    public void deleteById(@PathVariable @Parameter(description = "Уникальный идентификатор", required = true) Long id) {
        service.deleteById(id);
    }
}
