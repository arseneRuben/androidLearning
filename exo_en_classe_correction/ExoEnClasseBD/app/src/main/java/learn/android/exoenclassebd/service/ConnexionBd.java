package learn.android.exoenclassebd.service;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class ConnexionBd {
    private static int version = 1;
    private static String bnName = "teambd.db";
    private static SQLiteDatabase bd = null;
    private static TeamBdHelper helper;
    public static SQLiteDatabase getBd(Context context) {
        if (helper == null) {
            helper = new TeamBdHelper(context, bnName, null, version);
        }
        bd = helper.getWritableDatabase();
        return bd;
    }
    public static void close() {
        if (bd != null && !bd.isOpen()) {
            bd.close();
        }
    }
}
