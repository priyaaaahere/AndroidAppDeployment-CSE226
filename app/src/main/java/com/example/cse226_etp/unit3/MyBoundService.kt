package com.example.cse226_etp.unit3

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyBoundService : Service(){
    private val binder=LocalBinder()

    inner class LocalBinder : Binder(){
        fun getService():MyBoundService=this@MyBoundService
    }
    override fun onBind(intent: Intent): IBinder {
        return binder
    }
    fun getWelcomeMesssage():String{
        return "Hello from Bound Service"
    }
}