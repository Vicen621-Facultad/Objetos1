package io.github.vicen621.clientecorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;

    public Email(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new ArrayList<>();
    }

    public boolean contieneTexto(String texto) {
        return this.titulo.contains(texto) || this.cuerpo.contains(texto);
    }

    public int getTamano() {
        int tamanoAdjuntos = adjuntos.stream()
                .mapToInt(Archivo::tamano)
                .sum();

        return this.titulo.length() + this.cuerpo.length() + tamanoAdjuntos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void agregarAdjunto(Archivo archivo) {
        this.adjuntos.add(archivo);
    }

    public void eliminarAdjunto(Archivo archivo) {
        this.adjuntos.remove(archivo);
    }
}
