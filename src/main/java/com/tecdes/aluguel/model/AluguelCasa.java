package com.tecdes.aluguel.model;

public class AluguelCasa implements Aluguel {
    private double valorMensal;
    private int meses;

    public AluguelCasa(double valorMensal, int meses) {
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    @Override
    public String calcular() {
        double total = valorMensal * meses;
        return "Aluguel de Casa: R$ " + total;
    }
}