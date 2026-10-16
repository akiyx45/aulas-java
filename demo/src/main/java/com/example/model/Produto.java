package com.example.model;

import java.util.List;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.codigo = 0; // Ou algum valor padrão
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int codigo, String nome, double preco, int quantidade) {
        this(nome, preco, quantidade);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    // Métodos:

    public double calcularValorTotal() {
        return preco * quantidade;
    }

    public boolean temEstoque() {
        return quantidade > 0;
    }

    public void exibirResumo() {
        System.out.println(nome + " | R$" + preco +  " | " + quantidade);
    }

    // metodo == função:
    public Produto buscarPorCodigo(List<Produto> lista, int codigo) {
        for (Produto produto : lista) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public boolean adicionarProduto(List<Produto> lista, Produto produto) {
        int qtd = produto.getQuantidade();
        if (qtd <= 0) return false;
        quantidade += qtd;
        return true;
    }

    public boolean removerProduto(int qtd) {
        if (qtd <= 0 || qtd > quantidade) return false;
        quantidade -= qtd;
        return true;
    }

    public boolean adicionarEstoque(int qtd) {
        if (qtd <= 0) return false;
        quantidade += qtd;
        return true;
    }

    public boolean removerEstoque(int qtd) {
        if (qtd <= 0 || qtd > quantidade) return false;
        quantidade -= qtd;
        return true;
    }

    public boolean aplicarDescontoPercentual(double percentual) {
        if (percentual <= 0 || percentual > 50) return false;
        preco -= preco * (percentual / 100);
        return true;
    }
    
    public boolean aplicarDescontoFixo(double valor, boolean fixo) {
        if (!fixo || valor <= 0 || valor > preco) return false;
        preco -= valor;
        return true;    
    }
}
