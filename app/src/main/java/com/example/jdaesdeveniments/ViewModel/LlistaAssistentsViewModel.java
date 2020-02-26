package com.example.jdaesdeveniments.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.jdaesdeveniments.MainActivity;
import com.example.jdaesdeveniments.Model.Assistent;

import java.util.List;

public class LlistaAssistentsViewModel extends ViewModel {

    public List<Assistent> getLista_assistents() {
        final List<Assistent> lista_assistents = MainActivity.accessDataRoom.getAssistents();

        return lista_assistents;
    }
}
