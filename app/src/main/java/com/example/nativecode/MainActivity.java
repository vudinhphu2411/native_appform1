package com.example.nativecode;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText metName, metMobile, metEmail, metCountry, metPrice, metNotes, metPropertyName;
    Button mbtSubmit;
    TextInputLayout til_property_type;
    AutoCompleteTextView act_property_type;

    ArrayList<String> arrayList_propertyType;
    ArrayAdapter<String> arrayAdapter_propertyType;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        til_property_type = (TextInputLayout) findViewById(R.id.til_property_type);
        act_property_type = (AutoCompleteTextView) findViewById(R.id.act_property_type);

        arrayList_propertyType = new ArrayList<>();
        arrayList_propertyType.add("Flat");
        arrayList_propertyType.add("House");
        arrayList_propertyType.add("Bungalow");

        arrayAdapter_propertyType = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList_propertyType);
        act_property_type.setAdapter(arrayAdapter_propertyType);

        act_property_type.setThreshold(1);

        metName = findViewById(R.id.et_name);
        metMobile = findViewById(R.id.et_mobile);
        metEmail = findViewById(R.id.et_email);
        metCountry = findViewById(R.id.et_country);
        metPrice = findViewById(R.id.et_price);
        metNotes = findViewById(R.id.et_notes);
        metPropertyName = findViewById(R.id.et_propertyName);
        mbtSubmit = findViewById(R.id.bt_submit);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(MainActivity.this, R.id.et_name, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        awesomeValidation.addValidation(MainActivity.this, R.id.et_mobile, RegexTemplate.NOT_EMPTY, R.string.invalid_mobile);
        awesomeValidation.addValidation(MainActivity.this, R.id.et_email, Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        awesomeValidation.addValidation(MainActivity.this, R.id.et_country, RegexTemplate.NOT_EMPTY, R.string.invalid_country);
        awesomeValidation.addValidation(MainActivity.this, R.id.et_price, RegexTemplate.NOT_EMPTY, R.string.invalid_price);
        awesomeValidation.addValidation(MainActivity.this, R.id.et_propertyName, RegexTemplate.NOT_EMPTY, R.string.invalid_propertyName);


        mbtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("First Activity");

                final EditText metName = findViewById(R.id.et_name);
                final EditText metMobile = findViewById(R.id.et_mobile);
                final EditText metEmail = findViewById(R.id.et_email);
                final EditText metCountry = findViewById(R.id.et_country);
                final EditText metPrice = findViewById(R.id.et_price);
                final EditText metNotes = findViewById(R.id.et_notes);
                final EditText metPropertyName = findViewById(R.id.et_propertyName);

                //Button
                Button btSubmit = findViewById(R.id.bt_submit);
                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(), "Form Validate Successfully..", Toast.LENGTH_SHORT).show();
                    String name = metName.getText().toString();
                    String mobile = metMobile.getText().toString();
                    String email = metEmail.getText().toString();
                    String country = metCountry.getText().toString();
                    String price = metPrice.getText().toString();
                    String notes = metNotes.getText().toString();
                    String propertyName = metPropertyName.getText().toString();

                    showDialog(name, mobile, email, country, price, notes, propertyName);

                    //TODO move cai nay qua ben dialog de chuyen man hinh
//                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                    intent.putExtra("Full Name", name);
//                    intent.putExtra("Mobile", mobile);
//                    intent.putExtra("Email", email);
//                    intent.putExtra("Country", country);
//                    intent.putExtra("Monthly Rent Price", price);
//                    intent.putExtra("Note", notes);
//                    intent.putExtra("Property's Name", propertyName);
//                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Validation Failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showDialog(String name, String mobile, String email, String country, String price, String notes, String propName) {
        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = DialogVerifyDataFragment.newInstance(name, mobile, email, country, price, notes, propName);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }
}