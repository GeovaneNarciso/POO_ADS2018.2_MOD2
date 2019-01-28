package stopthegame.com.stopthegame;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ConfigSalaActivity extends AppCompatActivity {

    private Spinner selecaoRodada;
    private Spinner selecaoJogador;
    private Spinner selecaoTempo;
    private CheckBox cep;
    private CheckBox alimento;
    private CheckBox nome;
    private CheckBox pch;
    private CheckBox tv;
    private CheckBox objeto;

    private int qtdMaxRodadas = 3;
    private int qtdMaxJogadores = 2;
    private int tempoRodadaSegundos = 60;
    private String catCep;
    private String catAlimento;
    private String catNome;
    private String catPCH;
    private String catTV;
    private String catObjeto;
    private String cod_sala;

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
        alimento = findViewById(R.id.checkBoxAlimento);
        nome = findViewById(R.id.checkBoxNome);
        pch = findViewById(R.id.checkBoxPCH);
        tv = findViewById(R.id.checkBoxTV);
        objeto = findViewById(R.id.checkBoxObjeto);

    }

    public void iniciarSala(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            cod_sala = user.getUid().substring(user.getUid().length() - 5);
        }
        Toast.makeText(this, cod_sala, Toast.LENGTH_LONG).show();
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBoxCEP:
                if (checked)
                    catCep = cep.getText().toString();
                else
                    catCep = null;
                break;
            case R.id.checkBoxAlimento:
                if (checked)
                    catAlimento = alimento.getText().toString();
                else
                    catAlimento = null;
                break;
            case R.id.checkBoxNome:
                if (checked)
                    catNome = nome.getText().toString();
                else
                    catNome = null;
                break;
            case R.id.checkBoxPCH:
                if (checked)
                    catPCH = pch.getText().toString();
                else
                    catPCH = null;
                break;
            case R.id.checkBoxTV:
                if (checked)
                    catTV = tv.getText().toString();
                else
                    catTV = null;
                break;
            case R.id.checkBoxObjeto:
                if (checked)
                    catObjeto = objeto.getText().toString();
                else
                    catObjeto = null;
                break;
        }
    }
}
