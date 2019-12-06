package br.ifsc.edu.sqlite_exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    NotasController notasController;
    EditText editText;
    TextView textView;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textNota);

        id = getIntent().getExtras().getInt("id");
        notasController = new NotasController(getApplicationContext());

        textView.setText(notasController.getNota(id));

    }

    public void editNota(View view) {
    //    notasController.editNota(id, editText.getText().toString());
    }
}
