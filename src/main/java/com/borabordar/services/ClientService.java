package com.borabordar.services;

import com.borabordar.model.Cliente;
import com.borabordar.repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository repository = new ClientRepository();

    public void cadastrarCliente(String nome, String telefone, String cpf){
        if(nome == null || nome.trim().isEmpty()){
            throw new RuntimeException("Nome não pode ser vazio");
        }
        if(!cpfValido(cpf)){
            throw new RuntimeException("Cpf deve conter 11 digitos");
        }
        if(repository.buscarPorCpf(cpf) != null){
            throw new RuntimeException("CPF já está cadastrado!");
        }
        Cliente cliente = new Cliente(nome, telefone, cpf);
        repository.salvar(cliente);

    }
    public List<Cliente> listarCliente(){
        return repository.listar();
    }

    private boolean cpfValido(String cpf){
        if(cpf == null) return false;

        if(cpf.length() != 11) return false;

        for (char c : cpf.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
            }
        return true;

    }
    public Cliente buscarPorCpf(String cpf){
        return repository.buscarPorCpf(cpf);
    }


}
