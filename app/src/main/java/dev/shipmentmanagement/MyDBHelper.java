package dev.shipmentmanagement;

/*
 * Created by Devashish Katoriya on 05-09-2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import dev.shipmentmanagement.DBSchema.Table;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase.db";
    private static final String LOG_TAG = "MyDBHelperDebug";

    public MyDBHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG_TAG,"At onCreate");

        sqLiteDatabase.execSQL("create table " + Table.TNAME + " ( " +
                " _id integer primary key autoincrement, " +
                Table.Cols.Person_NAME + ", " +
                Table.Cols.Phone_NO + ", " +
                Table.Cols.Username + ", " +
                Table.Cols.Password + ", " +
                Table.Cols.Address + ", " +
                Table.Cols.Email +
                " ) "
        );

        Log.d(LOG_TAG,"onCreate finished");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
