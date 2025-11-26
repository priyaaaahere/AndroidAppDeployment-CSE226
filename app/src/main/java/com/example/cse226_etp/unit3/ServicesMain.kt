package com.example.cse226_etp.unit3

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse226_etp.R


class ServicesMain : AppCompatActivity() {

    private var boundService: MyBoundService? = null

    private var isBound=false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder=service as MyBoundService.LocalBinder
            boundService=binder.getService()
            isBound=true
            Toast.makeText(this@ServicesMain, boundService?.getWelcomeMesssage(),Toast.LENGTH_SHORT).show()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound=false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_services_main)

        val startStartedService=findViewById<Button>(R.id.btnStartStarteddService)
        val stopStartedService=findViewById<Button>(R.id.btnStopStartedService)
        val bindBoundService=findViewById<Button>(R.id.btnBindBoundService)
        val unbindBoundService=findViewById<Button>(R.id.btnUnbindBoundService)
        val startForeground=findViewById<Button>(R.id.btnStartForeground)
        val stopForeground=findViewById<Button>(R.id.btnStopForeground)

        startStartedService.setOnClickListener{
            startService(Intent(this, MyStartedService::class.java))
        }
        stopStartedService.setOnClickListener{
            stopService(Intent(this, MyStartedService::class.java))
        }
        bindBoundService.setOnClickListener{
            val intent=Intent(this,MyBoundService::class.java)
            bindService(intent,connection,BIND_AUTO_CREATE)
        }
        unbindBoundService.setOnClickListener{
            if(isBound){
                unbindService(connection)
                isBound=false
                Toast.makeText(this, "Bound Service Unbound", Toast.LENGTH_SHORT).show()
            }
        }
        startForeground.setOnClickListener{
            startForegroundService(Intent(this,MyForegroundService::class.java))
        }
        stopForeground.setOnClickListener{
            stopService(Intent(this,MyForegroundService::class.java))
        }

    }
}