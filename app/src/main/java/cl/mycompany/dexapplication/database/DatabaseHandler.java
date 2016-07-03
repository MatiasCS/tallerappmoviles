package cl.mycompany.dexapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cl.mycompany.dexapplication.model.Move;
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

    // Pokemon table name
    private static final String TABLE_POKEMON = "pokemon";

    //Move table name
    private static final String TABLE_MOVES = "moves";

    // Pokemon Table Columns names
    private static final String KEY_NUMBER = "id_number";
    private static final String KEY_NAME = "name";

    // MOVES Table Columns names
    private static final String KEY_NUMBER_MOVES = "id_number";
    private static final String KEY_NAME_MOVES = "name";
    private static final String KEY_TYPE_MOVES = "type";
    private static final String KEY_TYPE_PP = "pp";
    private static final String KEY_TYPE_ATT = "attack";
    private static final String KEY_TYPE_ACC = "accuracy";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POKEMON_TABLE = "CREATE TABLE " + TABLE_POKEMON + "("
                + KEY_NUMBER + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + ")";
        String CREATE_MOVES_TABLE = "CREATE TABLE " + TABLE_MOVES+ "("
                + KEY_NUMBER_MOVES + " INTEGER PRIMARY KEY," + KEY_NAME_MOVES + " TEXT," + KEY_TYPE_MOVES + " TEXT,"
                + KEY_TYPE_PP + " INTEGER," + KEY_TYPE_ATT + " INTEGER," + KEY_TYPE_ACC + " INTEGER" + ")";
        db.execSQL(CREATE_POKEMON_TABLE);
        db.execSQL(CREATE_MOVES_TABLE);
        fillDatabasePokemon(db);
        fillDatabaseMove(db);
        //db.close();
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKEMON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVES);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addPokemon(Pokemon pokemon, SQLiteDatabase db) {
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, pokemon.getName());

        // Inserting Row
        db.insert(TABLE_POKEMON, null, values);
        //db.close(); // Closing database connection
    }

    // Adding new contact
    public void addMove(Move move, SQLiteDatabase db) {
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_MOVES, move.getName());
        values.put(KEY_TYPE_MOVES, move.getType());
        values.put(KEY_TYPE_PP,move.getPP());
        values.put(KEY_TYPE_ATT,move.getPower());
        values.put(KEY_TYPE_ACC,move.getAccuracy());

        // Inserting Row
        db.insert(TABLE_MOVES, null, values);
       // db.close(); // Closing database connection
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
        //db.close();
        // return contact
        return pokemon;
    }

    // Getting single contact
    public Move getMove(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MOVES, new String[] { KEY_NUMBER_MOVES,
                        KEY_NAME_MOVES, KEY_TYPE_MOVES}, KEY_NUMBER + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Move move = new Move(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5));
        cursor.close();
        //db.close();
        // return contact
        return move;
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
                Pokemon pokemon = new Pokemon(number,name);
                // Adding contact to list
                pokemonList.add(pokemon);
            } while (cursor.moveToNext());
        }

        // return contact list
        cursor.close();
        //db.close();
        return pokemonList;
    }

    // Getting All Contacts
    public ArrayList<Move> getAllMoves() {

        ArrayList<Move> moveList = new ArrayList<Move>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MOVES + " ORDER BY " + KEY_NAME_MOVES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int number = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String type = cursor.getString(2);
                int PP = cursor.getInt(3);
                int power = cursor.getInt(4);
                int accuracy = cursor.getInt(5);
                Move move = new Move(number,name,type,PP,power,accuracy);
                // Adding contact to list
                moveList.add(move);
            } while (cursor.moveToNext());
        }

        // return contact list
        cursor.close();
        //db.close();
        return moveList;
    }


    private void fillDatabasePokemon(SQLiteDatabase db){
        Log.d("Insert: ", "Inserting ..");
        addPokemon(new Pokemon(1, "Bulbasaur"), db);
        addPokemon(new Pokemon(2,"Ivysaur"),db);
        addPokemon(new Pokemon(3,"Venusaur"),db);
        addPokemon(new Pokemon(4,"Charmander"),db);
        addPokemon(new Pokemon(5,"Charmeleon"),db);
        addPokemon(new Pokemon(6,"Charizard"),db);
        addPokemon(new Pokemon(7,"Squirtle"),db);
        addPokemon(new Pokemon(8,"Wartortle"),db);
        addPokemon(new Pokemon(9,"Blastoise"),db);
        addPokemon(new Pokemon(10,"Caterpie"),db);
        addPokemon(new Pokemon(11,"Metapod"),db);
        addPokemon(new Pokemon(12,"Butterfree"),db);
        addPokemon(new Pokemon(13,"Weedle"),db);
        addPokemon(new Pokemon(14,"Kakuna"),db);
        addPokemon(new Pokemon(15,"Beedrill"),db);
        addPokemon(new Pokemon(16,"Pidgey"),db);
        addPokemon(new Pokemon(17,"Pidgeotto"),db);
        addPokemon(new Pokemon(18,"Pidgeot"),db);
        addPokemon(new Pokemon(19,"Rattata"),db);
        addPokemon(new Pokemon(20,"Raticate"),db);
        addPokemon(new Pokemon(21,"Spearow"),db);
        addPokemon(new Pokemon(22,"Fearow"),db);
        addPokemon(new Pokemon(23,"Ekans"),db);
        addPokemon(new Pokemon(24,"Arbok"),db);
        addPokemon(new Pokemon(25,"Pikachu"),db);
        addPokemon(new Pokemon(26,"Raichu"),db);
        addPokemon(new Pokemon(27,"Sandshrew"),db);
        addPokemon(new Pokemon(28,"Sandslash"),db);
        addPokemon(new Pokemon(29,"Nidoran♀"),db);
        addPokemon(new Pokemon(30,"Nidorina"),db);
        addPokemon(new Pokemon(31,"Nidoqueen"),db);
        addPokemon(new Pokemon(32,"Nidoran♂"),db);
        addPokemon(new Pokemon(33,"Nidorino"),db);
        addPokemon(new Pokemon(34,"Nidoking"),db);
        addPokemon(new Pokemon(35,"Clefairy"),db);
        addPokemon(new Pokemon(36,"Clefable"),db);
        addPokemon(new Pokemon(37,"Vulpix"),db);
        addPokemon(new Pokemon(38,"Ninetales"),db);
        addPokemon(new Pokemon(39,"Jigglypuff"),db);
        addPokemon(new Pokemon(40,"Wigglytuff"),db);
        addPokemon(new Pokemon(41,"Zubat"),db);
        addPokemon(new Pokemon(42,"Golbat"),db);
        addPokemon(new Pokemon(43,"Oddish"),db);
        addPokemon(new Pokemon(44,"Gloom"),db);
        addPokemon(new Pokemon(45,"Vileplume"),db);
        addPokemon(new Pokemon(46,"Paras"),db);
        addPokemon(new Pokemon(47,"Parasect"),db);
        addPokemon(new Pokemon(48,"Venonat"),db);
        addPokemon(new Pokemon(49,"Venomoth"),db);
        addPokemon(new Pokemon(50,"Diglett"),db);
        addPokemon(new Pokemon(51,"Dugtrio"),db);
        addPokemon(new Pokemon(52,"Meowth"),db);
        addPokemon(new Pokemon(53,"Persian"),db);
        addPokemon(new Pokemon(54,"Psyduck"),db);
        addPokemon(new Pokemon(55,"Golduck"),db);
        addPokemon(new Pokemon(56,"Mankey"),db);
        addPokemon(new Pokemon(57,"Primeape"),db);
        addPokemon(new Pokemon(58,"Growlithe"),db);
        addPokemon(new Pokemon(59,"Arcanine"),db);
        addPokemon(new Pokemon(60,"Poliwag"),db);
        addPokemon(new Pokemon(61,"Poliwhirl"),db);
        addPokemon(new Pokemon(62,"Poliwrath"),db);
        addPokemon(new Pokemon(63,"Abra"),db);
        addPokemon(new Pokemon(64,"Kadabra"),db);
        addPokemon(new Pokemon(65,"Alakazam"),db);
        addPokemon(new Pokemon(66,"Machop"),db);
        addPokemon(new Pokemon(67,"Machoke"),db);
        addPokemon(new Pokemon(68,"Machamp"),db);
        addPokemon(new Pokemon(69,"Bellsprout"),db);
        addPokemon(new Pokemon(70,"Weepinbell"),db);
        addPokemon(new Pokemon(71,"Victreebel"),db);
        addPokemon(new Pokemon(72,"Tentacool"),db);
        addPokemon(new Pokemon(73,"Tentacruel"),db);
        addPokemon(new Pokemon(74,"Geodude"),db);
        addPokemon(new Pokemon(75,"Graveler"),db);
        addPokemon(new Pokemon(76,"Golem"),db);
        addPokemon(new Pokemon(77,"Ponyta"),db);
        addPokemon(new Pokemon(78,"Rapidash"),db);
        addPokemon(new Pokemon(79,"Slowpoke"),db);
        addPokemon(new Pokemon(80,"Slowbro"),db);
        addPokemon(new Pokemon(81,"Magnemite"),db);
        addPokemon(new Pokemon(82,"Magneton"),db);
        addPokemon(new Pokemon(83,"Farfetch'd"),db);
        addPokemon(new Pokemon(84,"Doduo"),db);
        addPokemon(new Pokemon(85,"Dodrio"),db);
        addPokemon(new Pokemon(86,"Seel"),db);
        addPokemon(new Pokemon(87,"Dewgong"),db);
        addPokemon(new Pokemon(88,"Grimer"),db);
        addPokemon(new Pokemon(89,"Muk"),db);
        addPokemon(new Pokemon(90,"Shellder"),db);
        addPokemon(new Pokemon(91,"Cloyster"),db);
        addPokemon(new Pokemon(92,"Gastly"),db);
        addPokemon(new Pokemon(93,"Haunter"),db);
        addPokemon(new Pokemon(94,"Gengar"),db);
        addPokemon(new Pokemon(95,"Onix"),db);
        addPokemon(new Pokemon(96,"Drowzee"),db);
        addPokemon(new Pokemon(97,"Hypno"),db);
        addPokemon(new Pokemon(98,"Krabby"),db);
        addPokemon(new Pokemon(99,"Kingler"),db);
        addPokemon(new Pokemon(100,"Voltorb"),db);
        addPokemon(new Pokemon(101,"Electrode"),db);
        addPokemon(new Pokemon(102,"Exeggcute"),db);
        addPokemon(new Pokemon(103,"Exeggutor"),db);
        addPokemon(new Pokemon(104,"Cubone"),db);
        addPokemon(new Pokemon(105,"Marowak"),db);
        addPokemon(new Pokemon(106,"Hitmonlee"),db);
        addPokemon(new Pokemon(107,"Hitmonchan"),db);
        addPokemon(new Pokemon(108,"Lickitung"),db);
        addPokemon(new Pokemon(109,"Koffing"),db);
        addPokemon(new Pokemon(110,"Weezing"),db);
        addPokemon(new Pokemon(111,"Rhyhorn"),db);
        addPokemon(new Pokemon(112,"Rhydon"),db);
        addPokemon(new Pokemon(113,"Chansey"),db);
        addPokemon(new Pokemon(114,"Tangela"),db);
        addPokemon(new Pokemon(115,"Kangaskhan"),db);
        addPokemon(new Pokemon(116,"Horsea"),db);
        addPokemon(new Pokemon(117,"Seadra"),db);
        addPokemon(new Pokemon(118,"Goldeen"),db);
        addPokemon(new Pokemon(119,"Seaking"),db);
        addPokemon(new Pokemon(120,"Staryu"),db);
        addPokemon(new Pokemon(121,"Starmie"),db);
        addPokemon(new Pokemon(122,"Mr. Mime"),db);
        addPokemon(new Pokemon(123,"Scyther"),db);
        addPokemon(new Pokemon(124,"Jynx"),db);
        addPokemon(new Pokemon(125,"Electabuzz"),db);
        addPokemon(new Pokemon(126,"Magmar"),db);
        addPokemon(new Pokemon(127,"Pinsir"),db);
        addPokemon(new Pokemon(128,"Tauros"),db);
        addPokemon(new Pokemon(129,"Magikarp"),db);
        addPokemon(new Pokemon(130,"Gyarados"),db);
        addPokemon(new Pokemon(131,"Lapras"),db);
        addPokemon(new Pokemon(132,"Ditto"),db);
        addPokemon(new Pokemon(133,"Eevee"),db);
        addPokemon(new Pokemon(134,"Vaporeon"),db);
        addPokemon(new Pokemon(135,"Jolteon"),db);
        addPokemon(new Pokemon(136,"Flareon"),db);
        addPokemon(new Pokemon(137,"Porygon"),db);
        addPokemon(new Pokemon(138,"Omanyte"),db);
        addPokemon(new Pokemon(139,"Omastar"),db);
        addPokemon(new Pokemon(140,"Kabuto"),db);
        addPokemon(new Pokemon(141,"Kabutops"),db);
        addPokemon(new Pokemon(142,"Aerodactyl"),db);
        addPokemon(new Pokemon(143,"Snorlax"),db);
        addPokemon(new Pokemon(144,"Articuno"),db);
        addPokemon(new Pokemon(145,"Zapdos"),db);
        addPokemon(new Pokemon(146,"Moltres"),db);
        addPokemon(new Pokemon(147,"Dratini"),db);
        addPokemon(new Pokemon(148,"Dragonair"),db);
        addPokemon(new Pokemon(149,"Dragonite"),db);
        addPokemon(new Pokemon(150,"Mewtwo"),db);
        addPokemon(new Pokemon(151,"Mew"),db);
        //db.close();
    }

    public void fillDatabaseMove(SQLiteDatabase db){
        //Adding Moves
        addMove(new Move(1,"Pound","Normal",35,40,100),db);
        addMove(new Move(2,"Karate Chop","Fighting",25,50,100),db);
        addMove(new Move(3,"Double Slap","Normal",10,15,85),db);
        addMove(new Move(4,"Comet Punch","Normal",15,18,85),db);
        addMove(new Move(5,"Mega Punch","Normal",20,80,85),db);
        addMove(new Move(6,"Pay Day","Normal",20,40,100),db);
        addMove(new Move(7,"Fire Punch","Fire",15,75,100),db);
        addMove(new Move(8,"Ice Punch","Ice",15,75,100),db);
        addMove(new Move(9,"Thunder Punch","Electric",15,75,100),db);
        addMove(new Move(10,"Scratch","Normal",35,40,100),db);
        addMove(new Move(11,"Vice Grip","Normal",30,55,100),db);
        addMove(new Move(12,"Guillotine","Normal",5,0,0 ),db);
        addMove(new Move(13,"Razor Wind","Normal",10,80,100),db);
        addMove(new Move(14,"Swords Dance","Normal",20,0,0),db);
        addMove(new Move(15,"Cut","Normal",30,50,95),db);
        addMove(new Move(16,"Gust","Flying",35,40,100),db);
        addMove(new Move(17,"Wing Attack","Flying",35,60,100),db);
        addMove(new Move(18,"Whirlwind","Normal",20,0,0),db);
        addMove(new Move(19,"Fly","Flying",15,90,95),db);
        addMove(new Move(20,"Bind","Normal",20,15,85),db);
        addMove(new Move(21,"Slam","Normal",20,80,75),db);
        addMove(new Move(22,"Vine Whip","Grass",25,45,100),db);
        addMove(new Move(23,"Stomp","Normal",20,65,100),db);
        addMove(new Move(24,"Double Kick","Fighting",30,30,100),db);
        addMove(new Move(25,"Mega Kick","Normal",5,120,75),db);
        addMove(new Move(26,"Jump Kick","Fighting",10,100,95),db);
        addMove(new Move(27,"Rolling Kick","Fighting",15,60,85),db);
        addMove(new Move(28,"Sand Attack","Ground",15,0,100),db);
        addMove(new Move(29,"Headbutt","Normal",15,70,100),db);
        addMove(new Move(30,"Horn Attack","Normal",25,65,100),db);
        addMove(new Move(31,"Fury Attack","Normal",20,15,85),db);
        addMove(new Move(32,"Horn Drill","Normal",5,0,0 ),db);
        addMove(new Move(33,"Tackle","Normal",35,50,100),db);
        addMove(new Move(34,"Body Slam","Normal",15,85,100),db);
        addMove(new Move(35,"Wrap","Normal",20,15,90),db);
        addMove(new Move(36,"Take Down","Normal",20,90,85),db);
        addMove(new Move(37,"Thrash","Normal",10,120,100),db);
        addMove(new Move(38,"Double0Edge","Normal",15,120,100),db);
        addMove(new Move(39,"Tail Whip","Normal",30,0,100),db);
        addMove(new Move(40,"Poison Sting","Poison",35,15,100),db);
        addMove(new Move(41,"Twineedle","Bug",20,25,100),db);
        addMove(new Move(42,"Pin Missile","Bug",20,25,95),db);
        addMove(new Move(43,"Leer","Normal",30,0,100),db);
        addMove(new Move(44,"Bite","Dark",25,60,100),db);
        addMove(new Move(45,"Growl","Normal",40,0,100),db);
        addMove(new Move(46,"Roar","Normal",20,0,0),db);
        addMove(new Move(47,"Sing","Normal",15,0,55),db);
        addMove(new Move(48,"Supersonic","Normal",20,0,55),db);
        addMove(new Move(49,"Sonic Boom","Normal",20,0,90),db);
        addMove(new Move(50,"Disable","Normal",20,0,100),db);
        addMove(new Move(51,"Acid","Poison",30,40,100),db);
        addMove(new Move(52,"Ember","Fire",25,40,100),db);
        addMove(new Move(53,"Flamethrower","Fire",15,90,100),db);
        addMove(new Move(54,"Mist","Ice",30,0,0),db);
        addMove(new Move(55,"Water Gun","Water",25,40,100),db);
        addMove(new Move(56,"Hydro Pump","Water",5,110,80),db);
        addMove(new Move(57,"Surf","Water",15,90,100),db);
        addMove(new Move(58,"Ice Beam","Ice",10,90,100),db);
        addMove(new Move(59,"Blizzard","Ice",5,110,70),db);
        addMove(new Move(60,"Psybeam","Psychic",20,65,100),db);
        addMove(new Move(61,"Bubble Beam","Water",20,65,100),db);
        addMove(new Move(62,"Aurora Beam","Ice",20,65,100),db);
        addMove(new Move(63,"Hyper Beam","Normal",5,150,90),db);
        addMove(new Move(64,"Peck","Flying",35,35,100),db);
        addMove(new Move(65,"Drill Peck","Flying",20,80,100),db);
        addMove(new Move(66,"Submission","Fighting",25,80,80),db);
        addMove(new Move(67,"Low Kick","Fighting",20,0,100),db);
        addMove(new Move(68,"Counter","Fighting",20,0,100),db);
        addMove(new Move(69,"Seismic Toss","Fighting",20,0,100),db);
        addMove(new Move(70,"Strength","Normal",15,80,100),db);
        addMove(new Move(71,"Absorb","Grass",25,20,100),db);
        addMove(new Move(72,"Mega Drain","Grass",15,40,100),db);
        addMove(new Move(73,"Leech Seed","Grass",10,0,90),db);
        addMove(new Move(74,"Growth","Normal",20,0,0),db);
        addMove(new Move(75,"Razor Leaf","Grass",25,55,95),db);
        addMove(new Move(76,"Solar Beam","Grass",10,120,100),db);
        addMove(new Move(77,"Poison Powder","Poison",35,0,75),db);
        addMove(new Move(78,"Stun Spore","Grass",30,0,75),db);
        addMove(new Move(79,"Sleep Powder","Grass",15,0,75),db);
        addMove(new Move(80,"Petal Dance","Grass",10,120,100),db);
        addMove(new Move(81,"String Shot","Bug",40,0,95),db);
        addMove(new Move(82,"Dragon Rage","Dragon",10,0,100),db);
        addMove(new Move(83,"Fire Spin","Fire",15,35,85),db);
        addMove(new Move(84,"Thunder Shock","Electric",30,40,100),db);
        addMove(new Move(85,"Thunderbolt","Electric",15,90,100),db);
        addMove(new Move(86,"Thunder Wave","Electric",20,0,100),db);
        addMove(new Move(87,"Thunder","Electric",10,110,70),db);
        addMove(new Move(88,"Rock Throw","Rock",15,50,90),db);
        addMove(new Move(89,"Earthquake","Ground",10,100,100),db);
        addMove(new Move(90,"Fissure","Ground",5,0,0 ),db);
        addMove(new Move(91,"Dig","Ground",10,80,100),db);
        addMove(new Move(92,"Toxic","Poison",10,0,90),db);
        addMove(new Move(93,"Confusion","Psychic",25,50,100),db);
        addMove(new Move(94,"Psychic","Psychic",10,90,100),db);
        addMove(new Move(95,"Hypnosis","Psychic",20,0,60),db);
        addMove(new Move(96,"Meditate","Psychic",40,0,0),db);
        addMove(new Move(97,"Agility","Psychic",30,0,0),db);
        addMove(new Move(98,"Quick Attack","Normal",30,40,100),db);
        addMove(new Move(99,"Rage","Normal",20,20,100),db);
        addMove(new Move(100,"Teleport","Psychic",20,0,0),db);
        addMove(new Move(101,"Night Shade","Ghost",15,0,100),db);
        addMove(new Move(102,"Mimic","Normal",10,0,100),db);
        addMove(new Move(103,"Screech","Normal",40,0,85),db);
        addMove(new Move(104,"Double Team","Normal",15,0,0),db);
        addMove(new Move(105,"Recover","Normal",10,0,0),db);
        addMove(new Move(106,"Harden","Normal",30,0,0),db);
        addMove(new Move(107,"Minimize","Normal",10,0,0),db);
        addMove(new Move(108,"Smokescreen","Normal",20,0,100),db);
        addMove(new Move(109,"Confuse Ray","Ghost",10,0,100),db);
        addMove(new Move(110,"Withdraw","Water",40,0,0),db);
        addMove(new Move(111,"Defense Curl","Normal",40,0,0),db);
        addMove(new Move(112,"Barrier","Psychic",20,0,0),db);
        addMove(new Move(113,"Light Screen","Psychic",30,0,0),db);
        addMove(new Move(114,"Haze","Ice",30,0,0),db);
        addMove(new Move(115,"Reflect","Psychic",20,0,0),db);
        addMove(new Move(116,"Focus Energy","Normal",30,0,0),db);
        addMove(new Move(117,"Bide","Normal",10,0,100),db);
        addMove(new Move(118,"Metronome","Normal",10,0,0),db);
        addMove(new Move(119,"Mirror Move","Flying",20,0,0),db);
        addMove(new Move(120,"Self0Destruct","Normal",5,200,100),db);
        addMove(new Move(121,"Egg Bomb","Normal",10,100,75),db);
        addMove(new Move(122,"Lick","Ghost",30,30,100),db);
        addMove(new Move(123,"Smog","Poison",20,30,70),db);
        addMove(new Move(124,"Sludge","Poison",20,65,100),db);
        addMove(new Move(125,"Bone Club","Ground",20,65,85),db);
        addMove(new Move(126,"Fire Blast","Fire",5,110,85),db);
        addMove(new Move(127,"Waterfall","Water",15,80,100),db);
        addMove(new Move(128,"Clamp","Water",15,35,85),db);
        addMove(new Move(129,"Swift","Normal",20,60,0),db);
        addMove(new Move(130,"Skull Bash","Normal",10,130,100),db);
        addMove(new Move(131,"Spike Cannon","Normal",15,20,100),db);
        addMove(new Move(132,"Constrict","Normal",35,10,100),db);
        addMove(new Move(133,"Amnesia","Psychic",20,0,0),db);
        addMove(new Move(134,"Kinesis","Psychic",15,0,80),db);
        addMove(new Move(135,"Soft0Boiled","Normal",10,0,0),db);
        addMove(new Move(136,"High Jump Kick","Fighting",10,130,90),db);
        addMove(new Move(137,"Glare","Normal",30,0,100),db);
        addMove(new Move(138,"Dream Eater","Psychic",15,100,100),db);
        addMove(new Move(139,"Poison Gas","Poison",40,0,90),db);
        addMove(new Move(140,"Barrage","Normal",20,15,85),db);
        addMove(new Move(141,"Leech Life","Bug",15,20,100),db);
        addMove(new Move(142,"Lovely Kiss","Normal",10,0,75),db);
        addMove(new Move(143,"Sky Attack","Flying",5,140,90),db);
        addMove(new Move(144,"Transform","Normal",10,0,0),db);
        addMove(new Move(145,"Bubble","Water",30,40,100),db);
        addMove(new Move(146,"Dizzy Punch","Normal",10,70,100),db);
        addMove(new Move(147,"Spore","Grass",15,0,100),db);
        addMove(new Move(148,"Flash","Normal",20,0,100),db);
        addMove(new Move(149,"Psywave","Psychic",15,0,100),db);
        addMove(new Move(150,"Splash","Normal",40,0,0),db);
        addMove(new Move(151,"Acid Armor","Poison",20,0,0),db);
        addMove(new Move(152,"Crabhammer","Water",10,100,90),db);
        addMove(new Move(153,"Explosion","Normal",5,250,100),db);
        addMove(new Move(154,"Fury Swipes","Normal",15,18,80),db);
        addMove(new Move(155,"Bonemerang","Ground",10,50,90),db);
        addMove(new Move(156,"Rest","Psychic",10,0,0),db);
        addMove(new Move(157,"Rock Slide","Rock",10,75,90),db);
        addMove(new Move(158,"Hyper Fang","Normal",15,80,90),db);
        addMove(new Move(159,"Sharpen","Normal",30,0,0),db);
        addMove(new Move(160,"Conversion","Normal",30,0,0),db);
        addMove(new Move(161,"Tri Attack","Normal",10,80,100),db);
        addMove(new Move(162,"Super Fang","Normal",10,0,90),db);
        addMove(new Move(163,"Slash","Normal",20,70,100),db);
        addMove(new Move(164,"Substitute","Normal",10,0,0),db);
        addMove(new Move(165,"Struggle","Normal",1,50,0),db);
        addMove(new Move(166,"Sketch","Normal",1,0,0),db);
        addMove(new Move(167,"Triple Kick","Fighting",10,10,90),db);
        addMove(new Move(168,"Thief","Dark",25,60,100),db);
        addMove(new Move(169,"Spider Web","Bug",10,0,100),db);
        addMove(new Move(170,"Mind Reader","Normal",5,0,100),db);
        addMove(new Move(171,"Nightmare","Ghost",15,0,100),db);
        addMove(new Move(172,"Flame Wheel","Fire",25,60,100),db);
        addMove(new Move(173,"Snore","Normal",15,50,100),db);
        addMove(new Move(174,"Curse","Ghost",10,0,0),db);
        addMove(new Move(175,"Flail","Normal",15,0,100),db);
        addMove(new Move(176,"Conversion 2","Normal",30,0,100),db);
        addMove(new Move(177,"Aeroblast","Flying",5,100,95),db);
        addMove(new Move(178,"Cotton Spore","Grass",40,0,100),db);
        addMove(new Move(179,"Reversal","Fighting",15,0,100),db);
        addMove(new Move(180,"Spite","Ghost",10,0,100),db);
        addMove(new Move(181,"Powder Snow","Ice",25,40,100),db);
        addMove(new Move(182,"Protect","Normal",10,0,0),db);
        addMove(new Move(183,"Mach Punch","Fighting",30,40,100),db);
        addMove(new Move(184,"Scary Face","Normal",10,0,100),db);
        addMove(new Move(185,"Feint Attack","Dark",20,60,0),db);
        addMove(new Move(186,"Sweet Kiss","Fairy",10,0,75),db);
        addMove(new Move(187,"Belly Drum","Normal",10,0,0),db);
        addMove(new Move(188,"Sludge Bomb","Poison",10,90,100),db);
        addMove(new Move(189,"Mud0Slap","Ground",10,20,100),db);
        addMove(new Move(190,"Octazooka","Water",10,65,85),db);
        addMove(new Move(191,"Spikes","Ground",20,0,0),db);
        addMove(new Move(192,"Zap Cannon","Electric",5,120,50),db);
        addMove(new Move(193,"Foresight","Normal",40,0,100),db);
        addMove(new Move(194,"Destiny Bond","Ghost",5,0,0),db);
        addMove(new Move(195,"Perish Song","Normal",5,0,0),db);
        addMove(new Move(196,"Icy Wind","Ice",15,55,95),db);
        addMove(new Move(197,"Detect","Fighting",5,0,0),db);
        addMove(new Move(198,"Bone Rush","Ground",10,25,90),db);
        addMove(new Move(199,"Lock0On","Normal",5,0,100),db);
        addMove(new Move(200,"Outrage","Dragon",10,120,100),db);
        addMove(new Move(201,"Sandstorm","Rock",10,0,0),db);
        addMove(new Move(202,"Giga Drain","Grass",10,75,100),db);
        addMove(new Move(203,"Endure","Normal",10,0,0),db);
        addMove(new Move(204,"Charm","Fairy",20,0,100),db);
        addMove(new Move(205,"Rollout","Rock",20,30,90),db);
        addMove(new Move(206,"False Swipe","Normal",40,40,100),db);
        addMove(new Move(207,"Swagger","Normal",15,0,90),db);
        addMove(new Move(208,"Milk Drink","Normal",10,0,0),db);
        addMove(new Move(209,"Spark","Electric",20,65,100),db);
        addMove(new Move(210,"Fury Cutter","Bug",20,40,95),db);
        addMove(new Move(211,"Steel Wing","Steel",25,70,90),db);
        addMove(new Move(212,"Mean Look","Normal",5,0,100),db);
        addMove(new Move(213,"Attract","Normal",15,0,100),db);
        addMove(new Move(214,"Sleep Talk","Normal",10,0,0),db);
        addMove(new Move(215,"Heal Bell","Normal",5,0,0),db);
        addMove(new Move(216,"Return","Normal",20,0,100),db);
        addMove(new Move(217,"Present","Normal",15,0,90),db);
        addMove(new Move(218,"Frustration","Normal",20,0,100),db);
        addMove(new Move(219,"Safeguard","Normal",25,0,0),db);
        addMove(new Move(220,"Pain Split","Normal",20,0,100),db);
        addMove(new Move(221,"Sacred Fire","Fire",5,100,95),db);
        addMove(new Move(222,"Magnitude","Ground",30,0,100),db);
        addMove(new Move(223,"Dynamic Punch","Fighting",5,100,50),db);
        addMove(new Move(224,"Megahorn","Bug",10,120,85),db);
        addMove(new Move(225,"Dragon Breath","Dragon",20,60,100),db);
        addMove(new Move(226,"Baton Pass","Normal",40,0,0),db);
        addMove(new Move(227,"Encore","Normal",5,0,100),db);
        addMove(new Move(228,"Pursuit","Dark",20,40,100),db);
        addMove(new Move(229,"Rapid Spin","Normal",40,20,100),db);
        addMove(new Move(230,"Sweet Scent","Normal",20,0,100),db);
        addMove(new Move(231,"Iron Tail","Steel",15,100,75),db);
        addMove(new Move(232,"Metal Claw","Steel",35,50,95),db);
        addMove(new Move(233,"Vital Throw","Fighting",10,70,0),db);
        addMove(new Move(234,"Morning Sun","Normal",5,0,0),db);
        addMove(new Move(235,"Synthesis","Grass",5,0,0),db);
        addMove(new Move(236,"Moonlight","Fairy",5,0,0),db);
        addMove(new Move(237,"Hidden Power","Normal",15,60,100),db);
        addMove(new Move(238,"Cross Chop","Fighting",5,100,80),db);
        addMove(new Move(239,"Twister","Dragon",20,40,100),db);
        addMove(new Move(240,"Rain Dance","Water",5,0,0),db);
        addMove(new Move(241,"Sunny Day","Fire",5,0,0),db);
        addMove(new Move(242,"Crunch","Dark",15,80,100),db);
        addMove(new Move(243,"Mirror Coat","Psychic",20,0,100),db);
        addMove(new Move(244,"Psych Up","Normal",10,0,0),db);
        addMove(new Move(245,"Extreme Speed","Normal",5,80,100),db);
        addMove(new Move(246,"Ancient Power","Rock",5,60,100),db);
        addMove(new Move(247,"Shadow Ball","Ghost",15,80,100),db);
        addMove(new Move(248,"Future Sight","Psychic",10,120,100),db);
        addMove(new Move(249,"Rock Smash","Fighting",15,40,100),db);
        addMove(new Move(250,"Whirlpool","Water",15,35,85),db);
        addMove(new Move(251,"Beat Up","Dark",10,0,100),db);
        addMove(new Move(252,"Fake Out","Normal",10,40,100),db);
        addMove(new Move(253,"Uproar","Normal",10,90,100),db);
        addMove(new Move(254,"Stockpile","Normal",20,0,0),db);
        addMove(new Move(255,"Spit Up","Normal",10,0,100),db);
        addMove(new Move(256,"Swallow","Normal",10,0,0),db);
        addMove(new Move(257,"Heat Wave","Fire",10,95,90),db);
        addMove(new Move(258,"Hail","Ice",10,0,0),db);
        addMove(new Move(259,"Torment","Dark",15,0,100),db);
        addMove(new Move(260,"Flatter","Dark",15,0,100),db);
        addMove(new Move(261,"Will0O0Wisp","Fire",15,0,85),db);
        addMove(new Move(262,"Memento","Dark",10,0,100),db);
        addMove(new Move(263,"Facade","Normal",20,70,100),db);
        addMove(new Move(264,"Focus Punch","Fighting",20,150,100),db);
        addMove(new Move(265,"Smelling Salts","Normal",10,70,100),db);
        addMove(new Move(266,"Follow Me","Normal",20,0,100),db);
        addMove(new Move(267,"Nature Power","Normal",20,0,0),db);
        addMove(new Move(268,"Charge","Electric",20,0,0),db);
        addMove(new Move(269,"Taunt","Dark",20,0,100),db);
        addMove(new Move(270,"Helping Hand","Normal",20,0,0),db);
        addMove(new Move(271,"Trick","Psychic",10,0,100),db);
        addMove(new Move(272,"Role Play","Psychic",10,0,0),db);
        addMove(new Move(273,"Wish","Normal",10,0,0),db);
        addMove(new Move(274,"Assist","Normal",20,0,0),db);
        addMove(new Move(275,"Ingrain","Grass",20,0,0),db);
        addMove(new Move(276,"Superpower","Fighting",5,120,100),db);
        addMove(new Move(277,"Magic Coat","Psychic",15,0,0),db);
        addMove(new Move(278,"Recycle","Normal",10,0,100),db);
        addMove(new Move(279,"Revenge","Fighting",10,60,100),db);
        addMove(new Move(280,"Brick Break","Fighting",15,75,100),db);
        addMove(new Move(281,"Yawn","Normal",10,0,100),db);
        addMove(new Move(282,"Knock Off","Dark",20,65,100),db);
        addMove(new Move(283,"Endeavor","Normal",5,0,100),db);
        addMove(new Move(284,"Eruption","Fire",5,0,100),db);
        addMove(new Move(285,"Skill Swap","Psychic",10,0,100),db);
        addMove(new Move(286,"Imprison","Psychic",10,0,100),db);
        addMove(new Move(287,"Refresh","Normal",20,0,100),db);
        addMove(new Move(288,"Grudge","Ghost",5,0,100),db);
        addMove(new Move(289,"Snatch","Dark",10,0,100),db);
        addMove(new Move(290,"Secret Power","Normal",20,70,100),db);
        addMove(new Move(291,"Dive","Water",10,80,100),db);
        addMove(new Move(292,"Arm Thrust","Fighting",20,15,100),db);
        addMove(new Move(293,"Camouflage","Normal",20,0,100),db);
        addMove(new Move(294,"Tail Glow","Bug",20,0,100),db);
        addMove(new Move(295,"Luster Purge","Psychic",5,70,100),db);
        addMove(new Move(296,"Mist Ball","Psychic",5,70,100),db);
        addMove(new Move(297,"Feather Dance","Flying",15,0,100),db);
        addMove(new Move(298,"Teeter Dance","Normal",20,0,100),db);
        addMove(new Move(299,"Blaze Kick","Fire",10,85,90),db);
        addMove(new Move(300,"Mud Sport","Ground",15,0,100),db);
        addMove(new Move(301,"Ice Ball","Ice",20,30,90),db);
        addMove(new Move(302,"Needle Arm","Grass",15,60,100),db);
        addMove(new Move(303,"Slack Off","Normal",10,0,100),db);
        addMove(new Move(304,"Hyper Voice","Normal",10,90,100),db);
        addMove(new Move(305,"Poison Fang","Poison",15,50,100),db);
        addMove(new Move(306,"Crush Claw","Normal",10,75,95),db);
        addMove(new Move(307,"Blast Burn","Fire",5,150,90),db);
        addMove(new Move(308,"Hydro Cannon","Water",5,150,90),db);
        addMove(new Move(309,"Meteor Mash","Steel",10,90,90),db);
        addMove(new Move(310,"Astonish","Ghost",15,30,100),db);
        addMove(new Move(311,"Weather Ball","Normal",10,50,100),db);
        addMove(new Move(312,"Aromatherapy","Grass",5,0,0),db);
        addMove(new Move(313,"Fake Tears","Dark",20,0,100),db);
        addMove(new Move(314,"Air Cutter","Flying",25,60,95),db);
        addMove(new Move(315,"Overheat","Fire",5,130,90),db);
        addMove(new Move(316,"Odor Sleuth","Normal",40,0,100),db);
        addMove(new Move(317,"Rock Tomb","Rock",15,60,95),db);
        addMove(new Move(318,"Silver Wind","Bug",5,60,100),db);
        addMove(new Move(319,"Metal Sound","Steel",40,0,85),db);
        addMove(new Move(320,"Grass Whistle","Grass",15,0,55),db);
        addMove(new Move(321,"Tickle","Normal",20,0,100),db);
        addMove(new Move(322,"Cosmic Power","Psychic",20,0,0),db);
        addMove(new Move(323,"Water Spout","Water",5,0,100),db);
        addMove(new Move(324,"Signal Beam","Bug",15,75,100),db);
        addMove(new Move(325,"Shadow Punch","Ghost",20,60,0),db);
        addMove(new Move(326,"Extrasensory","Psychic",20,80,100),db);
        addMove(new Move(327,"Sky Uppercut","Fighting",15,85,90),db);
        addMove(new Move(328,"Sand Tomb","Ground",15,35,85),db);
        addMove(new Move(329,"Sheer Cold","Ice",5,0,0),db);
        addMove(new Move(330,"Muddy Water","Water",10,90,85),db);
        addMove(new Move(331,"Bullet Seed","Grass",30,25,100),db);
        addMove(new Move(332,"Aerial Ace","Flying",20,60,0),db);
        addMove(new Move(333,"Icicle Spear","Ice",30,25,100),db);
        addMove(new Move(334,"Iron Defense","Steel",15,0,0),db);
        addMove(new Move(335,"Block","Normal",5,0,100),db);
        addMove(new Move(336,"Howl","Normal",40,0,0),db);
        addMove(new Move(337,"Dragon Claw","Dragon",15,80,100),db);
        addMove(new Move(338,"Frenzy Plant","Grass",5,150,90),db);
        addMove(new Move(339,"Bulk Up","Fighting",20,0,0),db);
        addMove(new Move(340,"Bounce","Flying",5,85,85),db);
        addMove(new Move(341,"Mud Shot","Ground",15,55,95),db);
        addMove(new Move(342,"Poison Tail","Poison",25,50,100),db);
        addMove(new Move(343,"Covet","Normal",25,60,100),db);
        addMove(new Move(344,"Volt Tackle","Electric",15,120,100),db);
        addMove(new Move(345,"Magical Leaf","Grass",20,60,0),db);
        addMove(new Move(346,"Water Sport","Water",15,0,100),db);
        addMove(new Move(347,"Calm Mind","Psychic",20,0,0),db);
        addMove(new Move(348,"Leaf Blade","Grass",15,90,100),db);
        addMove(new Move(349,"Dragon Dance","Dragon",20,0,0),db);
        addMove(new Move(350,"Rock Blast","Rock",10,25,90),db);
        addMove(new Move(351,"Shock Wave","Electric",20,60,0),db);
        addMove(new Move(352,"Water Pulse","Water",20,60,100),db);
        addMove(new Move(353,"Doom Desire","Steel",5,140,100),db);
        addMove(new Move(354,"Psycho Boost","Psychic",5,140,90),db);
        addMove(new Move(355,"Roost","Flying",10,0,0),db);
        addMove(new Move(356,"Gravity","Psychic",5,0,0),db);
        addMove(new Move(357,"Miracle Eye","Psychic",40,0,0),db);
        addMove(new Move(358,"Wake0Up Slap","Fighting",10,70,100),db);
        addMove(new Move(359,"Hammer Arm","Fighting",10,100,90),db);
        addMove(new Move(360,"Gyro Ball","Steel",5,0,100),db);
        addMove(new Move(361,"Healing Wish","Psychic",10,0,0),db);
        addMove(new Move(362,"Brine","Water",10,65,100),db);
        addMove(new Move(363,"Natural Gift","Normal",15,0,100),db);
        addMove(new Move(364,"Feint","Normal",10,30,100),db);
        addMove(new Move(365,"Pluck","Flying",20,60,100),db);
        addMove(new Move(366,"Tailwind","Flying",15,0,0),db);
        addMove(new Move(367,"Acupressure","Normal",30,0,0),db);
        addMove(new Move(368,"Metal Burst","Steel",10,0,100),db);
        addMove(new Move(369,"U0turn","Bug",20,70,100),db);
        addMove(new Move(370,"Close Combat","Fighting",5,120,100),db);
        addMove(new Move(371,"Payback","Dark",10,50,100),db);
        addMove(new Move(372,"Assurance","Dark",10,60,100),db);
        addMove(new Move(373,"Embargo","Dark",15,0,100),db);
        addMove(new Move(374,"Fling","Dark",10,0,100),db);
        addMove(new Move(375,"Psycho Shift","Psychic",10,0,100),db);
        addMove(new Move(376,"Trump Card","Normal",5,0,0),db);
        addMove(new Move(377,"Heal Block","Psychic",15,0,100),db);
        addMove(new Move(378,"Wring Out","Normal",5,0,100),db);
        addMove(new Move(379,"Power Trick","Psychic",10,0,0),db);
        addMove(new Move(380,"Gastro Acid","Poison",10,0,100),db);
        addMove(new Move(381,"Lucky Chant","Normal",30,0,0),db);
        addMove(new Move(382,"Me First","Normal",20,0,0),db);
        addMove(new Move(383,"Copycat","Normal",20,0,0),db);
        addMove(new Move(384,"Power Swap","Psychic",10,0,0),db);
        addMove(new Move(385,"Guard Swap","Psychic",10,0,0),db);
        addMove(new Move(386,"Punishment","Dark",5,0,100),db);
        addMove(new Move(387,"Last Resort","Normal",5,140,100),db);
        addMove(new Move(388,"Worry Seed","Grass",10,0,100),db);
        addMove(new Move(389,"Sucker Punch","Dark",5,80,100),db);
        addMove(new Move(390,"Toxic Spikes","Poison",20,0,0),db);
        addMove(new Move(391,"Heart Swap","Psychic",10,0,0),db);
        addMove(new Move(392,"Aqua Ring","Water",20,0,0),db);
        addMove(new Move(393,"Magnet Rise","Electric",10,0,0),db);
        addMove(new Move(394,"Flare Blitz","Fire",15,120,100),db);
        addMove(new Move(395,"Force Palm","Fighting",10,60,100),db);
        addMove(new Move(396,"Aura Sphere","Fighting",20,80,0),db);
        addMove(new Move(397,"Rock Polish","Rock",20,0,0),db);
        addMove(new Move(398,"Poison Jab","Poison",20,80,100),db);
        addMove(new Move(399,"Dark Pulse","Dark",15,80,100),db);
        addMove(new Move(400,"Night Slash","Dark",15,70,100),db);
        addMove(new Move(401,"Aqua Tail","Water",10,90,90),db);
        addMove(new Move(402,"Seed Bomb","Grass",15,80,100),db);
        addMove(new Move(403,"Air Slash","Flying",15,75,95),db);
        addMove(new Move(404,"X0Scissor","Bug",15,80,100),db);
        addMove(new Move(405,"Bug Buzz","Bug",10,90,100),db);
        addMove(new Move(406,"Dragon Pulse","Dragon",10,85,100),db);
        addMove(new Move(407,"Dragon Rush","Dragon",10,100,75),db);
        addMove(new Move(408,"Power Gem","Rock",20,80,100),db);
        addMove(new Move(409,"Drain Punch","Fighting",10,75,100),db);
        addMove(new Move(410,"Vacuum Wave","Fighting",30,40,100),db);
        addMove(new Move(411,"Focus Blast","Fighting",5,120,70),db);
        addMove(new Move(412,"Energy Ball","Grass",10,90,100),db);
        addMove(new Move(413,"Brave Bird","Flying",15,120,100),db);
        addMove(new Move(414,"Earth Power","Ground",10,90,100),db);
        addMove(new Move(415,"Switcheroo","Dark",10,0,100),db);
        addMove(new Move(416,"Giga Impact","Normal",5,150,90),db);
        addMove(new Move(417,"Nasty Plot","Dark",20,0,0),db);
        addMove(new Move(418,"Bullet Punch","Steel",30,40,100),db);
        addMove(new Move(419,"Avalanche","Ice",10,60,100),db);
        addMove(new Move(420,"Ice Shard","Ice",30,40,100),db);
        addMove(new Move(421,"Shadow Claw","Ghost",15,70,100),db);
        addMove(new Move(422,"Thunder Fang","Electric",15,65,95),db);
        addMove(new Move(423,"Ice Fang","Ice",15,65,95),db);
        addMove(new Move(424,"Fire Fang","Fire",15,65,95),db);
        addMove(new Move(425,"Shadow Sneak","Ghost",30,40,100),db);
        addMove(new Move(426,"Mud Bomb","Ground",10,65,85),db);
        addMove(new Move(427,"Psycho Cut","Psychic",20,70,100),db);
        addMove(new Move(428,"Zen Headbutt","Psychic",15,80,90),db);
        addMove(new Move(429,"Mirror Shot","Steel",10,65,85),db);
        addMove(new Move(430,"Flash Cannon","Steel",10,80,100),db);
        addMove(new Move(431,"Rock Climb","Normal",20,90,85),db);
        addMove(new Move(432,"Defog","Flying",15,0,0),db);
        addMove(new Move(433,"Trick Room","Psychic",5,0,0),db);
        addMove(new Move(434,"Draco Meteor","Dragon",5,130,90),db);
        addMove(new Move(435,"Discharge","Electric",15,80,100),db);
        addMove(new Move(436,"Lava Plume","Fire",15,80,100),db);
        addMove(new Move(437,"Leaf Storm","Grass",5,130,90),db);
        addMove(new Move(438,"Power Whip","Grass",10,120,85),db);
        addMove(new Move(439,"Rock Wrecker","Rock",5,150,90),db);
        addMove(new Move(440,"Cross Poison","Poison",20,70,100),db);
        addMove(new Move(441,"Gunk Shot","Poison",5,120,80),db);
        addMove(new Move(442,"Iron Head","Steel",15,80,100),db);
        addMove(new Move(443,"Magnet Bomb","Steel",20,60,0),db);
        addMove(new Move(444,"Stone Edge","Rock",5,100,80),db);
        addMove(new Move(445,"Captivate","Normal",20,0,100),db);
        addMove(new Move(446,"Stealth Rock","Rock",20,0,0),db);
        addMove(new Move(447,"Grass Knot","Grass",20,0,100),db);
        addMove(new Move(448,"Chatter","Flying",20,65,100),db);
        addMove(new Move(449,"Judgment","Normal",10,100,100),db);
        addMove(new Move(450,"Bug Bite","Bug",20,60,100),db);
        addMove(new Move(451,"Charge Beam","Electric",10,50,90),db);
        addMove(new Move(452,"Wood Hammer","Grass",15,120,100),db);
        addMove(new Move(453,"Aqua Jet","Water",20,40,100),db);
        addMove(new Move(454,"Attack Order","Bug",15,90,100),db);
        addMove(new Move(455,"Defend Order","Bug",10,0,0),db);
        addMove(new Move(456,"Heal Order","Bug",10,0,0),db);
        addMove(new Move(457,"Head Smash","Rock",5,150,80),db);
        addMove(new Move(458,"Double Hit","Normal",10,35,90),db);
        addMove(new Move(459,"Roar of Time","Dragon",5,150,90),db);
        addMove(new Move(460,"Spacial Rend","Dragon",5,100,95),db);
        addMove(new Move(461,"Lunar Dance","Psychic",10,0,0),db);
        addMove(new Move(462,"Crush Grip","Normal",5,0,100),db);
        addMove(new Move(463,"Magma Storm","Fire",5,100,75),db);
        addMove(new Move(464,"Dark Void","Dark",10,0,80),db);
        addMove(new Move(465,"Seed Flare","Grass",5,120,85),db);
        addMove(new Move(466,"Ominous Wind","Ghost",5,60,100),db);
        addMove(new Move(467,"Shadow Force","Ghost",5,120,100),db);
        addMove(new Move(468,"Hone Claws","Dark",15,0,0),db);
        addMove(new Move(469,"Wide Guard","Rock",10,0,0),db);
        addMove(new Move(470,"Guard Split","Psychic",10,0,0),db);
        addMove(new Move(471,"Power Split","Psychic",10,0,0),db);
        addMove(new Move(472,"Wonder Room","Psychic",10,0,0),db);
        addMove(new Move(473,"Psyshock","Psychic",10,80,100),db);
        addMove(new Move(474,"Venoshock","Poison",10,65,100),db);
        addMove(new Move(475,"Autotomize","Steel",15,0,0),db);
        addMove(new Move(476,"Rage Powder","Bug",20,0,0),db);
        addMove(new Move(477,"Telekinesis","Psychic",15,0,0),db);
        addMove(new Move(478,"Magic Room","Psychic",10,0,0),db);
        addMove(new Move(479,"Smack Down","Rock",15,50,100),db);
        addMove(new Move(480,"Storm Throw","Fighting",10,60,100),db);
        addMove(new Move(481,"Flame Burst","Fire",15,70,100),db);
        addMove(new Move(482,"Sludge Wave","Poison",10,95,100),db);
        addMove(new Move(483,"Quiver Dance","Bug",20,0,0),db);
        addMove(new Move(484,"Heavy Slam","Steel",10,0,100),db);
        addMove(new Move(485,"Synchronoise","Psychic",15,120,100),db);
        addMove(new Move(486,"Electro Ball","Electric",10,0,100),db);
        addMove(new Move(487,"Soak","Water",20,0,100),db);
        addMove(new Move(488,"Flame Charge","Fire",20,50,100),db);
        addMove(new Move(489,"Coil","Poison",20,0,0),db);
        addMove(new Move(490,"Low Sweep","Fighting",20,65,100),db);
        addMove(new Move(491,"Acid Spray","Poison",20,40,100),db);
        addMove(new Move(492,"Foul Play","Dark",15,95,100),db);
        addMove(new Move(493,"Simple Beam","Normal",15,0,100),db);
        addMove(new Move(494,"Entrainment","Normal",15,0,100),db);
        addMove(new Move(495,"After You","Normal",15,0,0),db);
        addMove(new Move(496,"Round","Normal",15,60,100),db);
        addMove(new Move(497,"Echoed Voice","Normal",15,40,100),db);
        addMove(new Move(498,"Chip Away","Normal",20,70,100),db);
        addMove(new Move(499,"Clear Smog","Poison",15,50,0),db);
        addMove(new Move(500,"Stored Power","Psychic",10,20,100),db);
        addMove(new Move(501,"Quick Guard","Fighting",15,0,0),db);
        addMove(new Move(502,"Ally Switch","Psychic",15,0,0),db);
        addMove(new Move(503,"Scald","Water",15,80,100),db);
        addMove(new Move(504,"Shell Smash","Normal",15,0,0),db);
        addMove(new Move(505,"Heal Pulse","Psychic",10,0,0),db);
        addMove(new Move(506,"Hex","Ghost",10,65,100),db);
        addMove(new Move(507,"Sky Drop","Flying",10,60,100),db);
        addMove(new Move(508,"Shift Gear","Steel",10,0,0),db);
        addMove(new Move(509,"Circle Throw","Fighting",10,60,90),db);
        addMove(new Move(510,"Incinerate","Fire",15,60,100),db);
        addMove(new Move(511,"Quash","Dark",15,0,100),db);
        addMove(new Move(512,"Acrobatics","Flying",15,55,100),db);
        addMove(new Move(513,"Reflect Type","Normal",15,0,0),db);
        addMove(new Move(514,"Retaliate","Normal",5,70,100),db);
        addMove(new Move(515,"Final Gambit","Fighting",5,0,100),db);
        addMove(new Move(516,"Bestow","Normal",15,0,0),db);
        addMove(new Move(517,"Inferno","Fire",5,100,50),db);
        addMove(new Move(518,"Water Pledge","Water",10,80,100),db);
        addMove(new Move(519,"Fire Pledge","Fire",10,80,100),db);
        addMove(new Move(520,"Grass Pledge","Grass",10,80,100),db);
        addMove(new Move(521,"Volt Switch","Electric",20,70,100),db);
        addMove(new Move(522,"Struggle Bug","Bug",20,50,100),db);
        addMove(new Move(523,"Bulldoze","Ground",20,60,100),db);
        addMove(new Move(524,"Frost Breath","Ice",10,60,90),db);
        addMove(new Move(525,"Dragon Tail","Dragon",10,60,90),db);
        addMove(new Move(526,"Work Up","Normal",30,0,0),db);
        addMove(new Move(527,"Electroweb","Electric",15,55,95),db);
        addMove(new Move(528,"Wild Charge","Electric",15,90,100),db);
        addMove(new Move(529,"Drill Run","Ground",10,80,95),db);
        addMove(new Move(530,"Dual Chop","Dragon",15,40,90),db);
        addMove(new Move(531,"Heart Stamp","Psychic",25,60,100),db);
        addMove(new Move(532,"Horn Leech","Grass",10,75,100),db);
        addMove(new Move(533,"Sacred Sword","Fighting",15,90,100),db);
        addMove(new Move(534,"Razor Shell","Water",10,75,95),db);
        addMove(new Move(535,"Heat Crash","Fire",10,0,100),db);
        addMove(new Move(536,"Leaf Tornado","Grass",10,65,90),db);
        addMove(new Move(537,"Steamroller","Bug",20,65,100),db);
        addMove(new Move(538,"Cotton Guard","Grass",10,0,0),db);
        addMove(new Move(539,"Night Daze","Dark",10,85,95),db);
        addMove(new Move(540,"Psystrike","Psychic",10,100,100),db);
        addMove(new Move(541,"Tail Slap","Normal",10,25,85),db);
        addMove(new Move(542,"Hurricane","Flying",10,110,70),db);
        addMove(new Move(543,"Head Charge","Normal",15,120,100),db);
        addMove(new Move(544,"Gear Grind","Steel",15,50,85),db);
        addMove(new Move(545,"Searing Shot","Fire",5,100,100),db);
        addMove(new Move(546,"Techno Blast","Normal",5,120,100),db);
        addMove(new Move(547,"Relic Song","Normal",10,75,100),db);
        addMove(new Move(548,"Secret Sword","Fighting",10,85,100),db);
        addMove(new Move(549,"Glaciate","Ice",10,65,95),db);
        addMove(new Move(550,"Bolt Strike","Electric",5,130,85),db);
        addMove(new Move(551,"Blue Flare","Fire",5,130,85),db);
        addMove(new Move(552,"Fiery Dance","Fire",10,80,100),db);
        addMove(new Move(553,"Freeze Shock","Ice",5,140,90),db);
        addMove(new Move(554,"Ice Burn","Ice",5,140,90),db);
        addMove(new Move(555,"Snarl","Dark",15,55,95),db);
        addMove(new Move(556,"Icicle Crash","Ice",10,85,90),db);
        addMove(new Move(557,"V0create","Fire",5,180,95),db);
        addMove(new Move(558,"Fusion Flare","Fire",5,100,100),db);
        addMove(new Move(559,"Fusion Bolt","Electric",5,100,100),db);
        addMove(new Move(560,"Flying Press","Fighting",10,80,95),db);
        addMove(new Move(561,"Mat Block","Fighting",10,0,0),db);
        addMove(new Move(562,"Belch","Poison",10,120,90),db);
        addMove(new Move(563,"Rototiller","Ground",10,0,0),db);
        addMove(new Move(564,"Sticky Web","Bug",20,0,0),db);
        addMove(new Move(565,"Fell Stinger","Bug",25,30,100),db);
        addMove(new Move(566,"Phantom Force","Ghost",10,90,100),db);
        addMove(new Move(567,"Trick0or0Treat","Ghost",20,0,100),db);
        addMove(new Move(568,"Noble Roar","Normal",30,0,100),db);
        addMove(new Move(569,"Ion Deluge","Electric",25,0,0),db);
        addMove(new Move(570,"Parabolic Charge","Electric",20,50,100),db);
        addMove(new Move(571,"Forest's Curse","Grass",20,0,100),db);
        addMove(new Move(572,"Petal Blizzard","Grass",15,90,100),db);
        addMove(new Move(573,"Freeze0Dry","Ice",20,70,100),db);
        addMove(new Move(574,"Disarming Voice","Fairy",15,40,0),db);
        addMove(new Move(575,"Parting Shot","Dark",20,0,100),db);
        addMove(new Move(576,"Topsy0Turvy","Dark",20,0,100),db);
        addMove(new Move(577,"Draining Kiss","Fairy",10,50,100),db);
        addMove(new Move(578,"Crafty Shield","Fairy",10,0,0),db);
        addMove(new Move(579,"Flower Shield","Fairy",10,0,0),db);
        addMove(new Move(580,"Grassy Terrain","Grass",10,0,0),db);
        addMove(new Move(581,"Misty Terrain","Fairy",10,0,0),db);
        addMove(new Move(582,"Electrify","Electric",20,0,0),db);
        addMove(new Move(583,"Play Rough","Fairy",10,90,90),db);
        addMove(new Move(584,"Fairy Wind","Fairy",30,40,0),db);
        addMove(new Move(585,"Moonblast","Fairy",15,95,100),db);
        addMove(new Move(586,"Boomburst","Normal",10,140,100),db);
        addMove(new Move(587,"Fairy Lock","Fairy",10,0,0),db);
        addMove(new Move(588,"King's Shield","Steel",10,0,0),db);
        addMove(new Move(589,"Play Nice","Normal",20,0,0),db);
        addMove(new Move(590,"Confide","Normal",20,0,0),db);
        addMove(new Move(591,"Diamond Storm","Rock",5,100,95),db);
        addMove(new Move(592,"Steam Eruption","Water",5,110,95),db);
        addMove(new Move(593,"Hyperspace Hole","Psychic",5,80,0),db);
        addMove(new Move(594,"Water Shuriken","Water",20,15,100),db);
        addMove(new Move(595,"Mystical Fire","Fire",10,65,100),db);
        addMove(new Move(596,"Spiky Shield","Grass",10,0,0),db);
        addMove(new Move(597,"Aromatic Mist","Fairy",20,0,0),db);
        addMove(new Move(598,"Eerie Impulse","Electric",15,0,100),db);
        addMove(new Move(599,"Venom Drench","Poison",20,0,100),db);
        addMove(new Move(600,"Powder","Bug",20,0,100),db);
        addMove(new Move(601,"Geomancy","Fairy",10,0,0),db);
        addMove(new Move(602,"Magnetic Flux","Electric",20,0,0),db);
        addMove(new Move(603,"Happy Hour","Normal",30,0,0),db);
        addMove(new Move(604,"Electric Terrain","Electric",10,0,0),db);
        addMove(new Move(605,"Dazzling Gleam","Fairy",10,80,100),db);
        addMove(new Move(606,"Celebrate","Normal",40,0,0),db);
        addMove(new Move(607,"Hold Hands","Normal",40,0,0),db);
        addMove(new Move(608,"Baby0Doll Eyes","Fairy",30,0,100),db);
        addMove(new Move(609,"Nuzzle","Electric",20,20,100),db);
        addMove(new Move(610,"Hold Back","Normal",40,40,100),db);
        addMove(new Move(611,"Infestation","Bug",20,20,100),db);
        addMove(new Move(612,"Power0Up Punch","Fighting",20,40,100),db);
        addMove(new Move(613,"Oblivion Wing","Flying",10,80,100),db);
        addMove(new Move(614,"Thousand Arrows","Ground",10,90,100),db);
        addMove(new Move(615,"Thousand Waves","Ground",10,90,100),db);
        addMove(new Move(616,"Land's Wrath","Ground",10,90,100),db);
        addMove(new Move(617,"Light of Ruin","Fairy",5,140,90),db);
        addMove(new Move(618,"Origin Pulse","Water",10,110,85),db);
        addMove(new Move(619,"Precipice Blades","Ground",10,120,85),db);
        addMove(new Move(620,"Dragon Ascent","Flying",5,120,100),db);
        addMove(new Move(621,"Hyperspace Fury","Dark",5,100,0),db);


        //db.close();
    }
}
