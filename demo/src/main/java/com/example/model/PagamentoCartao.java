package com.example.model;

public class PagamentoCartao extends Pagamento {

    private double percentualTaxa;
    
    public PagamentoCartao(double valor, double percentualTaxa) {
        super(valor);
        this.percentualTaxa = percentualTaxa;
    }

    @Override
    public double calcularTaxa() {
        return getValor() * percentualTaxa / 100.0;
    }

    @Override
    public void processar() {
        System.out.println("Pagamento via cartao");
        }
}
