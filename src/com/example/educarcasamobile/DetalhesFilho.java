package com.example.educarcasamobile;

import java.io.Serializable;

/**
 * Created by Luiz Romario Filho on 12/15/2014.
 */
public class DetalhesFilho implements Serializable {
    private Integer id;
    private Integer aluno_id;
    private Integer disciplina_id;
    private  Integer semestre_id;
    private Integer f_id;
    private String f_valor;
    private Integer n_id;
    private String n_valor;
    private String s_valor;
    private Integer d_id;
    private String d_nome;

    public DetalhesFilho() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(Integer aluno_id) {
        this.aluno_id = aluno_id;
    }

    public Integer getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(Integer disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public Integer getSemestre_id() {
        return semestre_id;
    }

    public void setSemestre_id(Integer semestre_id) {
        this.semestre_id = semestre_id;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_valor() {
        return f_valor;
    }

    public void setF_valor(String f_valor) {
        this.f_valor = f_valor;
    }

    public Integer getN_id() {
        return n_id;
    }

    public void setN_id(Integer n_id) {
        this.n_id = n_id;
    }

    public String getN_valor() {
        return n_valor;
    }

    public void setN_valor(String n_valor) {
        this.n_valor = n_valor;
    }

    public String getS_valor() {
        return s_valor;
    }

    public void setS_valor(String s_valor) {
        this.s_valor = s_valor;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_nome() {
        return d_nome;
    }

    public void setD_nome(String d_nome) {
        this.d_nome = d_nome;
    }
}
