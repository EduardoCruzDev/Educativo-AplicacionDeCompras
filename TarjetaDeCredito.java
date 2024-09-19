package org.example;

import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {


    private double saldo;
    private double limiteDeCredito;
    private List<CompraManager> productos;

    public TarjetaDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
        this.saldo = limiteDeCredito;
        this.productos = new ArrayList<>();
    }

    public boolean comprarProducto(CompraManager compraManager) {
        if(this.saldo >= compraManager.getValor()){
            this.saldo -= compraManager.getValor();
            this.productos.add(compraManager);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<CompraManager> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "El saldo de tu Tarjeta es: $" + saldo;
    }
}