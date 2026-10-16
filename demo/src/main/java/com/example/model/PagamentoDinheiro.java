package com.example.model;

public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro (double valor) {
        super(valor);
    }

    @Override
    public double calcularTaxa() {
       return 0.0;
    }

    @Override
    public void processar() {
        System.out.println("pagamento por dinheiro");
    }

    public double getValor() {
        return super.getValor();
    }
}
