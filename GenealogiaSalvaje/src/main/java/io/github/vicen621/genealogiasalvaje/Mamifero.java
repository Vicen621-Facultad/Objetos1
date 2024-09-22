package io.github.vicen621.genealogiasalvaje;

import java.time.LocalDate;

public class Mamifero {
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private Mamifero madre;
    private Mamifero padre;

    public Mamifero() {
        this(null);
    }

    public Mamifero(String identificador) {
        this.identificador = identificador;
        this.fechaNacimiento = LocalDate.now();
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero) {
        boolean bool = false;
        // Si la madre no es null, recorro el arbol genealogico de la madre hasta encontrar
        // La raiz del arbol (un mamifero donde ambos padres sean null)
        if (getMadre() != null)
            bool = getMadre().equals(unMamifero) || getMadre().tieneComoAncestroA(unMamifero);

        // Se entra en este if solo si el ancestro no se encontro en el arbol de la madre
        // Por eso esta la condición de !bool
        if (getPadre() != null && !bool)
            bool = getPadre().equals(unMamifero) || getPadre().tieneComoAncestroA(unMamifero);


        return bool;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getAbueloMaterno() {
        return getMadre() == null ? null : getMadre().getPadre();
    }

    public Mamifero getAbuelaMaterna() {
        return getMadre() == null ? null : getMadre().getMadre();
    }

    public Mamifero getAbueloPaterno() {
        return getPadre() == null ? null : getPadre().getPadre();
    }

    public Mamifero getAbuelaPaterna() {
        return getPadre() == null ? null : getPadre().getMadre();
    }
}
