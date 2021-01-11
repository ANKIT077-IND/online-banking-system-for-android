package com.codewithankit.online;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class openaccount extends SQLiteOpenHelper {

    private static final String dbname="banking.db";
    public openaccount( Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query="create table online (id integer primary key autoincrement,Name text,Father_name text,Address text,Mobile text,Aadhar text,Date text,Gmail text,Addressproof text,Idproof text,Profession text,Account_type text,Balance text)";
   db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS online");
    onCreate(db);
    }

    public String addRecord(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9, String p10, String p11,String p12)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name",p1);
        cv.put("Father_name",p2);
        cv.put("Address",p3);
        cv.put("Mobile",p4);
        cv.put("Aadhar",p5);
        cv.put("Date",p6);
        cv.put("Gmail",p7);
        cv.put("Addressproof",p8);
        cv.put("Idproof",p9);
        cv.put("Profession",p10);
        cv.put("Account_type",p11);
        cv.put("Balance",p12);

        long result=db.insert("online",null,cv);

     if (result==-1){
         return "Failed,Try Again";
     }
     else{
         return"Data Inserted Successfully";
     }
    }


    public boolean UpdateRecord(String Mobile, String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9, String p10, String p11,String p12)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("Mobile",Mobile);
        cv.put("Name",p1);
        cv.put("Father_name",p2);
        cv.put("Address",p3);
        cv.put("Mobile",p4);
        cv.put("Aadhar",p5);
        cv.put("Date",p6);
        cv.put("Gmail",p7);
        cv.put("Addressproof",p8);
        cv.put("Idproof",p9);
        cv.put("Profession",p10);
        cv.put("Account_type",p11);
        cv.put("Balance",p12);

        long update=db.update("online",cv,"Mobile = ?",new String[] {Mobile});


        if (update==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor balance( String Mobile){

        SQLiteDatabase db=this.getWritableDatabase();

        String balance="select * from "+"online"+" where Mobile="+Mobile;
        Cursor crs=db.rawQuery(balance,null);
        return crs;




    }

   public Integer deleteRecord(String id){
       SQLiteDatabase db=this.getWritableDatabase();
       return db.delete("online","id=?",new String[]{id});

   }

   public Cursor Updatedata(String Mobile){
       SQLiteDatabase db=this.getWritableDatabase();

       String update="select * from "+"online"+" where Mobile="+Mobile;
       Cursor crs=db.rawQuery(update,null);
       return  crs;


   }

    public Cursor withdrawshowdetail(String Mobile){

        SQLiteDatabase db=this.getWritableDatabase();

        String showdetail="select * from "+"online"+" where Mobile="+Mobile;
        Cursor crs=db.rawQuery(showdetail,null);
        return  crs;



    }


    public boolean withdrawAccount(String Mobile,String p12,String p1)
    {
        SQLiteDatabase db=this.getWritableDatabase();

       final ContentValues cv=new ContentValues();

        cv.put("Mobile",Mobile);
        cv.put("Balance",p12);
        long update=db.update("online",cv,"Mobile = ?",new String[] {Mobile});


        if (update==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor Depositshowdetail(String Mobile){
        SQLiteDatabase db=this.getWritableDatabase();

        String showdetail="select * from "+"online"+" where Mobile="+Mobile;
        Cursor crs=db.rawQuery(showdetail,null);
        return  crs;


    }


    public boolean DepositAmount(String Mobile,String p12,String p1)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        final ContentValues cv=new ContentValues();

        cv.put("id",Mobile);
        cv.put("Balance",p12);

        long update=db.update("online",cv,"Mobile = ?",new String[] {Mobile});


        if (update==-1){
            return false;
        }
        else{
            return true;
        }
    }



}
