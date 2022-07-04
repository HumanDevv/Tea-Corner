package com.reva.teacorner.Activity;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DataBaseClient {

    private Context context;
    private static DataBaseClient minstace;

    private ChaiDatabse chaiDatabse;

    private DataBaseClient(Context context){
        this.context=context;
        chaiDatabse= Room.databaseBuilder(context,ChaiDatabse.class,"MyDatabse ").build();
    }

    public  static synchronized DataBaseClient getInstance(Context context){
        if (minstace==null){
            minstace= new DataBaseClient(context);
        }
        return minstace;
    }
    public ChaiDatabse getChaiDatabse(){
        return chaiDatabse;
    }
}
