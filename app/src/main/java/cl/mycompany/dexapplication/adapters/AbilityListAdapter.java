package cl.mycompany.dexapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.abilityModel.Ability;
import cl.mycompany.dexapplication.model.abilityModel.EffectEntry;
import cl.mycompany.dexapplication.model.abilityModel.FlavorTextEntry;
import cl.mycompany.dexapplication.utils.uiFormat;

/**
 * Created by Matias on 4/22/2016.
 */
public class AbilityListAdapter extends ArrayAdapter <Ability> {

    private final Context context;
    private final Ability[] abilities;
    private final int hiddenAbilityID;
    private static final String RED_BACKGROUND = "#c24542";

    public AbilityListAdapter(Context context, Ability[] abilities, int isHidden) {
        super(context, -1, abilities);
        this.context=context;
        this.abilities=abilities;
        this.hiddenAbilityID = isHidden;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.ability_list, parent, false);

        TextView tvAbilityType = (TextView) rowView.findViewById(R.id.tv_ability_type);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.tv_ability_description);
        Ability ability = abilities[position];
        String abilityTitle;

        if(ability.getId() == hiddenAbilityID) {
            abilityTitle = ability.getName() + " (hidden)";
            tvAbilityType.setText(abilityTitle);
            tvAbilityType.setBackgroundColor(Color.parseColor(RED_BACKGROUND));
        }
        else
            abilityTitle = ability.getName() + " (regular)";
            tvAbilityType.setText(abilityTitle);
            tvAbilityType.setText(abilityTitle);

        List<FlavorTextEntry> descriptionsList = ability.getFlavorTextEntries();
        Iterator<FlavorTextEntry> description = descriptionsList.iterator();
        description.next();
        tvDescription.setText(uiFormat.deleteRL(description.next().getFlavorText()));

        return rowView;
    }
}
