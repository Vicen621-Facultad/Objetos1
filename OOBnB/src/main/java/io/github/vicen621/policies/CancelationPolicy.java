package io.github.vicen621.policies;

import java.time.LocalDate;

public interface CancelationPolicy {
    /**
     * Calcula el dinero que se debe reembolsar
     * @param fechaInicio La fecha en la que inicia la reserva
     * @param precioTotal El precio total de la reserva
     * @return El dinero que se debe reembolsar
     */
    double calcularReembolso(LocalDate fechaInicio, double precioTotal);
}
