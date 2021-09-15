package com.example.nativecode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");

        //intent to get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("Full Name"); // Nó phải giống cái name ở đây
        String email = intent.getStringExtra("Email");
        String mobile = intent.getStringExtra("Mobile");
        String country = intent.getStringExtra("Country");
        String price = intent.getStringExtra("Monthly Rent Price");
        String notes = intent.getStringExtra("Note");
        String propertyName = intent.getStringExtra("Property's Name");
        //TextView
        TextView mResultTv = findViewById(R.id.resultTv);

        //setText
        mResultTv.setText("Full Name: "+name+"\nEmail: "+email+ "\nMobile: "+mobile+"\nCountry: "+country+ "\nMonthly Rent Price: "+price+"\nNote: "+notes+ "\nProperty's Name: "+propertyName);

    }
}
