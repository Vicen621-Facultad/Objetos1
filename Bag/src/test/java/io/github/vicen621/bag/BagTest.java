package io.github.vicen621.bag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagTest {
    private Bag<String> bag;

    @BeforeEach
    public void setup() {
        bag = new BagImpl<>();
    }

    @Test
    public void addTest() {
        bag.add("test");
        bag.add("test1");
        bag.add("test");

        assertEquals(2, bag.occurrencesOf("test"));
        assertEquals(1, bag.occurrencesOf("test1"));
    }

    @Test
    public void removeTest() {
        bag.add("test");
        bag.add("test");
        bag.add("test");

        bag.remove("test");
        assertEquals(2, bag.occurrencesOf("test"));
    }

    @Test
    public void removeAllTest() {
        bag.add("test");
        bag.add("test");
        bag.add("test");

        bag.removeAll("test");
        assertEquals(0, bag.occurrencesOf("test"));
    }

    @Test
    public void sizeTest() {
        bag.add("test");
        bag.add("test");
        bag.add("test1");
        bag.add("test2");
        bag.add("test3");

        assertEquals(5, bag.size());
    }
}
