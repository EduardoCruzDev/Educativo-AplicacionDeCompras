package org.example;


import static java.lang.System.exit;

public class CompraManager implements Comparable<CompraManager>{

    private String producto;
    private double valor;

    public CompraManager(String producto, double valor) {
        this.producto = producto;
        if(valor>0){this.valor = valor;}else{
            System.out.println("La compra no puede realizarse por $0 o importes negativos");
            exit(0);
        }
    }

    public double getValor() {
        return valor;
    }

    public String getProducto() {
        return producto;
    }


    @Override
    public String toString() {
        return "Descripcion= " + producto +
                "valor= " + valor;
    }

    @Override
    public int compareTo(CompraManager CompraManagerOtros) {
        return Double.compare(this.valor, CompraManagerOtros.getValor());
    }
}