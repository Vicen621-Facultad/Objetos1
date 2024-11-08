package io.github.vicen621.poolcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasajeroTest {

    private Pasajero pasajero;
    private Viaje viaje;

    @BeforeEach
    public void setup() {
        Vehiculo vehiculo = new Vehiculo("test desc", 5, 2009, 1_000_000);
        Conductor conductor = new Conductor("test", vehiculo);
        this.pasajero = new Pasajero("test");
        this.viaje = new Viaje("test", "test", 1000, LocalDate.now(), conductor);
    }

    @Test
    public void testCalcularComisionSinViaje() {
        assertEquals(180, pasajero.calcularComision(200));
    }

    @Test
    public void testCalcularBonificacionSinViaje() {
        assertEquals(0, pasajero.calcularBonificacion());
    }

    @Test
    public void testCalcularComisionConViaje() {
        pasajero.agregarViaje(viaje);
        assertEquals(200, pasajero.calcularComision(200));
    }

    @Test
    public void testCalcularBonificacionConViaje() {
        pasajero.agregarViaje(viaje);
        assertEquals(500, pasajero.calcularBonificacion());
    }
}
