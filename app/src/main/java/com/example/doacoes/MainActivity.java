package com.example.doacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtSenha;
    Button btnEntrar;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        txtEmail = findViewById(R.id.Email);
        txtSenha = findViewById(R.id.Senha);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, senha;

                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();

                Boolean checarEmailSenha = db.checarEmailSenha(email,senha);

                if (checarEmailSenha==true){
                    Log.i("btnEntrar","Cliquei no botão entrar");
                    Toast.makeText(getApplicationContext(), "Acesso permitido.", Toast.LENGTH_SHORT).toString();
                    Intent intent = new Intent(getApplicationContext(),);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Acesso negado.", Toast.LENGTH_SHORT).toString();
                }
            }
        });

    }
}
