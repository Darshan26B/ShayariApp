package com.darshan.shayariapp;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExternalDB extends SQLiteOpenHelper {
    Context context;

   static final String DB_Name ="shayari";
    String DB_path="";
    public ExternalDB(@Nullable Context context) throws IOException {
        super(context, "Shayari-Name", null, 1);
        this. context =context;
        DB_path = context.getApplicationInfo().dataDir + "/databases/";

        if (!isDataBaseExists()) {
            copyDataBase();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean isDataBaseExists() {
        File dbFile = new File(DB_path + DB_Name);
        return dbFile.exists();
    }
    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(DB_Name);

        String outFileName = DB_path + DB_Name;


        OutputStream myOutput = new FileOutputStream(outFileName);


        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }


        myOutput.flush();
        myOutput.close();
        myInput.close();

    }
    public List<ShayariModel>getShayari(){
        List<ShayariModel> modelList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM myShayari";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();

        for (int i = 0; i<cursor.getCount(); i++) {
            int id = cursor.getInt(0);
            String shayari = cursor.getString(1);
            String cat = cursor.getString(2);
            ShayariModel model = new ShayariModel (id,shayari,cat);
            modelList.add(model);
            cursor.moveToNext();
        }

        return modelList;
    }

}
