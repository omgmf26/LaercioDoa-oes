package com.example.doacoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    DatabaseHelper bd;

    EditText txtNome, txtEmailCad, txtSenhaCad;
    Button btnRegistrarCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        db = DatabaseHelper(this);

        txtNome = findViewById(R.id.NomeCad);
        txtEmailCad = findViewById(R.id.EmailCad);
        txtSenhaCad = findViewById(R.id.SenhaCad);

        btnRegistrarCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, email, senha;

                nome = txtNome.getText().toString();
                email = txtEmailCad.getText().toString();
                senha = txtSenhaCad.getText().toString();

                if (nome.equals("") || email.equals("") || senha.equals("")) {
                    Toast.makeText(getApplicationContext(), "Por favor insira os valores.", Toast.LENGTH_SHORT).show();
                } else {
                    if (senha.equals(senha)) {
                        Boolean checarEmail = db.validarEmail(email);
                        if (checarEmail == true) {
                            Boolean inserir = db.insert(senha, email);
                            if (inserir == true) {
                                Toast.makeText(getApplicationContext(), "Registro inserido com sucesso.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email inserido já existe.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Senha não confere.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
