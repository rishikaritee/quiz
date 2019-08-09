package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mydb extends SQLiteOpenHelper {

    public Mydb(Context context) {
        super(context, "quiz17", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String t1="Create table data1(id integer PRIMARY KEY AUTOINCREMENT,name text,password text)";

        String t2="Create table cqnew(id integer primary key autoincrement,q text,op1 text,op2 text,op3 text,op4 text,ans text)";

        String t4="Create table newdsa(id integer primary key autoincrement,q text,op1 text,op2 text,op3 text,op4 text,ans text)";
        String t5="Create table newdbms(id integer primary key autoincrement,q text,op1 text,op2 text,op3 text,op4 text,ans text)";
        String t6="Create table newjava(id integer primary key autoincrement,q text,op1 text,op2 text,op3 text,op4 text,ans text)";
        String t7="Create table newandroid(id integer primary key autoincrement,q text,op1 text,op2 text,op3 text,op4 text,ans text)";
        db.execSQL(t7);
        db.execSQL(t6);
        db.execSQL(t5);
        db.execSQL(t4);
        db.execSQL(t2);
        db.execSQL(t1);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS newdsa");

        db.execSQL("DROP TABLE IF EXISTS cqnew");
        db.execSQL("DROP TABLE IF EXISTS newdbms");
        db.execSQL("DROP TABLE IF EXISTS newjava");
    }
    public void add_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("cqnew",null,cv);
        d.close();

    }
   /* public Cursor cc(String n){
        SQLiteDatabase db=this.getWritableDatabase();

        String lg1="select* from cq where ans='"+n+"'";

        Cursor c=db.rawQuery(lg1,null);

        return c;
    }*/
    public  void add(String s1,String s3){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",s1);

        cv.put("password",s3);

        db.insert("data1",null,cv );
        db.close();
    }



    public Cursor login(String us1,String p){
        SQLiteDatabase db=this.getWritableDatabase();

        String lg="select* from data1 where name='"+us1+"'and password='"+p+"'";

        Cursor c=db.rawQuery(lg,null);

        return c;
    }
    public Cursor get_quiz(int idd) {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus = "select* from cqnew where id=" + idd + "";

        Cursor c = d.rawQuery(qus, null);


        return c;
    }
    public void adddsa_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("newdsa",null,cv);
        d.close();

    }
    public Cursor dsa_quiz(int idd) {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus1 = "select* from newdsa where id=" + idd + "";

        Cursor c = d.rawQuery(qus1, null);


        return c;
    }
    public void adddbms_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("newdbms",null,cv);
        d.close();

    }
    public Cursor dbms_quiz(int idd) {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus1 = "select* from newdbms where id=" + idd + "";

        Cursor c = d.rawQuery(qus1, null);


        return c;
    }
    public void addjava_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("newjava",null,cv);
        d.close();

    }
    public Cursor java_quiz(int idd) {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus1 = "select* from newjava where id=" + idd + "";

        Cursor c = d.rawQuery(qus1, null);


        return c;
    }
    public void addandroid_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("q",qs);
        cv.put("op1",p1);
        cv.put("op2",p2);
        cv.put("op3",p3);
        cv.put("op4",p4);
        cv.put("ans",anss);
        d.insert("newandroid",null,cv);
        d.close();

    }
    public Cursor android_quiz(int idd) {
        SQLiteDatabase d = this.getWritableDatabase();
        String qus1 = "select* from newandroid where id=" + idd + "";

        Cursor c = d.rawQuery(qus1, null);


        return c;
    }
    }
