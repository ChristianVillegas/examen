package com.example.jdaesdeveniments;

import androidx.room.RoomDatabase;

import com.example.jdaesdeveniments.Model.Assistent;
import com.example.jdaesdeveniments.Model.AssistentDao;

@androidx.room.Database(version = 1, entities = {Assistent.class})
public abstract class DataBase extends RoomDatabase {

    abstract public AssistentDao getAssistentDao();
}
