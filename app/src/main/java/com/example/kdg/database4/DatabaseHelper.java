package com.example.kdg.database4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KDG on 06/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Inventoriocompras.db";
    public static final String TABLE1_NAME = "List_Crear";
    public static final String T1_COL_1 = "Producto_ID";
    public static final String T1_COL_2 = "Nombre";
    public static final String T1_COL_3 = "Marca";
    public static final String T1_COL_4 = "Unidad";
   // public static final String T1_COL_5 = "Foto";
    public static final String T1_COL_5 = "Alerta_Min_Stock_SP";
    public static final String T1_COL_6 = "Alerta_Max_Stock_SP";
    public static final String T1_COL_7 = "Alerta_Low_Consump_Quantity_SP";
    public static final String T1_COL_8 = "Alerta_Low_Consump_Time_Dias_SP";
    public static final String T1_COL_9 = "Alerta_Inactivity_Time_Dias_SP";
    public static final String T1_COL_10 = "Alerta_Expiration_Dias_Before_SP";
    public static final String T1_COL_12 = "Monitor_Alertas";

    public static final String TABLE2_NAME = "Inventorio";
    public static final String T2_COL_1 = "CODIGO";
    public static final String T2_COL_2 = "NOMBRE";
    public static final String T2_COL_3 = "CANTIDAD";
    public static final String T2_COL_4 = "UNIDAD";
    public static final String T2_COL_5 = "MARCA";
    public static final String T2_COL_6 = "QUANTITY";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE1_NAME + " (Producto_ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Marca TEXT, Unidad TEXT, Alerta_Min_Stock_SP INTEGER, Alerta_Max_Stock_SP INTEGER, Alerta_Low_Consump_Quantity_SP INTEGER, Alerta_Low_Consump_Time_Dias_SP INTEGER, Alerta_Inactivity_Time_Dias_SP INTEGER, Alerta_Expiration_Dias_Before_SP INTEGER, Monitor_Alertas BOOLEAN)");
        db.execSQL("create table " + TABLE2_NAME + " (Inventorio_ID INTEGER PRIMARY KEY AUTOINCREMENT, Producto_ID INTEGER  REFERENCES \"List_Crear\" (\"Producto_ID\"), Producto_Actual INTEGER, EXP_Ano INTEGER, EXP_Mes INTEGER, EXP_Dia INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE2_NAME);
        onCreate(db);
    }

    public boolean insertData(String Nombre, String Marca, String Unidad, Integer Alerta_Min_Stock_SP, Integer Alerta_Max_Stock_SP, Integer Alerta_Low_Consump_Quantity_SP, Integer Alerta_Low_Consump_Time_Dias_SP, Integer Alerta_Inactivity_Time_Dias_SP, Integer Alerta_Expiration_Dias_Before_SP) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL_2,Nombre);
        contentValues.put(T1_COL_3,Marca);
        contentValues.put(T1_COL_4,Unidad);
        // contentValues.put(T1_COL_5,Foto);
        contentValues.put(T1_COL_5,Alerta_Min_Stock_SP);
        contentValues.put(T1_COL_6,Alerta_Max_Stock_SP);
        contentValues.put(T1_COL_7,Alerta_Low_Consump_Quantity_SP);
        contentValues.put(T1_COL_8,Alerta_Low_Consump_Time_Dias_SP);
        contentValues.put(T1_COL_9,Alerta_Inactivity_Time_Dias_SP);
        contentValues.put(T1_COL_10,Alerta_Expiration_Dias_Before_SP);
        //contentValues.put(T1_COL_12,Monitor_Alertas);
        long result = db.insert(TABLE1_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


}


