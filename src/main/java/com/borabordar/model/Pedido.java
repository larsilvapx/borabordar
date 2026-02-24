package com.borabordar.model;

public class Pedido {

    public static int contador = 1;

    private int id;
    private Cliente cliente;
    private String descricao;
    private double valor;
    private StatusPedido status;



    public Pedido(Cliente cliente, String descricao, Double valor) {
        this.id = contador ++;
        this.cliente = cliente;
        this.descricao = descricao;
        this.valor = valor;
        this.status = StatusPedido.PENDENTE;
    }

    public static int getContador() {
        return contador;
    }



    public int getId() {
        return id;
    }



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void atualizarStatus(StatusPedido novoStatus) {
        if (this.status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Pedido já entregue não pode ser alterado.");
        }
        this.status = novoStatus;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}
