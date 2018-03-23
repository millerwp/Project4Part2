package com.example.pmill.project4part2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by pmill on 3/23/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pairs.db";
    private static final String TABLE_NAME = "pairs";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_ANTONYM = "antonym";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table pairs (id integer primary key not null, " +
            "word text not null, antonym text not null);";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertWordPair(WordPair pair)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, pair.getWord());
        values.put(COLUMN_ANTONYM, pair.getAntonym());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchTerm(String word)
    {
        db = this.getReadableDatabase();
        String query = "select word, antonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String tempWord, tempAnt;
        tempAnt = "not found";
        if(cursor.moveToFirst())
        {
            do{
                tempWord = cursor.getString(0);
                if(tempWord.equalsIgnoreCase(word))
                {
                    tempAnt = cursor.getString(1);
                }
            } while(cursor.moveToNext());
        }
        return tempAnt;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
