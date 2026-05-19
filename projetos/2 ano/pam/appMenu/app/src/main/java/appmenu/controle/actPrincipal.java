package appmenu.controle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class actPrincipal extends AppCompatActivity {
    ImageView imgEscola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_principal);
        imgEscola=findViewById(R.id.imgEscola);
        imgEscola.animate().setDuration(2000);
        imgEscola.animate().rotation(90);
        imgEscola.animate().alpha(0.1f);
        imgEscola.animate().rotationX(360);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exibirMenu();
            }
        },2000);

    }
    public void exibirMenu(){
        Intent it =new Intent(this,actMenu.class);
        startActivity(it);
        this.finish();
    }
}