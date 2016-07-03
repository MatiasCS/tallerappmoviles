package cl.mycompany.dexapplication.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import cl.mycompany.dexapplication.API.ClientPokeApi;
import cl.mycompany.dexapplication.API.PokeApi;
import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.moveModel.EffectEntry;
import cl.mycompany.dexapplication.model.moveModel.Move;
import cl.mycompany.dexapplication.model.typeModel.DamageRelations;
import cl.mycompany.dexapplication.model.typeModel.Type;
import cl.mycompany.dexapplication.utils.supportFunctions;
import cl.mycompany.dexapplication.utils.uiFormat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MoveDetailsActivity extends AppCompatActivity {

    private TextView tvMoveDescription;
    private TextView tvMoveEffect;
    private TextView tvAccuracyValue;
    private TextView tvAttackValue;
    private TextView tvPPValue;
    private TextView tvMoveName;
    private TextView tvMoveType;
    private TextView tvMoveCategory;
    private TextView tvMoveCategory2;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindActivity();

        String power = String.valueOf(getIntent().getExtras().getInt("power"));
        String accuracy = String.valueOf(getIntent().getExtras().getInt("accuracy"));

        if(power.equals("0"))
            power = "-";
        if(accuracy.equals("0"))
            accuracy = "-";

        tvAccuracyValue.setText(accuracy);
        tvAttackValue.setText(power);
        tvPPValue.setText(String.valueOf(getIntent().getExtras().getInt("pp")));
        tvMoveType.setText(getIntent().getExtras().getString("type").toUpperCase());
        tvMoveName.setText(getIntent().getExtras().getString("name"));
        bindMoveDetails(findViewById(R.id.main_content));

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
        tvMoveDescription = (TextView) findViewById(R.id.tv_move_description);
        tvMoveEffect = (TextView) findViewById(R.id.tv_move_effect);
        tvAttackValue = (TextView) findViewById(R.id.tv_move_attack_value);
        tvAccuracyValue = (TextView) findViewById(R.id.tv_move_accuracy_value);
        tvPPValue = (TextView) findViewById(R.id.tv_move_pp_value);
        tvMoveName = (TextView) findViewById(R.id.tv_move_name);
        tvMoveType = (TextView) findViewById(R.id.tv_move_type);
        tvMoveCategory = (TextView) findViewById(R.id.tv_move_category);
        tvMoveCategory2 = (TextView) findViewById(R.id.tv_move_category2);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
    }

    public void bindMoveDetails(final View v){
        Retrofit retrofit;
        retrofit = ClientPokeApi.getClient();
        final PokeApi restApi = retrofit.create(PokeApi.class);
        int id = getIntent().getExtras().getInt("index");

        Call<Move> call = restApi.getMove(String.valueOf(id));
        call.enqueue(new Callback<Move>() {
            @Override
            public void onResponse(Call<Move> call, Response<Move> response) {
                if(response.isSuccessful()){
                    Move move = response.body();
                    List<EffectEntry> entries = move.getEffectEntries();
                    tvMoveDescription.setText(entries.get(0).getShortEffect());
                    tvMoveEffect.setText(entries.get(0).getEffect());
                    tvMoveCategory.setText(move.getDamageClass().getName());
                    tvMoveCategory2.setText("- "+move.getDamageClass().getName());
                    int typeID = supportFunctions.getIdFromURL(move.getType().getUrl());

                    Call<Type> typeCall = restApi.getType(String.valueOf(typeID));
                    typeCall.enqueue(new Callback<Type>() {
                        @Override
                        public void onResponse(Call<Type> call, Response<Type> response) {
                            if(response.isSuccessful()){
                                Type type = response.body();
                                DamageRelations dr = type.getDamageRelations();
                                //TODO implementar effectividad
                                Map<String , String> timesEffectiveTo;
                                timesEffectiveTo = uiFormat.timesEffectiveTo(dr.getDoubleDamageTo(), dr.getHalfDamageTo(), dr.getNoDamageTo());
                                uiFormat.setText(v,getResources(),timesEffectiveTo);
                            }
                        }

                        @Override
                        public void onFailure(Call<Type> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Move> call, Throwable t) {

            }
        });
    }

}
