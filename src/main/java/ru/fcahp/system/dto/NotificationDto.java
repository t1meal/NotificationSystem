package ru.fcahp.system.dto;

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

    private Long id;

//    @NotNull(message = "aa")
    private String sender;
//
//    @NotNull(message = "aa")
//    @NotEmpty(message = "aa")
//    @NotBlank(message = "aa")
    private String recipient;

    private LocalDate cargoArrivalDate;

    private NotificationStatus status;

    private CrossingPoint crossingPoint;

    private List<ProductPackageDto> productPackages;

    private LocalDateTime created_at;

    private String extraInfo;

}