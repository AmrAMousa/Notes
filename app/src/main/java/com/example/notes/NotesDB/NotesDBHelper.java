package com.example.notes.NotesDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.notes.NotesDB.NotesContract.NotesEntry;


public class NotesDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NotesList.db";
    public static final int DATABASE_VERSION = 1;

    public NotesDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " +
                NotesEntry.TABLE_NAME + " (" +
                NotesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NotesEntry.COLUMN_NOTES + " TEXT NOT NULL, " +
                NotesEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_NOTES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NotesEntry.TABLE_NAME);
        onCreate(db);
    }
}
