package ru.fcahp.system.common;

import lombok.Getter;

@Getter
public enum NotificationStatus {
    CREATED("Создано"),
    ORDERED("Оформлено"),
    CLOSED("Закрыто");

    private final String caption;
    NotificationStatus(String caption) {
        this.caption = caption;
    }
}
