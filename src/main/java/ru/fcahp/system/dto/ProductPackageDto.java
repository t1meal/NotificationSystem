package ru.fcahp.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class ProductPackageDto implements Serializable {

    @Schema(description = "ID сущности")
    private Long id;

    @Schema(description = "Название")
    private String caption;

    @Schema(description = "Объем продукции")
    private Double capacity;

    @Schema(description = "Единицы измерения")
    private ValueRef metricUnit;
}