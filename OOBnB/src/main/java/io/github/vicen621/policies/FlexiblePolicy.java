package io.github.vicen621.policies;

import io.github.vicen621.datelapse.DateRangeable;

import java.time.LocalDate;

public class FlexiblePolicy implements CancelationPolicy {

    @Override
    public double calcularReembolso(LocalDate fechaInicio, double precioTotal) {
        return precioTotal;
    }
}
