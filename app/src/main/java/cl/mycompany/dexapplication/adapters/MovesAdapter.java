package cl.mycompany.dexapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.activities.MoveDetailsActivity;
import cl.mycompany.dexapplication.fragments.MoveDescription;
import cl.mycompany.dexapplication.model.moveModel.Move;

/**
 * Created by Matias on 5/4/2016.
 */
public class MovesAdapter extends RecyclerView.Adapter<MovesAdapter.MoveHolder>{

    private List<Move> moves;
    public static final String ATTACK = "Att | ";
    public static final String PP = "PP | ";
    public static final String ACCURACY = "Acc | ";

    public static class MoveHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Campos respectivos de un item
        public TextView name;
        public TextView type;
        public TextView levelLearned;
        public TextView attack;
        public TextView pp;
        public TextView accuracy;
        public RelativeLayout backgroundColor;
        public View view;
        private AdapterView.OnItemClickListener listener;

        public MoveHolder(View v) {
            super(v);
            type = (TextView) v.findViewById(R.id.tv_move_type);
            name = (TextView) v.findViewById(R.id.tv_move_name);
            levelLearned = (TextView) v.findViewById(R.id.tv_level_learned);
            attack = (TextView) v.findViewById(R.id.tv_move_attack);
            pp = (TextView) v.findViewById(R.id.tv_move_pp);
            accuracy = (TextView) v.findViewById(R.id.tv_move_accuracy);
            backgroundColor = (RelativeLayout) v.findViewById(R.id.relative_move_type);
            view = v;
            view.setOnClickListener(new View.OnClickListener() {
                //TODO: Implementar override
                @Override
                public void onClick(View v) {
                    Log.d("Apretado", "Cardview");
                }
            });

        }

        @Override
        public void onClick(View v) {
        }
    }
    public MovesAdapter(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public int getItemCount() {
        return moves.size();
    }

    @Override
    public MoveHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.move_list, viewGroup, false);
        return new MoveHolder(v);
    }

    @Override
    public void onBindViewHolder(MoveHolder viewHolder, final int i) {
        Move move = moves.get(i);
        String attack =  String.valueOf(move.getPower());
        String pp = String.valueOf(move.getPp());
        String accuracy = String.valueOf(move.getAccuracy());

        if(accuracy.equals("null"))
            accuracy = "-";
        if(attack.equals("null"))
            attack = "-";

        viewHolder.name.setText(moves.get(i).getName().toUpperCase());
        viewHolder.type.setText(moves.get(i).getType().getName().toUpperCase().replace("-", " "));

        viewHolder.levelLearned.setText(String.valueOf(move.getLevelLearned()));

        String attackText = ATTACK + attack;
        String ppText = PP + pp;
        String accuracyText = ACCURACY + accuracy;

        viewHolder.attack.setText(attackText);
        viewHolder.pp.setText(ppText);
        viewHolder.accuracy.setText(accuracyText);
        int typeColor = viewHolder.view.getResources().getIdentifier(moves.get(i).getType().getName(), "color", "cl.mycompany.dexapplication");
        viewHolder.backgroundColor.setBackgroundResource(typeColor);

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(),
                        MoveDetailsActivity.class);
                intent.putExtra("index", moves.get(i).getId());
                intent.putExtra("name", moves.get(i).getName().toUpperCase().replace("-", " "));
                intent.putExtra("type", moves.get(i).getType().getName());
                intent.putExtra("accuracy", moves.get(i).getAccuracy());
                intent.putExtra("pp", moves.get(i).getPp());
                intent.putExtra("power", moves.get(i).getPower());
                v.getContext().startActivity(intent);
            }
        });
    }
}
