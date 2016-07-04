package cl.mycompany.dexapplication.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cl.mycompany.dexapplication.API.ClientPokeApi;
import cl.mycompany.dexapplication.API.PokeApi;
import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.abilityModel.Ability;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AbilityDetailsActivity extends AppCompatActivity {
    private TextView tvAbilityName;
    private TextView tvAbilityDescription;
    private TextView tvAbilityEffect;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindActivity();
        bindAbilityDetails();

        //Toolbar title animation
        final String appBarTitle = getIntent().getExtras().getString("name");

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

    private void bindActivity(){
        tvAbilityName = (TextView) findViewById(R.id.tv_ability_name);
        tvAbilityDescription = (TextView) findViewById(R.id.tv_ability_description);
        tvAbilityEffect = (TextView) findViewById(R.id.tv_ability_effect);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
    }

    public void bindAbilityDetails(){
        tvAbilityName.setText(getIntent().getExtras().getString("name"));
        tvAbilityDescription.setText(getIntent().getExtras().getString("description"));

        Retrofit retrofit;
        retrofit = ClientPokeApi.getClient();
        final PokeApi restApi = retrofit.create(PokeApi.class);
        int id = getIntent().getExtras().getInt("index");

        Call<Ability> call = restApi.getAbility(String.valueOf(id));
        call.enqueue(new Callback<Ability>() {
            @Override
            public void onResponse(Call<Ability> call, Response<Ability> response) {
                if(response.isSuccessful()){
                    Ability ability = response.body();
                    tvAbilityEffect.setText(ability.getEffectEntries().get(0).getEffect());
                }
            }

            @Override
            public void onFailure(Call<Ability> call, Throwable t) {

            }
        });
    }

}
