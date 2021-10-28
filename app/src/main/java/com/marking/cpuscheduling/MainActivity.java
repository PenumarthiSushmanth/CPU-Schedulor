package com.marking.cpuscheduling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPage1(View v)
    {
        Intent ob = new Intent(this, forpriority.class);
        startActivity(ob);
    }

    public void openPage2(View v)
    {
        Intent ob1 = new Intent(this, forljf.class);
        startActivity(ob1);
    }

}

