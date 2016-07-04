package cl.mycompany.dexapplication.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.AbilitydexAdapter;
import cl.mycompany.dexapplication.database.DatabaseHandler;
import cl.mycompany.dexapplication.model.Ability;
import cl.mycompany.dexapplication.model.Move;

public class AbilitydexActivity extends AppCompatActivity {
//TODO: implementar llenado del recycler view y intent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abilitydex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Ability> ability= db.getAllAbilities();
        final Ability[] abilitiesArray = ability.toArray(new Ability[191]);
        setAbilityList(abilitiesArray, db);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    //Populating the recyclerview
    private void setAbilityList(final Ability[] abilities, DatabaseHandler db){

        //Recycler View params
        RecyclerView recycler;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager lManager;

        recycler = (RecyclerView) findViewById(R.id.rv_abilities);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new AbilitydexAdapter(abilities);
        recycler.setAdapter(adapter);

    }

}
