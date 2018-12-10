package g.nu3ents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PegaDadosActivity extends AppCompatActivity {
    public static final String ENCOMENDA_NOME = "encomenda_nome";
    public static final String ENCOMENDA_ALTURA = "encomenda_altura";
    public static final String ENCOMENDA_PESO = "encomenda_peso";
    public static final String ENCOMENDA_TMB = "encomenda_tmb";

    private EditText editNome;
    private EditText editAltura;
    private EditText editPeso;

    String nome;
    float altura, peso, tmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pega_dados);

        editNome = findViewById(R.id.editTextNome);
        editAltura = findViewById(R.id.editTextAltura);
        editPeso = findViewById(R.id.editTextPeso);
    }

    public void enviar_para_main(View view) {
        nome = editNome.getText().toString();
        altura = Float.parseFloat(editAltura.getText().toString());
        peso = Float.parseFloat(editPeso.getText().toString());
        tmb = (11.3f * peso) + (16 * altura) + 901;

        Intent intent = new Intent();

        intent.putExtra(ENCOMENDA_NOME, nome);
        intent.putExtra(ENCOMENDA_ALTURA, altura);
        intent.putExtra(ENCOMENDA_PESO, peso);
        intent.putExtra(ENCOMENDA_TMB, tmb);

        setResult(RESULT_OK, intent);

        finish();
    }
}
