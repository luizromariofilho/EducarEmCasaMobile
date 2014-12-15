package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private EditText txtLogin;
    protected EditText txtPassword;
    private TextView txtErrorLogin;
    private TextView txtErrorServer;
    private List<Filho> filhos;
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.txtLogin = (EditText) findViewById(R.id.txtLogin);
        this.txtPassword = (EditText) findViewById(R.id.txtPassword);

        this.txtErrorLogin = (TextView) findViewById(R.id.txtErrorLogin);
        this.txtErrorServer = (TextView) findViewById(R.id.txtErrorServer);

        this.txtErrorLogin.setVisibility(View.GONE);
        this.txtErrorServer.setVisibility(View.GONE);
    }

    public void btnLoginOnClick(View view){
        String email = txtLogin.getText().toString();
        String password = txtPassword.getText().toString();

        if(Util.validate(email) && Util.isNotNull(password)){
            loginOnServer(email, password);
        } else{
            txtErrorLogin.setVisibility(View.VISIBLE);
            txtErrorServer.setVisibility(View.GONE);
        }
    }

    private void loginOnServer(String email, String password) {
        login(email,password);
    }

    private List<Filho> getFilhos(Integer idResponsavel) {
        Tarefa tarefa;
        tarefa = new Tarefa(Util.URL_WEBSERVICE + "/classes/aluno/buscar-por-pai.php?id=" + idResponsavel);
        tarefa.setEventListen(new TarefaEvents() {
            @Override
            public void onCompleta(String retorno) {
                TypeToken<List<Filho>> token = new TypeToken<List<Filho>>() {};
                ArrayList<Filho> filhos= gson.fromJson(retorno, token.getType());
                setFilhos(filhos);
                if(filhos != null){
                    if (filhos.size() == 1) {
                        navigateToDetalhes(filhos.get(0));
                    } else {
                        navigateToSelecionarFilho(filhos);
                    }
                    finish();
                } else {
                    txtErrorServer.setVisibility(View.VISIBLE);
                    txtErrorLogin.setVisibility(View.GONE);
                }
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
        return this.filhos;
    }

    private void setFilhos(List<Filho> filhos) {
        this.filhos = filhos;
    }

    private Integer login(String email, String password) {
        Tarefa tarefa;
        tarefa = new Tarefa(Util.URL_WEBSERVICE + "/classes/utils/login.php?username="+ email + "&password=" + password);
        tarefa.setEventListen(new TarefaEvents() {
            @Override
            public void onCompleta(String retorno) {
                Login login = gson.fromJson(retorno, Login.class);
                getFilhos(login.getId());
            }

            @Override
            public void onFalha(String retorno) {
                System.out.println(retorno);
                System.out.println("Falha ao sincronizar.");
            }

            @Override
            public void onIniciada() {
                System.out.println("Iniciando sincronização.");
            }
        });
        tarefa.executar(true);
        return null;
    }


    private void navigateToDetalhes(Filho filho){
        Intent intent = new Intent(this,DetalhesActivity.class);
        Bundle parametro = new Bundle();
        parametro.putSerializable("filho",filho);
        intent.putExtras(parametro);
        startActivity(intent);
    }

    private void navigateToSelecionarFilho(ArrayList<Filho> filhos){
        Intent intent = new Intent(this,SelecionarFilhoActivity.class);
        Bundle parametro = new Bundle();
        parametro.putSerializable("filhos",filhos);
        intent.putExtras(parametro);
        startActivity(intent);
    }
}