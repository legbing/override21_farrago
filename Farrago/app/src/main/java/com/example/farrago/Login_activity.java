package com.example.farrago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_activity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button login;
    EditText emailText;
    EditText passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        //Log.d("Login page", "page entered");
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        login = findViewById(R.id.login);
        //BottomNavigationView nav_view = findViewById(R.id.navigation);
        BottomAppBar bottomAppBar = findViewById(R.id.navigation);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_back:
                        onStart();
                        return true;


                }
                return false;
            }
        });

        mAuth = FirebaseAuth.getInstance();
        //onCheck();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString().trim();
                Log.d("email_login", email);
                String password = passwordText.getText().toString().trim();
                Log.d("password_login:", password);
                if(email.isEmpty())
                {
                    emailText.setError("Email is empty");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Log.d("Authentication: ", "signInWithEmail:success");
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else
                        {
                            Log.w("Authentication: ", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login_activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
            }
        });
    }




    public void onCheck() {
        //super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null) {
            startActivity(new Intent(this, MainActivity.class));
        }

    }



}