package ec.edu.uce.pa.inyeccion;

import jakarta.inject.Singleton;

@Singleton 
public class MailService {

    public void enviar(String correo, String asunto, String cuerpo){
        System.out.println("Enviando correo al " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado con éxito.");
    }
}
