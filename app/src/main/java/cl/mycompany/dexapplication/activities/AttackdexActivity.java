package cl.mycompany.dexapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.MovesdexAdapter;
import cl.mycompany.dexapplication.adapters.PokemonListAdapter;
import cl.mycompany.dexapplication.database.DatabaseHandler;
import cl.mycompany.dexapplication.model.Move;
import cl.mycompany.dexapplication.model.Pokemon;

public class AttackdexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attackdex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Move> move = db.getAllMoves();
        final Move[] movesArray = move.toArray(new Move[621]);
        setMovesList(movesArray, db);
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
    private void setMovesList(final Move[] moves, DatabaseHandler db){

        //Recycler View params
        RecyclerView recycler;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager lManager;

        recycler = (RecyclerView) findViewById(R.id.rv_moves);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new MovesdexAdapter(moves);
        recycler.setAdapter(adapter);

        //ListView moveList = (ListView) findViewById(R.id.move_list);
        //final Move[] movesArray = moves.toArray(new Move[621]);
        //moveList.setAdapter(new MovesdexAdapter(moves));
        /*
        recycler.setOnClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                intent = new Intent(AttackdexActivity.this,
                        MoveDetailsActivity.class);
                intent.putExtra("index", moves[position].getNumber());
                intent.putExtra("name", moves[position].getName());
                intent.putExtra("type", moves[position].getType());
                intent.putExtra("accuracy", moves[position].getAccuracy());
                intent.putExtra("pp", moves[position].getPP());
                intent.putExtra("power", moves[position].getPower());
                startActivity(intent);
            }
        });*/

    }
}
