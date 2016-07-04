package cl.mycompany.dexapplication.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.activities.AbilityDetailsActivity;
import cl.mycompany.dexapplication.model.Ability;

/**
 * Created by Matias on 7/4/2016.
 */
public class AbilitydexAdapter extends RecyclerView.Adapter<AbilitydexAdapter.MoveHolder> {

    private final Ability[] abilities;

    public static class MoveHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView name;
        public TextView description;
        public View view;

        public MoveHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.tv_ability_name);
            description = (TextView) v.findViewById(R.id.tv_ability_description);
            view = v;
        }

    }
    public AbilitydexAdapter(Ability[] abilities) {
        this.abilities = abilities;
    }

    @Override
    public int getItemCount() {
        return abilities.length;
    }

    @Override
    public MoveHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.abilitydex_list, viewGroup, false);
        return new MoveHolder(v);
    }

    @Override
    public void onBindViewHolder(MoveHolder viewHolder, final int i) {
        viewHolder.name.setText(abilities[i].getName().toUpperCase());
        viewHolder.description.setText(abilities[i].getDescription());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(),
                        AbilityDetailsActivity.class);
                intent.putExtra("index", abilities[i].getIndex());
                intent.putExtra("name", abilities[i].getName().toUpperCase());
                intent.putExtra("description", abilities[i].getDescription());
                v.getContext().startActivity(intent);
            }
        });
    }
}

