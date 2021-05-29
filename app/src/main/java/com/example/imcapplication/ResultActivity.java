package com.example.imcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultado;
    String strNome;
    Float fltAltura, fltPeso, fltResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultado = (TextView) findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        strNome = intent.getStringExtra("nome");
        fltAltura = Float.parseFloat(intent.getStringExtra("altura"));
        fltPeso = Float.parseFloat(intent.getStringExtra("peso"));
        fltResult = fltPeso / (fltAltura * fltAltura);

        String strResult = "Olá " + strNome + "!";
        strResult = strResult + "\n" + "IMC = " + fltResult.toString();

        if(fltResult < 17) {
            strResult = strResult + "\n" + "Muito abaixo do peso";
        }
        else if(fltResult < 18.49){
            strResult = strResult + "\n" + "Abaixo do peso";
        }
        else if(fltResult < 24.99){
            strResult = strResult + "\n" + "Peso normal";
        }
        else if(fltResult < 29.99){
            strResult = strResult + "\n" + "Acima do peso";
        }
        else if(fltResult < 34.99){
            strResult = strResult + "\n" + "Obesidade I";
        }
        else if(fltResult < 39.99){
            strResult = strResult + "\n" + "Obesidade II (severa)";
        }
        else {
            strResult = strResult + "\n" + "Obesidade III (mórbida)";
        }

        resultado.setText(strResult);
    }
}