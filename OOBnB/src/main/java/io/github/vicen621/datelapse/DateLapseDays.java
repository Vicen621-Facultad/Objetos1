package io.github.vicen621.datelapse;

import java.time.LocalDate;
import java.util.Objects;

public class DateLapseDays implements DateRangeable {

    private LocalDate from;
    private int sizeInDays;

    public DateLapseDays(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    @Override
    public int sizeInDays() {
        return sizeInDays;
    }

    @Override
    public boolean includesDate(LocalDate other) {
        return other.isAfter(from) && other.isBefore(from.plusDays(sizeInDays));
    }

    @Override
    public boolean overlaps(DateRangeable another) {
        LocalDate thisTo = this.from.plusDays(this.sizeInDays - 1);
        if (another instanceof DateLapseDates) {
            DateLapseDates other = (DateLapseDates) another;
            return (this.from.isBefore(other.getTo()) || this.from.isEqual(other.getTo())) &&
                    (thisTo.isAfter(other.getFrom()) || thisTo.isEqual(other.getFrom()));
        } else if (another instanceof DateLapseDays) {
            DateLapseDays other = (DateLapseDays) another;
            LocalDate otherTo = other.from.plusDays(other.sizeInDays() - 1);
            return (this.from.isBefore(otherTo) || this.from.isEqual(otherTo)) &&
                    (thisTo.isAfter(other.from) || thisTo.isEqual(other.from));
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

    public int getSizeInDays() {
        return sizeInDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateLapseDays)) return false;
        DateLapseDays that = (DateLapseDays) o;
        return getSizeInDays() == that.getSizeInDays() && getFrom().equals(that.getFrom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getSizeInDays());
    }
}
