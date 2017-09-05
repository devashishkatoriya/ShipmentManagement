package dev.shipmentmanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserEntryActivity extends AppCompatActivity {

    private static final String LOG_TAG = "UserEntryDebug";
    private EditText e1,e2,e3,e4,e5,e6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_entry);

        e1 = (EditText) findViewById(R.id.UserEntryEditText1);
        e2 = (EditText) findViewById(R.id.UserEntryEditText2);
        e3 = (EditText) findViewById(R.id.UserEntryEditText3);
        e4 = (EditText) findViewById(R.id.UserEntryEditText4);
        e5 = (EditText) findViewById(R.id.UserEntryEditText5);
        e6 = (EditText) findViewById(R.id.UserEntryEditText6);

        Button btn_submit = (Button) findViewById(R.id.UserEntryButton1);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEntry();
            }
        });
        Log.d(LOG_TAG,"onCreate completed");
    }

    private void insertEntry()
    {
        Log.d(LOG_TAG,"At insertEntry");
        ContentValues values = getContentValues();
        long row_id = MainActivity.myDatabase.insert(DBSchema.Table.TNAME,null,values);              // returns row id of newly inserted row otherwise -1 if error

        if(row_id==-1)
            Toast.makeText(this, "Insertion Error.", Toast.LENGTH_SHORT).show();
        else
        {
            Toast.makeText(this, "User Successfully added! Please Login.", Toast.LENGTH_SHORT).show();
            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");
            e5.setText("");
            e6.setText("");

            Intent i = new Intent("dev.shipmentmanagement.LoginActivity");
            startActivity(i);
        }
        Log.d(LOG_TAG,"insertEntry finished");
    }

    private ContentValues getContentValues()            //Packs up info and forms a single row
    {
        Log.d(LOG_TAG,"At getContentValues");
        ContentValues values = new ContentValues();
        values.put(DBSchema.Table.Cols.Person_NAME,e1.getText().toString());
        values.put(DBSchema.Table.Cols.Phone_NO,e2.getText().toString());
        values.put(DBSchema.Table.Cols.Address,e3.getText().toString());
        values.put(DBSchema.Table.Cols.Email,e4.getText().toString());
        values.put(DBSchema.Table.Cols.Username,e5.getText().toString());
        values.put(DBSchema.Table.Cols.Password,e6.getText().toString());
        Log.d(LOG_TAG,"getContentValues finished");
        return values;
    }
}
