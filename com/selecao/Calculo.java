package com.selecao;

public class Calculo {
    private double altura;
    private double peso;
    private double imc;

    public Calculo(double altura, double peso) {
        this.altura = altura;
        this.peso = peso;
        this.imc = peso /(altura * altura);
    }

    public double getImc() {
        return imc;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}


