package com.example.farrago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register_activity extends AppCompatActivity {
    EditText emailText;
    EditText passwordText;
    Button signup;
    Button login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        signup = findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();
        onCheck();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString().trim();
                Log.d("email", email);
                String password = passwordText.getText().toString().trim();
                Log.d("password:", password);
                if(email.isEmpty())
                {
                    emailText.setError("Email is empty");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(getApplicationContext(), Login_activity.class));
                        }
                        else {
                            Toast.makeText(Register_activity.this, "Failed", Toast.LENGTH_SHORT).show();
                            Log.e("Authentication error", task.getException().toString());
                        }
                    }
                });
            }
        });
    }



    public void onCheck() {

        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null) {
            startActivity(new Intent(this, Login_activity.class));
        }

    }


}