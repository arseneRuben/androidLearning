package learn.android.exoenclassebd.service;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class TeamBdHelper extends SQLiteOpenHelper {
    public TeamBdHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTable = "create table player(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    first_name TEXT,\n" +
                "    last_name TEXT," +
                "number INTEGER," +
                "position INTEGER" +
                ")";
        db.execSQL(queryCreateTable);

        db.execSQL("insert into player (number, first_name, last_name, position) values " +
                "(22, \"Lautaro\", \"Martínez\", 1)," +
                "(10, \"Lionel\", \"Messi\", 1)," +
                "(20, \"Alexis\", \"Mac Allister\", 2)," +
                "(24, \"Enzo\", \"Fernández\",2)," +
                "(7, \"Rodrigo\", \"De Paul\",2)," +
                "(11, \"Ángel\", \"Di María\",2)," +
                "(3, \"Nicolás\", \"Tagliafico\",0)," +
                "(19, \"Nicolás\", \"Otamendi\",0)," +
                "(13, \"Cristian\", \"Romero\",0)," +
                "(26, \"Nahuel\", \"Molina\",0)," +
                "(23, \"Emiliano\", \"Martínez\",3)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
