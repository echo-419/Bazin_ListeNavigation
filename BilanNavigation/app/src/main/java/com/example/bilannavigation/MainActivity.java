package com.example.bilannavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button Bt_form;
    private TextView Psd;
    private TextView titre;


    private final String EXTRA_User =  "";
    private final String EXTRA_Jeu =  "";


    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;
    private String[] mesJeu = {"Halo CE","Halo 2", "Halo 3","Halo 4", "Halo 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bt_form=(Button)findViewById(R.id.BT_Log);
        Psd=(TextView) findViewById(R.id.TV_Pseudo);
        titre=(TextView) findViewById(R.id.TV_Titre);
        monRecyclerView = (RecyclerView)findViewById(R.id.RV_Liste);
        monRecyclerView.setHasFixedSize(true);

        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);
        monAdapter = new adapter(mesJeu);
        monRecyclerView.setAdapter(monAdapter);


        monRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent monIntent = new Intent(MainActivity.this, Activity_PageList.class);
                switch (mesJeu[position]){
                    case "Halo CE":
                        monIntent.putExtra(EXTRA_Jeu,"Halo CE");
                        break;
                    case "Halo 2":
                        monIntent.putExtra(EXTRA_Jeu,"Halo 2");
                        break;
                    case "Halo 3":
                        monIntent.putExtra(EXTRA_Jeu,"Halo 3");
                        break;
                    case "Halo 4":
                        monIntent.putExtra(EXTRA_Jeu,"Halo 4");
                        break;
                    case "Halo 5":
                        monIntent.putExtra(EXTRA_Jeu,"Halo 5");
                        break;
                }

                startActivity(monIntent);
            }
        }));



        Bt_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, ActivityForm.class);
                startActivityForResult(data,1);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super. onActivityResult(requestCode, resultCode, data);

        Psd = (TextView) findViewById(R.id.TV_Pseudo);


        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                //Faire le traitement souhaité



                User user= data.getParcelableExtra(EXTRA_User);
                Log.v("ActivityResult" ,user.getPseudo());
                Psd.setText(user.getPseudo());
                monRecyclerView = (RecyclerView)findViewById(R.id.RV_Liste);
                monRecyclerView.setVisibility(View.VISIBLE);
                titre.setVisibility(View.VISIBLE);

                Bt_form.setVisibility(View.INVISIBLE);

            }
        }
    }


}
