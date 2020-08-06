package com.qintess.curso;

import com.qintess.curso.domain.entity.Cliente;
import com.qintess.curso.domain.entity.Pedido;
import com.qintess.curso.domain.repository.ClienteRepo;
import com.qintess.curso.domain.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired ClienteRepo clienteRepo,
            @Autowired PedidoRepo pedidoRepo){
        return args -> {
            Cliente gabriel = new Cliente("Gabriel");
            clienteRepo.save(gabriel);
            Cliente monica = new Cliente("Mônica");
            clienteRepo.save(monica);

            Pedido p = new Pedido();
            p.setCliente(gabriel);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidoRepo.save(p);

            Cliente cliente = clienteRepo.findClienteFetchPedidos(gabriel.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());

            boolean existe2 = clienteRepo.existsByNome("Mônica");
            System.out.println("existe um cliente com o nome Mônica ? " + existe2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class,args);
    }
}
