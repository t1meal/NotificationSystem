package ru.fcahp.system.common;

import lombok.Getter;

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
}
