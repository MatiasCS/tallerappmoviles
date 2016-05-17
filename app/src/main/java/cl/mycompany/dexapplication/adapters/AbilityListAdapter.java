package cl.mycompany.dexapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.Ability;

/**
 * Created by Matias on 4/22/2016.
 */
public class AbilityListAdapter extends ArrayAdapter <Ability> {

    private final Context context;
    private final Ability[] abilities;
    private static final String RED_BACKGROUND = "#c24542";

    public AbilityListAdapter(Context context, Ability[] abilities) {
        super(context, -1, abilities);
        this.context=context;
        this.abilities=abilities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(cl.mycompany.dexapplication.R.layout.ability_list, parent, false);

        TextView abilityTypeTextView = (TextView) rowView.findViewById(R.id.tv_ability_type);
        TextView descriptionTextView = (TextView) rowView.findViewById(R.id.tv_ability_description);

        String description = "<b>" + abilities[position].getName() + ": </b> " + abilities[position].getDescription();

        if(abilities[position].getHidden() == 1) {
            abilityTypeTextView.setText("HIDDEN");
            abilityTypeTextView.setBackgroundColor(Color.parseColor(RED_BACKGROUND));
        }
        else
            abilityTypeTextView.setText("REGULAR");


        descriptionTextView.setText(Html.fromHtml(description));

        return rowView;
    }
}
