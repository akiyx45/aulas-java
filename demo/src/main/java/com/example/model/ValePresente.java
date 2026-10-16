package com.example.model;

public class ValePresente implements Pagavel {
    
    private double valor;
    private double saldo;

    public ValePresente(double valor, double saldo) {
        this.valor = valor;
        this.saldo = saldo;
    }

    @Override
    public double calcularTotal() {
        return valor;
    }

    @Override
    public void processar() {
        System.out.println("Processando pagamento com vale presente no valor de: " + valor);
        if (saldo >= valor) {
            System.out.println("Vale Presente Autorizado!");
        } else {
            System.out.println("Vale Presente Negado - Saldo Insuficiente!");
        }
    }
    
}
