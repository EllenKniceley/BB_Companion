package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Kickoff_RecyclerViewAdapter extends RecyclerView.Adapter<Kickoff_RecyclerViewAdapter.MyViewHolder> {

    private final KickoffRecyclerViewInterface kickoffRecyclerViewInterface;
    Context context;

    ArrayList<KickoffListModel> kickoffListModels;

    public Kickoff_RecyclerViewAdapter(Context context,ArrayList<KickoffListModel> kickoffListModels, KickoffRecyclerViewInterface kickoffRecyclerViewInterface){
        this.context = context;
        this.kickoffListModels = kickoffListModels;
        this.kickoffRecyclerViewInterface = kickoffRecyclerViewInterface;
    }

    @NonNull
    @Override
    public Kickoff_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.kickoff_recyclerview_row,parent,false);
        return new Kickoff_RecyclerViewAdapter.MyViewHolder(view, kickoffRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Kickoff_RecyclerViewAdapter.MyViewHolder holder, int position) {
       holder.tvKickoffNumber.setText(kickoffListModels.get(position).getKickoffNumber());
       holder.tvKickoffTitle.setText(kickoffListModels.get(position).getKickoffTitle());
    }

    @Override
    public int getItemCount() {
        return kickoffListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvKickoffNumber;
        TextView tvKickoffTitle;

        public MyViewHolder(@NonNull View itemView, KickoffRecyclerViewInterface kickoffRecyclerViewInterface)  {
            super(itemView);
            tvKickoffNumber = itemView.findViewById(R.id.kickoffNumbers);
            tvKickoffTitle = itemView.findViewById(R.id.kickoffHeader);

            itemView.setOnClickListener(v -> {
                if (kickoffRecyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        kickoffRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
