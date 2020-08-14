package br.unigran.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private EditText campoTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //capitura do xml
        botao=findViewById(R.id.buttonOk);
        campoTexto=findViewById(R.id.etnome);

        //modelo ação
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoTexto.setText("teste");
            }
        });
    }
    //modelo açao
    public void acaobotao(View view){
        Toast.makeText(getApplicationContext(),"Olá "+campoTexto.getText(),Toast.LENGTH_LONG).show();
    }
}