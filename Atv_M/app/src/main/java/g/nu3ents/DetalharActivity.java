package g.nu3ents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static g.nu3ents.MainActivity.REQUEST_CODE;

public class DetalharActivity extends AppCompatActivity {
    private TextView nome;
    private TextView pro_kcal;
    private TextView pro_g;
    private TextView carbo_kcal;
    private TextView carbo_g;
    private TextView gordu_kcal;
    private TextView gordu_g;
    private String nome2;
    private float kcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar);

        nome = findViewById(R.id.textViewNomeDetalhar);
        pro_kcal = findViewById(R.id.textViewProteinasValor);
        pro_g = findViewById(R.id.textViewProteinasGramas);
        carbo_kcal = findViewById(R.id.textViewCarboValor);
        carbo_g = findViewById(R.id.textViewCarboGramas);
        gordu_kcal = findViewById(R.id.textViewGorduValor);
        gordu_g = findViewById(R.id.textViewGorduraGramas);

        final Intent intent = getIntent();

        nome2 = intent.getStringExtra(MainActivity.PACOTE_NOME);
        kcal = intent.getFloatExtra(MainActivity.PACOTE_CALORIA_TOTAL, 0.0f);

        nome.setText(nome2);
        pro_kcal.setText(String.format("%.2f", kcal * 0.15));
        pro_g.setText(String.format("%.2f", (kcal * 0.15) / 4));
        carbo_kcal.setText(String.format("%.2f", kcal * 0.60));
        carbo_g.setText(String.format("%.2f", (kcal * 0.60) / 4));
        gordu_kcal.setText(String.format("%.2f", kcal * 0.25));
        gordu_g.setText(String.format("%.2f", (kcal * 0.25) / 9));
    }

    public void voltar(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
