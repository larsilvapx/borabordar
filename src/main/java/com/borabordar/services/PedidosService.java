package com.borabordar.services;

import com.borabordar.model.Cliente;
import com.borabordar.model.Pedido;
import com.borabordar.model.StatusPedido;
import com.borabordar.repository.PedidoRepository;

import java.util.List;

public class PedidosService {

    private PedidoRepository repository = new PedidoRepository();

    public Pedido criarPedido(Cliente cliente, String descricao, double valor) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new RuntimeException("Descrição de pedido não pode ser vazia");
        }
        if (valor <= 0) {
            throw new RuntimeException("Valor do pedido não pode ser negativo");
        }

        Pedido pedido = new Pedido(cliente, descricao, valor);
        repository.salvar(pedido);
        return pedido;

    }

    public List<Pedido> listarPedido() {
        return repository.listar();
    }

    public void cancelarPedido(int id) {

        Pedido pedido = repository.buscarPedidoPorId(id);

        if (pedido == null) {
            throw new RuntimeException("Pedido não localizado");
        }
        pedido.cancelar();

    }

    public List<Pedido> listarPedidoPorCliente (String cpf){

        return repository.listar().stream()
                .filter(pedido -> pedido.getCliente()
                        .equals(cpf)).toList();
    }


    public void atualizarStatus(int id, StatusPedido status) {
        Pedido pedido = repository.buscarPedidoPorId(id);
        if (pedido != null) {
            pedido.atualizarStatus(status);
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }
}
