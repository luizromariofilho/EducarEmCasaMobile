package com.example.educarcasamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

/**
 * Created by Luiz Romario Filho on 12/13/2014.
 */
public class SelecionarFilhoActivity extends Activity {
    private List<Filho> list;
    private ListView listView;
    private static final int REQUEST_DETALHES_CODE = 1;

    {
        list = new ArrayList<Filho>();
        list.add(new Filho(1, "Teste Filho 1"));
        list.add(new Filho(2, "Teste Filho 2"));
        list.add(new Filho(3, "Teste Filho 3"));
        list.add(new Filho(4, "Teste Filho 4"));
        list.add(new Filho(5, "Teste Filho 5"));
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecionar_filho);
        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new FilhoListAdapter(list, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Filho filho = list.get(parseInt(String.valueOf(parent.getItemIdAtPosition(position))));
                Intent intent = new Intent(SelecionarFilhoActivity.this, DetalhesActivity.class);
                Bundle parametro = new Bundle();
                parametro.putSerializable("filho",filho);
                intent.putExtras(parametro);
                startActivityForResult(intent,REQUEST_DETALHES_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_DETALHES_CODE){
            listView.setAdapter(new FilhoListAdapter(list, this));
        }
    }
}