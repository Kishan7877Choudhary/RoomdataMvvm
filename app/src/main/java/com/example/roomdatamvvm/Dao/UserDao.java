package com.example.roomdatamvvm.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatamvvm.Model.Userdetail;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Userdetail actorList);

    @Query("SELECT * FROM userdetails")
    LiveData<Userdetail> getAllActors();

    @Query("DELETE FROM userdetails")
    void deleteAll();
}
