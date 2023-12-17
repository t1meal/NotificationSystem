package ru.fcahp.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Schema(description = "ID + текстовое значение")
@FieldNameConstants
@NoArgsConstructor
public class ValueRef {

    @Schema(description = "ID сущности")
    private Long id;

    @Schema(description = "Название")
    private String caption;

}
