package stopthegame.com.stopthegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SalaInicioActivity extends AppCompatActivity {
    private DatabaseReference stopBD;
    private TextView cod_sala;

    private String valor_cod_sala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_inicio);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            valor_cod_sala = user.getUid().substring(user.getUid().length() - 5);
        }
        cod_sala = findViewById(R.id.textViewCodSalaValor);
        cod_sala.setText(valor_cod_sala);
    }
}
