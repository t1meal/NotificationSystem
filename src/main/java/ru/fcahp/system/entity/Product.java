package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "caption", nullable = false)
    private String caption;

    @Column(name = "capacity", nullable = false)
    private Double capacity;

    @ManyToOne
    @JoinColumn(name = "metric_unit_id", nullable = false)
    private MetricUnit metricUnit;
}