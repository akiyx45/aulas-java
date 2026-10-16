package com.example.model;

public class Cliente extends Usuario {

    private int pontos;

    public Cliente(String nome, String documento, int pontos) {
        super(nome, documento);
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Pontos: " + pontos);
    }
}