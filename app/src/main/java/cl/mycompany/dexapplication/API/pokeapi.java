package cl.mycompany.dexapplication.API;

import cl.mycompany.dexapplication.model.abilityModel.Ability;
import cl.mycompany.dexapplication.model.pokemonModel.Pokemon;
import cl.mycompany.dexapplication.model.specieModel.Specie;
import cl.mycompany.dexapplication.model.typeModel.Type;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Matias on 5/19/2016.
 */
public interface PokeApi {

    @GET("pokemon/{number}")
    Call<Pokemon> getPokemon(@Path("number") String number);

    @GET("ability/{number}")
    Call<Ability> getAbility(@Path("number") String number);

    @GET("pokemon-species/{number}")
    Call<Specie> getSpecie(@Path("number") String number);

    @GET("type/{number}")
    Call<Type> getType(@Path("number") String number);
}
