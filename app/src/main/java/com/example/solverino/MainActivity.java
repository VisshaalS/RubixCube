package com.example.solverino;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start;
    Button up;
    Button down;
    Button left;
    Button right;
    Button front;
    Button back;


    // Variables used for picking an image from gallery
    public static final int PICK_IMAGE = 1;
    private Uri[] uriArray = new Uri[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init the button which will start the calculations
        start = findViewById(R.id.start);
        start.setOnClickListener(this);

        // init button to select "up" image
        up = findViewById(R.id.up);
        up.setOnClickListener(this);

        // init button to select "down" image
        down = findViewById(R.id.down);
        down.setOnClickListener(this);

        // init button to select "left" image
        left = findViewById(R.id.left);
        left.setOnClickListener(this);

        // init button to select "right" image
        right = findViewById(R.id.right);
        right.setOnClickListener(this);

        // init button to select "front" image
        front = findViewById(R.id.front);
        front.setOnClickListener(this);

        // init button to select "back" image
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.start:

                break;

            case R.id.up:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PICK_IMAGE);
                break;
            case R.id.down:
                Intent intent1 = new Intent();
                intent1.setType("image/*");
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent1, PICK_IMAGE);
                break;
            case R.id.left:
                Intent intent2 = new Intent();
                intent2.setType("image/*");
                intent2.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent2, PICK_IMAGE);
                break;
            case R.id.right:
                Intent intent3 = new Intent();
                intent3.setType("image/*");
                intent3.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent3, PICK_IMAGE);
                break;
            case R.id.front:
                Intent intent4 = new Intent();
                intent4.setType("image/*");
                intent4.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent4, PICK_IMAGE);
                break;
            case R.id.back:
                Intent intent5 = new Intent();
                intent5.setType("image/*");
                intent5.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent5, PICK_IMAGE);
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case 0:
                if (requestCode == PICK_IMAGE){
                    Uri imageUri = data.getData();
                    uriArray[0] = imageUri;
                }
                break;
            case 1:
                if (requestCode == PICK_IMAGE){
                    Uri imageUri = data.getData();
                    uriArray[1] = imageUri;
                }
                break;
            case 2:
                if (requestCode == PICK_IMAGE){
                    Uri imageUri = data.getData();
                    uriArray[2] = imageUri;
                }
                break;
            case 3:
                if (requestCode == PICK_IMAGE){
                    Uri imageUri = data.getData();
                    uriArray[3] = imageUri;
                }
                break;
            case 4:
                if (requestCode == PICK_IMAGE){
                    Uri imageUri = data.getData();
                    uriArray[4] = imageUri;
                }
                break;
            case 5:
                if (requestCode == PICK_IMAGE){
                    Uri imageUri = data.getData();
                    uriArray[5] = imageUri;
                }
                break;

        }
    }

    public void identifyColor(Uri imageUri){
        imageView.setImageURI(imageUri);
        int height =  imageView.getHeight();
        int weight = imageView.getWidth();
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        int topLeft = bitmap.getPixel(height/6,weight/6);
        int topMiddle = bitmap.getPixel(height/6,weight/2);
        int topRight = bitmap.getPixel(height/6,weight*(5/6));
        int midLeft = bitmap.getPixel(height/2,weight/6);
        int midMiddle = bitmap.getPixel(height/2,weight/2);
        int midRight = bitmap.getPixel(height/2,weight*(5/6));
        int botLeft = bitmap.getPixel(height*(5/6),weight/6);
        int botMiddle = bitmap.getPixel(height*(5/6),weight/2);
        int botRight = bitmap.getPixel(height*(5/6),weight*(5/6));

        int blue  = Color.blue(topLeft);




        imageView.setVisibility(View.INVISIBLE);


    }

}
