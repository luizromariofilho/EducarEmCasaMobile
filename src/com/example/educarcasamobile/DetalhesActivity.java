package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class DetalhesActivity extends Activity {
    private Filho filho;
    private TextView txtNomeFilho;
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private Intent notasIntent;
    private Intent faltasIntent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        notasIntent = new Intent(DetalhesActivity.this, NotasActivity.class);
        faltasIntent = new Intent(DetalhesActivity.this, FaltasActivity.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes);
        txtNomeFilho = (TextView) findViewById(R.id.txtNomeFilho);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Filho filho = (Filho)extras.getSerializable("filho");
        this.filho = filho;
        txtNomeFilho.setText(filho.getNome());
    }

    public void btnNotasOnClick(View view){
        Tarefa tarefa;
        tarefa = new Tarefa(Util.URL_WEBSERVICE + "/classes/aluno/buscar-detalhes.php?id_filho=" + filho.getId());
        tarefa.setEventListen(new TarefaEvents() {
            @Override
            public void onCompleta(String retorno) {
                TypeToken<List<DetalhesFilho>> token = new TypeToken<List<DetalhesFilho>>() {};
                ArrayList<DetalhesFilho> detalhes = gson.fromJson(retorno, token.getType());
                Bundle parametro = new Bundle();
                parametro.putSerializable("detalhes",detalhes);
                notasIntent.putExtras(parametro);
                startActivity(notasIntent);
            }

            @Override
            public void onFalha(String retorno) {
                System.out.println(retorno);
                System.out.println("Erro ao sincronizar!");
            }

            @Override
            public void onIniciada() {
                System.out.println("Iniciando sincronização!");
            }
        });
        tarefa.executar(true);
    }

    public void btnFaltasOnClick(View view){
        Tarefa tarefa;
        tarefa = new Tarefa(Util.URL_WEBSERVICE + "/classes/aluno/buscar-detalhes.php?id_filho=" + filho.getId());
        tarefa.setEventListen(new TarefaEvents() {
            @Override
            public void onCompleta(String retorno) {
                TypeToken<List<DetalhesFilho>> token = new TypeToken<List<DetalhesFilho>>() {};
                ArrayList<DetalhesFilho> detalhes = gson.fromJson(retorno, token.getType());
                Bundle parametro = new Bundle();
                parametro.putSerializable("detalhes",detalhes);
                faltasIntent.putExtras(parametro);
                startActivity(faltasIntent);
            }

            @Override
            public void onFalha(String retorno) {
                System.out.println(retorno);
                System.out.println("Erro ao sincronizar!");
            }

            @Override
            public void onIniciada() {
                System.out.println("Iniciando sincronização!");
            }
        });
        tarefa.executar(true);
    }
}