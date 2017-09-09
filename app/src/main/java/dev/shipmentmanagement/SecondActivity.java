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

    public void goToAddShipment(View v)
    {
        Intent i = new Intent("dev.shipmentmanagement.AddShipmentActivity");
        startActivity(i);
    }

    public void goToDisplayShipment(View v)
    {
        Intent i = new Intent("dev.shipmentmanagement.ShipmentDisplayActivity");
        startActivity(i);
    }

    public void goToLoginActivity(View v)
    {
        Intent i = new Intent("dev.shipmentmanagement.LoginActivity");
        startActivity(i);
    }
}
