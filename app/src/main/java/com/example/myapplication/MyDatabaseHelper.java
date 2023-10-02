package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASENAME = "Phonebook.db";
    private static final int DATABASEVERSION = 1;
    private static final String TABLENAME = "myLibrary";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "person_name";
    private static final String COLUMN_NUMBER = "person_phone_number";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLENAME +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_NUMBER + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(db);

    }

    void AddPerson(String name, String number){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_NUMBER, number);

        long result = db.insert(TABLENAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "my bad", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "meow", Toast.LENGTH_SHORT).show();
        }
    }
}
