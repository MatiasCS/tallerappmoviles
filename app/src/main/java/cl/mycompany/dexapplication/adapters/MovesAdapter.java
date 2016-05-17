package cl.mycompany.dexapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.Move;

/**
 * Created by Matias on 5/4/2016.
 */
public class MovesAdapter extends RecyclerView.Adapter<MovesAdapter.MoveHolder>{

    private List<Move> moves;
    public static final String ATTACK = "Att | ";
    public static final String PP = "PP | ";
    public static final String ACCURACY = "Acc | ";

    public static class MoveHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView name;
        public TextView type;
        public TextView levelLearned;
        public TextView attack;
        public TextView pp;
        public TextView accuracy;

        public MoveHolder(View v) {
            super(v);
            type = (TextView) v.findViewById(R.id.tv_move_type);
            name = (TextView) v.findViewById(R.id.tv_move_name);
            levelLearned = (TextView) v.findViewById(R.id.tv_level_learned);
            attack = (TextView) v.findViewById(R.id.tv_move_attack);
            pp = (TextView) v.findViewById(R.id.tv_move_pp);
            accuracy = (TextView) v.findViewById(R.id.tv_move_accuracy);
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
    public void onBindViewHolder(MoveHolder viewHolder, int i) {
        viewHolder.name.setText(moves.get(i).getName());
        viewHolder.type.setText(moves.get(i).getType());
        viewHolder.levelLearned.setText(String.valueOf(moves.get(i).getLevelLearned()));

        String attack = ATTACK + String.valueOf(moves.get(i).getAttack());
        String pp = PP + String.valueOf(moves.get(i).getPP());
        String accuracy = ACCURACY + String.valueOf(moves.get(i).getAccuaracy());;

        viewHolder.attack.setText(attack);
        viewHolder.pp.setText(pp);
        viewHolder.accuracy.setText(accuracy);
    }
}
