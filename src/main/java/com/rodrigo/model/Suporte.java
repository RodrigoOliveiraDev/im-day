package com.rodrigo.model;
//Neste caso poderia ser uma classe que extenderia uma classe 'Pessoa' que teria dados mais basicos
public class Suporte {

    private Long id;//id de persistencia no banco
    private String nome;
    //neste campo caso ouvesse cadastro o usuario poderia colocar em que ordem o resolvedor ficaria no painel e na sequecência
    //com um "select s from suporte order by ordem asc" - poderia ter uma lista ordenada para o maps preencher
    private Integer ordem;

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

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
}
