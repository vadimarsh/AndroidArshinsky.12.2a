package com.example.androidarshinsky122;

import android.Manifest;
import android.content.Intent;
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
    public static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 10;
    private Button butChoose;
    private EditText editFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
    }

    private void init() {
        editFileName = findViewById(R.id.editFilename);
        butChoose = findViewById(R.id.buttonChooseBg);
        butChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionStatus = ContextCompat.checkSelfPermission(SettingsActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE);

                if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
                    if (LoadImg()) {
                        finish();
                    } else {
                        Toast.makeText(SettingsActivity.this, "File not exist", Toast.LENGTH_LONG).show();
                    }
                } else {
                    ActivityCompat.requestPermissions(SettingsActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            REQUEST_CODE_PERMISSION_READ_STORAGE);
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION_READ_STORAGE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (LoadImg()) {
                        finish();
                    } else {
                        Toast.makeText(this, "File not exist", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Permission error", Toast.LENGTH_LONG).show();
                }
                return;
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private boolean LoadImg() {

        ImageView v = (ImageView)findViewById(R.id.imageBackG);

        if (isExternalStorageWritable()) {


            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    editFileName.getText().toString());

            if (file.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                v.setImageBitmap(bitmap);
                Toast.makeText(this, file.getAbsolutePath(), Toast.LENGTH_LONG).show();
            } else {
                return false;
            }
        } else {
            Toast.makeText(this, "File Error", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


}
