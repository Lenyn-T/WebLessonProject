package com.programming.web.fatec.api_fatec.entities;

public class Cliente {
    private Long id;
    private String nome;
    private Integer idade;
    private String logradouro;

    public Cliente() {}

    public Cliente(Long id, String nome, int idade, String logradouro) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.logradouro = logradouro;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
