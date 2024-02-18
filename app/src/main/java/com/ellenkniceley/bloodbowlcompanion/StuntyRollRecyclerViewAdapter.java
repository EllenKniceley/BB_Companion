package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StuntyRollRecyclerViewAdapter extends RecyclerView.Adapter<StuntyRollRecyclerViewAdapter.MyViewHolder> {

    private final StuntyRollRecyclerViewInterface stuntyRollRecyclerViewInterface;

    Context context;

    ArrayList<StuntyRollListModel> stuntyRollListModels;

    public StuntyRollRecyclerViewAdapter(Context context, ArrayList<StuntyRollListModel> stuntyRollListModels, StuntyRollRecyclerViewInterface stuntyRollRecyclerViewInterface) {
        this.context = context;
        this.stuntyRollListModels = stuntyRollListModels;
        this.stuntyRollRecyclerViewInterface = stuntyRollRecyclerViewInterface;
    }

    @NonNull
    @Override
    public StuntyRollRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.stunty_roll_recyclerview_row,parent,false);
        return new StuntyRollRecyclerViewAdapter.MyViewHolder(view, stuntyRollRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull StuntyRollRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvStuntyRollNumber.setText(stuntyRollListModels.get(position).getStuntyRollNumber());
        holder.tvStuntyRollHeader.setText(stuntyRollListModels.get(position).getStuntyRollTitle());
    }

    @Override
    public int getItemCount() {
        return stuntyRollListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvStuntyRollNumber;
        TextView tvStuntyRollHeader;
        public MyViewHolder(@NonNull View itemView, StuntyRollRecyclerViewInterface stuntyRollRecyclerViewInterface) {
            super(itemView);
            tvStuntyRollNumber = itemView.findViewById(R.id.stuntyRollNumber);
            tvStuntyRollHeader = itemView.findViewById(R.id.stuntyRollHeader);

            itemView.setOnClickListener(v -> {
                if (stuntyRollRecyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        stuntyRollRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
