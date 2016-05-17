package cl.mycompany.dexapplication.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import cl.mycompany.dexapplication.fragments.GeneralInformationFragment;
import cl.mycompany.dexapplication.fragments.LevelUpMovesFragment;

/**
 * Created by Matias on 4/27/2016.
 */
public class PokemonDetailsPagerAdapter extends FragmentStatePagerAdapter {

    static final int ITEMS = 2;

    public PokemonDetailsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new GeneralInformationFragment();
            case 1:
                return new LevelUpMovesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 1:
                return "Level Up Moves";
            default:
                return "General Information";
        }
    }
}
