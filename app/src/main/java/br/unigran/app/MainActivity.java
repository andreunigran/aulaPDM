package br.unigran.app;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_CODE_LOCATION = 1;
    private Button botao;
    private EditText campoTexto;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //capitura do xml
        botao = findViewById(R.id.buttonOk);
        campoTexto = findViewById(R.id.etnome);
        imageView = findViewById(R.id.imageView2);
        //modelo ação
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoTexto.setText("teste");
            }
        });
    }

    //modelo açao
    public void acaobotao(View view) {
        Toast.makeText(getApplicationContext(), "Olá " + campoTexto.getText(), Toast.LENGTH_LONG).show();
    }

    public void alerta(View view) {
        //cria o builder
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);//sem estilo
        //AlertDialog.Builder alerta = new AlertDialog.Builder(this,R.style.Theme_AppCompat_NoActionBar);//com estilo
        alerta.setMessage("Alerta de teste")
        // .create().show();//poderia ser msm linha
        ;

        alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Olá " + campoTexto.getText(), Toast.LENGTH_LONG).show();
                    }

                }
        );
        alerta.setNegativeButton("Cancekar", null);


        //crio o dialog
        AlertDialog dialog = alerta.create();
        dialog.show();// chamo a msg

    }

    public void segundaTela(View view) {
        Intent it = new Intent(MainActivity.this, SegundaActivity.class);
        it.putExtra("mensagem", "Mensagem da primeira tela");//exemplo de envio de dados para proxima activy(tela)
        startActivity(it);

    }

    LocationManager mLocationManager;
    private static final int CAM_REQUEST = 1;

    public void camera(View view) {
//        Intent intent = new Intent (MediaStore. ACTION_IMAGE_CAPTURE );
//        startActivityForResult (intent, CAM_REQUEST );

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //return;
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            double latitude = location.getLatitude();
            double longitude =  location.getLongitude();

            Toast.makeText(this,"lat "+latitude+" long "+longitude,Toast.LENGTH_LONG).show();

        }else
        Toast.makeText(this,"Cade a perms",Toast.LENGTH_LONG).show();

    }
    private ImageView img;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAM_REQUEST) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imagem = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imagem);

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Captura da foto cancelada", Toast.LENGTH_LONG)
                        .show();
            } else {
                Toast.makeText(this, "Captura da foto falhou", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}