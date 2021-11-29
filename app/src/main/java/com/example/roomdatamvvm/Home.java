package com.example.roomdatamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatamvvm.Adapter.ActorAdapter;
import com.example.roomdatamvvm.Model.REPORT;
import com.example.roomdatamvvm.Model.RechargeListResponse;
import com.example.roomdatamvvm.Network.Api;
import com.example.roomdatamvvm.Respository.RechargeRespository;
import com.example.roomdatamvvm.ViewModel.RechargeViewModal;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.roomdatamvvm.MainActivity.token;

public class Home extends AppCompatActivity {
    private RechargeViewModal actorViewModal;

    private RecyclerView recyclerView;
    private List<REPORT> actorList;
    private RechargeRespository actorRespository;
    private ActorAdapter actorAdapter;
    int page_number = 1;
    int item_count = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView id = findViewById(R.id.id);
        id.setText(token);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        actorRespository=new RechargeRespository(getApplication());
        actorList=new ArrayList<>();
        actorAdapter=new ActorAdapter(this,actorList);

        actorViewModal=new ViewModelProvider(this).get(RechargeViewModal.class);
        networkRequest();
        actorViewModal.getAllActor().observe(this, new Observer<List<REPORT>>() {
            @Override
            public void onChanged(List<REPORT> actorList) {
                recyclerView.setAdapter(actorAdapter);
                actorAdapter.getAllActors(actorList);

                Log.d("main", "onChanged: "+actorList);
            }
        });

    }

    private void networkRequest() {
        Call<RechargeListResponse> call= Api.getClint().rechargreportdata(token, "",
                "",
                "",
                page_number,
                item_count,
                "5",
                "1");
        call.enqueue(new Callback<RechargeListResponse>() {
            @Override
            public void onResponse(Call<RechargeListResponse> call, Response<RechargeListResponse> response) {
                if(response.isSuccessful())
                {

                    try {
                        if(response.body().getERROR().equals("0")){
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            actorRespository.insert(response.body().getREPORT());
                        }else{
                            Toast.makeText(Home.this, ""+response.body().getMESSAGE(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                   //
                }
            }

            @Override
            public void onFailure(Call<RechargeListResponse> call, Throwable t) {
                Toast.makeText(Home.this, "something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}