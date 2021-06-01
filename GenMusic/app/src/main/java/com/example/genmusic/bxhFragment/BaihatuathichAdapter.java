package com.example.genmusic.bxhFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.R;
import com.example.genmusic.bxhFragment.Baihatuathich;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaihatuathichAdapter extends  RecyclerView.Adapter<BaihatuathichAdapter.ViewHolder>{
    @NonNull
    Context context;
    ArrayList<Baihatuathich> baihatuathichArrayList;

    public BaihatuathichAdapter(@NonNull Context context, ArrayList<Baihatuathich> baihatuathichArrayList) {
        this.context = context;
        this.baihatuathichArrayList = baihatuathichArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.dongbaihatuathich,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        Baihatuathich baihatuathich=baihatuathichArrayList.get(position);
        holder.txtcasi.setText(baihatuathich.getCasi());
        holder.txtten.setText(baihatuathich.getTenbaihat());
        Picasso.with(context).load(baihatuathich.getHinhbaihat()).into(holder.imghinh);

    }

    @Override
    public int getItemCount() {
        return baihatuathichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txtcasi;
        ImageView imghinh,imgluotthich;
        public ViewHolder(@NonNull  View itemView) {

            super(itemView);
            txtten=itemView.findViewById(R.id.textviewtenbaihatuathich);
            txtcasi=itemView.findViewById(R.id.textviewcasibaihatuathich);
            imghinh=itemView.findViewById(R.id.imageViewbaihatuathich);
            imgluotthich=itemView.findViewById(R.id.imageViewluotthich);
        }
    }
}
