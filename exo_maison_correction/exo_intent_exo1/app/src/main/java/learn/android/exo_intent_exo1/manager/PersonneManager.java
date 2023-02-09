package learn.android.exo_intent_exo1.manager;
import java.util.ArrayList;

import learn.android.exo_intent_exo1.R;
import learn.android.exo_intent_exo1.entitie.Personne;
public class PersonneManager {
    private static ArrayList<Personne> personnes;
    static {
        personnes = new ArrayList<>();
        personnes.add(new Personne("dupont", "marc", "footballer", 24, R.drawable.personne1));
        personnes.add(new Personne("jean", "marc", "footballer", 32, R.drawable.personne2));
        personnes.add(new Personne("yves", "saint laurant", "footballer", 26, R.drawable.personne3));
        personnes.add(new Personne("bouleboule", "roger", "footballer", 44, R.drawable.personne4));
    }
    public static ArrayList<Personne> getAll() {
        return personnes;
    }
    public static Personne getById(String id) {
        Personne retour = null;
        for(Personne personne : personnes)
            if(id.equalsIgnoreCase(personne.getId()))
                retour = personne;
        return retour;
    }
}
