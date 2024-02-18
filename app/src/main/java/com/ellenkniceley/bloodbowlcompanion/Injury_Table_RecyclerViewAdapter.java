package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Injury_Table_RecyclerViewAdapter extends RecyclerView.Adapter<Injury_Table_RecyclerViewAdapter.MyViewHolder> {

    private final InjuryTableRecyclerViewInterface injuryTableRecyclerViewInterface;

    Context context;
    ArrayList<InjuryTableListModel> injuryTableListModels;
    int[] type;

    public Injury_Table_RecyclerViewAdapter(Context context, ArrayList<InjuryTableListModel> injuryTableListModels, InjuryTableRecyclerViewInterface injuryTableRecyclerViewInterface, int[] type) {
        this.context = context;
        this.injuryTableListModels = injuryTableListModels;
        this.injuryTableRecyclerViewInterface = injuryTableRecyclerViewInterface;
        this.type = type;
    }

    @NonNull
    @Override
    public Injury_Table_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.injurytable_recyclerview_row,parent,false);
        return new MyViewHolder(view, injuryTableRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Injury_Table_RecyclerViewAdapter.MyViewHolder holder, int position) {
       holder.tvInjuryListTitle.setText(injuryTableListModels.get(position).getInjuryListTitle());

       switch (type[position]) {
           case 0:
               holder.itemView.setOnClickListener(v -> {
                   Intent intent = new Intent(context, Injury_Roll_Main.class);
                   context.startActivity(intent);
               });
               break;
           case 1:
               holder.itemView.setOnClickListener(v -> {
                   Intent intent = new Intent(context, Stunty_Roll_Main.class);
                   context.startActivity(intent);
               });
               break;
       }
    }

    @Override
    public int getItemCount() {
        return injuryTableListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvInjuryListTitle;
        public MyViewHolder(@NonNull View itemView, InjuryTableRecyclerViewInterface injuryTableRecyclerViewInterface) {
            super(itemView);
            tvInjuryListTitle = itemView.findViewById(R.id.injuryTableHeaderList);

            itemView.setOnClickListener(v -> {
                if (injuryTableRecyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        injuryTableRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
