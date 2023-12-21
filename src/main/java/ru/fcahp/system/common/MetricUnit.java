package ru.fcahp.system.common;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum MetricUnit {
    CUB_M("м3"),
    CUB_CM("cм3"),
    SQ_M("м2"),
    SQ_CM("cм2"),
    PC("шт");

    private final String caption;
    MetricUnit(String caption) {
        this.caption = caption;
    }
    public static MetricUnit fromCaption(String caption) {
        return Arrays.stream(values())
                .filter(unit -> unit.caption.equals(caption))
                .findFirst()
                .orElse(null);
    }
}
