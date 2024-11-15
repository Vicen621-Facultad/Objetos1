package io.github.vicen621.veterinaria.servicios;

import io.github.vicen621.veterinaria.Mascota;
import io.github.vicen621.veterinaria.Veterinario;

public class ConsultaMedica extends Servicio {
    private Veterinario veterinario;

    public ConsultaMedica(Mascota mascota, Veterinario veterinario) {
        super(mascota);
        this.veterinario = veterinario;
    }

    /**
     * honorarios del médico veterinario que interviene
     * adicional de materiales descartables ($300).
     * adicional por atención en día domingo ($200).
     * adicional por antigüedad del médico ($100 por año de antigüedad).
     * @return el costo total
     */
    @Override
    public double calcularCosto() {
        return 500 + veterinario.getHonorariosAtencion() + (veterinario.getAntiguedad()) * 100 + (fueEnDomingo() ? 200 : 0);
    }
}
