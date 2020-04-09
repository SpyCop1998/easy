package com.gamechanger.easy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="BOOKDB";
    private static final String TABLE_BOOK="BOOK";
    private static final String ATR_NAME="bookName";

    public DatabaseHandler( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS"+TABLE_BOOK+"("+ATR_NAME+"TEXT"+")";
        db.execSQL("create table if not exists BOOK (bookName TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addBook(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ATR_NAME,book.getBook_name());
        db.insert(TABLE_BOOK,null,values);
        db.close();
    }

    public List<Book> getALLBookName()
    {
        List<Book> bookList=new ArrayList<>();
        String selectQuery="select * from BOOK";
//        String selectQuery="SELECT * FROM"+TABLE_BOOK;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do {
                Book book=new Book();
                book.setBook_name(cursor.getString(0));
                bookList.add(book);
            }while (cursor.moveToNext());
        }

        return bookList;
    }

    public void deleteBook(Book book)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("BOOK","bookName = ?",new String[]{String.valueOf(book.getBook_name())});
        db.close();
    }

}
