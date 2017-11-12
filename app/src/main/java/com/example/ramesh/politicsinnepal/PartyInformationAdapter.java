package com.example.ramesh.politicsinnepal;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ramesh.politicsinnepal.PartyData.title;

/**
 * Created by ramesh on 10/23/17.
 */

public class PartyInformationAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_partylist,parent,false);


        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {

        return title.length;
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView partyLogo;
        private TextView partyName;
        private TextView estDate;
        private TextView extraImfo;
        private CardView informationRow;



        Context context;

        public ListViewHolder(View itemView){
            super(itemView);
            partyLogo = itemView.findViewById(R.id.partyLogo);
            partyName =itemView.findViewById(R.id.partyName);
            estDate = itemView.findViewById(R.id.estDate);
            extraImfo = itemView.findViewById(R.id.extraImfo);
            informationRow = itemView.findViewById(R.id.informationRow);

            itemView.setOnClickListener(this);


            informationRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view ) {
                    String partyName = PartyData.title[getAdapterPosition()];

                    Toast.makeText(view.getContext(), partyName, Toast.LENGTH_SHORT).show();
                }

            });
        }


        public void bindView(int position){
            partyLogo.setImageResource(PartyData.picturePath[position]);
            partyName.setText(title[position]);
            estDate.setText(PartyData.estDates[position]);
            extraImfo.setText(PartyData.extraInfo[position]);
        }

        public void onClick(View view){

        }



    }
}
