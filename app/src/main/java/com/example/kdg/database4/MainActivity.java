package com.example.kdg.database4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    DatabaseHelper myDB;
    EditText editNombre;
    EditText editMarca;
    EditText editUnidad;
    EditText editFoto;
    EditText editAlerta_Min_Stock_SP;
    EditText editAlerta_Max_Stock_SP;
    EditText editAlerta_Low_Consump_Quantity_SP;
    EditText editAlerta_Low_Consump_Time_Dias_SP;
    EditText editAlerta_Inactivity_Time_Dias_SP;
    EditText editAlerta_Expiration_Dias_Before_SP;
    EditText editMonitor_Alertas;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editNombre = (EditText) findViewById(R.id.editText_Nombre);
        editMarca = (EditText) findViewById(R.id.editText_Marca);
        editUnidad = (EditText) findViewById(R.id.editText_Unidad);
      //  editFoto = (EditText) findViewById(R.id.editText_Foto);
        editAlerta_Min_Stock_SP = (EditText) findViewById(R.id.editText_Alerta_Min_Stock);
        editAlerta_Max_Stock_SP = (EditText) findViewById(R.id.editText_Alerta_Max_Stock);
        editAlerta_Low_Consump_Quantity_SP = (EditText) findViewById(R.id.editText_Alerta_Low_Consump_Quantity_SP);
        editAlerta_Low_Consump_Time_Dias_SP = (EditText) findViewById(R.id.editText_Alerta_Low_Consump_Time_Dias_SP);
        editAlerta_Inactivity_Time_Dias_SP = (EditText) findViewById(R.id.editText_Alerta_Inactivity_Time_Dias_SP);
        editAlerta_Expiration_Dias_Before_SP = (EditText) findViewById(R.id.editText_Alerta_Expiration_Dias_Before_SP);
        editMonitor_Alertas = (EditText) findViewById(R.id.editText_Nombre);
        btnAddData = (Button) findViewById(R.id.button_Insert_Data);
        AddData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(editNombre.getText().toString(),
                                editMarca.getText().toString(),
                                editUnidad.getText().toString(),
                                Integer.parseInt(editAlerta_Min_Stock_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Max_Stock_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Low_Consump_Quantity_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Low_Consump_Time_Dias_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Inactivity_Time_Dias_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Expiration_Dias_Before_SP.getText().toString()));
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }




    protected void Data_Entry(View v) {

        //get input data
    //    EditText Product_Descrip = (EditText) findViewById(R.id.ET_Create_Name);
     //   TextView output = (TextView) findViewById(R.id.TV_Output);

        // output
      //  output.setText("Result");


    }

}

