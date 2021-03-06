package cl.mycompany.dexapplication.API;

import cl.mycompany.dexapplication.model.pokemonModel.Pokemon;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Matias on 5/19/2016.
 */
public class ClientPokeApi{

    public static final String BASE_URL = "http://pokeapi.co/api/v2/";

    public static Retrofit getClient() {

        OkHttpClient httpClient = new OkHttpClient();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}
