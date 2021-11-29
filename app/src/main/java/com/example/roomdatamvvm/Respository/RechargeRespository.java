package com.example.roomdatamvvm.Respository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdatamvvm.Dao.ActorDao;
import com.example.roomdatamvvm.Database.RechargeDatabase;
import com.example.roomdatamvvm.Model.REPORT;

import java.util.List;

public class RechargeRespository {

    private RechargeDatabase database;
    private LiveData<List<REPORT>> getAllActors;

    public RechargeRespository(Application application)
    {
        database=RechargeDatabase.getInstance(application);
        getAllActors=database.actorDao().getAllActors();
    }


    public void insert(List<REPORT> actorList){
        new InsertAsynTask(database).execute(actorList);
    }

    public LiveData<List<REPORT>> getAllActors()
    {
        return getAllActors;
    }

    static class InsertAsynTask extends AsyncTask<List<REPORT>,Void,Void> {
        private ActorDao actorDao;
        InsertAsynTask(RechargeDatabase actorDatabase)
        {
            actorDao=actorDatabase.actorDao();
        }
        @Override
        protected Void doInBackground(List<REPORT>... lists) {
            actorDao.insert(lists[0]);
            return null;
        }
    }
}
