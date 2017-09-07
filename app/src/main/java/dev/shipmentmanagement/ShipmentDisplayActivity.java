package dev.shipmentmanagement;

import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Vector;

public class ShipmentDisplayActivity extends AppCompatActivity {

    private ListView l1;
    private static final String LOG_TAG = "ShipmentDisplayDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_display);

        l1 = (ListView) findViewById(R.id.listView);

        Log.d(LOG_TAG,"onCreate completed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Handler h1 = new Handler();
        h1.postDelayed(new Runnable() {
            @Override
            public void run() {
                setData();
            }
        },1000);
        Log.d(LOG_TAG,"onStart completed");
    }

    private void setData()
    {
        Log.d(LOG_TAG,"At setData");
        Cursor cursor = myQuery(DBSchema.Table2.TNAME,null,null);
        try
        {
            if (cursor.moveToFirst())                                //Check if cursor is not NULL
            {
                Vector<String> StringArray = new Vector<String>();
                do
                {
                    Log.d(LOG_TAG, "Got id " + cursor.getString(0));


                    //Todo: read the appropriate columns
                    StringArray.addElement("" + cursor.getString(1));
                    StringArray.addElement("" + cursor.getString(2));

                } while (cursor.moveToNext());
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_list_view, StringArray);
                l1.setAdapter(arrayAdapter);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d(LOG_TAG, "Exception encountered. " + e);
        }
        finally
        {
            cursor.close();
        }
        Log.d(LOG_TAG,"setData finished");
    }


    private Cursor myQuery(String table_name, String whereClause,String[] whereArgs)
    {
        Log.d(LOG_TAG,"At myQuery");

        //String[] columns = new String[] { DBSchema.Table.Cols.Person_NAME, DBSchema.Table.Cols.Phone_NO };
        Cursor cursor = MainActivity.myDatabase.query
                (table_name,                // a. table
                        null,               // b. column names
                        whereClause,        // c. selections
                        whereArgs,          // d. selections args
                        null,               // e. group by
                        null,               // f. having
                        null,               // g. order by
                        null);

        Log.d(LOG_TAG,"myQuery finished");
        return cursor;
    }
}
