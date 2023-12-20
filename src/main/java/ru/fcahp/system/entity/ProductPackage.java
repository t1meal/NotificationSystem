package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

/** Продукция */
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldNameConstants
@Table(name = "product_packages")
public class ProductPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** Название */
    @Column(name = "caption", nullable = false)
    private String caption;

    /** Объем продукции */
    @Column(name = "capacity", nullable = false)
    private Double capacity;

    /** Id уведомления */
    @Column(name = "notification_id", nullable = false)
    private Long notificationId;

    /** Единица измерения продукции */
    @ManyToOne
    @JoinColumn(name = "metric_unit_id", nullable = false)
    private MetricUnit metricUnit;
}