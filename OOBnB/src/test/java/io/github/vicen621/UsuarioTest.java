package io.github.vicen621;

import io.github.vicen621.datelapse.DateLapseDays;
import io.github.vicen621.policies.ModeratePolicy;
import io.github.vicen621.policies.StrictPolicy;
import io.github.vicen621.usuarios.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Usuario usuario;
    private Propiedad propiedad;

    @BeforeEach
    public void setup() {
        this.usuario = new Usuario("test", "12345678", "Test 123");
        this.propiedad = new Propiedad("Test 456", 100, "test propiedad", new StrictPolicy());
    }

    @Test
    public void test_consultar_disponibilidad() {
        propiedad.reservar(new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        ));

        assertTrue(usuario.consultarDisponibilidad(propiedad, new DateLapseDays(
                LocalDate.of(2024, 9, 1),
                7
        )));
        assertFalse(usuario.consultarDisponibilidad(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));
    }

    @Test
    public void test_reservar() {
        assertTrue(usuario.crearReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));

        assertFalse(propiedad.estaDisponible(new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));

        assertFalse(usuario.crearReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));
    }

    @Test
    public void test_cancelar_reserva_flexible_policy() {
        propiedad.reservar(new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        ));

        assertEquals(700, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));

        assertTrue(propiedad.estaDisponible(new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));

        assertEquals(-1, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));
    }

    @Test
    public void test_cancelar_reserva_strict_policy() {
        propiedad.reservar(new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        ));

        assertEquals(0, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));

        assertTrue(propiedad.estaDisponible(new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));

        assertEquals(-1, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 1),
                7
        )));
    }

    @Test
    public void test_cancelar_reserva_moderate_policy_all() {
        this.propiedad = new Propiedad("Test 456", 100, "test propiedad", new ModeratePolicy());
        propiedad.reservar(new DateLapseDays(
                LocalDate.of(2100, 11, 10),
                7
        ));

        assertEquals(700, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2100, 11, 10),
                7
        )));

        assertTrue(propiedad.estaDisponible(new DateLapseDays(
                LocalDate.of(2100, 11, 10),
                7
        )));

        assertEquals(-1, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2100, 11, 10),
                7
        )));
    }

    @Test
    public void test_cancelar_reserva_moderate_policy_50percent() {
        this.propiedad = new Propiedad("Test 456", 100, "test propiedad", new ModeratePolicy());
        propiedad.reservar(new DateLapseDays(
                LocalDate.of(2024, 10, 28),
                7
        ));

        assertEquals(350, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 28),
                7
        )));

        assertTrue(propiedad.estaDisponible(new DateLapseDays(
                LocalDate.of(2024, 10, 28),
                7
        )));

        assertEquals(-1, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 28),
                7
        )));
    }

    @Test
    public void test_cancelar_reserva_moderate_policy_0() {
        this.propiedad = new Propiedad("Test 456", 100, "test propiedad", new ModeratePolicy());
        propiedad.reservar(new DateLapseDays(
                LocalDate.of(2024, 10, 23),
                7
        ));

        assertEquals(0, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 23),
                7
        )));

        assertTrue(propiedad.estaDisponible(new DateLapseDays(
                LocalDate.of(2024, 10, 23),
                7
        )));

        assertEquals(-1, usuario.cancelarReserva(propiedad, new DateLapseDays(
                LocalDate.of(2024, 10, 23),
                7
        )));
    }
}
