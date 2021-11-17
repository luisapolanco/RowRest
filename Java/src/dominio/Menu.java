package dominio;

import dominio.Bebida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Plato> platos;
    private List<Bebida> bebidas;

    public Menu(List<Plato> platos, List<Bebida> bebidas) {
        this.platos = platos;
        this.bebidas = bebidas;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public static Menu crearMenu(){
        boolean cond = true;
        Scanner scan = new Scanner(System.in);
        List<Plato> platos =  new ArrayList<>();
        List<Bebida> bebidas =  new ArrayList<>();
        while(cond){
            System.out.println("1. Ingresar un nuevo plato");
            System.out.println("2. Ingresar una nueva bebida");
            System.out.println("3. Salir del programa");
            int opcion = scan.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese un nombre para el plato: ");
                    String nombrePlato = scan.next();
                    System.out.println("Ingrese una descripción para el plato: ");
                    String descripcionPlato = scan.next();
                    System.out.println("Ingrese un precio para el plato: ");
                    double precioPlato = scan.nextDouble();
                    Plato plato = new Plato(nombrePlato, descripcionPlato, precioPlato);
                    platos.add(plato);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la bebida: ");
                    String nombreBebida = scan.next();
                    System.out.println("Ingrese el precio de la bebida: ");
                    double precioBebida = scan.nextDouble();

                    Bebida bebida = new Bebida(nombreBebida, precioBebida);
                    bebidas.add(bebida);
                    break;
                case 3:
                    cond = false;
                    break;
            }
        }

        Menu menu = new Menu(platos, bebidas);
        return menu;
    }


}
