package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainList_RecyclerViewAdapter extends RecyclerView.Adapter<MainList_RecyclerViewAdapter.MyViewHolder>{
    private OnItemListener mOnItemListener;
    Context context;
    ArrayList<ListModel> listModels;
    int[] type;

    public MainList_RecyclerViewAdapter(Context context, ArrayList<ListModel> listModels, OnItemListener onItemListener, int[] type) {
         this.context = context;
         this.listModels = listModels;
         this.mOnItemListener = onItemListener;
         this.type = type;
    }


    @NonNull
    @Override
    public MainList_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new MainList_RecyclerViewAdapter.MyViewHolder(view, mOnItemListener);
        
    }

    @Override
    public void onBindViewHolder(@NonNull MainList_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view
        holder.textViewListName.setText(listModels.get(position).getListName());
        holder.imageView.setImageResource(listModels.get(position).getImage());

        switch (type[position]) {
            case 0:
                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(context, MainActivity2.class);
                    context.startActivity(intent);
                });
                break;
            case 1:
                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(context, Kickoff_table_main.class);
                    context.startActivity(intent);
                });
                break;
            case 2:
                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(context, Skills_main.class);
                    context.startActivity(intent);
            });
                break;
            case 3:
                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(context, PassingChart.class);
                    context.startActivity(intent);
                });
                break;
            case 4:
                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(context, Foul_Table_Main.class);
                    context.startActivity(intent);
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        // the recycler view wants to know the number of items you want displayed
        return listModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // grabbing the views from our recycler_view_row layout file

        ImageView imageView;
        TextView textViewListName;
        OnItemListener onItemListener;
        public MyViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewListName = itemView.findViewById(R.id.textView);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           onItemListener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnItemListener{
        void onItemClick(int position);
    }
}
