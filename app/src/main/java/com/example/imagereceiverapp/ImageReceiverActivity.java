package com.example.imagereceiverapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ImageReceiverActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_receiver);
        imageView = findViewById(R.id.imageView);

        // Handle the incoming intent
        handleIncomingIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIncomingIntent(intent);
    }

    private void handleIncomingIntent(Intent intent) {
        if (Intent.ACTION_SEND.equals(intent.getAction()) && intent.getType() != null) {
            Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            if (imageUri != null) {
                displayImage(imageUri);
            } else {
                Toast.makeText(this, "No image received", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Invalid action", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayImage(Uri imageUri) {
        imageView.setImageURI(imageUri);
        Toast.makeText(this, "Image received successfully!", Toast.LENGTH_SHORT).show();
    }
}