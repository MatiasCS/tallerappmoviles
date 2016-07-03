package cl.mycompany.dexapplication.fragments;

import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.mycompany.dexapplication.API.ClientPokeApi;
import cl.mycompany.dexapplication.API.PokeApi;
import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.adapters.AbilityListAdapter;
import cl.mycompany.dexapplication.adapters.EvoChainGridAdapter;
import cl.mycompany.dexapplication.interfaces.IFragmentToActivity;
import cl.mycompany.dexapplication.model.abilityModel.Ability;
import cl.mycompany.dexapplication.model.evolutionChainModel.Chain;
import cl.mycompany.dexapplication.model.evolutionChainModel.EvolutionChain;
import cl.mycompany.dexapplication.model.specieModel.Specie;
import cl.mycompany.dexapplication.model.typeModel.DoubleDamageFrom;
import cl.mycompany.dexapplication.model.typeModel.HalfDamageFrom;
import cl.mycompany.dexapplication.model.typeModel.NoDamageFrom;
import cl.mycompany.dexapplication.model.typeModel.Type;
import cl.mycompany.dexapplication.utils.supportFunctions;
import cl.mycompany.dexapplication.utils.uiFormat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralInformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralInformationFragment extends Fragment {
    //ArrayList<Ability> abilities = new ArrayList<>();
    private IFragmentToActivity mCallback;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ABILITIES_LIST = "abilitiesList";
    private static final String ARG_HIDDEN_ABILITY_ID = "hAbilityID";

    // TODO: Rename and change types of parameters
    private int[] mAbilitiesList = new int[3];
    private int[] mTypesList;
    private int mHAbilityID;
    private int mSpecieID;

    private OnFragmentInteractionListener mListener;

    public GeneralInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param abilitiesList Parameter 1.
     * @return A new instance of fragment GeneralInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralInformationFragment newInstance(int[] abilitiesList, int hAbilityInd) {
        GeneralInformationFragment fragment = new GeneralInformationFragment();
        Bundle args = new Bundle();
        args.putIntArray(ARG_ABILITIES_LIST, abilitiesList);
        args.putInt(ARG_HIDDEN_ABILITY_ID, hAbilityInd);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAbilitiesList = getArguments().getIntArray(ARG_ABILITIES_LIST);
            mHAbilityID = getArguments().getInt(ARG_HIDDEN_ABILITY_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_general_information, container, false);
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
        try {
            mCallback = (IFragmentToActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }


        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
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

    public void onRefresh(int[] abilitiesList , int hAbilityID, int[] typesList, int specieID){
        mAbilitiesList = abilitiesList;
        mHAbilityID = hAbilityID;
        mTypesList = typesList;
        mSpecieID = specieID;
        bindAbilityList();
        bindTypeMatchUp();
        bindEvoChain(mSpecieID);
    }

    private void bindAbilityList(){
        setAbilitiesTask task = new setAbilitiesTask();
        task.execute();
    }

    private void bindTypeMatchUp(){
        setWeaknessesTask task = new setWeaknessesTask();
        task.execute();
    }

    private void bindEvoChain(int id){
        Retrofit retrofit;
        retrofit = ClientPokeApi.getClient();
        final PokeApi restApi = retrofit.create(PokeApi.class);

        Call<Specie> call = restApi.getSpecie(String.valueOf(id));
        call.enqueue(new Callback<Specie>() {
            @Override
            public void onResponse(Call<Specie> call, Response<Specie> response) {
                Specie specie = response.body();
                int evoChainID = supportFunctions.getIdFromURL(specie.getEvolutionChain().getUrl());

                final Call<EvolutionChain> evoCall = restApi.getEvoChain(String.valueOf(evoChainID));
                evoCall.enqueue(new Callback<EvolutionChain>() {
                    @Override
                    public void onResponse(Call<EvolutionChain> call, Response<EvolutionChain> response) {
                        if (response.isSuccessful()){
                            GridView evoChainGrid = (GridView)getView().findViewById(R.id.evo_chain_grid);
                            Chain evoChain = response.body().getChain();
                            String[] evolutionaryList= supportFunctions.getEvoList(evoChain);
                            evoChainGrid.setAdapter(new EvoChainGridAdapter(getContext(), evolutionaryList));
                            evoChainGrid.setNumColumns(evolutionaryList.length);
                        }
                    }

                    @Override
                    public void onFailure(Call<EvolutionChain> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Specie> call, Throwable t) {

            }
        });

    }

    private class setAbilitiesTask extends AsyncTask<Void, Void,
            ArrayList<Ability>> {
        Retrofit retrofit;

        @Override
        protected void onPreExecute() {
            retrofit = ClientPokeApi.getClient();
        }

        @Override
        protected ArrayList<Ability> doInBackground(Void... params) {
            PokeApi restApi = retrofit.create(PokeApi.class);
            ArrayList<Ability> abilities = new ArrayList<>();
            for (int id : mAbilitiesList) {
                if (id != 0) {
                    Call<Ability> call = restApi.getAbility(String.valueOf(id));
                    try {
                        Ability response = call.execute().body();
                        abilities.add(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return abilities;
        }

        @Override
        protected void onPostExecute(ArrayList<Ability> abilities){

            LinearLayout listLayout = (LinearLayout) getView().findViewById(R.id.linear_ability_list);
            Ability[] abilityArray = abilities.toArray(new Ability[0]);
            AbilityListAdapter adapter = new AbilityListAdapter(getActivity(), abilityArray, mHAbilityID);

            final int adapterCount = adapter.getCount();
            for (int i = 0; i < adapterCount; i++) {
                View item = adapter.getView(i, null, null);
                listLayout.addView(item);
            }
        }
    }

    private class setWeaknessesTask extends AsyncTask<Void, Void,
            List<Type>> {
        Retrofit retrofit;

        @Override
        protected void onPreExecute() {
            retrofit = ClientPokeApi.getClient();
        }

        @Override
        protected List<Type> doInBackground(Void... params) {
            PokeApi restApi = retrofit.create(PokeApi.class);
            List<Type> typeList = new ArrayList<Type>();
            for (int id : mTypesList) {
                if (id != 0) {
                    Call<Type> call = restApi.getType(String.valueOf(id));
                    try {
                        Type response = call.execute().body();
                        typeList.add(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return typeList;
        }

        @Override
        protected void onPostExecute(List<Type> typeList){
            Map<String, String> weaknessesResume;
            if(typeList.size()>1) {
                List<List<DoubleDamageFrom>> times2 = new ArrayList<List<DoubleDamageFrom>>(2);
                List<List<HalfDamageFrom>> timeshalf = new ArrayList<List<HalfDamageFrom>>(2);
                List<List<NoDamageFrom>> times0 = new ArrayList<List<NoDamageFrom>>(2);

                for (Type type : typeList) {
                    times2.add(type.getDamageRelations().getDoubleDamageFrom());
                    timeshalf.add(type.getDamageRelations().getHalfDamageFrom());
                    times0.add(type.getDamageRelations().getNoDamageFrom());
                }

                weaknessesResume = uiFormat.timesEffectiveFromDualTyping(times2, timeshalf, times0);
            }
            else {
                Type type = typeList.get(0);
                List<DoubleDamageFrom> times2 = type.getDamageRelations().getDoubleDamageFrom();
                List<HalfDamageFrom> timeshalf = type.getDamageRelations().getHalfDamageFrom();
                List<NoDamageFrom> times0 = type.getDamageRelations().getNoDamageFrom();
                weaknessesResume = uiFormat.timesEffectiveFromMonoTyping(times2, timeshalf, times0);
            }
            Resources r = getResources();
            View v = getView();
            uiFormat.setText(v,r,weaknessesResume);
        }
    }
}
