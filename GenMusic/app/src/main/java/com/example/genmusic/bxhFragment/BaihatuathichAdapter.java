package com.example.genmusic.bxhFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.PlayNhacActivity;
import com.example.genmusic.R;
import com.example.genmusic.bxhFragment.Baihatuathich;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",baihatuathichArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.iconloved);;
                    Dataservice dataservice= APIService.getService();
                    Call<String> callback=dataservice.UpdateLuotThich("1",baihatuathichArrayList.get(getPosition()).getIdbaihat());
                    Toast.makeText(context,"Đã thích",Toast.LENGTH_SHORT).show();
                    /*callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua= response.body();
                            if(ketqua.equals("Success")){

                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });*/
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
