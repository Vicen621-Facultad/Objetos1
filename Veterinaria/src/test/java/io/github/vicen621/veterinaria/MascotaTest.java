package io.github.vicen621.veterinaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MascotaTest {
    private Mascota mascota;

    @BeforeEach
    public void setup() {
        this.mascota = new Mascota("Zeus", "gato", LocalDate.of(2022, 6, 1));
    }

    @Test
    public void calcularRecaudacionTest() {
        Veterinario veterinario = new Veterinario("Jose", LocalDate.of(2020, 10, 11), 100);
        this.mascota.registrarConsultaMedica(veterinario);
        this.mascota.registrarVacunacion(veterinario, "test", 200);
        this.mascota.registrarGuarderia(4);

        int esDomingo = LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY ? 200 : 0;

        assertEquals(500 * 3 + 300 + esDomingo * 2, mascota.calcularRecaudacion(LocalDate.now()));
    }
}
