package dev.shipmentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TrackingActivity extends AppCompatActivity {

    private static final String LOG_TAG = "TrackingActivityDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);


        Log.d(LOG_TAG,"onCreate completed");
    }
}
