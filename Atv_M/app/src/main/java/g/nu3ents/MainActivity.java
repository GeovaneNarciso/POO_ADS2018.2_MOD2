package g.nu3ents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 100;
    public static final String PACOTE_NOME = "nome";
    public static final String PACOTE_CALORIA_TOTAL = "calorias";

    private TextView nome;
    private TextView altura;
    private TextView peso;
    private TextView tmb_txt;
    private TextView tmb_valor;
    private LinearLayout linear_layout;
    private Spinner spinner;
    private TextView calorias_txt;
    private TextView calorias_valor;
    private Button detalhar;

    String nome2;
    float kcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estilo_spinner, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.estilo_spinner);
        spinner.setAdapter(adapter);


        nome = findViewById(R.id.textViewNome);
        altura = findViewById(R.id.textViewAltura);
        peso = findViewById(R.id.textViewPeso);
        tmb_txt = findViewById(R.id.textViewTmbTxt);
        tmb_valor = findViewById(R.id.textViewTmbValue);
        linear_layout = findViewById(R.id.linearLayout);
        calorias_txt = findViewById(R.id.textViewCaloriasTxt);
        calorias_valor = findViewById(R.id.textViewCaloriasValor);
        detalhar = findViewById(R.id.buttonDetalhar);
    }

    public void ir_para_pega_dados(View view) {
        Intent intent = new Intent(this, PegaDadosActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void detalhar(View view) {
        nome2 = nome.getText().toString();
        kcal = Float.parseFloat(calorias_valor.getText().toString());

        Intent intent = new Intent(this, DetalharActivity.class);

        intent.putExtra(PACOTE_NOME, nome2);
        intent.putExtra(PACOTE_CALORIA_TOTAL, kcal);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String nome = data.getStringExtra(PegaDadosActivity.ENCOMENDA_NOME);
                float altura = data.getFloatExtra(PegaDadosActivity.ENCOMENDA_ALTURA, 0);
                float peso = data.getFloatExtra(PegaDadosActivity.ENCOMENDA_PESO, 0);
                final float tmb = data.getFloatExtra(PegaDadosActivity.ENCOMENDA_TMB, 0);

                this.nome.setText(nome);
                this.altura.setText(String.format("%s m", altura));
                this.peso.setText(String.format("%s kg", peso));
                tmb_valor.setText(String.format("%s kcal", tmb));
                calorias_valor.setText(String.format("%s ", tmb));

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        float kcal = 0;
                        if (position == 0) {
                            kcal = tmb * 1.0f;
                        }else if (position == 1) {
                            kcal = tmb * 1.11f;
                        }else if (position == 2) {
                            kcal = tmb * 1.25f;
                        }else if (position == 3)
                            kcal = tmb * 1.48f;
                        String kcal2 = String.format("%.2f", kcal);
                        calorias_valor.setText(kcal2);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                this.nome.setVisibility(TextView.VISIBLE);
                this.altura.setVisibility(TextView.VISIBLE);
                this.peso.setVisibility(TextView.VISIBLE);
                tmb_txt.setVisibility(TextView.VISIBLE);
                tmb_valor.setVisibility(TextView.VISIBLE);
                linear_layout.setVisibility(LinearLayout.VISIBLE);
                calorias_txt.setVisibility(TextView.VISIBLE);
                calorias_valor.setVisibility(TextView.VISIBLE);
                detalhar.setVisibility(Button.VISIBLE);
            }
        }
    }
}
