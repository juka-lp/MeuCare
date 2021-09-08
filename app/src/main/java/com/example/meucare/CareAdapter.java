package com.example.meucare;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CareAdapter extends RecyclerView.Adapter<CareAdapter.CareViewHolder>{

    //neste contexto, usaremos para inflar o layout
    private Context mCtx;

    //estamos armazenando todos os produtos em uma lista
    private List<Care> careList;

    //obter o contexto e a lista de produtos com o construtor
    public CareAdapter(Context mCtx, List<Care> careList) {
        this.mCtx = mCtx;
        this.careList = careList;
    }

    @Override
    public CareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.care_view, null);
        return new CareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CareViewHolder holder, int position) {
        //obtendo o produto da posição especificada
        Care care = careList.get(position);

        //vinculando os dados com as visualizações do visualizador
        holder.textViewTitle.setText(care.getTitle());
        holder.textViewShortDesc.setText(care.getShortdesc());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(care.getImage()));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implement onClick
                Log.d("Clicoooou", String.valueOf(care.getTitle()));
                holder.cardView.getContext().startActivity(new Intent(holder.cardView.getContext(), ProfileActivity.class));

            }
        });


    }


    @Override
    public int getItemCount() {
        return careList.size();
    }


    class CareViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;
        CardView cardView;

        public CareViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
