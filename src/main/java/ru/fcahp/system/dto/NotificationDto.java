package ru.fcahp.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import ru.fcahp.system.common.NotificationStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class NotificationDto implements Serializable {

    private Long id;

//    @NotNull(message = "aaa")
    private String sender;
//
//    @NotNull(message = "aa")
//    @NotEmpty(message = "aa")
//    @NotBlank(message = "aa")
    private String recipient;

//    @NotNull
    private LocalDateTime cargoArrivalDate;

//    @NotNull
    private NotificationStatus status;

    private ValueRef crossingPoint;

    private List<ProductPackageDto> productPackages;

    private LocalDateTime created_at;

    private String extraInfo;

}