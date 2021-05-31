package com.example.genmusic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.theLoaiFragment.TheLoai;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    @NonNull
    private List<Song> ListSong;


    public void setData(List<Song> list)
    {
        this.ListSong = list;
        notifyDataSetChanged();
    }

    @Override
    public SongViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feature_song,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  SongAdapter.SongViewHolder holder, int position) {
        Song song= ListSong.get(position);
        if(song==null){
            return;
        }
        holder.imageview.setImageResource(song.getImgId());
        holder.title.setText(song.getTitle());
        holder.description.setText(song.getDescription());
        holder.menu_button.setImageResource(song.getImgMenu());

    }

    @Override
    public int getItemCount() {
        if(ListSong!=null)
        {
            return ListSong.size();
        }
        return 0;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageview;
        public TextView title;
        public TextView description;
        public ImageView menu_button;

        public SongViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            menu_button=itemView.findViewById(R.id.menu_button);

        }
    }
}
