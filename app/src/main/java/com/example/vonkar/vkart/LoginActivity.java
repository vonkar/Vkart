package com.example.vonkar.vkart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView userName = (TextView) findViewById(R.id.usernameTextView);
        TextView password = (TextView) findViewById(R.id.passwordTextView);

        Button login = (Button) findViewById(R.id.loginButton);

        login.setOnClickListener();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.loginButton:
                    Intent main = new Intent(MainActivity.class);
                    startActivityForResult(main);
                    break;

            }
        }
    }
}
