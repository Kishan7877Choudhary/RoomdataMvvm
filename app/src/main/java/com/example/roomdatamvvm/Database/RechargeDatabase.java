package com.example.roomdatamvvm.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatamvvm.Dao.ActorDao;
import com.example.roomdatamvvm.Model.REPORT;

@Database(entities = {REPORT.class},version = 1)
public abstract class RechargeDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="ActorDatabase";

    public abstract ActorDao actorDao();

    private static volatile RechargeDatabase INSTANCE;

    public static RechargeDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (RechargeDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context, RechargeDatabase.class,
                            DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };
    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private ActorDao actorDao;
        PopulateAsynTask(RechargeDatabase actorDatabase)
        {
            actorDao=actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            actorDao.deleteAll();
            return null;
        }
    }
}
