package com.example.notes.NotesDB;

import android.provider.BaseColumns;

public class NotesContract {

    private NotesContract(){};

    public static final class NotesEntry implements BaseColumns {
        public static final String TABLE_NAME="notesList";
        public static final String COLUMN_NOTES="notes";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
