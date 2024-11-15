package io.github.vicen621.veterinaria.servicios;

import io.github.vicen621.veterinaria.Mascota;
import io.github.vicen621.veterinaria.Veterinario;

public class Vacunacion extends Servicio {
    private Veterinario veterinario;
    private String vacuna;
    private double costoVacuna;

    public Vacunacion(Mascota mascota, Veterinario veterinario, String vacuna, double costoVacuna) {
        super(mascota);
        this.veterinario = veterinario;
        this.vacuna = vacuna;
        this.costoVacuna = costoVacuna;
    }

    /**
     * honorarios del médico veterinario que interviene
     * adicional de materiales descartables ($500).
     * adicional por atención en día domingo ($200).
     * el costo de la vacuna utilizada
     * @return
     */
    @Override
    public double calcularCosto() {
        return 500 + veterinario.getHonorariosAtencion() + costoVacuna + (fueEnDomingo() ? 200 : 0);
    }
}
