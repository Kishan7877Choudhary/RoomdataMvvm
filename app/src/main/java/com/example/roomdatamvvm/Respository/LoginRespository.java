package com.example.roomdatamvvm.Respository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdatamvvm.Dao.UserDao;
import com.example.roomdatamvvm.Database.LoginDatabase;
import com.example.roomdatamvvm.Model.Userdetail;

import java.util.List;

public class LoginRespository {

    private LoginDatabase database;
    private LiveData<Userdetail> getAllActors;

    public LoginRespository(Application application)
    {
        database=LoginDatabase.getInstance(application);
        getAllActors=database.actorDao().getAllActors();
    }


    public void insert(Userdetail actorList){
        new InsertAsynTask(database).execute(actorList);
    }

    public LiveData<Userdetail> getAllActors()
    {
        return getAllActors;
    }

    static class InsertAsynTask extends AsyncTask<Userdetail,Void,Void> {
        private UserDao actorDao;
        InsertAsynTask(LoginDatabase actorDatabase)
        {
            actorDao=actorDatabase.actorDao();
        }
        @Override
        protected Void doInBackground(Userdetail... lists) {
            actorDao.insert(lists[0]);
            return null;
        }
    }
}
