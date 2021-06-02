package com.example.genmusic.trangChuFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.R;
import com.example.genmusic.theLoaiFragment.Album;

import java.util.List;

public class HotAlbumAdapter extends RecyclerView.Adapter<HotAlbumAdapter.HotAlbumViewHolder>{


    private List<Album> mHotAlbums;

    public void setData(List<Album> list) {
        this.mHotAlbums = list;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public HotAlbumViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new HotAlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder( HotAlbumAdapter.HotAlbumViewHolder holder, int position) {
        Album album = mHotAlbums.get(position);
        if(album == null) {
            return;
        }
        holder.imgAlbum.setImageResource(album.getImgId());
        holder.tvTitle.setText(album.getTieuDe());
    }

    @Override
    public int getItemCount() {
        if(mHotAlbums != null) {
            return mHotAlbums.size();
        }
        return 0;
    }

    public class HotAlbumViewHolder extends RecyclerView.ViewHolder {


        private ImageView imgAlbum;
        private TextView tvTitle;

        public HotAlbumViewHolder( View itemView) {
            super(itemView);

            imgAlbum = itemView.findViewById(R.id.imgAlbum);
            tvTitle = itemView.findViewById(R.id.txtTieuDeAlbum);
        }
    }

}
