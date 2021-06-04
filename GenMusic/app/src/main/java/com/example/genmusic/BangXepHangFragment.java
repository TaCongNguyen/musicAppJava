package com.example.genmusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.bxhFragment.APIService;
import com.example.genmusic.bxhFragment.Baihatuathich;
import com.example.genmusic.bxhFragment.BaihatuathichAdapter;
import com.example.genmusic.bxhFragment.Dataservice;
import com.example.genmusic.bxhFragment.bxh;
import com.example.genmusic.bxhFragment.bxhAdapter;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BangXepHangFragment extends Fragment {
    View view;
    ListView lvchart;
    TextView txttitlechart,txtviewmorechart;
    bxhAdapter bxhadapter;
    ArrayList<bxh>mangchart;

    RecyclerView recyclerViewtopbaihatuathich;
    BaihatuathichAdapter baihatuathichAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bxh, container, false);
        lvchart=view.findViewById(R.id.listviewchart);
        txttitlechart=view.findViewById(R.id.textviewtitlechart);
        txtviewmorechart=view.findViewById(R.id.textviewviewmorechart);

        recyclerViewtopbaihatuathich=view.findViewById(R.id.recyclerviewtopbaihatuathich);
        GetData();
        GetData_baihatuathich();
        return view;




    }

    private void GetData_baihatuathich() {
        Dataservice dataservice=APIService.getService();
        Call<List<Baihatuathich>> callback=dataservice.GetBaiHatHot();
        callback.enqueue(new Callback<List<Baihatuathich>>() {
            @Override
            public void onResponse(Call<List<Baihatuathich>> call, Response<List<Baihatuathich>> response) {
                ArrayList<Baihatuathich> baihatuathichArrayList=(ArrayList<Baihatuathich>) response.body();
                baihatuathichAdapter=new BaihatuathichAdapter(getActivity(),baihatuathichArrayList);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewtopbaihatuathich.setLayoutManager(linearLayoutManager);
                recyclerViewtopbaihatuathich.setAdapter(baihatuathichAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihatuathich>> call, Throwable t) {

            }
        });
    }

    private void GetData(){
        Dataservice dataservice= APIService.getService();
        Call<List<bxh>> callback=dataservice.GetChartCurrentDay();
        callback.enqueue(new Callback<List<bxh>>() {
            @Override
            public void onResponse(Call<List<bxh>> call, Response<List<bxh>> response) {
                mangchart=(ArrayList<bxh>) response.body();
                bxhadapter=new bxhAdapter(getActivity(), android.R.layout.simple_list_item_1,mangchart);
                lvchart.setAdapter(bxhadapter);
            }

            @Override
            public void onFailure(Call<List<bxh>> call, Throwable t) {

            }
        });





    }

}
