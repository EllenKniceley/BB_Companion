package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SkillsRecyclerViewAdapter extends RecyclerView.Adapter<SkillsRecyclerViewAdapter.MyViewHolder> {
    private final SkillsRecyclerViewInterface skillsRecyclerViewInterface;
    Context context;
    ArrayList<SkillsListModel> skillsListModels;

    public SkillsRecyclerViewAdapter(Context context, ArrayList<SkillsListModel> skillsListModels, SkillsRecyclerViewInterface skillsRecyclerViewInterface) {
        this.context = context;
        this.skillsListModels = skillsListModels;
        this.skillsRecyclerViewInterface = skillsRecyclerViewInterface;
    }

    @NonNull
    @Override
    public SkillsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.skills_recyclerview_row, parent,false);
        return new MyViewHolder(view, skillsRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvSkillsHeader.setText(skillsListModels.get(position).getSkillsTitle());
    }

    @Override
    public int getItemCount() {
        return skillsListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvSkillsHeader;
        public MyViewHolder(@NonNull View itemView, SkillsRecyclerViewInterface skillsRecyclerViewInterface) {
            super(itemView);
            tvSkillsHeader = itemView.findViewById(R.id.skillsHeader);

            itemView.setOnClickListener(v -> {
                if (skillsRecyclerViewInterface != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        skillsRecyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
