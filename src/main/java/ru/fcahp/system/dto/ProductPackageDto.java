package ru.fcahp.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class ProductPackageDto implements Serializable {

    @Schema(description = "ID сущности")
    private Long id;

    @NotBlank(message = "Поле 'Название' должно быть заполнено")
    @Schema(description = "Название")
    private String caption;

    @NotBlank(message = "Поле 'Объем продукции' должно быть заполнено")
    @Schema(description = "Объем продукции")
    private Double capacity;

    @Schema(description = "Идентификатор уведомления")
    private Long notificationId;

    @NotBlank(message = "Поле 'Единицы измерения' должно быть заполнено")
    @Schema(description = "Единицы измерения")
    private ValueRef metricUnit;
}