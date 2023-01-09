package com.example.projectapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.projectapi.R;
import com.example.projectapi.models.teamss;

import java.util.ArrayList;
import java.util.List;

public class teamsViewAdapter extends RecyclerView.Adapter<teamsViewAdapter.ViewHolder> {
    private List<teamss> teamsList = new ArrayList<>();

    public teamsViewAdapter(List<teamss> teamsList) {

        this.teamsList = teamsList;
    }

    @NonNull
    @Override
    public teamsViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_teams,parent,false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull teamsViewAdapter.ViewHolder holder, int position) {
        teamss QM = teamsList.get(position);

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animasi));
        holder.tvid.setText(QM.getTeams_id());
        holder.tvname.setText(QM.getName());
        holder.tvlose.setText(QM.getLosses());
        holder.tvrating.setText(QM.getRating());
        holder.tvwins.setText(QM.getWins());
        holder.tvtag.setText(QM.getTag());
        holder.tvmatch.setText(QM.getLast_match_time());
        Glide.with(holder.itemView.getContext()).load(QM.getLogo_url()).apply(new RequestOptions().override(100,100)).into(holder.ivtim);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),"Nama Team : " + QM.getName(),Toast.LENGTH_SHORT).show();
                holder.ivtim.startAnimation(AnimationUtils.loadAnimation(holder.ivtim.getContext(), R.anim.zoom_in));
            }
        });



    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvid, tvname , tvmatch , tvrating , tvlose,tvwins,tvtag;
        private ImageView ivtim;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.tv_teamid);
            tvname = itemView.findViewById(R.id.tv_name);
            tvmatch = itemView.findViewById(R.id.tv_last_match_time);
            tvlose = itemView.findViewById(R.id.tv_losses);
            tvtag = itemView.findViewById(R.id.tv_tag);
            ivtim = itemView.findViewById(R.id.gambar);
            tvwins = itemView.findViewById(R.id.tv_wins);
            tvrating = itemView.findViewById(R.id.tv_rating);
            cardView = itemView.findViewById(R.id.cv_teams);

        }
    }
}
