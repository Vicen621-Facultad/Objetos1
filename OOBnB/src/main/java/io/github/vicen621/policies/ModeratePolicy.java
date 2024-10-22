package io.github.vicen621.policies;

import java.time.LocalDate;

public class ModeratePolicy implements CancelationPolicy {

    @Override
    public double calcularReembolso(LocalDate fechaInicio, double precioTotal) {
        if (LocalDate.now().isBefore(fechaInicio.minusWeeks(1))) {
            return precioTotal;
        } else if (LocalDate.now().isBefore(fechaInicio.minusDays(2))) {
            return precioTotal * 0.5;
        } else {
            return 0;
        }
    }
}
