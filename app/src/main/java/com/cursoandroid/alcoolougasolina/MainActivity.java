package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
        textResultado.setVisibility(View.INVISIBLE);

    }

    public void calcularPreco(View view){
        // recuperar valor digitados
        String precoAcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // validar os campos
        boolean camposValidados = validarCampo(precoAcool, precoGasolina);

        if ( camposValidados ){

            // Convertendo string para number
            double valorAlcool = Double.parseDouble(precoAcool);
            double valorGasolina = Double.parseDouble(precoGasolina);
            double resultado = valorAlcool / valorGasolina;

            if ( resultado >= 0.7){
                textResultado.setText("Melhor utilizar gasolina");

            }else{
                textResultado.setText("Melhor utilizar Alcool");
            }

        }else {
            textResultado.setText("Preencha os precos primeiros");
        }

           textResultado.setVisibility(View.VISIBLE);

    }

    public boolean validarCampo(String pAcool, String pGasolina){
        boolean camposValidados = true;

        if( pAcool == null || pAcool.equals("")){
            camposValidados = false;

        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }

        return camposValidados;
    }

}
