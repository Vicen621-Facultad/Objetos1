package io.github.vicen621.filteredset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenNumberSetTest {
    private EvenNumberSet evenNumberSet;

    @BeforeEach
    void setUp() {
        evenNumberSet = new EvenNumberSet();
    }

    @Test
    void testAddEvenNumber() {
        evenNumberSet.add(2);
        assertEquals(evenNumberSet.size(), 1);
        evenNumberSet.add(0);
        assertEquals(evenNumberSet.size(), 2);
        evenNumberSet.add(-2);
        assertEquals(evenNumberSet.size(), 3);
    }

    @Test
    void testAddOddNumber() {
        assertThrows(IllegalArgumentException.class, () -> evenNumberSet.add(1));
        assertThrows(IllegalArgumentException.class, () -> evenNumberSet.add(-1));
    }
}
