package com.example.model;

public class Funcionario {
    private String nome;
    private String email;
    private String senha;
    private String matricula;
    private String documento;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Matrícula: " + matricula);
    }
}

