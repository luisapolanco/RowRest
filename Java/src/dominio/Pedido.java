package dominio;

import alertas.Notificaciones;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Pedido {
    private List<Plato> platos;
    private List<Bebida> bebidas;
    private Reserva reservaInfo;
    private DetallePedido detallePedido;
    private static int contadorPedidos = 0;

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
        boolean pedidoConfirmado = true;
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

    public static void crearNuevoPedido(){
        contadorPedidos ++;
        boolean cond = true;
        Scanner scan = new Scanner(System.in);
        List<Plato> platos = new ArrayList<>();
        List<Bebida> bebidas = new ArrayList<>();
        DetallePedido detallePedido = new DetallePedido();
        Reserva reserva = new Reserva();
        System.out.println("Ingrese el restaurante en el que desea realizar el pedido: ");
        String restaurante = scan.next();
        System.out.println("Ingrese su nombre: ");
        String cliente = scan.next();

        while(cond){
            System.out.println("1. Ingresar un plato");
            System.out.println("2. Ingresar una bebida");
            System.out.println("3. Número de personas en la reserva");
            System.out.println("4.Salir");

            int opcion = scan.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del plato: ");
                    String nombrePlato = scan.next();
                    System.out.println("Ingrese la descripción para el plato: ");
                    String descripcionPlato = scan.next();
                    System.out.println("Ingrese el precio para el plato: ");
                    double precioPlato = scan.nextDouble();
                    System.out.println("Ingrese los detalles para el plato: ");
                    String detallePlato = scan.next();
                    Plato plato = new Plato(nombrePlato, descripcionPlato, precioPlato);

                    platos.add(plato);
                    Map<Plato, String> detallePedi = new HashMap<>();
                    detallePedi.put(plato,detallePlato );
                    detallePedido.setDetallePlato(detallePedi);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la bebida: ");
                    String nombreBebida = scan.next();
                    System.out.println("Ingrese el precio de la bebida: ");
                    double precioBebida = scan.nextDouble();

                    Bebida bebida = new Bebida(nombreBebida, precioBebida);
                    bebidas.add(bebida);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de personas que asistirán al restaurante: ");
                    int cantidadPersona = scan.nextInt();
                    reserva.setCantidadDePersonas(cantidadPersona);
                    break;
                case 4:
                    cond = false;
                    break;
            }
        }

        Pedido pedido = new Pedido(platos, bebidas, reserva, detallePedido);
        pedido.enviarPedidoRestaurante(pedido);

        System.out.println("-------------------");

        pedido.confirmarPedido(pedido);

        FileWriter ficheroPedido = null;
        PrintWriter pwPedido = null;

        try
        {
            ficheroPedido = new FileWriter("./pedido_"+contadorPedidos+".txt");
            pwPedido = new PrintWriter(ficheroPedido);
            pwPedido.println("RESTAURANTE: "+ restaurante);
            pwPedido.println("Nombre cliente: "+ cliente);

            for(int i = 0; i < pedido.platos.size(); i++){
                pwPedido.println("---------------------------------------------------");
                pwPedido.println("Nombre plato: "+ pedido.platos.get(i).getNombre());
                pwPedido.println("Descripcion plato: "+ pedido.platos.get(i).getDescripcion());
                pwPedido.println("Precio plato: "+ pedido.platos.get(i).getPrecio());
                pwPedido.println("Detalle plato: "+ pedido.detallePedido.getDetallePlato().entrySet());
            }

            for(int i = 0; i < pedido.bebidas.size(); i++){
                pwPedido.println("---------------------------------------------------");
                pwPedido.println("Nombre bebida: "+ pedido.bebidas.get(i).getNombre());
                pwPedido.println("Precio bebida: "+ pedido.bebidas.get(i).getPrecio());
            }

            pwPedido.println("---------------------------------------------------");
           pwPedido.println("Personas en el restaurante: "+ pedido.reservaInfo.getCantidadDePersonas() );

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != ficheroPedido)
                    ficheroPedido.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
