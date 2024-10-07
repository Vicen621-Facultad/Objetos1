package io.github.vicen621.clientecorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO: Hacer tests
public class ClienteDeCorreo {

    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo(Carpeta inbox) {
        this.inbox = inbox;
        this.carpetas = new ArrayList<>();
        this.carpetas.add(this.inbox);
    }

    public void recibir(Email email) {
        inbox.agregarEmail(email);
    }

    public Email buscar(String texto) {
        return carpetas.stream()
                .map(carpeta -> carpeta.buscarEmailTexto(texto))
                .filter(Objects::nonNull)
                .findFirst().orElse(null);
    }

    public int espacioOcupado() {
        return carpetas.stream()
                .mapToInt(Carpeta::getTamano)
                .sum();
    }

    public Carpeta getInbox() {
        return inbox;
    }
}
