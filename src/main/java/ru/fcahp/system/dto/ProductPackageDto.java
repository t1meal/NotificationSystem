package ru.fcahp.system.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class ProductPackageDto implements Serializable {

    private Long id;
    private String caption;
    private Double capacity;
    private ValueRef metricUnit;
}