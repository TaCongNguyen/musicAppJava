//
package com.example.genmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.bxhFragment.Baihatuathich;

import java.util.ArrayList;

public class DanhsachbaihatAdapter extends  RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder>{
    Context context;
    ArrayList<Baihatuathich> mangbaihat;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihatuathich> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_danhsachbaihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  DanhsachbaihatAdapter.ViewHolder holder, int position) {
        Baihatuathich baihatuathich=mangbaihat.get(position){
            holder.txtcasi.setText(baihatuathich.getCasi());
            holder.txttenbaihat.setText(baihatuathich.getTenbaihat());
            holder.txtindex.setText(position +1+"");

        }
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex,txttenbaihat,txtcasi;
        ImageView imgluotthich;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            txtcasi=itemView.findViewById(R.id.textviewtencasi);
            txtindex=itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat=itemView.findViewById(R.id.textviewtenbaihat);
            imgluotthich=itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);


        }
    }
}
