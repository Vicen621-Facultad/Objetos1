package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
    private int likes;
    private boolean featured;
    private String text;

    /**
     * Permite construir una instancia del WallpostImpl.
     * Luego de la invocación, debe tener como texto: “Undefined post”,
     * no debe estar marcado como destacado y la cantidad de “Me gusta” debe ser 0.
     */
    public WallPostImpl() {
        this.likes = 0;
        this.featured = false;
        this.text = "Undefined post";
    }

    /*
     * Retorna el texto descriptivo de la publicación
     */
    @Override
    public String getText() {
        return this.text;
    }

    /*
     * Asigna el texto descriptivo de la publicación
     */
    @Override
    public void setText (String descriptionText) {
        this.text = descriptionText;
    }
    /*
     * Retorna la cantidad de “me gusta”
     */
    @Override
    public int getLikes() {
        return this.likes;
    }

    /*
     * Incrementa la cantidad de likes en uno.
     */
    @Override
    public void like() {
        this.likes++;
    }

    /*
     * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada.
     */
    @Override
    public void dislike() {
        this.likes = Math.max(0, this.likes - 1);
    }

    /*
     * Retorna true si el post está marcado como destacado, false en caso contrario
     */
    @Override
    public boolean isFeatured() {
        return this.featured;
    }

    /*
     * Cambia el post del estado destacado a no destacado y viceversa.
     */
    @Override
    public void toggleFeatured() {
        this.featured = !this.featured;
    }

    /*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}
