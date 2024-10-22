package io.github.vicen621.usuarios;

import io.github.vicen621.Propiedad;
import io.github.vicen621.datelapse.DateRangeable;

import java.util.HashSet;
import java.util.Set;

public class Propietario extends Usuario {
    // Uso un set ya que no deberia haber propiedades repetidas
    private Set<Propiedad> propiedades;

    public Propietario(String nombre, String dni, String direccion) {
        super(nombre, dni, direccion);
        this.propiedades = new HashSet<>();
    }

    //Se debe calcular la retribución a un propietario, la cual es el 75% de la suma de precio totales de las reservas incluidas en un período específico de tiempo.
    /**
     * Calcula los ingresos del propietario en el reango de fechas ingresado
     * @param lapse El lapso en el cual calcular los ingresos
     * @return Los ingresos
     */
    public double calcularIngresos(DateRangeable lapse) {
        return this.propiedades.stream()
                .mapToDouble(propiedad -> propiedad.calcularIngresos(lapse))
                .sum();
    }
}
