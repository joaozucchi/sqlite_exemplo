package br.ifsc.edu.sqlite_exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText tituloText;
    EditText notaText;

    NotasController notasController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        notasController = new NotasController(getApplicationContext());
    }

    public void addNota(View view) {
        tituloText = findViewById(R.id.titulo);
        notaText = findViewById(R.id.nota);

        String titulo = tituloText.getText().toString();
        String nota = notaText.getText().toString();
        notasController.addNota(
                titulo,
                nota
        );

        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
