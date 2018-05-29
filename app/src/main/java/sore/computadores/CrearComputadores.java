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


        //fotos = new ArrayList<Integer>();
        //fotos.add(R.drawable.images);
        //fotos.add(R.drawable.images2);
        //fotos.add(R.drawable.images3);
        //fotos.add(R.drawable.images4);

    }

    public String obtenerDato(Spinner spn){
        String cadena = "";
        cadena = spn.getSelectedItem().toString();
        return cadena;
    }

    public void guardar(View v){
        String marca, color, tipo,so, id;
        int ram, foto;
        foto = Datos.fotoAleatoria(fotos);
        marca = obtenerDato(Marca);
        ram  = Integer.parseInt(Ram.getText().toString());
        color = obtenerDato(Color);
        tipo = obtenerDato(Tipo);
        so = obtenerDato(SO);
        id = Datos.getId();

        Computador C = new Computador(id, marca, color, tipo, so, ram, foto);
        C.guardar();
        Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        Marca.setSelection(0);
        Ram.setText("");
        Color.setSelection(0);
        Tipo.setSelection(0);
        SO.setSelection(0);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearComputadores.
                this,Main.class);
        startActivity(i);
    }

}
