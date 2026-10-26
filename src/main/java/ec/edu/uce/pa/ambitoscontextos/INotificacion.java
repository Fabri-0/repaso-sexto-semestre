package ec.edu.uce.pa.ambitoscontextos;

public interface INotificacion {

    void enviar(String destino, String mensaje);

    Integer getCantidad();

    void setCantidad(Integer cantidad);

    String getNombre();

    void setNombre(String nombre);
}
