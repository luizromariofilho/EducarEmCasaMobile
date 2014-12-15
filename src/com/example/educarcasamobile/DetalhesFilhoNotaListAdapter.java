package com.example.educarcasamobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luiz Romario Filho on 12/13/2014.
 */
public class DetalhesFilhoNotaListAdapter extends BaseAdapter {
    private List<DetalhesFilho> detalhesFilhos;
    private Context context;

    public DetalhesFilhoNotaListAdapter(List<DetalhesFilho> detalhesFilhos, Context context) {
        this.detalhesFilhos = detalhesFilhos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return detalhesFilhos.size();
    }

    @Override
    public Object getItem(int position) {
        return detalhesFilhos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return detalhesFilhos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DetalhesFilho detalhesFilho = (DetalhesFilho) this.getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_filho_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.txtNomeFilho);
        textView.setText(detalhesFilho.getD_nome() + " - " + detalhesFilho.getS_valor() + " - " + detalhesFilho.getN_valor());

        return view;
    }
}
