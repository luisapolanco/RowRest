package alertas;

import dominio.Pedido;

public class Notificaciones {
    public static void notificarCambiosEnElPedido(Pedido ped){
        System.out.println("Se ha realizado un cambio en el pedido");
    }
}
