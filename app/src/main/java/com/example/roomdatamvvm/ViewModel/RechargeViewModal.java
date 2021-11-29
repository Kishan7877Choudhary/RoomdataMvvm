package com.example.roomdatamvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatamvvm.Model.REPORT;
import com.example.roomdatamvvm.Respository.RechargeRespository;

import java.util.List;

public class RechargeViewModal extends AndroidViewModel {

    private RechargeRespository actorRespository;
    private LiveData<List<REPORT>> getAllActors;

    public RechargeViewModal(@NonNull Application application) {
        super(application);
        actorRespository=new RechargeRespository(application);
        getAllActors=actorRespository.getAllActors();
    }

    public void insert(List<REPORT> list)
       {
           actorRespository.insert(list);
      }

    public LiveData<List<REPORT>> getAllActor()
    {
        return getAllActors;
    }
}
