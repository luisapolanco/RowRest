package dominio;

import java.util.Map;

public class DetallePedido {
    private Map<Plato, String> detallePlato;

    public DetallePedido(Map<Plato, String> detallePlato) {
        this.detallePlato = detallePlato;
    }

    public DetallePedido() {
    }

    public Map<Plato, String> getDetallePlato() {
        return detallePlato;
    }

    public void setDetallePlato(Map<Plato, String> detallePlato) {
        this.detallePlato = detallePlato;
    }
}
