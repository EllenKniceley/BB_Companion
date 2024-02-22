package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NuffleTableRecyclerViewAdapter extends RecyclerView.Adapter<NuffleTableRecyclerViewAdapter.MyViewHolder> {
    private final NuffleTableRecyclerViewInterface nuffleTableRecyclerViewInterface;

    Context context;

    ArrayList<NuffleTableListModel> nuffleTableListModels;

    public NuffleTableRecyclerViewAdapter(Context context, ArrayList<NuffleTableListModel> nuffleTableListModels, NuffleTableRecyclerViewInterface nuffleTableRecyclerViewInterface) {
        this.context = context;
        this.nuffleTableListModels = nuffleTableListModels;
        this.nuffleTableRecyclerViewInterface = nuffleTableRecyclerViewInterface;
    }

    @NonNull
    @Override
    public NuffleTableRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.nuffle_table_recyclerview_row,parent,false);
        return new NuffleTableRecyclerViewAdapter.MyViewHolder(view, nuffleTableRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NuffleTableRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvNuffleTableNumber.setText(nuffleTableListModels.get(position).getNuffleTableNumber());
        holder.tvNuffleTableHeader.setText(nuffleTableListModels.get(position).getNuffleTableTitle());
    }

    @Override
    public int getItemCount() {
        return nuffleTableListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNuffleTableNumber;
        TextView tvNuffleTableHeader;
        public MyViewHolder(@NonNull View itemView, NuffleTableRecyclerViewInterface nuffleTableRecyclerViewInterface) {
            super(itemView);
            tvNuffleTableNumber = itemView.findViewById(R.id.nuffleTableNumber);
            tvNuffleTableHeader = itemView.findViewById(R.id.nuffleTableHeader);

            itemView.setOnClickListener(v -> {
                if (nuffleTableRecyclerViewInterface != null){
                    int pos = getAdapterPosition();

                    if (pos!= RecyclerView.NO_POSITION){
                        nuffleTableRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
