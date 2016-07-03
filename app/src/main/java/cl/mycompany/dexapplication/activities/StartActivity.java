package cl.mycompany.dexapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.database.DatabaseHandler;

public class StartActivity extends AppCompatActivity {

    public static final int POKEDEX_OPTION = 0;
    public static final int ATTACKDEX_OPTION = 1;
    public static final int ITEMDEX_OPTION = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        setHomeOptionsList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    private void setHomeOptionsList(){
        ListView homeOptionsList = (ListView) findViewById(R.id.homeOptions);
        String[] homeOptions = new String[]{"Pokedex","Attackdex","Abilitydex"};
        ArrayAdapter<String> homeAdapter = new ArrayAdapter<String>(this,
                R.layout.center_text_list,
                android.R.id.text1,
                homeOptions);
        homeOptionsList.setAdapter(homeAdapter);

        homeOptionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case POKEDEX_OPTION:
                        intent = new Intent(StartActivity.this,
                                PokedexActivity.class);
                        startActivity(intent);
                        break;

                    case ATTACKDEX_OPTION:
                        intent = new Intent(StartActivity.this,
                                AttackdexActivity.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        });
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
}
