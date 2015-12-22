package com.time.time;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afolabi on 12/21/2015.
 */
public class DBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "timeTable";
    private static final String TABLE_PROFILE = "profiles";

    //PROFILE TABLE COLUMNS
    private static final String PF_ID = "id";
    private static final String PF_NAME = "name";
    private static final String PF_DESCRIPTION = "description";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_profile_table = "CREATE TABLE " + TABLE_PROFILE + " ( " + PF_ID + " INTEGER PRIMARY KEY, " + PF_NAME + " TEXT, " + PF_DESCRIPTION + " TEXT " + ")";
        db.execSQL(create_profile_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);

        // Create tables again
        onCreate(db);
    }

    //implement methods to manipulate tables
    //PROFILE TABLE
    public void addProfile(Profiles pf) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PF_NAME, pf.getProfileName());
        values.put(PF_DESCRIPTION, pf.getProfileDescription());

        //inserting row
        db.insert(TABLE_PROFILE, null, values);
        db.close();
    }

    public List<Profiles> getAllProfile() {
        List<Profiles> profileList = new ArrayList<Profiles>();

        String allQuery = "SELECT * FROM " + TABLE_PROFILE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(allQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Profiles pf = new Profiles();
                pf.setProfileId(Integer.parseInt(cursor.getString(0)));
                pf.setProfileName(cursor.getString(1));
                pf.setProfileDescription(cursor.getString(2));
                pf.setProfileColor("color_test");

                profileList.add(pf);

            } while (cursor.moveToNext());
        }
        return profileList;
    }


}
