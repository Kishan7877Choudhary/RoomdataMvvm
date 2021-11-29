package com.example.roomdatamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.roomdatamvvm.Model.Userdetail;
import com.example.roomdatamvvm.Network.Api;
import com.example.roomdatamvvm.Respository.LoginRespository;
import com.example.roomdatamvvm.ViewModel.UserViewModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    UserViewModal catViewModel;
    private List<Userdetail> getCats;
    private LoginRespository repository;
    public static String token = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("user", Context.MODE_PRIVATE);
        String storedUsername = prefs.getString("token", "");
        token=storedUsername;

        if(storedUsername.equals("")||storedUsername.isEmpty()||storedUsername==null){
            catViewModel=new ViewModelProvider(this).get(UserViewModal.class);
            makeRequest();

        }else{
            Intent intent = new Intent(MainActivity.this,Home.class);
            startActivity(intent);
        }

    }

    private void makeRequest() {

        Call<Userdetail> call= Api.getClint().login("8386900066","1234","49849644489","5");
        call.enqueue(new retrofit2.Callback<Userdetail>() {
            @Override
            public void onResponse(Call<Userdetail> call, Response<Userdetail> response) {
                if(response.isSuccessful()) {
                 //   repository.insert((List<Userdetail>) response.body());
                    if(response.body().getERROR().equals("0")){
                        token = response.body().getTOKENID();

                        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                        SharedPreferences.Editor myedit = sharedPreferences.edit();
                        myedit.putString("token",token);
                        myedit.apply();
                        myedit.commit();

                        Log.e("token","token         "+token);
                        Intent intent = new Intent(MainActivity.this,Home.class);
                        startActivity(intent);
                    }else{

                        Toast.makeText(MainActivity.this, ""+response.body().getERROR(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<Userdetail> call, Throwable t) {
              //  Log.d("main", "onFailure: "+t.getMessage());
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}