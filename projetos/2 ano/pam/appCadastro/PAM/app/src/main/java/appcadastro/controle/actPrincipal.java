package appcadastro.controle;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class actPrincipal extends AppCompatActivity {

    TextView txtExibir;
    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_principal);
        txtExibir=findViewById(R.id.txtExibir);
        edtNome=findViewById(R.id.edtNome);
    }
    public void Exibir(View view) {
        String nome = edtNome.getText().toString();
        txtExibir.setText(nome);
    }
}