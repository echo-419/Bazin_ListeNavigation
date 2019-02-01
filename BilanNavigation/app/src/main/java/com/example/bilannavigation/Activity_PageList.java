package com.example.bilannavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Activity_PageList extends AppCompatActivity {


    private final String EXTRA_Jeu =  "";
    private ImageView img;
    private TextView txt;
    private TextView titre;
    private List<String> Description=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__page_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txt=(TextView)findViewById(R.id.TV_TitrePage);
        TextView titre=(TextView)findViewById(R.id.TV_Description);
        ImageView img=(ImageView) findViewById(R.id.IV_img);

        Intent monIntent = getIntent();
        String strNom = monIntent.getStringExtra(EXTRA_Jeu);

        switch (strNom){
            case "Halo CE":
                titre.setText("Halo CE");
                txt.setText(genererText(strNom));
                img.setBackgroundResource(R.drawable.h1);
                break;
            case "Halo 2":
                titre.setText("Halo 2");
                txt.setText(genererText(strNom));
                img.setBackgroundResource(R.drawable.h2);
                break;
            case "Halo 3":
                titre.setText("Halo 3");
                txt.setText(genererText(strNom));
                img.setBackgroundResource(R.drawable.h3);
                break;
            case "Halo 4":
                titre.setText("Halo 4");
                txt.setText(genererText(strNom));
                //img.setBackgroundResource(R.drawable.h4);
                break;
            case "Halo 5":
                titre.setText("Halo 5");
                txt.setText(genererText(strNom));
                //img.setBackgroundResource(R.drawable.h5);
                break;

        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public List<String> getText(String nom){
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(getAssets().open(nom)));
            String line;

            while ((line=buffer.readLine())!=null){
                Description.add(line);
            }
            buffer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return Description;
    }

    public String genererText(String nom){
        Description=getText(nom);
        String word = Description.toString();
        word=word.substring(1,word.length()-1);
        return word;
    }

}
