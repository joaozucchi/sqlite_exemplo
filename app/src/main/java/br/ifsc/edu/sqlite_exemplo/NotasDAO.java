package br.ifsc.edu.sqlite_exemplo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class NotasDAO {

    SQLiteDatabase bd;

    public NotasDAO(Context c) {
        bd = c.openOrCreateDatabase("meubd",c.MODE_PRIVATE,null);

        bd.execSQL("CREATE TABLE IF NOT EXISTS notas (" +
                "id integer primary key autoincrement," +
                "titulo varchar not null," +
                "texto varchar not null  )");
    }

    public ArrayList<Nota> getNotas(){
        ArrayList<Nota> arrayListResult = new ArrayList<Nota>();

        Cursor cursor= bd.rawQuery("SELECT * FROM notas",null,null);
        cursor.moveToFirst();

        int id;
        String titulo;
        String texto;

        while(!cursor.isAfterLast()){

            id = cursor.getInt(cursor.getColumnIndex("id"));
            titulo= cursor.getString(cursor.getColumnIndex("titulo"));
            texto = cursor.getString(cursor.getColumnIndex("texto"));

            arrayListResult.add(new Nota(id, titulo, texto));
            cursor.moveToNext();
        }

        return arrayListResult;
    }
}
