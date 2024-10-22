package io.github.vicen621.policies;

import java.time.LocalDate;

public class StrictPolicy implements CancelationPolicy {
    @Override
    public double calcularReembolso(LocalDate fechaInicio, double precioTotal) {
        return 0;
    }
}
