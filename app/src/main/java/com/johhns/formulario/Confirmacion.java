package com.johhns.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    Button btnEdit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle parametros = getIntent().getExtras();
        String v_nombre   = parametros.getString("Nombre") ;
        String v_fecha    = parametros.getString("Fecha") ;
        String v_telefono = parametros.getString("Telefono") ;
        String v_mail     = parametros.getString("Mail") ;
        String v_descrip  = parametros.getString("Descrip") ;

        TextView tv_nombre   = findViewById(R.id.tvNombre);
        TextView tv_fecha    = findViewById(R.id.tvFecha);
        TextView tv_telefono = findViewById(R.id.tvTelefono);
        TextView tv_mail     = findViewById(R.id.tvMail);
        TextView tv_descrip  = findViewById(R.id.tvDescripcion);

        tv_nombre.setText(v_nombre);
        tv_fecha.setText("Fecha nacimiento : " + v_fecha);
        tv_telefono.setText("Tel : " + v_telefono);
        tv_mail.setText("Email : " + v_mail);
        tv_descrip.setText("Descripcion : " + v_descrip);

        btnEdit = findViewById(R.id.btnEditar);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Confirmacion.this , MainActivity.class ) ;
                i.putExtra("NOMBRE", v_nombre ) ;
                i.putExtra("FECHA", v_fecha) ;
                i.putExtra("TELEFONO", v_telefono) ;
                i.putExtra("MAIL", v_mail) ;
                i.putExtra("DESCRIP", v_descrip) ;
                startActivity(i);
                //finish();
            }
        });
    }
}
