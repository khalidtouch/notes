package com.example.notes;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    //member from repo
    private NotesRepo mNotesRepo;
    //list of observed notes
    LiveData<List<Word>> mAllNotes;
    /*
    from this constructor we fetch the
    list of notes from the repo
     */
    public NoteViewModel(Application application){
        super(application);
        mNotesRepo = new NotesRepo(application);
        mAllNotes = mNotesRepo.getAllNotesFromCache();

    }

    /*
    this is getter method that
    return the list of notes to the UI
     */
    public LiveData<List<Word>> getAllNotes(){return mAllNotes;}

    /*
    a wrapper method to insert note into the UI
     */
    public void insertTOUI(Word word){
        mNotesRepo.insertToRepo(word);
    }


}
