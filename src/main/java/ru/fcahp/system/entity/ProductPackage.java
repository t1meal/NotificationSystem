package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Продукция */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "product")
public class ProductPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Название */
    @Column(name = "caption", nullable = false)
    private String caption;

    /** Объем продукции */
    @Column(name = "capacity", nullable = false)
    private Double capacity;

    /** Единица измерения продукции */
    @ManyToOne
    @JoinColumn(name = "metric_unit_id", nullable = false)
    private MetricUnit metricUnit;
}