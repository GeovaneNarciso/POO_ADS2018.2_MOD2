package g.addonha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> letras = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "W", "X", "Y", "Z");
    private String letra = "A";
    private TextView showLetra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLetra = findViewById(R.id.textView_letra);
    }

    public void showNext(View view) {
        letra += letra;
        //letra = "A";
        showLetra.setText(letra);
    }
}
