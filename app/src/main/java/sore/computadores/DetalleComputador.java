package sore.computadores;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputador extends AppCompatActivity {
    private TextView tMarcadetalle,tRamdetalle,tColordetalle,tTipodetalle,tSistemaopdetalle;
    private int foto_pc, ram;
    private String id, marca,color,tipo,sistemaOp;
    private ImageView Fimg;
    private Intent i;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);

        tMarcadetalle = findViewById(R.id.tMarcadetalle);
        tRamdetalle = findViewById(R.id.tRamdetalle);
        tColordetalle = findViewById(R.id.tColordetalle);
        tTipodetalle = findViewById(R.id.tTipodetalle);
        tSistemaopdetalle = findViewById(R.id.tSistemaopdetalle);

        Fimg = findViewById(R.id.foto);

        i = getIntent();

        bundle = i.getBundleExtra("datos");
        marca = bundle.getString("marca");
        ram = bundle.getInt("ram");
        color = bundle.getString("color");
        tipo = bundle.getString("tipo");
        sistemaOp = bundle.getString("sistemaop");
        foto_pc = bundle.getInt("foto");
        id = bundle.getString("id");

        tMarcadetalle.setText(marca);
        tRamdetalle.setText(String.valueOf(ram));
        tColordetalle.setText(color);
        Fimg.setImageResource(foto_pc);


    }
    public void eliminar(View v){
        String acceder,denegar;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        acceder = getResources().getString(R.string.positivo);
        denegar = getResources().getString(R.string.negativo);

        builder.setPositiveButton(acceder, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador cpmt = new Computador(id);
                cpmt.eliminar();
                onBackPressed();
            }
        });
        builder.setNegativeButton(denegar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void onBackPressed() {
        finish();
        Intent i = new Intent(DetalleComputador.this,Main.class);
        startActivity(i);
    }
}
