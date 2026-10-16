package com.example.model;

public class Vale extends Pagamento {
    public Vale (double valor, double saldo) {
        super(valor);
        this.saldo = saldo;
    }

    double saldo = 200.0;

    @Override
    public double calcularTaxa() {
       return 0.0;
    }

    @Override
    public void processar() {
        System.out.println("pagamento por vale");
        System.out.println("-------------------");
        if (saldo >= getValor()) {
            System.out.println("Vale Autorizado!");
        } else {
            System.out.println("Vale Negado - Saldo Insuficiente!");
        }
    }

    public double getValor() {
        return super.getValor();
    }
}
