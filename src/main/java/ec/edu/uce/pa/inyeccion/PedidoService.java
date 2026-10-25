package ec.edu.uce.pa.inyeccion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped 
public class PedidoService {

    // INYECCION POR ATRIBUTO ***********************************

    @Inject
    private MailService mailService;

    // INYECCION POR CONSTRUCTOR *******************************

    /* private MailService mailService;

    @Inject 
    public PedidoService(MailService mailService) {
        this.mailService = mailService;
    } */
    
    // INYECCION POR SETTERS ************************************

    /* private MailService mailService;

    @Inject 
    public void setMailService(MailService mailService){
        this.mailService = mailService;
    } */

    public void realizar(Pedido pedido) {
        System.out.println("Realizar pedido");
        System.out.println("Pedido realizado para cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");

        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + pedido.getProducto()
                + " por un total de $" + pedido.getTotal() + " ha sido realizado con exito.";

        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);

    }

}
