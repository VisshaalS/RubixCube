package com.example.solverino;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bPic = findViewById(R.id.bPic);

        bPic.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        if(v == bPic){
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(takePicture);

        }
    }
}
