package com.johhns.formulario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText ;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener listener ;
    private EditText vwFecha ;
    private Button   btnSiguiente;
    private TextInputEditText teNombre   ;
    private TextInputEditText teFecha    ;
    private TextInputEditText teTelefono ;
    private TextInputEditText teMail     ;
    private TextInputEditText teDescrip  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            teNombre = (TextInputEditText) findViewById(R.id.txtEditNombre);
            teFecha = (TextInputEditText) findViewById(R.id.txtEditFecha);
            teTelefono = (TextInputEditText) findViewById(R.id.txtEditTelefono);
            teMail = (TextInputEditText) findViewById(R.id.txtEditMail);
            teDescrip = (TextInputEditText) findViewById(R.id.txtEditDescrip);

            String v_nombre   = parametros.getString("NOMBRE") ;
            String v_fecha    = parametros.getString("FECHA") ;
            String v_telefono = parametros.getString("TELEFONO") ;
            String v_mail     = parametros.getString("MAIL") ;
            String v_descrip  = parametros.getString("DESCRIP") ;

            teNombre.setText( v_nombre );
            teFecha.setText( v_fecha );
            teTelefono.setText( v_telefono );
            teMail.setText( v_mail );
            teDescrip.setText( v_descrip );
        }



        vwFecha = findViewById(R.id.txtEditFecha) ;
        Calendar calendario = Calendar.getInstance() ;
        final int v_periodo = calendario.get(Calendar.YEAR) ;
        final int v_mes     = calendario.get(Calendar.MONTH) ;
        final int v_dia     = calendario.get(Calendar.DAY_OF_MONTH) ;

        vwFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DatePickerDialog selectorFecha = new DatePickerDialog( MainActivity.this , android.R.style.Theme_Holo_Dialog_MinWidth, listener, v_periodo, v_mes, v_dia );
               selectorFecha.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
               selectorFecha.show();
            }
        });

        listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1 ;
                String v_Fecha = dayOfMonth + "/" + month + "/" + year ;
                vwFecha.setText(v_Fecha);
            }
        } ;

        btnSiguiente = findViewById(R.id.btnSiguiente) ;


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teNombre   = (TextInputEditText) findViewById(R.id.txtEditNombre) ;
                teFecha    = (TextInputEditText) findViewById(R.id.txtEditFecha) ;
                teTelefono = (TextInputEditText) findViewById(R.id.txtEditTelefono) ;
                teMail     = (TextInputEditText) findViewById(R.id.txtEditMail) ;
                teDescrip  = (TextInputEditText) findViewById(R.id.txtEditDescrip) ;

                Intent i = new Intent( MainActivity.this , Confirmacion.class ) ;
                i.putExtra("Nombre", teNombre.getText().toString()) ;
                i.putExtra("Fecha", teFecha.getText().toString()) ;
                i.putExtra("Telefono", teTelefono.getText().toString()) ;
                i.putExtra("Mail", teMail.getText().toString()) ;
                i.putExtra("Descrip", teDescrip.getText().toString()) ;
                startActivity(i);
                finish();
            }
        });

        /* para mostrar otro formato de calendario, solo hay que comentariar el codigo de arriba
        vwFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog selectorFecha = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month += 1 ;
                        String v_Fecha = dayOfMonth + "/" + month + "/" + year ;
                        vwFecha.setText( v_Fecha );
                    }
                }, v_periodo, v_mes, v_dia ) ;
                selectorFecha.show() ;
            }
        });
        */



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        teNombre   = (TextInputEditText) findViewById(R.id.txtEditNombre) ;
        teFecha    = (TextInputEditText) findViewById(R.id.txtEditFecha) ;
        teTelefono = (TextInputEditText) findViewById(R.id.txtEditTelefono) ;
        teMail     = (TextInputEditText) findViewById(R.id.txtEditMail) ;
        teDescrip  = (TextInputEditText) findViewById(R.id.txtEditDescrip) ;

        outState.putString("NOMBRE",teNombre.getText().toString());
        outState.putString("FECHA",teFecha.getText().toString());
        outState.putString("TELEFONO",teTelefono.getText().toString());
        outState.putString("MAIL",teMail.getText().toString());
        outState.putString("DESCRIP",teDescrip.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if ( savedInstanceState != null ) {
            teNombre   = (TextInputEditText) findViewById(R.id.txtEditNombre) ;
            teFecha    = (TextInputEditText) findViewById(R.id.txtEditFecha) ;
            teTelefono = (TextInputEditText) findViewById(R.id.txtEditTelefono) ;
            teMail     = (TextInputEditText) findViewById(R.id.txtEditMail) ;
            teDescrip  = (TextInputEditText) findViewById(R.id.txtEditDescrip) ;

            //teNombre.setText( savedInstanceState.getString("NOMBRE")  );
            teFecha.setText( savedInstanceState.getString("TELEFONO") ) ;
            teTelefono.setText( savedInstanceState.getString("FECHA") ) ;
            teMail.setText( savedInstanceState.getString("MAIL") )  ;
            teDescrip.setText( savedInstanceState.getString("DESCRIP") )  ;
        }

    }
}