package com.example.genmusic.theLoaiFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.R;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    //Tạo context (TheLoaiFragment), để lúc sau có thể intent sang 1 activity khác từ fragment này
    private Context context;
    //Tạo list chứa các thể loại
    private List<Album> ListAlbum;

    //Hàm đổ dữ liệu vào List
    public void setData(List<Album> list)
    {
        this.ListAlbum = list;
        notifyDataSetChanged();
    }

    //Hàm khởi tạo adapter và kết nối với layout xml
    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        //Lưu context vào biến
        context = parent.getContext();

        return new AlbumViewHolder(view);
    }

    //Hàm xử lý với từng item trong recycleview
    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Album album = ListAlbum.get(position);
        if(album == null)
            return;
        else
        {
            holder.imgAlbum.setImageResource(album.getImgId());
            holder.txtTieuDeAlbum.setText(album.getTieuDe());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AlbumPlaylist.class);

                    intent.putExtra("key", "album qua roi ne !");

                    context.startActivity(intent);
                }


            });
        }

    }
    //Hàm lấy số lượng item
    @Override
    public int getItemCount() {

        if(ListAlbum != null)
        {
            return ListAlbum.size();
        }
        return 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAlbum;
        private TextView txtTieuDeAlbum;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAlbum = itemView.findViewById(R.id.imgAlbum);
            txtTieuDeAlbum = itemView.findViewById(R.id.txtTieuDeAlbum);

        }
    }
}
