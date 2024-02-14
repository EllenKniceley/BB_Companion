package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InjuryRollRecyclerViewAdapter extends RecyclerView.Adapter<InjuryRollRecyclerViewAdapter.MyViewHolder> {

    private final InjuryRollRecyclerViewInterface injuryRollRecyclerViewInterface;

    Context context;

    ArrayList<InjuryRollListModel> injuryRollListModels;

    public InjuryRollRecyclerViewAdapter(Context context, ArrayList<InjuryRollListModel> injuryRollListModels,InjuryRollRecyclerViewInterface injuryRollRecyclerViewInterface) {
        this.context = context;
        this.injuryRollListModels = injuryRollListModels;
        this.injuryRollRecyclerViewInterface = injuryRollRecyclerViewInterface;
    }


    @NonNull
    @Override
    public InjuryRollRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.injury_roll_recyclerview_row,parent,false);
        return new InjuryRollRecyclerViewAdapter.MyViewHolder(view, injuryRollRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull InjuryRollRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvInjuryRollNumber.setText(injuryRollListModels.get(position).getInjuryRollNumber());
        holder.tvInjuryRollTitle.setText(injuryRollListModels.get(position).getInjuryRollTitle());
    }

    @Override
    public int getItemCount() {
        return injuryRollListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvInjuryRollNumber;
        TextView tvInjuryRollTitle;
        public MyViewHolder(@NonNull View itemView, InjuryRollRecyclerViewInterface injuryRollRecyclerViewInterface) {
            super(itemView);
            tvInjuryRollNumber = itemView.findViewById(R.id.injuryRollNumber);
            tvInjuryRollTitle = itemView.findViewById(R.id.injuryRollHeader);

            itemView.setOnClickListener(v -> {
                if (injuryRollRecyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        injuryRollRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
