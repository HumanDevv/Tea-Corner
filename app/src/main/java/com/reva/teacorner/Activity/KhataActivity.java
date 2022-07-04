package com.reva.teacorner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.reva.teacorner.R;

import java.util.List;

public class KhataActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "54548";
    private static final String TAG = "df";
    FloatingActionButton fab;
RecyclerView recyckhta;
AppCompatButton send;
    Intent intent;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khata);
        fab= findViewById(R.id.fab);
        send= findViewById(R.id.send);
        recyckhta= findViewById(R.id.recyckhta);
        recyckhta.setLayoutManager(new LinearLayoutManager(this));
        fab.setColorFilter(R.color.white);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(KhataActivity.this,AddKhataActivity.class);
                startActivity(intent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
        getkhatas();
    }

    public void getkhatas(){

        class GetKhatas extends AsyncTask<Void,Void, List<Khata>>{

            @Override
            protected List<Khata> doInBackground(Void... voids) {

                List<Khata> khataList=DataBaseClient.getInstance(getApplicationContext()).getChaiDatabse().khataDao().getAll();
                return khataList;
            }

            @Override
            protected void onPostExecute(List<Khata> khatas) {
                super.onPostExecute(khatas);
                KhataAdappter khataAdappter= new KhataAdappter(KhataActivity.this,khatas);
                recyckhta.setAdapter(khataAdappter);
            }
        }

        GetKhatas getKhatas= new GetKhatas();
        getKhatas.execute();
    }





            private void sendNotification() {

                try {
                    intent = new Intent(this, MainActivity1.class);
                    pendingIntent = PendingIntent.getActivity(this, 3, intent,
                            PendingIntent.FLAG_UPDATE_CURRENT);

                } catch (ActivityNotFoundException | NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    CharSequence name = "YOUR CHANNEL";
                    String description = "YOUR CHANNEL DESCRIPTION";
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel channel = new NotificationChannel( "YOUR CHANNEL ID", name, importance);
                    channel.setDescription(description);
                    // Register the channel with the system; you can't change the importance
                    // or other notification behaviors after this
                    NotificationManager notificationManager = KhataActivity.this.getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);
                }



                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.kullad)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.kullad))
                            .setContentTitle("My Notify")
                            .setContentText("Hey this is my first notification demo. wish me all the best")
                            .setAutoCancel(true)
                    /*Notification with Image*/
                            //.set

                            // .setFullScreenIntent(pendingIntent,true)
                            .setContentIntent(pendingIntent);

                    //  Toast.makeText(this, "hlo", Toast.LENGTH_SHORT).show();

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(KhataActivity.this);
                    notificationBuilder.setChannelId("YOUR CHANNEL ID");

                    notificationManager.notify(0, notificationBuilder.build());




        }

}