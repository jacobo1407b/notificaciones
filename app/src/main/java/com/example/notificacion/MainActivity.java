package com.example.notificacion;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;

import com.example.notificacion.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;
    private Button simpleButtos;
    private static String id = "test_channel_01";
    int notificacionId = 1;
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        simpleButtos = binding.simpleButton;



    }

    public void simpleButtonClick(View view){
        Intent viewIntent = new Intent(this,MainActivity2.class);
        viewIntent.putExtra("notiID","notificacion es:"+notificacionId);
        PendingIntent viewPendingIntent = PendingIntent.getActivity(this,0,viewIntent,0);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= 26){
            Log.d(TAG, "La version es mayor a 26" + Build.VERSION.SDK_INT);
            String descripcion = "Descripcion del canal :V";
            int importancia = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(id,descripcion,importancia);
            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(MainActivity.this,id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notificacion :v")
                    .setContentText("Hola mundo werOs shey :(")
                    .setContentIntent(viewPendingIntent)
                    .setAutoCancel(true)
                    .build();
            Log.d(TAG,"se compilo chido XD");
            manager.notify(1,notification);
            Log.d(TAG,"Se envio al administrador");
        }else {
            Log.d(TAG, "la version es menor a 26");
            Notification notification = new NotificationCompat.Builder(MainActivity.this)
                    .setContentTitle("HOla tienes msg")
                    .setContentText("hola Este es mensaje nuevo jasjajs")
                    .setContentIntent(viewPendingIntent)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            manager.notify(1, notification);
        }
        startActivity(viewIntent);
    }
}