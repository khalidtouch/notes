package com.example.notes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
    private static NotesDatabase INSTANCE;
    public abstract NoteDao getNoteDao();

    public static NotesDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (NotesDatabase.class){
                if(INSTANCE == null){
                    // database creation
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    NotesDatabase.class, "notes")
                                    .fallbackToDestructiveMigration()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
