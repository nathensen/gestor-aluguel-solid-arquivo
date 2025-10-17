package com.tecdes.aluguel.model;

public class AluguelComercial implements Aluguel {
    private double valorMensal;
    private int meses;

    public AluguelComercial(double valorMensal, int meses) {
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    @Override
    public String calcular() {
        double imposto = 0.10; // imposto comercial
        double total = (valorMensal * meses) * (1 + imposto);
        return "Aluguel Comercial: R$ " + total;
    }
}