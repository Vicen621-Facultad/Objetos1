package io.github.vicen621;

import io.github.vicen621.datelapse.DateRangeable;
import io.github.vicen621.policies.CancelationPolicy;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Propiedad {
    private String direccion;
    private double precio;
    private String nombre;
    private CancelationPolicy policy;
    // Uso un set ya que no deberia haber reservas repetidas
    private Set<Reserva> reservas;

    public Propiedad(String direccion, double precio, String nombre, CancelationPolicy policy) {
        this.direccion = direccion;
        this.precio = precio;
        this.nombre = nombre;
        this.policy = policy;
        this.reservas = new HashSet<>();
    }

    /**
     * Devuelve si la propiedad esta disponible para el rango de fechas ingresado
     * @param lapse El rango de fechas a chequear
     * @return True si la propiedad esta disponible en esas fechas, false en caso contrario
     */
    public boolean estaDisponible(DateRangeable lapse) {
        return reservas.stream()
                .noneMatch(reserva -> reserva.overlapsDates(lapse));
    }

    /**
     * Reserva la propiedad en el rango de fechas pasado
     * @param lapse Las fechas de la reserva
     * @return True si se pudo hacer la reserva, false si ya hay una reserva hecha o si no está disponible para la fecha solicitada
     */
    public boolean reservar(DateRangeable lapse) {
        if (!estaDisponible(lapse))
            return false;

        return this.reservas.add(new Reserva(this, lapse));
    }

    /**
     * Obtiene una reserva que coincida con la fecha pasada fecha pasados
     * @param lapse el rango de fechas
     * @return La reserva si la encuentra, null en caso contrario
     */
    public Reserva getReserva(DateRangeable lapse) {
        Reserva reserva = new Reserva(this, lapse);
        return reservas.stream()
                .filter(res -> res.equals(reserva))
                .findAny()
                .orElse(null);
    }

    /**
     * Cancela una reserva que coincida con la fecha pasado y retorna el monto que será reembolsado
     * @param lapse el rango de fechas
     * @return El monto a reembolsar. Devuelve -1 en caso de que el reembolso no se pueda hacer
     */
    public double cancelarReserva(DateRangeable lapse) {
        if (lapse.includesDate(LocalDate.now()))
            return -1;

        Reserva reserva = getReserva(lapse);
        if (reserva == null)
            return -1;
        this.reservas.remove(reserva);
        return policy.calcularReembolso(lapse.startDate(), reserva.calcularPrecio());
    }

    public double calcularIngresos(DateRangeable lapse) {
        return this.reservas.stream()
                .filter(reserva -> reserva.overlapsDates(lapse))
                .mapToDouble(Reserva::calcularPrecio)
                .sum();
    }

    public void setPolicy(CancelationPolicy policy) {
        this.policy = policy;
    }

    public CancelationPolicy getPolicy() {
        return policy;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
