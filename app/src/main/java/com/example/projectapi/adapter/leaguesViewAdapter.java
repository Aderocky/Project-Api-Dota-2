package com.example.projectapi.adapter;

import android.media.MediaPlayer;
import android.provider.MediaStore;
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
import com.example.projectapi.models.leagueidd;


import java.util.ArrayList;
import java.util.List;

public class leaguesViewAdapter extends RecyclerView.Adapter<leaguesViewAdapter.ViewHolder> {
    MediaPlayer mysingging;
    private List<leagueidd> leagueidList = new ArrayList<>();

    public leaguesViewAdapter(List<leagueidd> leagueidList) {

        this.leagueidList = leagueidList;
    }

    @NonNull
    @Override
    public leaguesViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_leagues,parent,false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull leaguesViewAdapter.ViewHolder holder, int position) {
        leagueidd QM = leagueidList.get(position);

        holder.tvid.setText(QM.getLeagueid());
        holder.tvname.setText(QM.getName());
        holder.tvtier.setText(QM.getTier());
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animasi));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),"Nama Tournament : " + QM.getName(),Toast.LENGTH_SHORT).show();
                mysingging= MediaPlayer.create(holder.itemView.getContext(),R.raw.crowd);
                mysingging.setVolume(100,100);
                mysingging.start();
            }
        });


    }

    @Override
    public int getItemCount() {
        return leagueidList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvid, tvname ,tvtier;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.tv_leagueid);
            tvtier = itemView.findViewById(R.id.tv_tier);
            tvname = itemView.findViewById(R.id.tv_name);
            cardView = itemView.findViewById(R.id.cv_league);


        }
    }
}
