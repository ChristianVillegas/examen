package com.example.jdaesdeveniments.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jdaesdeveniments.MainActivity;
import com.example.jdaesdeveniments.Model.Esdeveniment;

import java.util.Date;

public class NouEsdevenimentViewModel extends ViewModel {

    public void addEsdeveniment(String nombre, String fecha,
                                String lugar, String mail, String sala,
                                String descripcion, String precio, String aforo) {

        Esdeveniment esdeveniment = new Esdeveniment();
        esdeveniment.setNombre(nombre);
        esdeveniment.setFecha(fecha);
        esdeveniment.setLugar(lugar);
        esdeveniment.setMail(mail);
        esdeveniment.setSala(sala);
        esdeveniment.setDescripcion(descripcion);
        esdeveniment.setPrecio(precio);
        esdeveniment.setAforo(aforo);

        MainActivity.accessDataPostgres.insertInPostgres(nombre, fecha, lugar, mail, sala, descripcion, precio, aforo);

    }
}