package io.github.vicen621.veterinaria;

import java.time.LocalDate;

public class DateLapseDays {

    private LocalDate from;
    private int sizeInDays;

    public DateLapseDays(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    public int sizeInDays() {
        return sizeInDays;
    }

    public boolean includesDate(LocalDate other) {
        return other.isAfter(from) && other.isBefore(from.plusDays(sizeInDays));
    }
}