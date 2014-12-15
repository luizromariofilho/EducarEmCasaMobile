package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NotasActivity extends Activity {
    private ListView listView;
    private List<DetalhesFilho> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas);
        listView = (ListView) findViewById(R.id.listView2);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        ArrayList<DetalhesFilho> detalhesFilho = (ArrayList<DetalhesFilho>) extras.getSerializable("detalhes");
        list = detalhesFilho;
        listView.setAdapter(new DetalhesFilhoNotaListAdapter(list, this));
    }
}