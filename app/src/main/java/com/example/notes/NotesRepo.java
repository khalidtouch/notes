package com.example.notes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepo {
    /*
    members for the Dao and the list of notes
     */
    private NoteDao mNoteDao;
    private LiveData<List<Word>> mAllNotes;

    /**
     * Instantiating this class automatically fetches the entire
     * list of the notes via the dao
     * the list of notes is then cached
     * @param application
     */
    public NotesRepo(Application application){
        // here we use this repo to get the database and engage the DAO
        NotesDatabase db = NotesDatabase.getDatabase(application);
        mNoteDao = db.getNoteDao();
        mAllNotes = mNoteDao.getAllNotes();
    }

    /**
     * this is a wrapper method that gets the stored list of notes
     * right from the cache memory
     * @return
     */
    LiveData<List<Word>> getAllNotesFromCache(){
        return mAllNotes;
    }

    public void insertToRepo(Word word){
        //
    }

    /**
     * An inner class to handle inserting into the cache memory (or repo)
     * We call InsertAsyncTask
     */
    private static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private NoteDao mNoteDaoAsync;

        public InsertAsyncTask(NoteDao noteDao){
            this.mNoteDaoAsync = noteDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mNoteDaoAsync.insertNote(words[0]);
            return null;
        }
    }
}
