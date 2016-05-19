package cl.mycompany.dexapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.PokemonListAdapter;
import cl.mycompany.dexapplication.database.DatabaseHandler;
import cl.mycompany.dexapplication.model.Pokemon;

public class PokedexActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Pokemon> pokemon = db.getAllPokemon();
        setPokemonList(pokemon);
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

    //Populating the gridview
    private void setPokemonList(ArrayList<Pokemon> pokemon){
        //ListView pokemonList = (ListView) findViewById(R.id.pokemon_list);
        GridView pokemonGrid = (GridView) findViewById(R.id.pokemon_grid);
        Pokemon[] pokemonArray = pokemon.toArray(new Pokemon[151]);
        pokemonGrid.setAdapter(new PokemonListAdapter(this, pokemonArray));

        pokemonGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(PokedexActivity.this,
                        PokemonDetailsActivity.class);
                intent.putExtra("index", String.valueOf(position + 1));
                startActivity(intent);
            }
        });

    }
}
