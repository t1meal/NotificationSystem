package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Пункт пропуска */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "crossing_point")
public class CrossingPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Наименование */
    @Column(name = "caption", nullable = false)
    private String caption;
}