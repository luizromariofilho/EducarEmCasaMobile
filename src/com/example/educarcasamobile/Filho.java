package com.example.educarcasamobile;

import java.io.Serializable;

/**
 * Created by Luiz Romario Filho on 12/13/2014.
 */
public class Filho implements Serializable {
    private Integer id;
    private String nome;

    public Filho() {
    }

    public Filho( Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
