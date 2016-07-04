package cl.mycompany.dexapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.activities.AttackdexActivity;
import cl.mycompany.dexapplication.activities.MoveDetailsActivity;
import cl.mycompany.dexapplication.model.Move;
import cl.mycompany.dexapplication.model.Pokemon;
import cl.mycompany.dexapplication.utils.uiFormat;

/**
 * Created by Matias on 7/3/2016.
 */
public class MovesdexAdapter extends RecyclerView.Adapter<MovesdexAdapter.MoveHolder> {

    private final Move[] moves;
    public static final String ATTACK = "Att | ";
    public static final String PP = "PP | ";
    public static final String ACCURACY = "Acc | ";

    public static class MoveHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView name;
        public TextView type;
        public TextView attack;
        public TextView pp;
        public TextView accuracy;
        public RelativeLayout backgroundColor;
        public View view;

        public MoveHolder(View v) {
            super(v);
            type = (TextView) v.findViewById(R.id.tv_move_type);
            name = (TextView) v.findViewById(R.id.tv_move_name);
            attack = (TextView) v.findViewById(R.id.tv_move_attack);
            pp = (TextView) v.findViewById(R.id.tv_move_pp);
            accuracy = (TextView) v.findViewById(R.id.tv_move_accuracy);
            backgroundColor = (RelativeLayout) v.findViewById(R.id.relative_move_type);
            view = v;
        }

    }
    public MovesdexAdapter(Move[] moves) {
        this.moves = moves;
    }

    @Override
    public int getItemCount() {
        return moves.length;
    }

    @Override
    public MoveHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movedex_list, viewGroup, false);
        return new MoveHolder(v);
    }

    @Override
    public void onBindViewHolder(MoveHolder viewHolder, final int i) {
        Move move = moves[i];
        String attack =  String.valueOf(move.getPower());
        String pp = String.valueOf(move.getPP());
        String accuracy = String.valueOf(move.getAccuracy());

        if(accuracy.equals("0"))
            accuracy = "-";
        if(attack.equals("0"))
            attack = "-";

        viewHolder.name.setText(moves[i].getName().toUpperCase());
        viewHolder.type.setText(moves[i].getType().toUpperCase());


        String attackText = ATTACK + attack;
        String ppText = PP + pp;
        String accuracyText = ACCURACY + accuracy;

        viewHolder.attack.setText(attackText);
        viewHolder.pp.setText(ppText);
        viewHolder.accuracy.setText(accuracyText);
        int typeColor = viewHolder.view.getResources().getIdentifier(moves[i].getType().toLowerCase(), "color", "cl.mycompany.dexapplication");
        viewHolder.backgroundColor.setBackgroundResource(typeColor);

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(),
                        MoveDetailsActivity.class);
                intent.putExtra("index", moves[i].getNumber());
                intent.putExtra("name", moves[i].getName().toUpperCase());
                intent.putExtra("type", moves[i].getType());
                intent.putExtra("accuracy", moves[i].getAccuracy());
                intent.putExtra("pp", moves[i].getPP());
                intent.putExtra("power", moves[i].getPower());
                v.getContext().startActivity(intent);
            }
        });
    }
}

