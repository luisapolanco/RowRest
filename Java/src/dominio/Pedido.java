package dominio;

import alertas.Notificaciones;

import java.util.List;

public class Pedido {
    private List<Plato> platos;
    private List<Bebida> bebidas;
    private Reserva reservaInfo;
    private DetallePedido detallePedido;

    public Pedido(List<Plato> platos, List<Bebida> bebidas, Reserva reservaInfo, DetallePedido detallePedido) {
        this.platos = platos;
        this.bebidas = bebidas;
        this.reservaInfo = reservaInfo;
        this.detallePedido = detallePedido;
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

    public Reserva getReservaInfo() {
        return reservaInfo;
    }

    public void setReservaInfo(Reserva reservaInfo) {
        this.reservaInfo = reservaInfo;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    //Ejemplo propuesto con datos quemados por la implementación de servicios y más elementos no estrictamente
    // necesarios en la estructura del dominio de estos casos de uso.

    public void enviarPedidoRestaurante(Pedido p){
        System.out.println("El pedido se ha enviado al restaurante, espere la confirmación");
    }

    public String confirmarPedido(Pedido p){
        boolean pedidoConfirmado = false;
        int tiempo = 20;
        String mensaje = "";
        if(pedidoConfirmado){
            return mensaje = "Su pedido ha sido confirmado por el  restaurante, dirijase a el en "+ tiempo + " minutos";
        }else{
            return mensaje = "En este momento el restaurante no puede confirmar su pedido";
        }
    }

    public void agregarNovedadesPedido(Pedido pedido){
        Notificaciones.notificarCambiosEnElPedido(pedido);
    }
}
