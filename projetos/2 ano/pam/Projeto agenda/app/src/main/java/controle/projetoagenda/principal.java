package controle.projetoagenda;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import bd.bdAgenda;

public class principal extends AppCompatActivity {

    Button bt_log;

        EditText edtnome,edtemail,edtcelular,edtID;

                Button btncadastrar, btnalterar, btnconsultar, btnexcluir, btnlimpar;
    bdAgenda bdagenda= null;

    SQLiteDatabase bd = null;

    ContentValues values = null;

    Cursor cursor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        edtnome=findViewById(R.id.txt_name);
        edtcelular=findViewById(R.id.txt_cel);
        edtemail=findViewById(R.id.txt_email);
        edtID=findViewById(R.id.txt_ID);
        btncadastrar=findViewById(R.id.bt_cad);
        btnconsultar=findViewById(R.id.bt_con);
        btnexcluir=findViewById(R.id.bt_excluir);
        btnalterar=findViewById(R.id.bt_alt);
        btnlimpar=findViewById(R.id.bt_limp);

        bdagenda = new bdAgenda(getBaseContext());
    }
    public void LimparEDT(View view){
        edtemail.setText("");
        edtnome.setText(null);
        edtcelular.setText(null);
        edtnome.requestFocus();
    }
    public void Cadastrar(View view){
        bd=bdagenda.getWritableDatabase();
        values= new ContentValues();
        values.put("nome", edtnome.getText().toString());
        values.put("email", edtemail.getText().toString());
        values.put("Celular", edtcelular.getText().toString());
        values.put("pass", "");
        bd.insert("contatos",null, values);
        long linha=bd.insert("contatos", null, values);
        if(linha<=0){
            Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Cadastro com sucesso", Toast.LENGTH_SHORT).show();

        }
        LimparEDT(view);
        bd.close();
    }

    public void ConsultarID(View view){
        bd=bdagenda.getReadableDatabase();
        cursor=bd.rawQuery("select * from contatos where id="+ Integer.parseInt(edtID.getText().toString()),null );
        if(cursor.moveToFirst()){
            edtnome.setText(cursor.getString(1));
            edtcelular.setText(cursor.getString(2));
            edtemail.setText(cursor.getString(3));
        }else{

            Toast.makeText(this, "ID não cadastrado", Toast.LENGTH_SHORT).show();
            LimparEDT(view);
        }
        bd.close();
    }
    public void Alterar(View view){
        bd=bdagenda.getWritableDatabase();
        values= new ContentValues();
        values.put("nome", edtnome.getText().toString());
        values.put("email", edtemail.getText().toString());
        values.put("Celular", edtcelular.getText().toString());
        values.put("pass", "");
        int linha=bd.update("contatos",values, "id="+Integer.parseInt(edtID.getText().toString()), null);
        if(linha<=0){
            Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Cadastro com sucesso", Toast.LENGTH_SHORT).show();

        }
        bd.close();
    }

    public void Excluir(View view){
        bd=bdagenda.getWritableDatabase();
        int linha=bd.delete("contatos", "id="+Integer.parseInt(edtID.getText().toString()), null);
        if(linha<=0){
            Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Cadastro com sucesso", Toast.LENGTH_SHORT).show();

        }
        bd.close();


    }
    public void Sair(View view) {
        this.finish();
    }

}