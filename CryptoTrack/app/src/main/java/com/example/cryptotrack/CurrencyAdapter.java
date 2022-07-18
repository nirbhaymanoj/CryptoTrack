package com.example.cryptotrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {
    private ArrayList<CurrencyModalClass> currencyModalClassArrayList;
    private Context context;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public CurrencyAdapter(ArrayList<CurrencyModalClass> currencyModalClassArrayList, Context context) {
        this.currencyModalClassArrayList = currencyModalClassArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<CurrencyModalClass> filteredList){
        currencyModalClassArrayList = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_currency,parent,false);
        return new CurrencyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyAdapter.ViewHolder holder, int position) {
     CurrencyModalClass currencyModalClass = currencyModalClassArrayList.get(position);
     holder.rate.setText("$ "+df2.format(currencyModalClass.getPrice()));
     holder.name.setText(currencyModalClass.getName());
     holder.symbol.setText(currencyModalClass.getSymbol());
    }

    @Override
    public int getItemCount() {
        return currencyModalClassArrayList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private TextView name,symbol,rate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            symbol = itemView.findViewById(R.id.symbol);
            rate = itemView.findViewById(R.id.rate);
        }
    }
}
