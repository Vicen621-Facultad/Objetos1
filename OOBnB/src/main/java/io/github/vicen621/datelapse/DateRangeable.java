package io.github.vicen621.datelapse;

import java.time.LocalDate;

public interface DateRangeable {
    LocalDate startDate();
    int sizeInDays();

    /**
     * @param other fecha a comprobar
     * @return true si la fecha esta incluida en el lapso de tiempo, false en cualquier otro caso
     */
    boolean includesDate(LocalDate other);

    /**
     * @return true si el período de tiempo del receptor se superpone con el recibido por parámetro
     */
    boolean overlaps(DateRangeable another);

    boolean equals(Object other);
}
