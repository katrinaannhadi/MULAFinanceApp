package org.mula.finance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import org.mula.finance.Models.Video;
import org.mula.finance.R;
import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private ArrayList<Video> mVideos;
    private RecyclerViewClickListener mListener;
    Context context;

    public VideoAdapter(ArrayList<Video> videos, RecyclerViewClickListener listener) {
        mVideos = videos;
        mListener = listener;
        this.context = context;
    }

    public VideoAdapter(ArrayList<Video> videos) {
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView channelName, playlistName;
        public ImageView videoImage;
        private RecyclerViewClickListener mListener;


        public VideoViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            channelName = v.findViewById(R.id.channel_name);
            playlistName = v.findViewById(R.id.playlist_name);
            videoImage = v.findViewById(R.id.course_image);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(v, mListener);
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position){

        Video video = mVideos.get(position);
        holder.channelName.setText(video.getChannelName());
        holder.playlistName.setText(video.getPlaylistName());
        holder.videoImage.setImageResource(video.getImage());

    }

    @Override
    public int getItemCount() {
        //return mVideos.size();
        return 3;
    }
    //Return the size of our dataset
//    @Override
//    public int getItemCount() {
//        return mVideos.size();
//    }
}


