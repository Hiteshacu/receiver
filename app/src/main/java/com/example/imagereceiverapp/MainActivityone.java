package com.example.imagereceiverapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityone extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);

        imageView = findViewById(R.id.imageView);

        // Check if the app was launched with an intent
        Intent intent = getIntent();
        if (intent != null) {
            // Get the image URI from the intent
            Uri imageUri = intent.getData();

            // Check if the URI is not null
            if (imageUri != null) {
                // Display the image in the ImageView
                displayImage(imageUri);
            }
        }
    }

    private void displayImage(Uri imageUri) {
        try {
            // Get the bitmap from the image URI
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));

            // Display the bitmap in the ImageView
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            // Handle any exceptions that occur while displaying the image
            e.printStackTrace();
        }
    }
}