package br.ifsc.edu.sqlite_exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bd;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = openOrCreateDatabase("meubd",MODE_PRIVATE,null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS notas (" +
                "id integer primary key autoincrement," +
                "titulo varchar not null," +
                "texto varchar not null  )");

        //bd.execSQL("INSERT INTO notas (titulo, texto) VALUES ('bah guri','Firebase é melhor') ");

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", "bah pia");
        contentValues.put("texto", "Firestore é melhor");

        bd.insert("notas", null, contentValues);

        Cursor cursor= bd.rawQuery("SELECT * FROM notas",null,null);
        cursor.moveToFirst();

        String id;
        String titulo;
        String texto;
        final ArrayList<String> arrayList = new ArrayList<>();

        while(!cursor.isAfterLast()){

             id = cursor.getString(cursor.getColumnIndex("id"));
             titulo= cursor.getString(cursor.getColumnIndex("titulo"));
             texto = cursor.getString(cursor.getColumnIndex("texto"));

            //Log.d("Tabela notas", id +" "+ titulo +" "+ texto);
            arrayList.add(id+" "+titulo + " "+ texto);
            cursor.moveToNext();
        }

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayList
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                
            }
        });
    }
}