package io.github.vicen621.intervalotiempo;

import java.time.LocalDate;

public interface DateRangeable {
    int sizeInDays();
    boolean includesDate(LocalDate other);
}
