package com.example.educarcasamobile;

import java.io.Serializable;

/**
 * Created by Luiz Romario Filho on 12/15/2014.
 */
public class Login implements Serializable {
    private Integer permissao;
    private Integer id;

    public Login() {
    }

    public Login(Integer permissao, Integer id) {
        this.permissao = permissao;
        this.id = id;
    }

    public Integer getPermissao() {
        return permissao;
    }

    public void setPermissao(Integer permissao) {
        this.permissao = permissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
