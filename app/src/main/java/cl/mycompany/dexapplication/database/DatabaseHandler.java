package cl.mycompany.dexapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cl.mycompany.dexapplication.model.Pokemon;

/**
 * Created by Matias on 5/17/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "pokemonList";

    // Contacts table name
    private static final String TABLE_POKEMON = "pokemon";

    // Contacts Table Columns names
    private static final String KEY_NUMBER = "id_number";
    private static final String KEY_NAME = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_POKEMON + "("
                + KEY_NUMBER + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        fillDatabase(this);
        db.close();
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKEMON);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addPokemon(Pokemon pokemon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, pokemon.getName());

        // Inserting Row
        db.insert(TABLE_POKEMON, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public Pokemon getPokemon(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_POKEMON, new String[] { KEY_NUMBER,
                        KEY_NAME}, KEY_NUMBER + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Pokemon pokemon = new Pokemon(cursor.getInt(0),
                cursor.getString(1));
        cursor.close();
        db.close();
        // return contact
        return pokemon;
    }

    // Getting All Contacts
    public ArrayList<Pokemon> getAllPokemon() {

        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_POKEMON;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int number = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                Pokemon contact = new Pokemon(number,name);
                // Adding contact to list
                pokemonList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        cursor.close();
        db.close();
        return pokemonList;
    }

    private void fillDatabase(DatabaseHandler db){
        Log.d("Insert: ", "Inserting ..");
        db.addPokemon(new Pokemon(1,"Bulbasaur"));
        db.addPokemon(new Pokemon(2,"Ivysaur"));
        db.addPokemon(new Pokemon(3,"Venusaur"));
        db.addPokemon(new Pokemon(4,"Charmander"));
        db.addPokemon(new Pokemon(5,"Charmeleon"));
        db.addPokemon(new Pokemon(6,"Charizard"));
        db.addPokemon(new Pokemon(7,"Squirtle"));
        db.addPokemon(new Pokemon(8,"Wartortle"));
        db.addPokemon(new Pokemon(9,"Blastoise"));
        db.addPokemon(new Pokemon(10,"Caterpie"));
        db.addPokemon(new Pokemon(11,"Metapod"));
        db.addPokemon(new Pokemon(12,"Butterfree"));
        db.addPokemon(new Pokemon(13,"Weedle"));
        db.addPokemon(new Pokemon(14,"Kakuna"));
        db.addPokemon(new Pokemon(15,"Beedrill"));
        db.addPokemon(new Pokemon(16,"Pidgey"));
        db.addPokemon(new Pokemon(17,"Pidgeotto"));
        db.addPokemon(new Pokemon(18,"Pidgeot"));
        db.addPokemon(new Pokemon(19,"Rattata"));
        db.addPokemon(new Pokemon(20,"Raticate"));
        db.addPokemon(new Pokemon(21,"Spearow"));
        db.addPokemon(new Pokemon(22,"Fearow"));
        db.addPokemon(new Pokemon(23,"Ekans"));
        db.addPokemon(new Pokemon(24,"Arbok"));
        db.addPokemon(new Pokemon(25,"Pikachu"));
        db.addPokemon(new Pokemon(26,"Raichu"));
        db.addPokemon(new Pokemon(27,"Sandshrew"));
        db.addPokemon(new Pokemon(28,"Sandslash"));
        db.addPokemon(new Pokemon(29,"Nidoran-f"));
        db.addPokemon(new Pokemon(30,"Nidorina"));
        db.addPokemon(new Pokemon(31,"Nidoqueen"));
        db.addPokemon(new Pokemon(32,"Nidoran-m"));
        db.addPokemon(new Pokemon(33,"Nidorino"));
        db.addPokemon(new Pokemon(34,"Nidoking"));
        db.addPokemon(new Pokemon(35,"Clefairy"));
        db.addPokemon(new Pokemon(36,"Clefable"));
        db.addPokemon(new Pokemon(37,"Vulpix"));
        db.addPokemon(new Pokemon(38,"Ninetales"));
        db.addPokemon(new Pokemon(39,"Jigglypuff"));
        db.addPokemon(new Pokemon(40,"Wigglytuff"));
        db.addPokemon(new Pokemon(41,"Zubat"));
        db.addPokemon(new Pokemon(42,"Golbat"));
        db.addPokemon(new Pokemon(43,"Oddish"));
        db.addPokemon(new Pokemon(44,"Gloom"));
        db.addPokemon(new Pokemon(45,"Vileplume"));
        db.addPokemon(new Pokemon(46,"Paras"));
        db.addPokemon(new Pokemon(47,"Parasect"));
        db.addPokemon(new Pokemon(48,"Venonat"));
        db.addPokemon(new Pokemon(49,"Venomoth"));
        db.addPokemon(new Pokemon(50,"Diglett"));
        db.addPokemon(new Pokemon(51,"Dugtrio"));
        db.addPokemon(new Pokemon(52,"Meowth"));
        db.addPokemon(new Pokemon(53,"Persian"));
        db.addPokemon(new Pokemon(54,"Psyduck"));
        db.addPokemon(new Pokemon(55,"Golduck"));
        db.addPokemon(new Pokemon(56,"Mankey"));
        db.addPokemon(new Pokemon(57,"Primeape"));
        db.addPokemon(new Pokemon(58,"Growlithe"));
        db.addPokemon(new Pokemon(59,"Arcanine"));
        db.addPokemon(new Pokemon(60,"Poliwag"));
        db.addPokemon(new Pokemon(61,"Poliwhirl"));
        db.addPokemon(new Pokemon(62,"Poliwrath"));
        db.addPokemon(new Pokemon(63,"Abra"));
        db.addPokemon(new Pokemon(64,"Kadabra"));
        db.addPokemon(new Pokemon(65,"Alakazam"));
        db.addPokemon(new Pokemon(66,"Machop"));
        db.addPokemon(new Pokemon(67,"Machoke"));
        db.addPokemon(new Pokemon(68,"Machamp"));
        db.addPokemon(new Pokemon(69,"Bellsprout"));
        db.addPokemon(new Pokemon(70,"Weepinbell"));
        db.addPokemon(new Pokemon(71,"Victreebel"));
        db.addPokemon(new Pokemon(72,"Tentacool"));
        db.addPokemon(new Pokemon(73,"Tentacruel"));
        db.addPokemon(new Pokemon(74,"Geodude"));
        db.addPokemon(new Pokemon(75,"Graveler"));
        db.addPokemon(new Pokemon(76,"Golem"));
        db.addPokemon(new Pokemon(77,"Ponyta"));
        db.addPokemon(new Pokemon(78,"Rapidash"));
        db.addPokemon(new Pokemon(79,"Slowpoke"));
        db.addPokemon(new Pokemon(80,"Slowbro"));
        db.addPokemon(new Pokemon(81,"Magnemite"));
        db.addPokemon(new Pokemon(82,"Magneton"));
        db.addPokemon(new Pokemon(83,"Farfetch'd"));
        db.addPokemon(new Pokemon(84,"Doduo"));
        db.addPokemon(new Pokemon(85,"Dodrio"));
        db.addPokemon(new Pokemon(86,"Seel"));
        db.addPokemon(new Pokemon(87,"Dewgong"));
        db.addPokemon(new Pokemon(88,"Grimer"));
        db.addPokemon(new Pokemon(89,"Muk"));
        db.addPokemon(new Pokemon(90,"Shellder"));
        db.addPokemon(new Pokemon(91,"Cloyster"));
        db.addPokemon(new Pokemon(92,"Gastly"));
        db.addPokemon(new Pokemon(93,"Haunter"));
        db.addPokemon(new Pokemon(94,"Gengar"));
        db.addPokemon(new Pokemon(95,"Onix"));
        db.addPokemon(new Pokemon(96,"Drowzee"));
        db.addPokemon(new Pokemon(97,"Hypno"));
        db.addPokemon(new Pokemon(98,"Krabby"));
        db.addPokemon(new Pokemon(99,"Kingler"));
        db.addPokemon(new Pokemon(100,"Voltorb"));
        db.addPokemon(new Pokemon(101,"Electrode"));
        db.addPokemon(new Pokemon(102,"Exeggcute"));
        db.addPokemon(new Pokemon(103,"Exeggutor"));
        db.addPokemon(new Pokemon(104,"Cubone"));
        db.addPokemon(new Pokemon(105,"Marowak"));
        db.addPokemon(new Pokemon(106,"Hitmonlee"));
        db.addPokemon(new Pokemon(107,"Hitmonchan"));
        db.addPokemon(new Pokemon(108,"Lickitung"));
        db.addPokemon(new Pokemon(109,"Koffing"));
        db.addPokemon(new Pokemon(110,"Weezing"));
        db.addPokemon(new Pokemon(111,"Rhyhorn"));
        db.addPokemon(new Pokemon(112,"Rhydon"));
        db.addPokemon(new Pokemon(113,"Chansey"));
        db.addPokemon(new Pokemon(114,"Tangela"));
        db.addPokemon(new Pokemon(115,"Kangaskhan"));
        db.addPokemon(new Pokemon(116,"Horsea"));
        db.addPokemon(new Pokemon(117,"Seadra"));
        db.addPokemon(new Pokemon(118,"Goldeen"));
        db.addPokemon(new Pokemon(119,"Seaking"));
        db.addPokemon(new Pokemon(120,"Staryu"));
        db.addPokemon(new Pokemon(121,"Starmie"));
        db.addPokemon(new Pokemon(122,"Mr. Mime"));
        db.addPokemon(new Pokemon(123,"Scyther"));
        db.addPokemon(new Pokemon(124,"Jynx"));
        db.addPokemon(new Pokemon(125,"Electabuzz"));
        db.addPokemon(new Pokemon(126,"Magmar"));
        db.addPokemon(new Pokemon(127,"Pinsir"));
        db.addPokemon(new Pokemon(128,"Tauros"));
        db.addPokemon(new Pokemon(129,"Magikarp"));
        db.addPokemon(new Pokemon(130,"Gyarados"));
        db.addPokemon(new Pokemon(131,"Lapras"));
        db.addPokemon(new Pokemon(132,"Ditto"));
        db.addPokemon(new Pokemon(133,"Eevee"));
        db.addPokemon(new Pokemon(134,"Vaporeon"));
        db.addPokemon(new Pokemon(135,"Jolteon"));
        db.addPokemon(new Pokemon(136,"Flareon"));
        db.addPokemon(new Pokemon(137,"Porygon"));
        db.addPokemon(new Pokemon(138,"Omanyte"));
        db.addPokemon(new Pokemon(139,"Omastar"));
        db.addPokemon(new Pokemon(140,"Kabuto"));
        db.addPokemon(new Pokemon(141,"Kabutops"));
        db.addPokemon(new Pokemon(142,"Aerodactyl"));
        db.addPokemon(new Pokemon(143,"Snorlax"));
        db.addPokemon(new Pokemon(144,"Articuno"));
        db.addPokemon(new Pokemon(145,"Zapdos"));
        db.addPokemon(new Pokemon(146,"Moltres"));
        db.addPokemon(new Pokemon(147,"Dratini"));
        db.addPokemon(new Pokemon(148,"Dragonair"));
        db.addPokemon(new Pokemon(149,"Dragonite"));
        db.addPokemon(new Pokemon(150,"Mewtwo"));
        db.addPokemon(new Pokemon(151,"Mew"));
        db.close();
    }
}
