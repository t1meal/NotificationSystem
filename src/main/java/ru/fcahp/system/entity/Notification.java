package ru.fcahp.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import ru.fcahp.system.common.CrossingPoint;
import ru.fcahp.system.common.NotificationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/** Уведомление */
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldNameConstants
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** Отправитель */
    @Column(name = "sender", nullable = false)
    private String sender;

    /** Получатель */
    @Column(name = "recipient", nullable = false)
    private String recipient;

    /** Дата получения груза */
    @Column(name = "cargo_arrival_date", nullable = false)
    private LocalDate cargoArrivalDate;

    /** Статус уведомления  */
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    /** Пункт пропуска */
    @JoinColumn(name = "crossing_point", nullable = false)
    @Enumerated(EnumType.STRING)
    private CrossingPoint crossingPoint;

    /** Продукция */
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "notification_id")
    private List<ProductPackage> productPackages;

    /** Дата создания уведомления */
    @Column(name = "created_at")
    private LocalDateTime created_at;

    /** Дополнительная информация */
    @Column(name = "extra_info")
    private String extraInfo;

}