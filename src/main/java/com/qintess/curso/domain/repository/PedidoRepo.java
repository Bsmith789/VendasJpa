package com.qintess.curso.domain.repository;

import com.qintess.curso.domain.entity.Cliente;
import com.qintess.curso.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PedidoRepo extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente( Cliente cliente);

}
