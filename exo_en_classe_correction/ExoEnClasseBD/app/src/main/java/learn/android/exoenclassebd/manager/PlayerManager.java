package learn.android.exoenclassebd.manager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import learn.android.exoenclassebd.entite.Player;
import learn.android.exoenclassebd.entite.Position;
import learn.android.exoenclassebd.service.ConnexionBd;
public class PlayerManager {
    public static ArrayList<Player> getAll(Context context) {
        ArrayList<Player> retour = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        Cursor cursor = bd.rawQuery("select * from player", null);
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                retour.add(new Player(cursor));
            }
        }
        return retour;
    }
    public static ArrayList<Player> getByPosition(Context context, Position positionToGet) {
        ArrayList<Player> retour = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        Cursor cursor = bd.rawQuery("select * from player where position = ?", new String[]{String.valueOf(Player.getValueFormPosition(positionToGet))});
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                retour.add(new Player(cursor));
            }
        }
        return retour;
    }

    public static Player getById(Context context, int idPlayer){
        Player retour = null;
        Cursor cursor = ConnexionBd.getBd(context).rawQuery("select * from player where id = ?",new String[]{String.valueOf(idPlayer)});
        if(cursor.moveToNext()){
            retour = new Player(cursor);
        }
        return retour;
    }
    public static void update(Context context, Player playerToUpdate){
        ContentValues cv = new ContentValues();
        cv.put("first_name",playerToUpdate.getFirstName());
        cv.put("last_name",playerToUpdate.getLastName());
        cv.put("number",playerToUpdate.getNumber());
        cv.put("position",playerToUpdate.getPosition().ordinal());
        ConnexionBd.getBd(context).update("player",cv,"id = ?", new String[]{String.valueOf(playerToUpdate.getId())});
    }
    public static void delete(Context context, int id){
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        bd.delete("player", "id =  ?", new String[]{String.valueOf(id)});
    }
    public static void add(Context context, Player playerToAdd){
        ContentValues cv = new ContentValues();
        cv.put("first_name",playerToAdd.getFirstName());
        cv.put("last_name",playerToAdd.getLastName());
        cv.put("number",playerToAdd.getNumber());
        cv.put("position",playerToAdd.getPosition().ordinal());
        ConnexionBd.getBd(context).insert("player",null, cv);
    }
}
