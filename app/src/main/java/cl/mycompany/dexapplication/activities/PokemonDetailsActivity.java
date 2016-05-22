package cl.mycompany.dexapplication.activities;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.util.List;

import cl.mycompany.dexapplication.API.ClientPokeApi;
import cl.mycompany.dexapplication.API.PokeApi;
import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.PokemonDetailsPagerAdapter;
import cl.mycompany.dexapplication.fragments.GeneralInformationFragment;
import cl.mycompany.dexapplication.model.pokemonModel.Ability;
import cl.mycompany.dexapplication.model.pokemonModel.Pokemon;
import cl.mycompany.dexapplication.model.pokemonModel.Stat;
import cl.mycompany.dexapplication.model.pokemonModel.Type;
import cl.mycompany.dexapplication.utils.supportFunctions;
import cl.mycompany.dexapplication.utils.uiFormat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PokemonDetailsActivity extends FragmentActivity{

    private Toolbar toolbar;
    private ViewPager informationPager;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private PokemonDetailsPagerAdapter detailsAdapter = new PokemonDetailsPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        bindActivity();
        getPokemonInfo();
        informationPager.setAdapter(detailsAdapter);
        tabLayout.setupWithViewPager(informationPager);

        //Toolbar title animation
        final String appBarTitle = uiFormat.numberToText(getIntent().getExtras().getInt("index")) + " " +getIntent().getExtras().getString("name");

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(appBarTitle);
                    collapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });

    }

    private void bindActivity(){
        informationPager = (ViewPager) findViewById(R.id.pager_pokemon_info);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
    }

    public void getPokemonInfo(){
        int pkmIndex = getIntent().getExtras().getInt("index");
        String pokemonIndex = String.valueOf(pkmIndex);
        //Retrofit call
        Retrofit retrofit = ClientPokeApi.getClient();
        PokeApi restApi = retrofit.create(PokeApi.class);
        Call<Pokemon> call = restApi.getPokemon(pokemonIndex);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.isSuccessful()) {
                    bindBaseInfo(response.body());
                    inflateFragment(response.body().getAbilities());
                }

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }

    public void bindBaseInfo(Pokemon pokemon){
        //XML Element to be set
        TextView tvPkmDescription, tvPkmNumber, tvType1, tvType2;
        TextView [] tvBaseStats = new TextView[6];
        ImageView ivPokemonSprite = (ImageView) findViewById(R.id.iv_pokemon_sprite);

        tvType1 = (TextView) findViewById(R.id.tv_type1);
        tvType2 = (TextView) findViewById(R.id.tv_type2);
        tvBaseStats[0] = (TextView) findViewById(R.id.tv_pokemon_speed_value);
        tvBaseStats[1] = (TextView) findViewById(R.id.tv_pokemon_speciald_value);
        tvBaseStats[2] = (TextView) findViewById(R.id.tv_pokemon_speciala_value);
        tvBaseStats[3] = (TextView) findViewById(R.id.tv_pokemon_defense_value);
        tvBaseStats[4] = (TextView) findViewById(R.id.tv_pokemon_attack_value);
        tvBaseStats[5]= (TextView) findViewById(R.id.tv_pokemon_hp_value);
        tvPkmDescription = (TextView) findViewById(R.id.tv_pokemon_description);
        tvPkmNumber = (TextView) findViewById(R.id.tv_pokemon_number);

        //Extraction of pokemon Data
        List<Stat> statsList= pokemon.getStats();
        List<Type> typesList = pokemon.getTypes();
        int pkmIndex = getIntent().getExtras().getInt("index");
        String pkmName = getIntent().getExtras().getString("name");
        String numberName = uiFormat.numberToText(pkmIndex) + " " +pkmName;

        //Setting of values
        tvPkmDescription.setText(pokemon.getSpecies().getName());
        tvPkmNumber.setText(numberName);
        Resources r = getResources();
        ivPokemonSprite.setImageResource(r.getIdentifier(pokemon.getName(),"drawable","cl.mycompany.dexapplication"));

        int i = 0;
        for (Stat stat : statsList){
            int baseStat = stat.getBaseStat();
            tvBaseStats[i].setText(String.valueOf(baseStat));
            tvBaseStats[i].setTextColor(Color.parseColor(uiFormat.statColor(baseStat)));
            i++;
        }

        for(Type type : typesList){
            int slot = type.getSlot();
            switch (slot){
                case 1:
                    tvType1.setText(type.getType().getName().toUpperCase());
                    break;
                case 2:
                    String secondTypeDivider = " | " + type.getType().getName().toUpperCase();
                    tvType2.setText(secondTypeDivider);
            }
        }
    }

    private void inflateFragment(List<Ability> abilitiesList){
        int[] abilitiesID = new int[3];
        int i = 0;
        int hiddenAbilityID = 0;

        for(Ability ability : abilitiesList){
            int id = supportFunctions.getAbilityId(ability.getAbility().getUrl());
            abilitiesID[ability.getSlot()-1] = id;
            if(ability.getIsHidden())
                hiddenAbilityID = id;
            i++;
        }
        Fragment fragment = detailsAdapter.getFragment(tabLayout.getSelectedTabPosition());
        ((GeneralInformationFragment) fragment).onRefresh(abilitiesID,hiddenAbilityID, fragment.getView());

    }
}
