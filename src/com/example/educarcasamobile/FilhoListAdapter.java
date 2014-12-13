package com.example.educarcasamobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luiz Romario Filho on 12/13/2014.
 */
public class FilhoListAdapter extends BaseAdapter {
    private List<Filho> filhos;
    private Context context;

    public FilhoListAdapter(List<Filho> filhos, Context context) {
        this.filhos = filhos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return filhos.size();
    }

    @Override
    public Object getItem(int position) {
        return filhos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return filhos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Filho filho = (Filho) this.getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_filho_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.txtNomeFilho);
        textView.setText(filho.getNome());

        return view;
    }
}
