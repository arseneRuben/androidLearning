package learn.android.exoclasselistview.manager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import learn.android.exoclasselistview.entitie.Voiture;
import learn.android.exoclasselistview.service.ConnexionBD;
public class VoitureManager {
    public static ArrayList<Voiture> getAll(Context context) {
        ArrayList<Voiture> retour = null;
        SQLiteDatabase bd = ConnexionBD.getBd(context);
        String query = "select * from voiture";
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()){
                retour.add(new Voiture(cursor));
            }
        }
        return retour;
    }
}
