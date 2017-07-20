package com.mhonore.finalapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void goToRegister( View view){

        //Create an Intent in order to launch the Register Activity
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

        startActivity(intent);
    }

    public void goToManage(View view){

        //Create an Intent in order to launch the Manage Activity
        Intent intent = new Intent(getApplicationContext(), ManageActivity.class);

        startActivity(intent);
    }

    public void tryLogin(View view){

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.mhonore.sharedpreferences", Context.MODE_PRIVATE);

        EditText emailEditText = (EditText) findViewById(R.id.emailText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordText);

        String email = emailEditText.getText().toString();
        String passworddEntered = passwordEditText.getText().toString();

        String passwordStored = sharedPreferences.getString(email,"");

        Log.i("Info", "email is: " + email);
        Log.i("Info", "Password entered is: " + passworddEntered);
        Log.i("Info", "Password stored is: " + passwordStored);


        if (passwordStored.equals(passworddEntered)){
            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            goToManage(view);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.mhonore.sharedpreferences", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("test@test.com", "password").apply();
    }
}
