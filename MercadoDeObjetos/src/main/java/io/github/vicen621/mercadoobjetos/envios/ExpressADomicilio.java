package io.github.vicen621.mercadoobjetos.envios;

public class ExpressADomicilio implements FormaDeEnvio {
    @Override
    public double calcularEnvio(double kilometros) {
        return 0.5*kilometros;
    }
}
