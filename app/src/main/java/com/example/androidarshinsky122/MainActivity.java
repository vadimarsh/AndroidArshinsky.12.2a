package com.example.androidarshinsky122;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private View engLayout;
    private View basLayout;
    private Button[] buttonsBas = new Button[11];
    private Button[] opbuttonsBas = new Button[5];
    private Button[] spesbuttonsBas = new Button[3];
    private Button[] buttonsEng = new Button[11];
    private Button[] opbuttonsEng = new Button[9];
    private Button[] spesbuttonsEng = new Button[3];

    private Button buttonChangeToEngen;
    private Button buttonChangeToBasic;

    private Button buttonSettings;
    private TextView textViewBas;
    private TextView textViewEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        buttonSettings = findViewById(R.id.buttonSettings);

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            }
        });
        engLayout = findViewById(R.id.engCalcLayout);
        basLayout = findViewById(R.id.simpleCalcLayout);

        textViewBas = findViewById(R.id.textview);

        buttonChangeToEngen = (Button) findViewById(R.id.buttonMode);

        buttonsBas[0] = (Button) findViewById(R.id.button0);
        buttonsBas[1] = (Button) findViewById(R.id.button1);
        buttonsBas[2] = (Button) findViewById(R.id.button2);
        buttonsBas[3] = (Button) findViewById(R.id.button3);
        buttonsBas[4] = (Button) findViewById(R.id.button4);
        buttonsBas[5] = (Button) findViewById(R.id.button5);
        buttonsBas[6] = (Button) findViewById(R.id.button6);
        buttonsBas[7] = (Button) findViewById(R.id.button7);
        buttonsBas[8] = (Button) findViewById(R.id.button8);
        buttonsBas[9] = (Button) findViewById(R.id.button9);
        buttonsBas[10] = (Button) findViewById(R.id.buttonDot);

        opbuttonsBas[0] = (Button) findViewById(R.id.buttonmult);
        opbuttonsBas[1] = (Button) findViewById(R.id.buttonminus);
        opbuttonsBas[2] = (Button) findViewById(R.id.buttonplus);
        opbuttonsBas[3] = (Button) findViewById(R.id.buttoneval);
        opbuttonsBas[4] = (Button) findViewById(R.id.buttondiv);

        spesbuttonsBas[0] = (Button) findViewById(R.id.buttonreset);
        spesbuttonsBas[1] = (Button) findViewById(R.id.buttonsign);
        spesbuttonsBas[2] = (Button) findViewById(R.id.buttonproc);

        buttonsBas[0].setText(R.string._0);
        buttonsBas[1].setText(R.string._1);
        buttonsBas[2].setText(R.string._2);
        buttonsBas[3].setText(R.string._3);
        buttonsBas[4].setText(R.string._4);
        buttonsBas[5].setText(R.string._5);
        buttonsBas[6].setText(R.string._6);
        buttonsBas[7].setText(R.string._7);
        buttonsBas[8].setText(R.string._8);
        buttonsBas[9].setText(R.string._9);
        buttonsBas[10].setText(R.string._dot);

        opbuttonsBas[0].setText(R.string._mult);
        opbuttonsBas[1].setText(R.string._minus);
        opbuttonsBas[2].setText(R.string._plus);
        opbuttonsBas[3].setText(R.string._eval);
        opbuttonsBas[4].setText(R.string._div);

        spesbuttonsBas[0].setText(R.string._reset);
        spesbuttonsBas[1].setText(R.string._sign);
        spesbuttonsBas[2].setText(R.string._proc);
        buttonChangeToEngen.setText(R.string._mode);
        buttonChangeToEngen.setOnClickListener(new ModeClickListener());

        for (int i = 0; i < buttonsBas.length; i++) {
            buttonsBas[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textViewBas.append(((Button) v).getText().toString());
                }
            });
        }
        textViewEng = findViewById(R.id.engtextview);
        buttonChangeToBasic = (Button) findViewById(R.id.engbuttonMode);
        buttonsEng[0] = (Button) findViewById(R.id.engbutton0);
        buttonsEng[1] = (Button) findViewById(R.id.engbutton1);
        buttonsEng[2] = (Button) findViewById(R.id.engbutton2);
        buttonsEng[3] = (Button) findViewById(R.id.engbutton3);
        buttonsEng[4] = (Button) findViewById(R.id.engbutton4);
        buttonsEng[5] = (Button) findViewById(R.id.engbutton5);
        buttonsEng[6] = (Button) findViewById(R.id.engbutton6);
        buttonsEng[7] = (Button) findViewById(R.id.engbutton7);
        buttonsEng[8] = (Button) findViewById(R.id.engbutton8);
        buttonsEng[9] = (Button) findViewById(R.id.engbutton9);
        buttonsEng[10] = (Button) findViewById(R.id.engbuttonDot);

        opbuttonsEng[0] = (Button) findViewById(R.id.engbuttonmult);
        opbuttonsEng[1] = (Button) findViewById(R.id.engbuttonminus);
        opbuttonsEng[2] = (Button) findViewById(R.id.engbuttonplus);
        opbuttonsEng[3] = (Button) findViewById(R.id.engbuttoneval);
        opbuttonsEng[4] = (Button) findViewById(R.id.engbuttondiv);
        opbuttonsEng[5] = (Button) findViewById(R.id.buttonexp);
        opbuttonsEng[6] = (Button) findViewById(R.id.buttonln);
        opbuttonsEng[7] = (Button) findViewById(R.id.buttonlog);
        opbuttonsEng[8] = (Button) findViewById(R.id.buttonpow);

        spesbuttonsEng[0] = (Button) findViewById(R.id.engbuttonreset);
        spesbuttonsEng[1] = (Button) findViewById(R.id.engbuttonsign);
        spesbuttonsEng[2] = (Button) findViewById(R.id.engbuttonproc);

        buttonsEng[0].setText(R.string._0);
        buttonsEng[1].setText(R.string._1);
        buttonsEng[2].setText(R.string._2);
        buttonsEng[3].setText(R.string._3);
        buttonsEng[4].setText(R.string._4);
        buttonsEng[5].setText(R.string._5);
        buttonsEng[6].setText(R.string._6);
        buttonsEng[7].setText(R.string._7);
        buttonsEng[8].setText(R.string._8);
        buttonsEng[9].setText(R.string._9);
        buttonsEng[10].setText(R.string._dot);

        opbuttonsEng[0].setText(R.string._mult);
        opbuttonsEng[1].setText(R.string._minus);
        opbuttonsEng[2].setText(R.string._plus);
        opbuttonsEng[3].setText(R.string._eval);
        opbuttonsEng[4].setText(R.string._div);
        opbuttonsEng[5].setText(R.string._exp);
        opbuttonsEng[6].setText(R.string._ln);
        opbuttonsEng[7].setText(R.string._log);
        opbuttonsEng[8].setText(R.string._pow);

        spesbuttonsEng[0].setText(R.string._reset);
        spesbuttonsEng[1].setText(R.string._sign);
        spesbuttonsEng[2].setText(R.string._proc);

        buttonChangeToBasic.setText(R.string._mode);
        buttonChangeToBasic.setOnClickListener(new ModeClickListener());


        for (int i = 0; i < buttonsEng.length; i++) {

            buttonsEng[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textViewEng.append(((Button) v).getText().toString());
                }
            });
        }
    }


    private void changeVisibility() {
        if (basLayout.getVisibility() == View.VISIBLE) {
            basLayout.setVisibility(View.GONE);
            engLayout.setVisibility(View.VISIBLE);
        } else {
            basLayout.setVisibility(View.VISIBLE);
            engLayout.setVisibility(View.GONE);
        }
    }

    private class ModeClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            changeVisibility();
        }
    }
}
