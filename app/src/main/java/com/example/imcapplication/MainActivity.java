package com.example.imcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nome,altura,peso;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.editTextNome);
        altura = (EditText) findViewById(R.id.editTextAltura);
        peso = (EditText) findViewById(R.id.editTextPeso);
        botao = (Button) findViewById(R.id.buttonOk);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTelaResultado();
            }
        });
    }

    public void mostrarTelaResultado(){

        if(TextUtils.isEmpty(nome.getText().toString())){
            nome.setError("Campo obrigatório!");
            return;
        }
        if(TextUtils.isEmpty(altura.getText().toString())){
            altura.setError("Campo obrigatório!");
            return;
        }
        if(TextUtils.isEmpty(peso.getText().toString())){
            peso.setError("Campo obrigatório!");
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("nome",nome.getText().toString());
        intent.putExtra("altura",altura.getText().toString());
        intent.putExtra("peso",peso.getText().toString());
        startActivity(intent);
    }
}