package com.example.roomdatamvvm.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatamvvm.Dao.UserDao;
import com.example.roomdatamvvm.Model.Userdetail;

@Database(entities = {Userdetail.class},version = 1)
public abstract class LoginDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="ActorDatabase";

    public abstract UserDao actorDao();

    private static volatile LoginDatabase INSTANCE;

    public static LoginDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (LoginDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context,LoginDatabase.class,
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
        private UserDao actorDao;
        PopulateAsynTask(LoginDatabase actorDatabase)
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
