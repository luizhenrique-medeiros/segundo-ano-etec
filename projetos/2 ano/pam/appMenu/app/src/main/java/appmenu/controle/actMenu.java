package appmenu.controle;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class actMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_menu);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater sla = getMenuInflater();
        sla.inflate(R.menu.menuprincipal,menu);
        return true;
    }
    public boolean onOptionsItemSelect(MenuItem item) {
      if (item.getItemId() == R.id.mnialunos) {
          Intent itAlunos = new Intent(this, actAlunos.class);
          startActivity(itAlunos);
      } else if (item.getItemId() == R.id.mniprofessores){
          Intent itProfessores = new Intent(this, actProfessores.class);
          startActivity(itProfessores);
      }else if (item.getItemId() == R.id.mniSair){
          System.exit(0);
      }
      return true;
    }
}