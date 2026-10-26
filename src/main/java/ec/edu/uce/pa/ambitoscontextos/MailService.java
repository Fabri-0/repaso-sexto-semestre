package ec.edu.uce.pa.ambitoscontextos;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
@Named ("mail")
public class MailService implements INotificacion {

    private Integer cantidad = 0;
    private String nombre;

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito.");
        System.out.println("Fin del envío del correo.");
        cantidad++;
    }

    @Override
    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(Integer cantidad) {
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
    }

}
