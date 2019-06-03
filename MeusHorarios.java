package paradaonibus.projetoandroid.com.paradaonibus;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.security.spec.ECField;
import java.util.ArrayList;

public class MeusHorarios extends AppCompatActivity {

    private EditText textoDigitado;
    private Button botaoSalvar;
    private ListView lista;
    private SQLiteDatabase bancoDados;

    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_horarios);

        try{
            textoDigitado = (EditText) findViewById(R.id.textoDigitadoId);
            botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);

            lista = (ListView) findViewById(R.id.listaSalvaId);

            bancoDados = openOrCreateDatabase("salvarhorarios", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS horario (id INTEGER PRIMARY KEY AUTOINCREMENT, horarios VARCHAR)");

            botaoSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String texto = textoDigitado.getText().toString();
                    salvarHorario(texto);
                }
            });

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    removerTarefa(ids.get(i));
                }
            });

            recuperarTarefas();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void salvarHorario(String textoSalvo){
        try{
            if (textoSalvo.equals("")){
                Toast.makeText(MeusHorarios.this, "Digite uma horario", Toast.LENGTH_LONG).show();
            }else{
                bancoDados.execSQL("INSERT INTO horario (horarios) VALUES (' " + textoSalvo + " ')");
                Toast.makeText(MeusHorarios.this, "Horario salvo com sucesso!", Toast.LENGTH_LONG).show();
                recuperarTarefas();
                textoDigitado.setText("");


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recuperarTarefas(){
        try {
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM horario ORDER BY id DESC", null);
            int indiceColunaId   = cursor.getColumnIndex("id");
            int indiceColunaHorario = cursor.getColumnIndex("horarios");

            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador   = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text2,
                    itens);
            lista.setAdapter(itensAdaptador);

           cursor.moveToFirst();

            while(cursor != null){
                itens.add(cursor.getString(indiceColunaHorario));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void removerTarefa(Integer id){
        try {
            bancoDados.execSQL("DELETE FROM horario WHERE id=" + id);
            Toast.makeText(MeusHorarios.this, "Horario deletado com sucesso", Toast.LENGTH_LONG).show();
            recuperarTarefas();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
