package br.unigran.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
    public void alerta(View view){
        //cria o builder
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);//sem estilo
        //AlertDialog.Builder alerta = new AlertDialog.Builder(this,R.style.Theme_AppCompat_NoActionBar);//com estilo
        alerta.setMessage("Alerta de teste")
       // .create().show();//poderia ser msm linha
        ;

        alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Olá "+campoTexto.getText(),Toast.LENGTH_LONG).show();
                    }

                }
        );
        alerta.setNegativeButton("Cancekar",null);


        //crio o dialog
        AlertDialog dialog =alerta.create();
       dialog.show();// chamo a msg

    }

    public void segundaTela(View view){
        Intent it = new Intent(MainActivity.this,SegundaActivity.class);
        startActivity(it);

    }
}