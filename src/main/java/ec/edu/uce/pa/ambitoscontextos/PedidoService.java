package ec.edu.uce.pa.ambitoscontextos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class PedidoService {

    @Inject
    @Named("mail")
    private MailService notificacionEmail;

    @Inject
    @Named("sms")
    private SMSService notificacionSMS;

    public void realizar(Pedido pedido) {

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");

        // NOTIFICACION POR EMAIL

        String mensaje = "Estimado " + pedido.getCliente() + ", su pedido de " + "'" + pedido.getProducto() + "'" +
                " por un total de $" + pedido.getTotal() + " ha sido realizado con éxito.";
        this.notificacionEmail.enviar(pedido.getCorreo(), mensaje);
        //this.notificacionEmail.setCantidad(this.notificacionEmail.getCantidad() + 1);
        System.out.println("Cantidad de correos enviados: " + this.notificacionEmail.getCantidad());
        this.notificacionEmail.setNombre("Correo de pedido");


        // NOTIFICACION POR SMS
        this.notificacionSMS.enviar(pedido.getCorreo(), mensaje);
        System.out.println("Cantidad de SMS enviados: " + this.notificacionSMS.getCantidad());
    }
}
