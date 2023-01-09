package com.example.projectapi.adapter;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectapi.R;
import com.example.projectapi.SplashScreen;
import com.example.projectapi.models.heroess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class heroesViewAdapter extends RecyclerView.Adapter<heroesViewAdapter.ViewHolder> {
    MediaPlayer mysing,mying1,mying2,mying3,mying4,mying5,mying6,mying7,mying8,mying9,mying10,mying11,mysing12,mysing13,mysing14,mysing15,mysing16,mysing17;
    private List<heroess> heroesList = new ArrayList<>();

    public heroesViewAdapter(List<heroess> heroesList) {
        this.heroesList = heroesList;

    }

    @NonNull
    @Override
    public heroesViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_heroes,parent,false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull heroesViewAdapter.ViewHolder holder, int position) {
        heroess QM = heroesList.get(position);

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animasi));
        holder.tvid.setText(QM.getId());
        holder.tvname.setText(QM.getName());
        holder.tvlocalname.setText(QM.getLocalized_name());
        holder.tvprimaryatt.setText(QM.getPrimary_attr());
        holder.tvatttype.setText(QM.getAttack_type());
        holder.tvkaki.setText(QM.getLegs());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),"Nama Hero : " + QM.getLocalized_name(),Toast.LENGTH_SHORT).show();
                Random rand = new Random();
                int ngerendom = rand.nextInt(17);
                mysing= MediaPlayer.create(holder.itemView.getContext(),R.raw.arkosh);
                mying1=MediaPlayer.create(holder.itemView.getContext(),R.raw.eyik);
                mying2=MediaPlayer.create(holder.itemView.getContext(),R.raw.doom);
                mying3=MediaPlayer.create(holder.itemView.getContext(),R.raw.firestart);
                mying4=MediaPlayer.create(holder.itemView.getContext(),R.raw.gambled);
                mying5=MediaPlayer.create(holder.itemView.getContext(),R.raw.hhhraaa);
                mying6=MediaPlayer.create(holder.itemView.getContext(),R.raw.hrraaaaar);
                mying7=MediaPlayer.create(holder.itemView.getContext(),R.raw.mmmmhhhaaaaaaaa);
                mying8=MediaPlayer.create(holder.itemView.getContext(),R.raw.notready);
                mying9=MediaPlayer.create(holder.itemView.getContext(),R.raw.ouhhells);
                mying10=MediaPlayer.create(holder.itemView.getContext(),R.raw.youlucky);
                mying11=MediaPlayer.create(holder.itemView.getContext(),R.raw.vodoomdeath);
                mysing12=MediaPlayer.create(holder.itemView.getContext(),R.raw.yes);
                mysing13=MediaPlayer.create(holder.itemView.getContext(),R.raw.underattck);
                mysing14=MediaPlayer.create(holder.itemView.getContext(),R.raw.doomdeath);
                mysing15=MediaPlayer.create(holder.itemView.getContext(),R.raw.doomkill);
                mysing16=MediaPlayer.create(holder.itemView.getContext(),R.raw.domemove);
                mysing17=MediaPlayer.create(holder.itemView.getContext(),R.raw.doomtahnks);
                if(ngerendom == 0){
                    mysing.setVolume(100,100);
                    mysing.start();
                }
                if(ngerendom == 1){
                    mying1.setVolume(100,100);
                    mying1.start();
                }
                if(ngerendom == 2){
                    mying2.setVolume(100,100);
                    mying2.start();
                }
                if(ngerendom == 3){
                    mying3.setVolume(100,100);
                    mying3.start();
                }
                if(ngerendom == 4){
                    mying4.setVolume(100,100);
                    mying4.start();
                }
                if(ngerendom == 5){
                    mying5.setVolume(100,100);
                    mying5.start();
                }
                if(ngerendom == 6){
                    mying6.setVolume(100,100);
                    mying6.start();
                }
                if(ngerendom == 7){
                    mying7.setVolume(100,100);
                    mying7.start();
                }
                if(ngerendom == 8){
                    mying8.setVolume(100,100);
                    mying8.start();
                }
                if(ngerendom == 9){
                    mying9.setVolume(100,100);
                    mying9.start();
                }
                if(ngerendom == 10){
                    mying10.setVolume(100,100);
                    mying10.start();
                }
                if(ngerendom == 11){
                    mying11.setVolume(100,100);
                    mying11.start();
                }
                if(ngerendom == 12){
                    mysing12.setVolume(100,100);
                    mysing12.start();
                } if(ngerendom == 13){
                    mysing13.setVolume(100,100);
                    mysing13.start();
                } if(ngerendom == 14){
                    mysing14.setVolume(100,100);
                    mysing14.start();
                } if(ngerendom == 15){
                    mysing15.setVolume(100,100);
                    mysing15.start();
                } if(ngerendom == 16){
                    mysing16.setVolume(100,100);
                    mysing16.start();
                } if(ngerendom == 17){
                    mysing17.setVolume(100,100);
                    mysing17.start();
                }





            }
        });


    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvid, tvname , tvlocalname , tvprimaryatt , tvatttype,tvkaki;
        private CardView cardView;
        private ImageView ivfoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            tvid = itemView.findViewById(R.id.tv_idhero);
            tvname = itemView.findViewById(R.id.tv_namehero);
            tvlocalname = itemView.findViewById(R.id.tv_localized_name);
            tvprimaryatt = itemView.findViewById(R.id.tv_primary_attr);
            tvatttype = itemView.findViewById(R.id.tv_attack_type);
            tvkaki = itemView.findViewById(R.id.tv_legs);
            cardView = itemView.findViewById(R.id.cv_hero);
            
        }
    }
}
