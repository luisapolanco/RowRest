package dominio;

import dominio.Bebida;

import java.util.List;

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

}
