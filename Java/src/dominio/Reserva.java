package dominio;

public class Reserva {
    private int cantidadDePersonas;

    public Reserva(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public Reserva() {
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
}
