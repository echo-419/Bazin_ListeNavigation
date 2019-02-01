package com.example.bilannavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityForm extends AppCompatActivity {

    private final String EXTRA_User =  "";
    private  EditText  NOM ;
    private  EditText  PRENOM ;
    private  EditText  MAIL ;
    private  EditText  PSEUDO ;
    private Button BT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText NOM= (EditText) findViewById(R.id.ET_Nom);
        final EditText PRENOM= (EditText) findViewById(R.id.ET_Prenom);
        final EditText MAIL= (EditText) findViewById(R.id.ET_Mail);
        final EditText PSEUDO= (EditText) findViewById(R.id.ET_Pseudo);
        Button BT= (Button) findViewById(R.id.BT_Validé);


        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                User user = new User(NOM.getText().toString(), PRENOM.getText().toString(), MAIL.getText().toString(), PSEUDO.getText().toString());
                intent.putExtra(EXTRA_User,user);
                setResult(MainActivity.RESULT_OK,intent);

                Log.v("ActivityResult" ,user.getPseudo());

                finish();

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
