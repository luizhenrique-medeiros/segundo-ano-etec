package controle.projetoagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class meupintologin extends AppCompatActivity {

   EditText txt_senha,txt_nomes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meupintologin);
        txt_nomes = findViewById(R.id.txt_nome);
        txt_senha = findViewById(R.id.txt_pass);

    }

    public void Login(View view){
        String login=txt_nomes.getText().toString();
        String senha=txt_senha.getText().toString();
        if(login.equals("batata") && senha.equals("123") ){
            Intent it = new Intent(this,principal.class);
            it.putExtra( "nome", login);
            it.putExtra( "senha", senha);

            startActivity(it);
        }else{
            Toast.makeText(this, "Login invalido", Toast.LENGTH_SHORT).show();
            txt_nomes.setText("");
            txt_senha.setText("");
            txt_nomes.requestFocus();
        }
    }

}