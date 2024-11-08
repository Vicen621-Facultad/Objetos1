package io.github.vicen621.mercadoobjetos.envios;

public class RetirarSucursalCorreo implements FormaDeEnvio {
    @Override
    public double calcularEnvio(double kilometros) {
        return 3_000;
    }
}
