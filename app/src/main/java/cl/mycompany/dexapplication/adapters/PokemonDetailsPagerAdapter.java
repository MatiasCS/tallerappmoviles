package cl.mycompany.dexapplication.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

import cl.mycompany.dexapplication.fragments.GeneralInformationFragment;
import cl.mycompany.dexapplication.fragments.LevelUpMovesFragment;

/**
 * Created by Matias on 4/27/2016.
 */
public class PokemonDetailsPagerAdapter extends FragmentStatePagerAdapter {

    private final SparseArray<WeakReference<Fragment>> instantiatedFragments = new SparseArray<>();
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

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final Fragment fragment = (Fragment) super.instantiateItem(container, position);
        instantiatedFragments.put(position, new WeakReference<>(fragment));
        return fragment;
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        instantiatedFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Nullable
    public Fragment getFragment(final int position) {
        final WeakReference<Fragment> wr = instantiatedFragments.get(position);
        if (wr != null) {
            return wr.get();
        } else {
            return null;
        }
    }
}
