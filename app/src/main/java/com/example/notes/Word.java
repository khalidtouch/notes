package com.example.notes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "note")
    private String textString;

    public Word(@NonNull String textString){
        this.textString = textString;
    }

    public String getText(){return textString;}
}
