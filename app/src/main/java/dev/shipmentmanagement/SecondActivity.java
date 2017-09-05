package dev.shipmentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToTracking(View v)
    {
        Intent i = new Intent("dev.shipmentmanagement.TrackingActivity");
        startActivity(i);
    }

    public void goToLoginActivity(View v)
    {
        Intent i = new Intent("dev.shipmentmanagement.LoginActivity");
        startActivity(i);
    }
}
