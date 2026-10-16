package com.example.model;

public class Pix extends Pagamento {

    public Pix (double valor) {
        super(valor);
    }

    @Override
    public double calcularTaxa() {
       return 0.0;
    }

    @Override
    public void processar() {
        System.out.println("pagamento via pix");
    }

    public double getValor() {
        return super.getValor();
    }
    
}