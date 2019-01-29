package stopthegame.com.stopthegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntradaActivity extends AppCompatActivity {
    private DatabaseReference stopBD;
    private String cod_sala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
    }

    public void criarSala(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            cod_sala = user.getUid().substring(user.getUid().length() - 5);
        }
        //HashMap<String, Object> map = new HashMap<String, Object>();
        //map.put(cod_sala, null);
        stopBD = FirebaseDatabase.getInstance().getReference().child("salas").child(cod_sala);
        stopBD.removeValue();
        Intent intent = new Intent(this, ConfigSalaActivity.class);
        startActivity(intent);
    }
}
