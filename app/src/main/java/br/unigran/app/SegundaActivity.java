package br.unigran.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        texto=findViewById(R.id.texto);

        Intent it = getIntent();// pega intent

        String mensagem = it.getStringExtra("mensagem");//recupera a chave mensagem
        texto.setText(mensagem);
    }
}