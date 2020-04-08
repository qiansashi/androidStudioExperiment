package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginSql extends SQLiteOpenHelper {

    private static final String DB_NAME="login_data";
    private static final String TABLE_NAME="users";
    private static final String USER_NAME="user_name";
    private static final String USER_PWD="user_pwd";
    private SQLiteDatabase db=null;
    private static final String DB_CREATE ="CREATE TABLE "+TABLE_NAME+" ("+USER_NAME+" VARCHAR,"+USER_PWD+" VARCHAR"+")"+";";
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public LoginSql(Context context){
        super(context,DB_NAME,null,1);
        db=getWritableDatabase();
    }

    public void createDataTable(){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        db.execSQL(DB_CREATE);
    }

    public void insertData(String s){
        db.execSQL(s);
    }


    public int signInCheck(String username){
        int flag=0;
        Cursor mCursor=db.query(TABLE_NAME,null,"user_name=?",new String[]{username},null,null,null);
        if (mCursor==null){
            return 0;
        }else{
            flag=mCursor.getCount();
            mCursor.close();
        }
        return flag;
//        db.rawQuery("select * from users where username like ? and password=?",new String[]{"%"+un+"%",pwd});
    }

    public int loginInCheck(String username,String userpwd){
        int flag=0;
        Cursor mCursor=db.query(TABLE_NAME,null,"user_name=? and user_pwd=?",new String[]{username,userpwd},null,null,null);
        if (mCursor==null){
            return 0;
        }else{
            flag=mCursor.getCount();
            mCursor.close();
        }
        return flag;
    }
    public void alertPwd(String username,String userpwd){
        db.execSQL("UPDATE "+TABLE_NAME+" SET user_pwd = '"+userpwd+"'"+" WHERE "+"user_name = '"+username+"'"+";");
    }
}
