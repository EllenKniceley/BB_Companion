package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Foul_RecyclerViewAdapter extends RecyclerView.Adapter<Foul_RecyclerViewAdapter.MyViewHolder> {

private final FoulRecyclerViewInterface foulRecyclerViewInterface;

Context context;
ArrayList<FoulListModel> foulListModels;

    public Foul_RecyclerViewAdapter(Context context, ArrayList<FoulListModel> foulListModels, FoulRecyclerViewInterface foulRecyclerViewInterface) {
        this.context = context;
        this.foulListModels = foulListModels;
        this.foulRecyclerViewInterface = foulRecyclerViewInterface;
    }

    @NonNull
    @Override
    public Foul_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.foul_recyclerview_row,parent,false);
        return new Foul_RecyclerViewAdapter.MyViewHolder(view, foulRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Foul_RecyclerViewAdapter.MyViewHolder holder, int position) {
       holder.tvFoulNumber.setText(foulListModels.get(position).getFoulNumber());
       holder.tvFoulTitle.setText(foulListModels.get(position).getFoulTitle());
    }

    @Override
    public int getItemCount() {
        return foulListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvFoulNumber;
        TextView tvFoulTitle;

        public MyViewHolder(@NonNull View itemView, FoulRecyclerViewInterface foulRecyclerViewInterface) {
            super(itemView);
            tvFoulNumber = itemView.findViewById(R.id.foulNumbers);
            tvFoulTitle = itemView.findViewById(R.id.foulHeader);

            itemView.setOnClickListener(v -> {
                if (foulRecyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        foulRecyclerViewInterface.onItemClick(pos);
                    }
                }
            }

            );
        }
    }
}
