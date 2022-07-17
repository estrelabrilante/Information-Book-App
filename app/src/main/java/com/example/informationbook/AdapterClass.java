package com.example.informationbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//create an adapter class for binding data to recyclerView.
public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder>{
    private ArrayList<ModelClass> modelList;
    //define context class to use properties in this adapter class  .
    private Context context;
    //Generated constructor for adapter class.
    public AdapterClass( ArrayList<ModelClass> modelList, Context context ) {
        this.modelList = modelList;
        this.context = context;
    }
    //creates new view and viewholder --  only creates as much as view holder needed.
    //ADAPTER creates view holder objects as required by calling onCreateViewHolder method.
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);
        CardViewHolder viewHolder = new CardViewHolder(v);
        return viewHolder;
    }
    //ADAPTER binds data to viewholder by calling onBindViewHolder method.
    //adapter binds viewholder to their data by assigning viewholder to a postion.
    @Override
    public void onBindViewHolder( @NonNull CardViewHolder holder, @SuppressLint("RecyclerView") int position ) {
        ModelClass model = modelList.get(position);
        (holder).textViewSplash.setText(model.getCategoryName());
        //Here image is String datatype in ModelClass
        //or if image is a Int Data Type in Model Class
        //((CardViewHolder)holder.imageViewSplash.setImageResource(model.getImageName());
        holder.imageViewSplash.setImageResource(context.getResources().getIdentifier(model.getImageName(),"drawable",context.getPackageName()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                if(position == 0){
                Intent intent = new Intent(context,CountriesActivity.class);
                context.startActivity(intent);
                };
                if(position == 1){
                    Intent intent = new Intent(context,LeadersActivity.class);
                    context.startActivity(intent);
                };
                if(position == 2){
                    Intent intent = new Intent(context,MuseumActivity.class);
                    context.startActivity(intent);
                };
                if(position == 3){
                    Intent intent = new Intent(context,WondersActivity.class);
                    context.startActivity(intent);
                };

            }
        });

    }
   //find how many objects in the totalList
    @Override
    public int getItemCount() {

        return modelList.size();
    }

    //inner class: CardViewHolder represent card design.
    public class CardViewHolder extends RecyclerView.ViewHolder{
        //define properties
        private ImageView imageViewSplash;
        private TextView textViewSplash;
        private CardView cardView;
    //constructor generated for card view class.
        public CardViewHolder( @NonNull View itemView ) {
            super(itemView);
            //match id
            imageViewSplash = itemView.findViewById(R.id.imageViewSplash);
            textViewSplash = itemView.findViewById(R.id.textViewSplash);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
