package com.example.apptemperatura;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Temperatura extends AppCompatActivity {
    EditText editTextValor;
    RadioButton radioCelsiusDe, radioFahrenheitDe, radioKelvinDe;
    RadioButton radioCelsiusPara, radioFahrenheitPara, radioKelvinPara;
    TextView textViewResultado;
    Button btnConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperatura);
        editTextValor = findViewById(R.id.editTextValor);
        radioCelsiusDe = findViewById(R.id.radioCelsiusDe);
        radioFahrenheitDe = findViewById(R.id.radioFahrenheitDe);
        radioKelvinDe = findViewById(R.id.radioKelvinDe);
        radioCelsiusPara = findViewById(R.id.radioCelsiuspara);
        radioFahrenheitPara = findViewById(R.id.radioFahrenheitpara);
        radioKelvinPara = findViewById(R.id.radioKelvinpara);
        textViewResultado = findViewById(R.id.textViewResultado);
        btnConverter = findViewById(R.id.btnConverter);

        btnConverter.setOnClickListener(v -> converterTemperatura());

    };
    private void converterTemperatura() {
        double valor;
        try {
            valor = Double.parseDouble(editTextValor.getText().toString());
        } catch (Exception e) {
            textViewResultado.setText("Digite um valor válido.");
            return;
        }

        String de = "", para = "";
        if (radioCelsiusDe.isChecked()) de = "C";
        else if (radioFahrenheitDe.isChecked()) de = "F";
        else if (radioKelvinDe.isChecked()) de = "K";

        if (radioCelsiusPara.isChecked()) para = "C";
        else if (radioFahrenheitPara.isChecked()) para = "F";
        else if (radioKelvinPara.isChecked()) para = "K";

        double resultado = 0;

        if (de.equals(para)) {
            resultado = valor;
        } else if (de.equals("C") && para.equals("F")) {
            resultado = (valor * 9 / 5) + 32;
        } else if (de.equals("C") && para.equals("K")) {
            resultado = valor + 273.15;
        } else if (de.equals("F") && para.equals("C")) {
            resultado = (valor - 32) * 5 / 9;
        } else if (de.equals("F") && para.equals("K")) {
            resultado = ((valor - 32) * 5 / 9) + 273.15;
        } else if (de.equals("K") && para.equals("C")) {
            resultado = valor - 273.15;
        } else if (de.equals("K") && para.equals("F")) {
            resultado = ((valor - 273.15) * 9 / 5) + 32;
        }

        textViewResultado.setText(String.format("Resultado: %.2f %s", resultado, para));
    }

}
