package cl.mycompany.dexapplication.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.Pokemon;

/**
 * Created by Matias on 4/16/2016.
 */
public class PokemonListAdapter extends ArrayAdapter <Pokemon> {

    private final Context context;
    private final Pokemon[] pokemon;

    public PokemonListAdapter(Context context, Pokemon[] pokemon) {
        super(context, -1, pokemon);
        this.context=context;
        this.pokemon=pokemon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(cl.mycompany.dexapplication.R.layout.pokedex_grid, parent, false);

        TextView nameTextView = (TextView) rowView.findViewById(R.id.tv_pokemon_name);
        TextView numberTextView = (TextView) rowView.findViewById(R.id.tv_pokemon_number);
        ImageView sprite = (ImageView) rowView.findViewById(R.id.pokemon_sprite);

        nameTextView.setText(pokemon[position].getName());
        numberTextView.setText(numberToText(pokemon[position].getNumber()));

        Resources r = context.getResources();

        if (pokemon[position].getName().equals("Mr. Mime"))
            sprite.setImageResource(R.drawable.mr_mime);
        else if (pokemon[position].getName().equals("Nidoran-f"))
            sprite.setImageResource(R.drawable.nidoran_f);
        else if (pokemon[position].getName().equals("Nidoran-m"))
            sprite.setImageResource(R.drawable.nidoran_m);
        else
            sprite.setImageResource(r.getIdentifier(pokemon[position].getName().toLowerCase(),"drawable","cl.mycompany.dexapplication"));

        return rowView;
    }

    private String numberToText(int number){
        String numberText;
        if(number < 9)
            numberText = "00" + String.valueOf(number) + "|";
        else if(number < 99)
            numberText = "0" + String.valueOf(number) + "|";
        else
            numberText = String.valueOf(number) + "|";

        return numberText;
    }
}
