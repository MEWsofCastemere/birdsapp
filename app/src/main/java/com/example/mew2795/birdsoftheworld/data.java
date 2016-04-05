package com.example.mew2795.birdsoftheworld;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class data {

    private int _id;
    private String _birdtype;
    private String _datos;
    private String _los;
    private String _notes;

    public data() {

    }

    public data(int id, String birdtype, String datos, String los, String notes) {
        this._id = id;
        this._birdtype = birdtype;
        this._datos = datos;
        this._los = los;
        this._notes = notes;
    }

    public data(String birdtype, String datos, String los, String notes) {
        this._birdtype = birdtype;
        this._datos = datos;
        this._los = los;
        this._notes = notes;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setbirdtype(String birdtype) {
        this._birdtype = birdtype;
    }

    public String getBIRDTYPE() {
        return this._birdtype;
    }

    public void setdatos(String datos) {
        this._datos = datos;
    }

    public String getDATOS() {
        return this._datos;
    }
    public void setlos(String los) {
        this._los = los;
    }
    public String getLOS() {
        return this._los;
    }

    public void setnotes(String notes) {
        this._notes = notes;
    }

    public String getNOTES() {
        return this._notes;
    }
}
