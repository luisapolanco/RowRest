package dominio;

import dominio.Menu;
import dominio.Usuario;

public class Restaurante extends Usuario {

    private String direccion;
    private String nit;
    private Menu menu;
    private int telefono;

    public Restaurante(String id,String direccion, String nit, Menu menu, int telefono, String nombre, String nombreDeUsuario, String contrasena) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
