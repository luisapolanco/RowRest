package dominio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cliente extends Usuario {
    private String direccion;
    private String celular;
    private String correo;

    public Cliente(String id, String nombre, String nombreDeUsuario, String contrasena, String direccion, String celular, String correo) {
        super(id, nombre, nombreDeUsuario, contrasena);
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public static void crearPerfilCliente(){
        //Módulo Captura
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scan.next();
        System.out.println("Ingrese su correo: ");
        String correo = scan.next();
        System.out.println("Ingrese su celular: ");
        String celular = scan.next();
        System.out.println("Ingrese su dirección: ");
        String direccion = scan.next();
        System.out.println("Ingrese su nombre de usuario: ");
        String nombreDeUsuario = scan.next();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scan.next();

        Cliente cliente = new Cliente(java.util.UUID.randomUUID().toString(), nombre, nombreDeUsuario, contrasena, direccion, celular, correo);

        FileWriter ficheroCliente = null;
        PrintWriter pwCliente = null;

        try
        {
            ficheroCliente = new FileWriter("./cliente_"+nombre+".txt");
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
}
