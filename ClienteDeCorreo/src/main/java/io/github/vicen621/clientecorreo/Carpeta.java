package io.github.vicen621.clientecorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }

    public Email buscarEmailTexto(String texto) {
        return emails.stream()
                .filter(email -> email.contieneTexto(texto))
                .findFirst().orElse(null);
    }

    public int getTamano() {
        return emails.stream()
                .mapToInt(Email::getTamano)
                .sum();
    }

    public String getNombre() {
        return nombre;
    }

    public void eliminarEmail(Email email) {
        this.emails.remove(email);
    }

    public void agregarEmail(Email email) {
        this.emails.add(email);
    }

    public void mover(Email email, Carpeta destino) {
        this.eliminarEmail(email);
        destino.agregarEmail(email);
    }
}
