package com.example.model;

public class ProdutoFisico extends Produto {
    private double peso;
    private double frete;

    public ProdutoFisico(String nome, double preco, int quantidade, double peso, double frete) {
        super(nome, preco, quantidade);
        this.peso = peso;
        this.frete = frete;
    }

    public ProdutoFisico(int codigo, String nome, double preco, int quantidade, double peso) {
        this(nome, preco, quantidade, peso, 0.0);
        super.setCodigo(codigo);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
    // Metodos:
    @Override
    public void exibirResumo() {
        super.exibirResumo();
        double valorFrete = this.frete * super.getQuantidade();
        System.out.println(" | Frete: R$" + String.format("%.2f", valorFrete));
    }

}
