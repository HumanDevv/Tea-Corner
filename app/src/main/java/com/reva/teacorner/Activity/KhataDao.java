package com.reva.teacorner.Activity;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface KhataDao {

    @Query("SELECT * FROM khata")
    List<Khata> getAll();

    @Insert
    void insert(Khata khata);

    @Update
    void update(Khata khata);

    @Delete
    void delete(Khata khata);
}
