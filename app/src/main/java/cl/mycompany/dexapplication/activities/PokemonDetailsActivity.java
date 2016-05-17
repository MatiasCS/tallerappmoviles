package cl.mycompany.dexapplication.activities;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.PokemonDetailsPagerAdapter;

public class PokemonDetailsActivity extends FragmentActivity {

    private Toolbar toolbar;
    private ViewPager informationPager;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        bindActivity();

        PokemonDetailsPagerAdapter detailsAdapter = new PokemonDetailsPagerAdapter(getSupportFragmentManager());
        informationPager.setAdapter(detailsAdapter);
        tabLayout.setupWithViewPager(informationPager);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("135 | Jolteon");
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
}
