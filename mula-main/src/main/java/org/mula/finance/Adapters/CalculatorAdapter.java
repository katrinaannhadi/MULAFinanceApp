package org.mula.finance.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.mula.finance.Models.IntentLink;
import org.mula.finance.R;

import java.util.ArrayList;

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.CalculatorViewHolder> {

    private ArrayList<IntentLink> data;

    public CalculatorAdapter(ArrayList<IntentLink> data) {this.data = data;}


    public static class CalculatorViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private Button searchBtn;

        //private ImageView drawable;
        private TextView textView;

        public CalculatorViewHolder(View view) {
            super(view);
            this.view = view;
            //drawable = view.findViewById(R.id.image_calculator);
            textView = view.findViewById(R.id.text_calculator);

        }
    }

    @NonNull
    @Override
    public CalculatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chunk_calculator, parent, false);
        CalculatorViewHolder calcViewHolder = new CalculatorViewHolder(v);



        return calcViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull CalculatorViewHolder calcViewHolder, int position){

        final IntentLink intentLink = data.get(position);

        Drawable icon = calcViewHolder.view.getResources().getDrawable(intentLink.getLinkDrawable());
        calcViewHolder.view.setBackground(icon);
        calcViewHolder.textView.setText(intentLink.getLinkName());
        calcViewHolder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context c = view.getContext();
                Intent intent = intentLink.getLinkIntent();
                switch(intentLink.getLinkName()){
                    case "Credit":
                        intent.putExtra("Difficulty", 1);
                        break;
                    case "Investment":
                        intent.putExtra("Difficulty", 2);
                        break;
                    case "Savings":
                        intent.putExtra("Difficulty", 3);
                        break;
                    default:
                        break;
                }
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return data.size();}
    public ArrayList<IntentLink> getData() {return this.data;}


}
