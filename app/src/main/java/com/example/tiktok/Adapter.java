package com.example.tiktok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktok.databinding.ReelsDgBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder>{

    Context context;
    ArrayList<Model> modelArrayList=new ArrayList<>();
    boolean isPlaying=true;
    MediaPlayer mp;
    int stopPosition;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    public class VideoHolder extends RecyclerView.ViewHolder
    {
        ReelsDgBinding reelsDgBinding;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            reelsDgBinding=ReelsDgBinding.bind(itemView);
        }
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.reels_dg,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
      holder.reelsDgBinding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
      holder.reelsDgBinding.name.setText(modelArrayList.get(position).getName());
      holder.reelsDgBinding.profileImage.setImageResource(modelArrayList.get(position).getProfile());

        holder.reelsDgBinding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        holder.reelsDgBinding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


}
