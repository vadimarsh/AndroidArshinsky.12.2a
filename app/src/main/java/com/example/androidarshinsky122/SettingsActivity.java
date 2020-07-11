package com.example.androidarshinsky122;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.zip.Inflater;

public class SettingsActivity extends AppCompatActivity {

    private Button butChoose;
    private EditText editFileName;
    private static String SAVEDDATA = "img_fname";
    private SharedPreferences mySharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
    }

    private void init() {
        editFileName = findViewById(R.id.editFilename);
        butChoose = findViewById(R.id.buttonChooseBg);
        mySharedPref = getSharedPreferences("Settings", MODE_PRIVATE);

        butChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myEditor = mySharedPref.edit();
                String fname = editFileName.getText().toString();
                myEditor.putString(SAVEDDATA, fname);
                myEditor.apply();
                SettingsActivity.this.finish();
            }
        });

    }




}
