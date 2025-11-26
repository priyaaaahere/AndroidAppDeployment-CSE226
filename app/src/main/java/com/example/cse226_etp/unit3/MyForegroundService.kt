package com.example.cse226_etp.unit3

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.Service.START_NOT_STICKY
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.cse226_etp.R
//it is very important to enable notifications on phone for the application
//it is very important to add two main permissions for foreground one for foreground service one for media playback
//services are main and also there's an extra thing to be added in foreground which is android:foregroundServiceType="mediaPlayback"
//for every service there's service with name and exported but for foreground there's this one extra which i wrote in the above line

class MyForegroundService : Service(){
    private val CHANNEL_ID="ForegroundServiceChannel"

    override fun onCreate(){
        super.onCreate()
        createNotificationChannel()
    }
    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification: Notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("Running in foreground...")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()
        startForeground(1,notification)
        //Do your foreground task here
        return START_NOT_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel= NotificationChannel (
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager=getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

}