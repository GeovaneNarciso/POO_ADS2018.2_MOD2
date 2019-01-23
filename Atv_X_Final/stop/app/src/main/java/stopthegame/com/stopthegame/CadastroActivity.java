package stopthegame.com.stopthegame;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editEmail;
    private EditText editSenha;
    private EditText editConfirmaSenha;

    String email, senha, confirmaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mAuth = FirebaseAuth.getInstance();

        editEmail = findViewById(R.id.editTextEmail);
        editSenha = findViewById(R.id.editTextSenha);
        editConfirmaSenha = findViewById(R.id.editTextConfirmaSenha);
    }

    public void cadastro_firebase(View view) {
        email = editEmail.getText().toString();
        senha = editSenha.getText().toString();
        confirmaSenha = editConfirmaSenha.getText().toString();

        if (senha.equals(confirmaSenha)) {
            mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            setResult(RESULT_OK);
                            Toast.makeText(CadastroActivity.this, "Cadastro com sucesso.", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(CadastroActivity.this, "Erro: "+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
        }else{
            Toast.makeText(this, "Senhas não coincidem.", Toast.LENGTH_SHORT).show();
        }
    }
}
