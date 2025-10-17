package com.tecdes.aluguel.model;

public class AluguelApartamento implements Aluguel {
    private double valorMensal;
    private int meses;

    public AluguelApartamento(double valorMensal, int meses) {
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    @Override
    public String calcular() {
        double taxa = 0.05; // taxa condominial
        double total = (valorMensal * meses) * (1 + taxa);
        return "Aluguel de Apartamento: R$ " + total;
    }
}