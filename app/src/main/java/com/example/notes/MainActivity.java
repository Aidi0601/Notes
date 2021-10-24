package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    public void onClick(View view) {
        EditText usernameTextField = (EditText) findViewById(R.id.Name);
        String str = usernameTextField.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();
        goToActivity(str);
    }

    public void goToActivity(String s) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String curname = sharedPreferences.getString(usernameKey, "");
            goToActivity(curname);
        } else {
            setContentView(R.layout.activity_main);
        }

    }

}