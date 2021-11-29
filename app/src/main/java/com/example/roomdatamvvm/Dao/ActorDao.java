package com.example.roomdatamvvm.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatamvvm.Model.REPORT;

import java.util.List;

@Dao
public interface ActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<REPORT> actorList);

    @Query("SELECT * FROM REPORT")
    LiveData<List<REPORT>> getAllActors();

    @Query("DELETE FROM REPORT")
    void deleteAll();
}
