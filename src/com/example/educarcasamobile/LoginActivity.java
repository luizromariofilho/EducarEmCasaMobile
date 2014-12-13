package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private EditText txtLogin;
    protected EditText txtPassword;
    private TextView txtError;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.txtLogin = (EditText) findViewById(R.id.txtLogin);
        this.txtPassword = (EditText) findViewById(R.id.txtPassword);
        this.txtError = (TextView) findViewById(R.id.txtError);
        this.txtError.setVisibility(View.GONE);
    }

    public void btnLoginOnClick(View view){
        String email = txtLogin.getText().toString();
        String password = txtPassword.getText().toString();

        if(Util.validate(email) && Util.isNotNull(password)){
            if("luizromariofilho@gmail.com".equalsIgnoreCase(email) && "1234".equalsIgnoreCase(password)){ // TODO simulate 1 son
                this.navigateToDetalhes(view);
            } else{
                this.navigateToSelecionarFilho(view);
            }
            this.finish();
        } else{
            txtError.setVisibility(View.VISIBLE);
        }
    }


    private void navigateToDetalhes(View view){
        Intent detalhesIntent = new Intent(this,DetalhesActivity.class);
        startActivity(detalhesIntent);
    }

    private void navigateToSelecionarFilho(View view){
        Intent homeIntent = new Intent(this,SelecionarFilhoActivity.class);
        startActivity(homeIntent);
    }
}