package applancheetec.controle;

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

public class actprincipal extends AppCompatActivity {
    RadioButton radioButton1, radioButton2, radioButton3;
    CheckBox checkBox3, checkBox4, checkBox5;
    TextView textView5;
    float total=0;
    String selecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actprincipal);
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
            total=10;
            selecao="Xburguer";
        } else if (radioButton2.isChecked()) {
            total=20;
            selecao="Xsalada";
        }else if (radioButton3.isChecked()) {
            total=37;
            selecao="Xbacon";
        }
        if (checkBox3.isChecked()) {
            total+=1;
            selecao+=" - queijo";
        }
        if (checkBox4.isChecked()) {
            total+=2;
            selecao+=" - maionese";
        }
        if (checkBox5.isChecked()) {
            total+=3;
            selecao+=" - cheddar";
        }
        textView5.setText("Seleção: " + selecao + "- Total:" + String.valueOf(total));
    }
}