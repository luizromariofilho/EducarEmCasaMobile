package com.example.educarcasamobile;

public interface TarefaEvents {
    public void onCompleta(String retorno);
    public void onFalha(String retorno);
    public void onIniciada();
}
