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

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.TheLoaiViewHolder>{

    //Lưu context
    private Context context;
    //Tạo list chứa các thể loại
    private List<TheLoai> ListTheLoai;

    //Hàm đổ dữ liệu vào List
    public void setData(List<TheLoai> list)
    {
        this.ListTheLoai = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_the_loai, parent, false);

        //Lưu context
        context = parent.getContext();
        return new TheLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TheLoaiAdapter.TheLoaiViewHolder holder, int position) {

        TheLoai theLoai = ListTheLoai.get(position);
        if(theLoai == null)
            return;
        else
        {
            holder.imgTheLoai.setImageResource(theLoai.getImgId());
            holder.txtTieuDeTheLoai.setText(theLoai.getTieuDe());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, Playlist.class);
                    context.startActivity(intent);

                }
            });
        }

    }

    @Override
    public int getItemCount() {

        if(ListTheLoai != null)
        {
            return ListTheLoai.size();
        }
        return 0;
    }

    public class TheLoaiViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgTheLoai;
        private TextView txtTieuDeTheLoai;

        public TheLoaiViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTheLoai = itemView.findViewById(R.id.imgTheLoai);
            txtTieuDeTheLoai = itemView.findViewById(R.id.txtTieuDeTheLoai);

        }
    }
}
