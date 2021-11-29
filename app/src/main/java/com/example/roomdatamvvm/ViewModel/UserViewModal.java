package com.example.roomdatamvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatamvvm.Model.Userdetail;
import com.example.roomdatamvvm.Respository.LoginRespository;

import java.util.List;

public class UserViewModal extends AndroidViewModel {

    private LoginRespository actorRespository;
    private LiveData<Userdetail> getAllActors;

    public UserViewModal(@NonNull Application application) {
        super(application);
        actorRespository=new LoginRespository(application);
        getAllActors=actorRespository.getAllActors();
    }

    public void insert(Userdetail list)
       {
           actorRespository.insert(list);
      }

    public LiveData<Userdetail> getAllActor()
    {
        return getAllActors;
    }
}
