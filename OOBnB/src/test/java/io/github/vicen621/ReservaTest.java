package io.github.vicen621;


import io.github.vicen621.datelapse.DateLapseDates;
import io.github.vicen621.datelapse.DateRangeable;
import io.github.vicen621.policies.StrictPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {
    private Reserva reserva;

    @BeforeEach
    public void setup() {
        Propiedad propiedad = new Propiedad("test 123", 100, "test", new StrictPolicy());
        DateRangeable lapse = new DateLapseDates(
                LocalDate.of(2024, 10, 21),
                LocalDate.of(2024, 10, 28)
        );
        this.reserva = new Reserva(propiedad, lapse);
    }

    @Test
    public void test_calular_precio() {
        assertEquals(700, reserva.calcularPrecio());
    }
}
