package com.example.solverino;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bPic;
    ImageView imageResult;
    File myFilesDir = getExternalFilesDir(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bPic = findViewById(R.id.bPic);

        bPic.setOnClickListener(this);

        imageResult = findViewById(R.id.imageResult);


    }

    @Override
    public void onClick(View v) {
        if (v == bPic) {
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(takePicture);

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            try {
                Bitmap cameraBitmap;
                cameraBitmap = BitmapFactory.decodeFile(myFilesDir + "/temp.jpg");
                Bitmap.createBitmap(cameraBitmap);
                imageResult.setImageBitmap(cameraBitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
