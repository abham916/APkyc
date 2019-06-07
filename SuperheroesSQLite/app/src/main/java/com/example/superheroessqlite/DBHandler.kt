package com.example.superheroessqlite

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class DBHandler(
    private  val context: MainActivity?
) : SQLiteOpenHelper(context, DBHandler.DB_NAME, null, DBHandler.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        Log.e("YC","db start")
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$NAME TEXT," +
                "$POWER INTEGER," +
                "$GENDER TEXT," +
                "$IMAGE INTEGER);"
        val INSERT = "INSERT INTO $TABLE_NAME ($NAME, $POWER, $GENDER, $IMAGE)" +
                "VALUES" +
                "('Superman', 100, 'M', ${getImageID("hero_0")})," +
                "('Spider man', 85, 'M', ${getImageID("hero_1")})," +
                "('Wonder woman', 90, 'F', ${getImageID("hero_2")})," +
                "('Thor', 95, 'M', ${getImageID("hero_3")})," +
                "('Black Panther', 80, 'M', ${getImageID("hero_4")})," +
                "('Batman', 92, 'M', ${getImageID("hero_5")})," +
                "('Cat', 75, 'F', ${getImageID("hero_6")})," +
                "('Invisible Woman', 92, 'F', ${getImageID("hero_7")})," +
                "('Iron man', 97, 'M', ${getImageID("hero_8")})," +
                "('Hulk', 85, 'M', ${getImageID("hero_9")})," +
                "('Aquaman', 75, 'M', ${getImageID("hero_10")});"
        db?.execSQL(CREATE_TABLE)
        Log.e("YC","db create")
        db?.execSQL(INSERT)
        Log.e("YC","db data insert")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun getImageID(imageName: String): Int{
        return context!!.resources.getIdentifier(imageName,"drawable", "com.example.superheroessqlite")
    }

    fun superheroes(context: FragmentActivity?): ArrayList<Hero>{
        val heroes = ArrayList<Hero>()
        val qry = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(qry,null)

        if(cursor == null) Toast.makeText(context, "No data found", Toast.LENGTH_LONG).show()
        else {
            Log.e("YC","data exist")
            while(cursor.moveToNext()){
                val hero = Hero()
                hero.name = cursor.getString(cursor.getColumnIndex(NAME))
                hero.gender = cursor.getString(cursor.getColumnIndex(GENDER))
                hero.power = cursor.getInt(cursor.getColumnIndex(POWER))
                hero.image = cursor.getInt(cursor.getColumnIndex(IMAGE))
                heroes.add(hero)
            }
        }
        cursor.close()
        db.close()
        return heroes
    }

    fun addHero(context: FragmentActivity?, hero: Hero){
        val db = this.writableDatabase
        try {
            db.execSQL("INSERT INTO $TABLE_NAME ($NAME, $POWER, $GENDER, $IMAGE)" +
                    "VALUES ('${hero.name}', ${hero.power}, '${hero.gender}', ${hero.image});")
        } catch (e : Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun updateHero(context: FragmentActivity?, hero: Hero, name: String){
//        val db = this.writableDatabase
//        Log.e("YC",name)
//        try {
//            db.execSQL("UPDATE $TABLE_NAME" +
//                    "SET $NAME = '${hero.name}', $POWER = ${hero.power}, $GENDER = '${hero.gender}', $IMAGE = ${hero.image}" +
//                    "WHERE $NAME = '$name';")
//        } catch (e : Exception){
//            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
//        }
//        db.close()
    }

    fun deleteHero(context: FragmentActivity?, hero: Hero){
//        val db = this.writableDatabase
//        try {
//            db.execSQL("INSERT INTO $TABLE_NAME ($NAME, $POWER, $GENDER, $IMAGE)" +
//                    "VALUES ('${hero.name}', ${hero.power}, '${hero.gender}', ${hero.image});")
//        } catch (e : Exception){
//            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
//        }
//        db.close()
    }





    companion object {
        private val DB_VERSION = 1
        private val DB_NAME = "Superheroes.db"

        val TABLE_NAME = "HeroProfile"
        val ID = "Id"
        val NAME = "Name"
        val POWER = "Power"
        val GENDER = "Gender"
        val IMAGE = "Image"
    }

}