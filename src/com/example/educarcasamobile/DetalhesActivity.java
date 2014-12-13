package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Luiz Romario Filho on 12/13/2014.
 */
public class DetalhesActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes);

    }

    public void btnNotasOnClick(View view){
        Intent intent = new Intent(DetalhesActivity.this,NotasActivity.class);
        startActivity(intent);
//        this.finish();
    }

    public void btnFaltasOnClick(View view){
        Intent intent = new Intent(DetalhesActivity.this,FaltasActivity.class);
        startActivity(intent);
//        this.finish();
    }
}