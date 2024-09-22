package io.github.vicen621.redalumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    private boolean lighten;
    private List<Farola> neighbors;

    public Farola() {
        this.lighten = false;
        this.neighbors = new ArrayList<>();
    }

    /**
     * Crea la relación de vecinos entre las farolas. La relación de vecinos
     * entre las farolas es recíproca, es decir el receptor del mensaje será vecino
     * de otraFarola, al igual que otraFarola también se convertirá en vecina del
     * receptor del mensaje
     */
    public void pairWithNeighbor(Farola otraFarola) {
        this.neighbors.add(otraFarola); 
        otraFarola.getNeighbors().add(this);
    }

    /**
     * Retorna sus farolas vecinas
     */
    public List<Farola> getNeighbors() {
        return this.neighbors;
    }

    /**
     * Si la farola no está encendida, la enciende y propaga la acción.
     */
    public void turnOn() {
        if (this.isOff()) {
            this.lighten = true;
            for (Farola farola : this.neighbors)
                farola.turnOn();
        }
    }

    /*
     * Si la farola no está apagada, la apaga y propaga la acción.
     */
    public void turnOff() {
        if (this.isOn()) {
            this.lighten = false;
            for (Farola farola : this.neighbors)
                farola.turnOff();
        }
    }

    /*
     * Retorna true si la farola está encendida.
     */
    public boolean isOn() {
        return this.lighten;
    }

    public boolean isOff() {
        return !this.isOn();
    }
}
