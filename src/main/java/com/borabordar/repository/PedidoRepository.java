package com.borabordar.repository;

import com.borabordar.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    private List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido){
        pedidos.add(pedido);
    }
    public List<Pedido> listar(){
        return pedidos;

    }public Pedido buscarPedidoPorId(int id){
        for(Pedido pedido : pedidos){
            if(pedido.getId() == id){
                return pedido;
            }
        }
        return null;
    }
}
