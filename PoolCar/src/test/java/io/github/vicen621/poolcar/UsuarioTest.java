package io.github.vicen621.poolcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Viaje viaje1;
    private Viaje viaje2;
    private Usuario usuario;

    @BeforeEach
    public void setup() {
        Vehiculo vehiculo = new Vehiculo("test desc", 5, 2009, 1_000_000);
        Conductor conductor = new Conductor("test", vehiculo);
        viaje1 = new Viaje("test", "test", 1000, LocalDate.now().minusDays(29), conductor);
        viaje2 = new Viaje("test", "test", 1000, LocalDate.now().minusDays(30), conductor);
        usuario = new Pasajero("test");
    }

    @Test
    public void testHizoViajeMenos30Dias() {
        assertFalse(usuario.hizoViajeMenos30Dias());
        usuario.agregarViaje(viaje1);
        assertFalse(usuario.hizoViajeMenos30Dias());
        usuario.agregarViaje(viaje2);
        assertTrue(usuario.hizoViajeMenos30Dias());
    }
}
