package com.example.jdaesdeveniments.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jdaesdeveniments.Model.Esdeveniment;
import com.example.jdaesdeveniments.ResultsPostgres;

import java.util.ArrayList;
import java.util.List;

public class LlistatEsdevenimentViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> lista;

    public LlistatEsdevenimentViewModel() {
        lista = new MutableLiveData<>();
    }

    public LiveData<ArrayList<String>> getListEsdeveniment() {
        return lista;
    }

    public void readListEsdevenient() {

        ResultsPostgres resultado = new ResultsPostgres();
        Thread hilo = new Thread(resultado);
        hilo.start();
        final List<Esdeveniment> list_esdeveniment = resultado.getEsdeveniments();

    }
}