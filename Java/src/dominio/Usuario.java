package dominio;

public class Usuario {

    protected String id;
    protected  String nombre;
    protected String nombreDeUsuario;
    protected String contrasena;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String nombreDeUsuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasena = contrasena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
