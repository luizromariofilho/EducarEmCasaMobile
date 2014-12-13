package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    private Integer idResponsavel;

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
            List<Filho> filhos = loginOnServer(email, password);
            if(filhos != null){
                if (filhos.size() == 1) {
                    this.navigateToDetalhes(view);
                } else {
                    this.navigateToSelecionarFilho(view);
                }
                this.finish();
            } else {
                txtErrorServer.setVisibility(View.VISIBLE);
                txtErrorLogin.setVisibility(View.GONE);
            }
        } else{
            txtErrorLogin.setVisibility(View.VISIBLE);
            txtErrorServer.setVisibility(View.GONE);
        }
    }

    private List<Filho> loginOnServer(String email, String password) {
        Integer idResponsavel = login(email,password);
        this.filhos = getFilhos(idResponsavel);
        return this.filhos;
    }

    private List<Filho> getFilhos(Integer idResponsavel) {
        return null;
    }

    private Integer login(String email, String password) {
        Tarefa tarefaPost;
            String json = "{'email': '" + email + "', 'senha':'" + password + "'}";
            tarefaPost = new Tarefa(Util.URL_WEBSERVICE + "/loginmobile.php",json);
            tarefaPost.setEventListen(new TarefaEvents() {
                @Override
                public void onCompleta(String retorno) {
                    Integer id = gson.fromJson(retorno, Integer.class);
                    setIdResponsavel(id);
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
            tarefaPost.executar(true);
        return null;
    }


    private void navigateToDetalhes(View view){
        Intent detalhesIntent = new Intent(this,DetalhesActivity.class);
        startActivity(detalhesIntent);
    }

    private void navigateToSelecionarFilho(View view){
        Intent homeIntent = new Intent(this,SelecionarFilhoActivity.class);
        startActivity(homeIntent);
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}