package br.ifsc.edu.sqlite_exemplo;

import android.content.Context;

import java.util.ArrayList;

public class NotasController {

    Context mContext;
    NotasDAO notasDAO;
    public NotasController(Context c){
        mContext = c;
        notasDAO = new NotasDAO(mContext);
    }

    public ArrayList<Nota> getNotas(){
        return notasDAO.getNotas();
    }

    public ArrayList<String> getTituloNotas(){
        ArrayList<String> arrayListResult = new ArrayList<String>();

        for (Nota n : notasDAO.getNotas() ){
            arrayListResult.add(n.getTitulo());
        }

        return arrayListResult;
    }

    public void addNota(String titulo, String nota) {
        notasDAO.addNota(titulo, nota);
    }
}