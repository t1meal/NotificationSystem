package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.fcahp.system.common.NotificationStatus;

import java.time.LocalDateTime;
import java.util.List;

/** Уведомление */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Отправитель */
    @Column(name = "sender", nullable = false)
    private String sender;

    /** Получатель */
    @Column(name = "getter", nullable = false)
    private String getter;

    /** Дата получения груза */
    @Column(name = "cargo_arrival_date", nullable = false)
    private LocalDateTime cargoArrivalDate;

    /** Статус уведомления  */
    @Column(name = "status", nullable = false)
    private NotificationStatus status;

    /** Пункт пропуска */
    @ManyToOne
    @JoinColumn(name = "crossing_point_id", nullable = false)
    private CrossingPoint crossingPoint;

    /** Продукция */
    @ManyToMany
    @JoinTable(
            name = "notification_products_relations",
            joinColumns = @JoinColumn(name = "notification_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_package_id", referencedColumnName = "id")
    )
    private List<ProductPackage> productPackages;

    /** Дата создания уведомления */
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    /** Дата создания уведомления */
    @Column(name = "information", nullable = false)
    private String information;

}