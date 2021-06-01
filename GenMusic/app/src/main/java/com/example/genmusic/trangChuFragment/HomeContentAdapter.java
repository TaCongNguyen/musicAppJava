package com.example.genmusic.trangChuFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.R;

import java.util.List;

public class HomeContentAdapter extends RecyclerView.Adapter<HomeContentAdapter.HomeContetViewHolder>{

    private Context mContext;
    List<HomeContent> mListHomeContent;

    public HomeContentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<HomeContent> list) {
        this.mListHomeContent = list;
        notifyDataSetChanged();
    }


    @Override
    public HomeContetViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content_homepage, parent,false);

        return new HomeContetViewHolder(view);
    }

    @Override
    public void onBindViewHolder( HomeContentAdapter.HomeContetViewHolder holder, int position) {
        HomeContent homeContent = mListHomeContent.get(position);
        if(homeContent == null) {
            return;
        }

        LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvHotAlbum.setLayoutManager(linearLayoutManager);

        holder.tvTitleContent.setText(homeContent.getNameContent());
        HotAlbumAdapter hotAlbumAdapter = new HotAlbumAdapter();
        hotAlbumAdapter.setData(homeContent.getHotAlbums());
        holder.rcvHotAlbum.setAdapter(hotAlbumAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListHomeContent != null) {
            return mListHomeContent.size();
        }
        return 0;
    }

    public class HomeContetViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitleContent;
        private RecyclerView rcvHotAlbum;

        public HomeContetViewHolder( View itemView) {
            super(itemView);

            tvTitleContent = itemView.findViewById(R.id.tv_content_title);
            rcvHotAlbum = itemView.findViewById(R.id.rcvHotAlbum);
        }
    }
}
