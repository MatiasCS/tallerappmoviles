package cl.mycompany.dexapplication.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.Pokemon;
import cl.mycompany.dexapplication.utils.uiFormat;

/**
 * Created by Matias on 5/23/2016.
 */
public class EvoChainGridAdapter extends ArrayAdapter<String>{
    private final Context context;
    private final String[] pokemonList;

    public EvoChainGridAdapter(Context context, String[] pokemonList){
        super(context, -1, pokemonList);
        this.context=context;
        this.pokemonList=pokemonList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.evochain_grid, parent, false);

        ImageView sprite = (ImageView) rowView.findViewById(R.id.pokemon_sprite);

        Resources r = context.getResources();

        sprite.setImageResource(r.getIdentifier(pokemonList[position].toLowerCase(),"drawable","cl.mycompany.dexapplication"));

        return rowView;
    }
}
