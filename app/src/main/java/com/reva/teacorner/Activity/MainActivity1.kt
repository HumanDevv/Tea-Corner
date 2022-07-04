package com.reva.teacorner.Activity

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.reva.teacorner.R


class MainActivity1 : AppCompatActivity() {
    var btnOneTime:Button? = null
    var btnRepeating:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRepeating= findViewById(R.id.btnRepeating)
        btnOneTime= findViewById(R.id.btnOneTime)
        btnOneTime!!.setOnClickListener {
            startAlarm(false)
        }

        btnRepeating!!.setOnClickListener {
            startAlarm(true)
        }
    }
    private fun startAlarm(isRepeat: Boolean) {
        val manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val myIntent: Intent
        val pendingIntent: PendingIntent

        myIntent = Intent(this, AlarmBroadCastReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0)

        if (!isRepeat)
            manager[AlarmManager.RTC,
                    SystemClock.elapsedRealtime() + 10] = pendingIntent
        else
            manager.setRepeating(
                AlarmManager.RTC,
                SystemClock.elapsedRealtime() + 1000,
                10 * 1000.toLong(),
                pendingIntent
            )

    }
}