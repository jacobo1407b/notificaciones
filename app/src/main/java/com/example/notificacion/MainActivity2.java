package com.example.notificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    String info;
    TextView logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            info= "No hay nada para mostrar";
        }else{
            info = extras.getString("notiID");
        }

        logger = findViewById(R.id.logger);
        logger.setText(info);
    }
}