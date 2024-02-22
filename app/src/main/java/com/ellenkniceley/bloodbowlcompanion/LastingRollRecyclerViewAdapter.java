package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LastingRollRecyclerViewAdapter extends RecyclerView.Adapter<LastingRollRecyclerViewAdapter.MyViewHolder> {
    private final LastingRollRecyclerViewInterface lastingRollRecyclerViewInterface;

    Context context;

    ArrayList<LastingRollListModel> lastingRollListModels;

    public LastingRollRecyclerViewAdapter(Context context, ArrayList<LastingRollListModel> lastingRollListModels, LastingRollRecyclerViewInterface lastingRollRecyclerViewInterface){
        this.context = context;
        this.lastingRollListModels = lastingRollListModels;
        this.lastingRollRecyclerViewInterface = lastingRollRecyclerViewInterface;
    }
    @NonNull
    @Override
    public LastingRollRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lasting_roll_recyclerview_roll,parent,false);
        return new LastingRollRecyclerViewAdapter.MyViewHolder(view, lastingRollRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull LastingRollRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvLastingRollNumber.setText(lastingRollListModels.get(position).getLastingRollNumber());
        holder.tvLastingRollHeader.setText(lastingRollListModels.get(position).getLastingRollTitle());
    }

    @Override
    public int getItemCount() {
        return lastingRollListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLastingRollNumber;
        TextView tvLastingRollHeader;
        public MyViewHolder(@NonNull View itemView, LastingRollRecyclerViewInterface lastingRollRecyclerViewInterface) {
            super(itemView);
            tvLastingRollNumber = itemView.findViewById(R.id.lastingRollNumber);
            tvLastingRollHeader = itemView.findViewById(R.id.lastingRollHeader);

            itemView.setOnClickListener(v -> {
                if (lastingRollRecyclerViewInterface != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        lastingRollRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
