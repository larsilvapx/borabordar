package com.borabordar.dto;

public class RelatorioCliente {

    private int totalPedidos;
    private int pendentes;
    private int finalizados;
    private int cancelados;
    private double valorTotal;


    public RelatorioCliente(int totalPedidos, int pendentes, int finalizados, int cancelados, double valorTotal) {
        this.totalPedidos = totalPedidos;
        this.pendentes = pendentes;
        this.finalizados = finalizados;
        this.cancelados = cancelados;
        this.valorTotal = valorTotal;
    }


    public int getTotalPedidos() {
        return totalPedidos;
    }

    public int getPendentes() {
        return pendentes;
    }

    public int getFinalizados() {
        return finalizados;
    }

    public int getCancelados() {
        return cancelados;
    }

    public double getValorTotal() {
        return valorTotal;
    }


}
