package com.example.jdaesdeveniments.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AssistentDao {

    @Query("SELECT * FROM Asistentes")
    List<Assistent> getAssistents();

    @Query("SELECT * FROM Asistentes WHERE nombre LIKE nombre")
    Assistent getAssistent();

    @Insert
    void addAssistent(Assistent assistent);

    @Delete
    void deleteAssistent(Assistent assistent);

    @Update
    void updateAssistent(Assistent assistent);
}
