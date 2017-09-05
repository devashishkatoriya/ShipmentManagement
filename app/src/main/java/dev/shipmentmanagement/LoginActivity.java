package dev.shipmentmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private static final String LOG_TAG = "LoginActivityDebug";
    private EditText e1,e2;
    public boolean hasLoggedIn;
    public String LoggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1 = (EditText) findViewById(R.id.LoginEditText1);
        e2 = (EditText) findViewById(R.id.LoginEditText2);
        Button btn_login = (Button) findViewById(R.id.LoginButton1);

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                checkUser();
            }
        });

        Log.d(LOG_TAG,"onCreate completed");
    }

    public void NewUser(View v)
    {
        Intent i = new Intent("dev.shipmentmanagement.UserEntryActivity");
        startActivity(i);
        Log.d(LOG_TAG,"UserEntryActivity started");
    }

    private void checkUser()
    {
        Log.d(LOG_TAG,"At read");
        String cName = e1.getText().toString();
        String cPass = e2.getText().toString();

        Cursor cursor = myQuery(null,null);
        try
        {
            if (cursor.moveToFirst())                       //Check if cursor is not NULL
            {
                String name,pass;
                boolean flag = false;
                do
                {
                    Log.d(LOG_TAG, "Got id " + cursor.getString(0));

                    name = cursor.getString(3);
                    pass = cursor.getString(4);

                    if(name.equals(cName))
                    {
                        if(pass.equals(cPass))
                        {
                            Toast.makeText(this, "Login Successful!!", Toast.LENGTH_LONG).show();
                            hasLoggedIn = true;
                            LoggedUser = cName;
                            flag = true;
                            break;
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                    else
                    {
                        flag = false;
                    }

                } while (cursor.moveToNext());
                if(!flag)
                    Toast.makeText(this, "Username or Password invalid!", Toast.LENGTH_SHORT).show();
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
        Log.d(LOG_TAG,"read finished");
    }

    private Cursor myQuery(String whereClause,String[] whereArgs)
    {
        Log.d(LOG_TAG,"At myQuery");

        //String[] columns = new String[] { DBSchema.Table.Cols.Person_NAME, DBSchema.Table.Cols.Phone_NO };
        Cursor cursor = MainActivity.myDatabase.query
                (DBSchema.Table.TNAME,      // a. table
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
