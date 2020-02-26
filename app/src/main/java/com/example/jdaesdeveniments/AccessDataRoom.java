package com.example.jdaesdeveniments;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.example.jdaesdeveniments.Model.Assistent;
import com.example.jdaesdeveniments.Model.AssistentDao;

import java.util.List;

public class AccessDataRoom {

    @SuppressLint("StaticFieldLeak")
    private static AccessDataRoom accessDataRoom;

    private AssistentDao assistentDao;

    private AccessDataRoom (Context ctx){
        Context appContext = ctx.getApplicationContext();
        DataBase database = Room.databaseBuilder(appContext, DataBase.class, "Asistentes")
                .allowMainThreadQueries().build();
        assistentDao = database.getAssistentDao();
    }

    public static AccessDataRoom getAccessDataRoom(Context ctx){
        if(accessDataRoom == null) accessDataRoom = new AccessDataRoom(ctx);
        return accessDataRoom;
    }

    /**
     * Method for save assistents into SQLite
     *
     * @param assistent Object Piloto
     */
    public void saveAssistent(Assistent assistent){
        assistentDao.addAssistent(assistent);
    }

    /**
     * Method get all assistents on file assistents
     *
     * @return List<Assistent>
     */
    public List<Assistent> getAssistents(){
        return assistentDao.getAssistents();
    }

    /**
     * Method for delete assistents into SQLite
     *
     * @param assistent Object Assistent
     */
    public void deleteAssistent(Assistent assistent){
        assistentDao.deleteAssistent(assistent);
    }
}
