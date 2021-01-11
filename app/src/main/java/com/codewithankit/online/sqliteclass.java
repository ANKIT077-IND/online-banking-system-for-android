package com.codewithankit.online;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqliteclass extends SQLiteOpenHelper {
 private static final String dnname="student.db";

    public sqliteclass( Context context) {
        super(context, dnname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String query="create table online(id integer primary key autoincrement, name text, email text, phone text,password text)";
      db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS online");
    onCreate(db);
    }
    public String addRecord( String p1,String p2,String p3,String p4){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("email",p2);
        cv.put("phone",p3);
        cv.put("password",p4);

        long result=db.insert("online",null,cv);

        if (result==-1){
            return "Failed,try Again";
        }
        else {
            return "Data Inserted Successfully !";
        }
    }

    public Boolean updatePassword(String phone,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("password",password);

        long update=db.update("online",cv,"phone=?",new String[]{phone});
       if (update==-1){
           return false;
       }
       else{
           return true;
       }

    }

   public Boolean checkusername(String phone){
       SQLiteDatabase db=this.getWritableDatabase();
       Cursor cursor=db.rawQuery("select * from  online where phone= ?",new String[]{phone});
     if (cursor.getCount() >0){
         return  true;
     }
     else{
         return false;
     }
   }

    public Boolean checkusernamepassword(String phone,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from  online where phone= ? and password=? ",new String[]{phone,password});
        if (cursor.getCount() >0){
            return  true;
        }
        else{
            return false;
        }
    }


}

