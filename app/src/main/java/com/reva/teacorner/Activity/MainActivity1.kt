package com.reva.teacorner.Activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.reva.teacorner.R


class MainActivity1 : AppCompatActivity() {
    // declaring variables
    /*lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // accessing button
        val btn = findViewById<Button>(R.id.btn)

        // it is a class to notify the user of events that happen.
        // This is how you tell the user that something has happened in the
        // background.
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // onClick listener for the button
       btn.setOnClickListener {
           val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "CHANNEL_ID")
               .setSmallIcon(R.drawable.ic_launcher_background)
               .setContentTitle("textTitle")
               .setContentText("textContent")
               .setPriority(NotificationCompat.PRIORITY_DEFAULT)
           val notificationManager = NotificationManagerCompat.from(this)

// notificationId is a unique int for each notification that you must define

// notificationId is a unique int for each notification that you must define
           notificationManager.notify(123, builder.build())
       }
}}*/
}