package main;

import dominio.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Principal {

    public static void main(String [] args){

        boolean cond = true;

        while (cond){
            Scanner scan = new Scanner(System.in);

            System.out.println("Ingrese la opción según lo que desee realizar: ");

            System.out.println("1. Crear perfil como cliente");
            System.out.println("2. Crear perfil como restaurante");
            System.out.println("3. Hacer un nuevo pedido");
            System.out.println("4. Salir del programa");

            int opcion = scan.nextInt();

            switch (opcion){
                case 1:
                    Cliente.crearPerfilCliente();
                    break;
                case 2:
                    Restaurante.crearPerfilRestaurante();
                    break;
                case 3:
                    Pedido.crearNuevoPedido();
                    break;
                case 4:
                    cond = false;
                    break;
            }
        }
    }
}
