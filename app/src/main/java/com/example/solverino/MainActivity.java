package com.example.solverino;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bPic;
    Button openGal;
    ImageView imageResult;

    // Variables used for picking an image from gallery
    public static final int PICK_IMAGE = 1;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init button to open the camera
        bPic = findViewById(R.id.bPic);
        bPic.setOnClickListener(this);

        imageResult = findViewById(R.id.imageResult);

        // init the button to open the gallery
        openGal = findViewById(R.id.openGal);
        openGal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bPic:
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(takePicture);
                break;

            case R.id.openGal:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                imageView = findViewById(R.id.imageResult);
                startActivityForResult(intent, PICK_IMAGE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE){
            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

}
