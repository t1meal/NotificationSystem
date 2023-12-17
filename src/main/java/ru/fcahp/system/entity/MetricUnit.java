package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Единицы измерения */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "metric_units")
public class MetricUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Наименование */
    @Column(name = "caption", nullable = false)
    private String caption;
}
