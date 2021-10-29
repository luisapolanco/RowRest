package dominio;

public class Cliente extends Usuario {
    private String direccion;
    private int celular;
    private String correo;

    public Cliente(String id, String nombre, String nombreDeUsuario, String contrasena, String direccion, int celular, String correo) {
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

    public int getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
}
