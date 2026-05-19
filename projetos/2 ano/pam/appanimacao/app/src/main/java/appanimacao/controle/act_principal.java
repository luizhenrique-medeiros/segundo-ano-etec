package appanimacao.controle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class act_principal extends AppCompatActivity {
    ImageView imgestrela;
    ImageView imgdel;
    ImageView imgalerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_principal);
        imgestrela=findViewById(R.id.imgestrela);
        imgestrela.animate().setDuration(2000);
        imgestrela.animate().rotation(90);
        imgestrela.animate().alpha(0.1f);
        imgestrela.animate().rotationX(360);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exibirMenu();
            }
        },2000);

        imgdel=findViewById(R.id.imgdel);
        imgdel.animate().setDuration(2000);
        imgdel.animate().rotation(180);
        imgdel.animate().alpha(0.1f);
        imgdel.animate().rotationX(90);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exibirMenu();
            }
        },2000);

        imgalerta=findViewById(R.id.imgalerta);
        imgalerta.animate().setDuration(2000);
        imgalerta.animate().rotation(360);
        imgalerta.animate().alpha(0.1f);
        imgalerta.animate().rotationX(180);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exibirMenu();
            }
        },2000);

    }

    public void exibirMenu(){
        Intent it =new Intent(this,act_principal.class);
        startActivity(it);
        this.finish();
    }
}
