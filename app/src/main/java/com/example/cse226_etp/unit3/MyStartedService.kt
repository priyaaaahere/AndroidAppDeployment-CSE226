package com.example.cse226_etp.unit3

import android.app.Service
import android.app.Service.START_NOT_STICKY
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyStartedService: Service(){
    override fun onCreate(){
        super.onCreate()
        Toast.makeText(this,"Started Service created",Toast.LENGTH_LONG).show()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this,"Started Service running",Toast.LENGTH_LONG).show()
        //Do your work here (e.g., background task)
        return START_NOT_STICKY
    }
    override fun onDestroy(){
        Toast.makeText(this,"Started Service destroyed",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}