package dev.shipmentmanagement;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase myDatabase;
    private static final String LOG_TAG = "MainActivityDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"onCreate completed");
    }

    @Override
    protected void onStart() {
        super.onStart();

        myDatabase = new MyDBHelper(getApplicationContext())
                .getWritableDatabase();

        Handler h1 = new Handler();
        h1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent("dev.shipmentmanagement.SecondActivity");
                startActivity(i);
                Log.d(LOG_TAG,"Second Activity Launched");
            }
        },2000);
        Log.d(LOG_TAG,"onStart completed");
    }
}
