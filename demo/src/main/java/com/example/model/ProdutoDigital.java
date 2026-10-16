package com.example.model;

public class ProdutoDigital extends Produto {
    private double taxaLicenca;

    public ProdutoDigital(String nome, double preco, int quantidade, double taxaLicenca) {
        super(nome, preco, quantidade);
        this.taxaLicenca = taxaLicenca;
    }

    public ProdutoDigital(int codigo, String nome, double preco, int quantidade, double taxaLicenca) {
        this(nome, preco, quantidade, taxaLicenca);
        super.setCodigo(codigo);
    }

    public double getTaxaLicenca() {
        return taxaLicenca;
    }

    public void setTaxaLicenca(double taxaLicenca) {
        this.taxaLicenca = taxaLicenca;
    }
    
    // Metodos:
    public double calcularValorTotalDigital() {
        return super.calcularValorTotal() + this.taxaLicenca * super.getQuantidade();
    }
    @Override
    public void exibirResumo() {
        super.exibirResumo();
        double valorTotal = super.getPreco() * super.getQuantidade() + this.taxaLicenca * super.getQuantidade();
        System.out.println(" | Taxa de licença: R$" + String.format("%.2f", valorTotal));
    }
}
