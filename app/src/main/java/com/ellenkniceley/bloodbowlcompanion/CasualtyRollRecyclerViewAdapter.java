package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CasualtyRollRecyclerViewAdapter extends RecyclerView.Adapter<CasualtyRollRecyclerViewAdapter.MyViewHolder> {

    private final CasualtyRollRecyclerViewInterface casualtyRollRecyclerViewInterface;

    Context context;

    ArrayList<CasualtyRollListModel> casualtyRollListModels;

    public CasualtyRollRecyclerViewAdapter(Context context, ArrayList<CasualtyRollListModel> casualtyRollListModels, CasualtyRollRecyclerViewInterface casualtyRollRecyclerViewInterface) {
        this.context = context;
        this.casualtyRollListModels = casualtyRollListModels;
        this.casualtyRollRecyclerViewInterface = casualtyRollRecyclerViewInterface;
    }

    @NonNull
    @Override
    public CasualtyRollRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.casualty_roll_recyclerview_row,parent,false);
        return new CasualtyRollRecyclerViewAdapter.MyViewHolder(view, casualtyRollRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CasualtyRollRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvCasualtyRollNumber.setText(casualtyRollListModels.get(position).getCasualtyRollNumber());
        holder.tvCasualtyRollHeader.setText(casualtyRollListModels.get(position).getCasualtyRollTitle());
    }

    @Override
    public int getItemCount() {
        return casualtyRollListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCasualtyRollNumber;
        TextView tvCasualtyRollHeader;
        public MyViewHolder(@NonNull View itemView, CasualtyRollRecyclerViewInterface casualtyRollRecyclerViewInterface) {
            super(itemView);
            tvCasualtyRollNumber = itemView.findViewById(R.id.casualtyRollNumber);
            tvCasualtyRollHeader = itemView.findViewById(R.id.casualtyRollHeader);

            itemView.setOnClickListener(v -> {
                if (casualtyRollRecyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        casualtyRollRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
