package learn.android.exoenclasseinflator2.manager;
import java.util.ArrayList;

import learn.android.exoenclasseinflator2.entite.Player;
import learn.android.exoenclasseinflator2.entite.Position;
public class PlayerManager {
    private static ArrayList<Player> players;
    private static void init() {
        players = new ArrayList<>();
        players.add(new Player(22, "Lautaro", "Martínez", Position.striker));
        players.add(new Player(10, "Lionel", "Messi", Position.striker));
        players.add(new Player(20, "Alexis", "Mac Allister", Position.middle));
        players.add(new Player(24, "Enzo", "Fernández", Position.middle));
        players.add(new Player(7, "Rodrigo", "De Paul", Position.middle));
        players.add(new Player(11, "Ángel", "Di María", Position.middle));
        players.add(new Player(3, "Nicolás", "Tagliafico", Position.defender));
        players.add(new Player(19, "Nicolás", "Otamendi", Position.defender));
        players.add(new Player(13, "Cristian", "Romero", Position.defender));
        players.add(new Player(26, "Nahuel", "Molina", Position.defender));
        players.add(new Player(23, "Emiliano", "Martínez", Position.goal_defender));
    }
    public static ArrayList<Player> getAll() {
        if (players == null)
            init();
        return players;
    }
    public static ArrayList<Player> getByPosition(Position positionToGet) {
        ArrayList<Player> retour = new ArrayList<>();
        for (Player player : players) {
            if (player.getPosition() == positionToGet)
                retour.add(player);
        }
        return retour;
    }
}
