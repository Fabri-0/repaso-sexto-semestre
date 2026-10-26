package ec.edu.uce.pa.ambitoscontextos;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
public class CompraService {

    @Inject
    @Named("mail")
    private MailService notificarCorreo;

    public void realizar(Compra compra) {

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Pedido realizado con exito.");

        // NOTIFICAR POR EMAIL

        String cuerpo = "Estimado " + compra.getCliente() + ", su pedido de " + "'" + compra.getProducto() + "'" +
                " por un total de $" + compra.getTotal() + " ha sido realizado con éxito.";
        this.notificarCorreo.enviar(compra.getCorreo(), cuerpo);
        System.out.println("Cantidad de correos enviados: " + this.notificarCorreo.getCantidad());
        //System.out.println("Nombre: " + this.notificarCorreo.getNombre());
    }
}
