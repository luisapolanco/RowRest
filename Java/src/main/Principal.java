package main;

import dominio.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Principal {



    public static void main(String [] args){
        crearPerfilCliente();
        crearPerfilRestaurante();
        crearNuevoPedido();
    }

    public static void crearPerfilRestaurante(){
        //Módulo Captura
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scan.next();
        System.out.println("Ingrese su dirección: ");
        String direccion = scan.next();
        System.out.println("Ingrese su nit: ");
        String nit = scan.next();
        System.out.println("Ingrese su teléfono: ");
        int telefono = scan.nextInt();
        System.out.println("Ingrese su nombre de usuario: ");
        String nombreDeUsuario = scan.next();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scan.next();
        Menu menu = Principal.crearMenu();

        Restaurante restaurante = new Restaurante(java.util.UUID.randomUUID().toString(), direccion, nit, menu, telefono, nombre, nombreDeUsuario, contrasena);

        FileWriter ficheroRestaurante = null;
        PrintWriter pwRestaurante = null;

        try
        {
            ficheroRestaurante = new FileWriter("./restaurante.txt");
            pwRestaurante = new PrintWriter(ficheroRestaurante);
            pwRestaurante.println("Nombre restaurante: "+ nombre);
            pwRestaurante.println("Teléfono restaurante: "+ telefono);
            pwRestaurante.println("Ubicación restaurante: "+ direccion);
            pwRestaurante.println("Nit restaurante: "+ nit);
            pwRestaurante.println("Menú restaurante: "+ menu);
            pwRestaurante.println("Nombre de usuario restaurante: "+ nombreDeUsuario);
            pwRestaurante.println("Contraseña restaurante: "+ contrasena);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != ficheroRestaurante)
                    ficheroRestaurante.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void crearPerfilCliente(){
        //Módulo Captura
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scan.next();
        System.out.println("Ingrese su correo: ");
        String correo = scan.next();
        System.out.println("Ingrese su celular: ");
        int celular = scan.nextInt();
        System.out.println("Ingrese su dirección: ");
        String direccion = scan.next();
        System.out.println("Ingrese su nombre de usuario: ");
        String nombreDeUsuario = scan.next();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scan.next();
        Menu menu = Principal.crearMenu();

        Cliente cliente = new Cliente(java.util.UUID.randomUUID().toString(), nombre, nombreDeUsuario, contrasena, direccion, celular, correo);

        FileWriter ficheroCliente = null;
        PrintWriter pwCliente = null;

        try
        {
            ficheroCliente = new FileWriter("./cliente.txt");
            pwCliente = new PrintWriter(ficheroCliente);
            pwCliente.println("Nombre cliente: "+ nombre);
            pwCliente.println("Correo cliente: "+ correo);
            pwCliente.println("Celular cliente: "+ celular);
            pwCliente.println("Dirección cliente: "+ direccion);
            pwCliente.println("Nombre de usuario cliente: "+ nombreDeUsuario);
            pwCliente.println("Contraseña cliente: "+ contrasena);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != ficheroCliente)
                    ficheroCliente.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }


    }

    public static void crearNuevoPedido(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre para el plato: ");
        String nombrePlato = scan.next();
        System.out.println("Ingrese la descripción para el plato: ");
        String descripcionPlato = scan.next();
        System.out.println("Ingrese el precio para el plato: ");
        double precioPlato = scan.nextDouble();
        System.out.println("Ingrese los detalles para el plato: ");
        String detallePlato = scan.next();
        Plato plato = new Plato(nombrePlato, descripcionPlato, precioPlato);

        System.out.println("Ingrese el nombre de la bebida: ");
        String nombreBebida = scan.next();
        System.out.println("Ingrese el precio de la bebida: ");
        double precioBebida = scan.nextDouble();

        System.out.println("Ingrese la cantidad de personas que asistirán al restaurante: ");
        int cantidadPersona = scan.nextInt();

        Bebida bebida = new Bebida(nombreBebida, precioBebida);
        List<Plato> platos = new ArrayList<>();
        List<Bebida> bebidas = new ArrayList<>();;
        platos.add(plato);
        bebidas.add(bebida);

        Map<Plato, String> detallePedi = new HashMap<>();
        detallePedi.put(plato,detallePlato );


        Reserva reserva = new Reserva(cantidadPersona);
        DetallePedido detallePedido = new DetallePedido(detallePedi);

        FileWriter ficheroPedido = null;
        PrintWriter pwPedido = null;

        try
        {
            ficheroPedido = new FileWriter("./pedido.txt");
            pwPedido = new PrintWriter(ficheroPedido);
            pwPedido.println("Nombre plato: "+ nombrePlato);
            pwPedido.println("Descripcion plato: "+ descripcionPlato);
            pwPedido.println("Precio plato: "+ precioPlato);
            pwPedido.println("Nombre bebida: "+ nombreBebida);
            pwPedido.println("Precio bebida: "+ precioBebida);
            pwPedido.println("Personas en el restaurante: "+ cantidadPersona);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != ficheroPedido)
                    ficheroPedido.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Menu crearMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un nombre para el plato: ");
        String nombrePlato = scan.next();
        System.out.println("Ingrese una descripción para el plato: ");
        String descripcionPlato = scan.next();
        System.out.println("Ingrese un precio para el plato: ");
        double precioPlato = scan.nextDouble();
        Plato plato = new Plato(nombrePlato, descripcionPlato, precioPlato);

        System.out.println("Ingrese el nombre de la bebida: ");
        String nombreBebida = scan.next();
        System.out.println("Ingrese el precio de la bebida: ");
        double precioBebida = scan.nextDouble();

        Bebida bebida = new Bebida(nombreBebida, precioBebida);
        List<Plato> platos =  new ArrayList<>();
        List<Bebida> bebidas =  new ArrayList<>();
        platos.add(plato);
        bebidas.add(bebida);

        Menu menu = new Menu(platos, bebidas);
        return menu;
    }


}
