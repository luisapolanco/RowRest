package dominio;

import dominio.Menu;
import dominio.Usuario;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Restaurante extends Usuario {

    private String direccion;
    private String nit;
    private Menu menu;
    private String telefono;

    public Restaurante(String id,String direccion, String nit, Menu menu, String telefono, String nombre, String nombreDeUsuario, String contrasena) {
        super(id,nombre, nombreDeUsuario, contrasena);
        this.direccion = direccion;
        this.nit = nit;
        this.menu = menu;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static void crearPerfilRestaurante(){
        //Módulo Captura
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del restaurante: ");
        String nombre = scan.next();
        System.out.println("Ingrese la dirección del restaurante: ");
        String direccion = scan.next();
        System.out.println("Ingrese el nit del restaurante: ");
        String nit = scan.next();
        System.out.println("Ingrese el teléfono del restaurante: ");
        String telefono = scan.next();
        System.out.println("Ingrese un nombre de usuario para el restaurante: ");
        String nombreDeUsuario = scan.next();
        System.out.println("Ingrese una contraseña para el restaurante: ");
        String contrasena = scan.next();
        Menu menu = Menu.crearMenu();

        Restaurante restaurante = new Restaurante(java.util.UUID.randomUUID().toString(), direccion, nit, menu, telefono, nombre, nombreDeUsuario, contrasena);

        FileWriter ficheroRestaurante = null;
        PrintWriter pwRestaurante = null;

        try
        {
            ficheroRestaurante = new FileWriter("./restaurante_"+nombre+".txt");
            pwRestaurante = new PrintWriter(ficheroRestaurante);
            pwRestaurante.println("Nombre restaurante: "+ nombre);
            pwRestaurante.println("Teléfono restaurante: "+ telefono);
            pwRestaurante.println("Ubicación restaurante: "+ direccion);
            pwRestaurante.println("Nit restaurante: "+ nit);
            pwRestaurante.println("Menú restaurante: "+ menu);
            pwRestaurante.println("Nombre de usuario restaurante: "+ nombreDeUsuario);
            pwRestaurante.println("Contraseña restaurante: "+ contrasena);
            pwRestaurante.println("--------------------------------");
            pwRestaurante.println("Menu ");
            for(int i = 0; i < restaurante.menu.getPlatos().size(); i++){
                pwRestaurante.println("---------------------------------------------------");
                pwRestaurante.println("Nombre plato: "+ restaurante.menu.getPlatos().get(i).getNombre());
                pwRestaurante.println("Descripcion plato: "+ restaurante.menu.getPlatos().get(i).getDescripcion());
                pwRestaurante.println("Precio plato: "+ restaurante.menu.getPlatos().get(i).getPrecio());
            }

            for(int i = 0; i < restaurante.menu.getBebidas().size(); i++){
                pwRestaurante.println("---------------------------------------------------");
                pwRestaurante.println("Nombre bebida: "+ restaurante.menu.getBebidas().get(i).getNombre());
                pwRestaurante.println("Precio bebida: "+ restaurante.menu.getBebidas().get(i).getPrecio());
            }


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

}
