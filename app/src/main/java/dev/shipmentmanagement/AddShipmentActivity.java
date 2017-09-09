package dev.shipmentmanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddShipmentActivity extends AppCompatActivity
{

    private static final String LOG_TAG = "AddShipmentDebug";
    private EditText e1,e3,e4,e5;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shipment);

        t2 = (TextView) findViewById(R.id.AddShipmentTextView2);
        e1 = (EditText) findViewById(R.id.AddShipmentEditText1);
        e3 = (EditText) findViewById(R.id.AddShipmentEditText3);
        e4 = (EditText) findViewById(R.id.AddShipmentEditText4);
        e5 = (EditText) findViewById(R.id.AddShipmentEditText5);

        Button btn_submit = (Button) findViewById(R.id.AddShipmentButton1);
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
        long row_id = MainActivity.myDatabase.insert(DBSchema.Table2.TNAME,null,values);              // returns row id of newly inserted row otherwise -1 if error

        if(row_id==-1)
            Toast.makeText(this, "Insertion Error.", Toast.LENGTH_SHORT).show();
        else
        {
            Toast.makeText(this, "Shipment Successfully added!", Toast.LENGTH_SHORT).show();
            e1.setText("");
            e3.setText("");
            e4.setText("");
            e5.setText("");

            Intent i = new Intent("dev.shipmentmanagement.SecondActivity");
            startActivity(i);
        }
        Log.d(LOG_TAG,"insertEntry finished");
    }

    private ContentValues getContentValues()                        //Packs up info and forms a single row
    {
        Log.d(LOG_TAG,"At getContentValues");
        ContentValues values = new ContentValues();
        values.put(DBSchema.Table2.Cols.Shipment_No,e1.getText().toString());
        values.put(DBSchema.Table2.Cols.Date,t2.getText().toString());
        values.put(DBSchema.Table2.Cols.Shipped_By,e3.getText().toString());
        values.put(DBSchema.Table2.Cols.Shipped_To,e4.getText().toString());
        values.put(DBSchema.Table2.Cols.Remarks,e5.getText().toString());
        Log.d(LOG_TAG,"getContentValues finished");
        return values;
    }

    public void showDatePickerDialog(View v)
    {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
