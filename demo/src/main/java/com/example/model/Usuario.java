package com.example.model;

public class Usuario {
    private String nome;
    private String documento;

    public Usuario(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    } 

    public String getNome() { return nome;}
    
    public String getDocumento() { return documento; }

    public void exibirDados () {
        System.out.println(nome + " - " + documento);
    }
}
