package com.borabordar.repository;

import com.borabordar.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente){
        clientes.add(cliente);
    }

    public List<Cliente> listar(){
        return clientes;
    }

    public Cliente buscarPorCpf(String cpf){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }
}
