package cl.mycompany.dexapplication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.AbilityListAdapter;
import cl.mycompany.dexapplication.model.Ability;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralInformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralInformationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GeneralInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeneralInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralInformationFragment newInstance(String param1, String param2) {
        GeneralInformationFragment fragment = new GeneralInformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ArrayList<Ability> abilities = new ArrayList<>();
    Ability ability1 = new Ability("Volt Absorb",
            "The Pokémon heals up to 1/4 of it’s maximum Hit Points when hit with Electric-type moves.",
            0);

    Ability ability2 = new Ability("Quick Feet",
            " Speed is increased by 50% when induced with a status (Burn, Poison, Sleep, Frozen & Paralysis). If Paralysed, the speed drop is ignored.",
            1);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_general_information, container, false);
        setAbilityList(fragment);
        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setAbilityList(View fragment){
        abilities.add(ability1);
        abilities.add(ability2);

        Ability[] abilityArray = abilities.toArray(new Ability[0]);

        LinearLayout listLayout = (LinearLayout) fragment.findViewById(R.id.linear_ability_list); // Your linear layout.
        AbilityListAdapter adapter = new AbilityListAdapter(getActivity(), abilityArray);// Your adapter.

        final int adapterCount = adapter.getCount();

        for (int i = 0; i < adapterCount; i++) {
            View item = adapter.getView(i, null, null);
            listLayout.addView(item);
        }
        //ListView abilityList = (ListView) findViewById(R.id.desc_ability_list);
        //abilityList.setAdapter(new AbilityListAdapter(this,abilityArray));
    }
}
