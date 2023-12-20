package ru.fcahp.system.common;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum NotificationStatus {
    CREATED("Создано"),
    ORDERED("Оформлено"),
    CLOSED("Закрыто");

    private final String caption;
    NotificationStatus(String caption) {
        this.caption = caption;
    }

    public static NotificationStatus fromCaption(String caption) {
        return Arrays.stream(values())
                .filter(status -> status.caption.equals(caption))
                .findFirst()
                .orElse(null);
    }
}
