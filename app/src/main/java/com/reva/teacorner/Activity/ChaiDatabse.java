package com.reva.teacorner.Activity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Khata.class},version = 1)
public abstract  class ChaiDatabse extends RoomDatabase {
    public abstract KhataDao khataDao();
}
