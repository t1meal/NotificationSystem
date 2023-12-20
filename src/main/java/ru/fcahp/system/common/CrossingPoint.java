package ru.fcahp.system.common;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CrossingPoint {
    WEST("КПП Запад"),
    EAST("КПП Восток"),
    MAIN("Главный въезд"),
    NORTH("Северный блокпост");

    private final String caption;
    CrossingPoint(String caption) {
        this.caption = caption;
    }
    public static CrossingPoint fromCaption(String caption) {
        return Arrays.stream(values())
                .filter(status -> status.caption.equals(caption))
                .findFirst()
                .orElse(null);
    }
}
