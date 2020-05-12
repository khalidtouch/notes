package com.example.notes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Word word);

    @Query("DELETE from notes")
    void deleteAllNotes();

    @Query("SELECT * from notes ORDER BY note ASC")
    LiveData<List<Word>> getAllNotes();
}
