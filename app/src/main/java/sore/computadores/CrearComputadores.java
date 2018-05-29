package sore.computadores;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputadores extends AppCompatActivity {
    private EditText Ram;
    private Spinner Marca, Color, Tipo, SO;
    private ArrayAdapter<String> adpM, adpC, adpT, adpS;
    private String opc_marca[], opc_color[], opc_tipo[], opc_so[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computadores);
        Marca = findViewById(R.id.spnMarca);
        Color = findViewById(R.id.spnColor);
        Tipo = findViewById(R.id.spnTipo);
        SO = findViewById(R.id.spnSO);
        Ram = findViewById(R.id.txtRam);

        opc_marca = this.getResources().getStringArray(R.array.op_marca);
        opc_color = this.getResources().getStringArray(R.array.op_color);
        opc_tipo = this.getResources().getStringArray(R.array.op_tipo);
        opc_so = this.getResources().getStringArray(R.array.op_so);

        adpM = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_marca);
        Marca.setAdapter(adpM);
        adpC = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_color);
        Color.setAdapter(adpC);
        adpT = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_tipo);
        Tipo.setAdapter(adpT);
        adpS = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_so);
        SO.setAdapter(adpS);



    }


}
