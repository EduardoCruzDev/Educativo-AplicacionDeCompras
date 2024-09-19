package org.example;

import java.util.Collections;
import java.util.Scanner;

public class Main {


    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ingresa el limite de la tarjeta:");
        double limiteDeCredito = sc.nextDouble();
        var tarjeta = new TarjetaDeCredito(limiteDeCredito);

        int salir = 1;
        while(salir !=0){

            try {
                System.out.println("Producto a comprar");
                String producto = sc.next();
                System.out.println("Precio del producto");
                double valor = sc.nextDouble();

                var compra = new CompraManager(producto, valor);
                boolean compraRealizada = tarjeta.comprarProducto(compra);
                if (compraRealizada) {
                    System.out.println("Compra realizada!");
                    System.out.println("Te quedan: $"+tarjeta.getSaldo());
                    System.out.println("Escriba 0 para salir o 1 para continuar");
                    salir = sc.nextInt();
                } else {
                    System.out.println("Saldo insuficiente!. Solo tienes: $" +tarjeta.getSaldo());
                    salir = 0;
                }
            }catch(Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                sc.nextLine(); // Limpiar el buffer en caso de un error

            }
        }

        System.out.println("******PRODUCTOS COMPRADOS***********");
        Collections.sort(tarjeta.getProductos());
        for (CompraManager compraManager1 : tarjeta.getProductos()) {
                       System.out.println("Producto: " + compraManager1.getProducto() + " | Precio: $" + compraManager1.getValor());
        }
        System.out.println("************************************");

    }
}