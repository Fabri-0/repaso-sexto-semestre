package ec.edu.uce.pa.ambitoscontextos;

import jakarta.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pedidoService;

    @Inject 
    private CompraService compraService;


    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args){
        System.out.println("Iniciando apliacion Quarkus");
        
        Pedido pedido = new Pedido("Fabricio Topon", "Laptop", "ftmarce@gmail.com",1500.50, "099999999");
        this.pedidoService.realizar(pedido);

        System.out.println("---------------------------------------------------");

        Compra compra = new Compra("Joss", "Flash", "joss@gmail.com",10.50, "0888888888");
        this.compraService.realizar(compra);

        return 0;
    }

}