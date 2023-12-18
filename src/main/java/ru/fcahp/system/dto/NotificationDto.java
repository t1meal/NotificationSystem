package ru.fcahp.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import ru.fcahp.system.common.CrossingPoint;
import ru.fcahp.system.common.NotificationStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class NotificationDto implements Serializable {

    @Schema(description = "ID сущности")
    private Long id;

    //    @NotNull(message = "aa")
    @Schema(description = "Наименование отправителя")
    private String sender;
    //
//    @NotNull(message = "aa")
//    @NotEmpty(message = "aa")
//    @NotBlank(message = "aa")
    @Schema(description = "Наименование получателя")
    private String recipient;

    @Schema(description = "Дата прибытия груза")
    private LocalDate cargoArrivalDate;

    @Schema(description = "Статус груза")
    private NotificationStatus status;

    @Schema(description = "Пункт пропуска")
    private CrossingPoint crossingPoint;

    @Schema(description = "Продукция входящая в состав груза")
    private List<ProductPackageDto> productPackages;

    @Schema(description = "Дата создания")
    private LocalDateTime created_at;

    @Schema(description = "Дополнительная информация")
    private String extraInfo;

}