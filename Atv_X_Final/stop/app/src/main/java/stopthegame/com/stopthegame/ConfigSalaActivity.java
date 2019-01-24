package stopthegame.com.stopthegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class ConfigSalaActivity extends AppCompatActivity {
    private Spinner selecaoRodada;
    private Spinner selecaoJogador;
    private Spinner selecaoTempo;
    private CheckBox cep;

    private int qtdMaxRodadas = 3;
    private int qtdMaxJogadores = 2;
    private int tempoRodadaSegundos = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_sala);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerRodadas, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecaoRodada = findViewById(R.id.spinnerRodadas);
        selecaoRodada.setAdapter(adapter);

        selecaoRodada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                qtdMaxRodadas = position + 3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spinnerJogadores, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecaoJogador = findViewById(R.id.spinnerJogadores);
        selecaoJogador.setAdapter(adapter2);

        selecaoJogador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                qtdMaxJogadores = position + 2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spinnerTempo, android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecaoTempo = findViewById(R.id.spinnerTempo);
        selecaoTempo.setAdapter(adapter3);

        selecaoTempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempoRodadaSegundos = (position + 1) * 60;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cep = findViewById(R.id.checkBoxCEP);
    }

    public void iniciarSala(View view) {
        Toast.makeText(this, "Qtd. max. rodadas: " + qtdMaxRodadas + "" +
                "\nQtd. max. jogadores: " + qtdMaxJogadores + "" +
                "\nTempo da rodada: " + tempoRodadaSegundos + "" +
                "\n C.E.P.: " + cep
                , Toast.LENGTH_LONG).show();
    }
}
