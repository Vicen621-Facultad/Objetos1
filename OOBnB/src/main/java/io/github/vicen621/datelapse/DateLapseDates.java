package io.github.vicen621.datelapse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DateLapseDates implements DateRangeable {
    private LocalDate from;
    private LocalDate to;

    public DateLapseDates(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public int sizeInDays() {
        return (int) from.until(to, ChronoUnit.DAYS);
    }

    public boolean includesDate(LocalDate other) {
        return other.isAfter(from) && other.isBefore(to);
    }

    @Override
    public boolean overlaps(DateRangeable another) {
        if (another instanceof DateLapseDates) {
            DateLapseDates other = (DateLapseDates) another;
            return (this.from.isBefore(other.to) || this.from.isEqual(other.to)) &&
                    (this.to.isAfter(other.from) || this.to.isEqual(other.from));
        } else if (another instanceof DateLapseDays) {
            DateLapseDays other = (DateLapseDays) another;
            LocalDate otherTo = other.getFrom().plusDays(other.sizeInDays() - 1);
            return (this.from.isBefore(otherTo) || this.from.isEqual(otherTo)) &&
                    (this.to.isAfter(other.getFrom()) || this.to.isEqual(other.getFrom()));
        }
        return false;
    }

    @Override
    public LocalDate startDate() {
        return getFrom();
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateLapseDates)) return false;
        DateLapseDates that = (DateLapseDates) o;
        return getFrom().equals(that.getFrom()) && getTo().equals(that.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo());
    }
}
