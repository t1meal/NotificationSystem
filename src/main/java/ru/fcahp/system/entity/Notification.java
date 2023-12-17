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
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** Отправитель */
    @Column(name = "sender", nullable = false)
    private String sender;

    /** Получатель */
    @Column(name = "recipient", nullable = false)
    private String recipient;

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

    /** Дополнительная информация */
    @Column(name = "extra_info", nullable = false)
    private String extraInfo;

}