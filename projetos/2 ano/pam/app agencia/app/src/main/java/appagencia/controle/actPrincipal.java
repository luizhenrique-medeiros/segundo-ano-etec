package appagencia.controle;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class actPrincipal extends AppCompatActivity {
    RadioButton radioButton1, radioButton2, radioButton3;
    CheckBox checkBox3, checkBox4, checkBox5;
    TextView textView5;
    float total=0;
    String selecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_principal);
        radioButton1= findViewById(R.id.radioButton);
        radioButton2= findViewById(R.id.radioButton2);
        radioButton3= findViewById(R.id.radioButton3);
        checkBox3= findViewById(R.id.checkBox3);
        checkBox4= findViewById(R.id.checkBox4);
        checkBox5= findViewById(R.id.checkBox5);
        textView5= findViewById(R.id.textView5);

    }
    public void total(View view){
        if (radioButton1.isChecked()) {
            total=20;
            selecao="Honda city";
        } else if (radioButton2.isChecked()) {
            total=2000;
            selecao="brasilia";
        }else if (radioButton3.isChecked()) {
            total=3000;
            selecao="Opala";
        }
        if (checkBox3.isChecked()) {
            total+=500;
            selecao+=" - roda";
        }
        if (checkBox4.isChecked()) {
            total+=1000;
            selecao+=" - som";
        }
        if (checkBox5.isChecked()) {
            total+=5000;
            selecao+=" - teto";
        }
        textView5.setText("Seleção: " + selecao + "- Total:" + String.valueOf(total));
    }
}