package ru.fcahp.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class NotificationDto implements Serializable {

    @Schema(description = "ID сущности")
    private Long id;

    @NotBlank(message = "Поле 'Отправитель' должно быть заполнено")
    @Schema(description = "Наименование отправителя")
    private String sender;

    @NotBlank(message = "Поле 'Получатель' должно быть заполнено")
    @Schema(description = "Наименование получателя")
    private String recipient;

    @NotBlank(message = "Поле 'Дата прибытия груза' должно быть заполнено")
    @Schema(description = "Дата прибытия груза")
    private LocalDate cargoArrivalDate;

    @Schema(description = "Статус груза")
    private String status;

    @Schema(description = "Пункт пропуска")
    private String crossingPoint;

    @Schema(description = "Продукция входящая в состав груза")
    private List<ProductPackageDto> productPackages;

//    @Schema(description = "Дата создания")
//    private LocalDateTime createdAt;

    @Schema(description = "Дополнительная информация")
    private String extraInfo;

}