package io.github.vicen621.usuarios;

import io.github.vicen621.Propiedad;
import io.github.vicen621.datelapse.DateRangeable;

public class Usuario {
    private String nombre;
    private String direccion;
    private String dni;

    public Usuario(String nombre, String dni, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    /**
     * Consulta la disponibilidad de una propiedad en un rango de fechas
     * @param propiedad la propiedad a verificar
     * @param lapse el rango de fechas
     * @return True si esta disponible, false en caso contrario
     */
    public boolean consultarDisponibilidad(Propiedad propiedad, DateRangeable lapse) {
        return propiedad.estaDisponible(lapse);
    }

    /**
     * Cancela una reserva y retorna el monto que será reembolsado
     * @param propiedad La propiedad en la que se hizo la reserva
     * @param lapse Las fechas en la que se hizo la reserva
     * @return  El monto a reembolsar. Devuelve -1 en caso de que el reembolso no se pueda hacer
     */
    public double cancelarReserva(Propiedad propiedad, DateRangeable lapse) {
        return propiedad.cancelarReserva(lapse);
    }

    /**
     * Crea una reserva
     * @return false si las fechas para esa propiedad estan ocupadas, true en caso contrario
     */
    public boolean crearReserva(Propiedad propiedad, DateRangeable lapse) {
        return propiedad.reservar(lapse);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }
}
