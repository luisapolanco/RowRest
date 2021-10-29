package dominio;

public class Reserva {
    private int cantidadDePersonas;

    public Reserva(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
}
