package paradaonibus.projetoandroid.com.paradaonibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Horarios extends AppCompatActivity {

    private ImageView assisCandidoMota;
    private ImageView assisCruzalia;
    private ImageView assisFlorinia;
    private ImageView assisOurinhos;
    private ImageView assisPlatina;
    private ImageView assisTaruma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);


        assisCandidoMota = (ImageView) findViewById(R.id.assisCandidoMotaId);
        assisCruzalia = (ImageView) findViewById(R.id.assisCruzaliaId);
        assisFlorinia = (ImageView) findViewById(R.id.assisFlorineaId);
        assisOurinhos = (ImageView) findViewById(R.id.assisOurinhosId);
        assisPlatina = (ImageView) findViewById(R.id.assisPlatinaId);
        assisTaruma = (ImageView) findViewById(R.id.assisTarumaId);

        assisCandidoMota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Horarios.this, AssisCandidoMota.class));
            }
        });

        assisCruzalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Horarios.this, AssisCruzalia.class));
            }
        });

        assisFlorinia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Horarios.this, AssisFlorinia.class));
            }
        });
        assisOurinhos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Horarios.this, AssisOurinhos.class));
            }
        });

        assisPlatina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Horarios.this, AssisPlatina.class));
            }
        });

        assisTaruma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Horarios.this, AssisTaruma.class));
            }
        });

    }



}
