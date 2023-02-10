package com.example.labviewperso.managers;


import com.example.labviewperso.entities.Planete;

import java.util.ArrayList;
public class PlaneteManager {
    private static ArrayList<Planete> planetes;
    static {
        planetes = new ArrayList<>();        
        planetes.add(new Planete(1, "Mercure", "\n" +
                "    Surface caractérisée par de nombreux cratères, résultats d’impacts météoritiques;\n" +
                "    Aucune trace d’eau;\n" +
                "    Atmosphère presque inexistante, mis à part la présence de traces de gaz;\n" +
                "    Écarts de température très grands (de -172oC à  427oC);\n" +
                "    Révolution de 88 jours terrestres;\n" +
                "    Rotation de 58,7 jours terrestres;\n" +
                "    Aucun satellite connu.\n", "s1077i11.jpg", Planete.PlaneteType.Tellurique));
        planetes.add(new Planete(2, "Vénus", "Relief qui présente de nombreuses montagnes, des canyons, des volcans et qui est criblé de cratères;\n" +
                "Aucune trace d’eau;\n" +
                "Atmosphère principalement composée de dioxyde de carbone (CO2)\n" +
                " mais aussi d’azote (N2), de dioxyde de soufre (S2) et d’acide sulfurique (H2S)\n" +
                ";\n" +
                "Effet de serre très important; \n" +
                "Température de 453oC en moyenne;\n" +
                "Révolution de 224,7 jours terrestres;\n" +
                "Rotation de 243 jours terrestres;\n" +
                "Rotation rétrograde (sens de rotation horaire);\n" +
                "Aucun satellite connu.", "s1077i12.jpg", Planete.PlaneteType.Tellurique));
        planetes.add(new Planete(3, "Terre", "Sol riche en sels minéraux, présence des cratères et relief très varié; \n" +
                "Importantes quantités d’eau (sous différentes formes, surtout salée), caractéristique de la présence de vie; \n" +
                "Atmosphère composée d’azote (N2)\n" +
                ", d’oxygène (O2), d’argon (Ar), mais aussi de dioxyde de carbone (CO2), de vapeur d’eau (H2O)\n" +
                "et d’autres gaz;\n" +
                "Températures variant entre -60oC et 45oC;\n" +
                "Révolution de 365,25 jours terrestres;\n" +
                "Rotation de 24 heures terrestres;\n" +
                "1 satellite connu : la Lune.", "s1077i13.jpg", Planete.PlaneteType.Tellurique));
        planetes.add(new Planete(4, "Mars", "Sol rouge caractérisé par la présence d’hématite;\n" +
                "Relief très accentué et présence de nombreux cratères; \n" +
                "Présence de glace aux pôles; \n" +
                "Atmosphère principalement composée de dioxyde de carbone (CO2)\n" +
                ", mais également d’azote (N2), d’argon (Ar) et même d’oxygène (O2)\n" +
                ";\n" +
                "Écarts de température relativement importants (de -123oC à 37oC);\n" +
                "Présence des vents violents;\n" +
                "Révolution de 687 jours terrestres;\n" +
                "Rotation de 24,63 heures terrestres;\n" +
                "2 satellites connus: Phobos et Deimos", "s1077i14.jpg", Planete.PlaneteType.Tellurique));
        planetes.add(new Planete(5, "Jupiter", "Plus grosse planète du système solaire;\n" +
                "Aucune lithosphère, même si un noyau est présent; \n" +
                "Aucune trace d’eau; \n" +
                "Importante atmosphère d’hydrogène (H2)\n" +
                "et d’hélium (He), mais aussi d’ammoniac (NH3), de méthane (CH4) et d’éthane (C2H6)\n" +
                ";\n" +
                "Température dans la partie extérieure des nuages d’environ -153oC;\n" +
                "Vents violents pouvant aller à plus de 500 km/h;\n" +
                "Révolution de 11,87 années terrestres;\n" +
                "Rotation de 9,93 heures terrestres;\n" +
                "67 satellites connus dont Ganymède, Io et Europe", "s1077i15.jpg", Planete.PlaneteType.Jeovienne));
        
        planetes.add(new Planete(6, "Saturne", "Présence de milliers d’anneaux colorés qui sont faits de glace et de roche; \n" +
                "Aucune lithosphère, même si un noyau est présent; \n" +
                "Aucune trace d’eau; \n" +
                "Importante atmosphère d’hydrogène (H2)\n" +
                ", d’hélium (He), de méthane (CH4) et d’ammoniac (NH3)\n" +
                ";\n" +
                "Température dans la partie extérieure des nuages d’environ -185oC\n" +
                "Révolution de 29,46 années terrestres;\n" +
                "Rotation de 10,66 heures terrestres;\n" +
                "62 satellites connus, dont Titan", "s1077i16.jpg", Planete.PlaneteType.Jeovienne));
        planetes.add(new Planete(7, "Uranus", "Qualifiée de géante de glace\n" +
                "Présence de gaz verdâtres formant une atmosphère composée d’hydrogène (H2)\n" +
                ", d’hélium (He)et de méthane (CH4)\n" +
                ";\n" +
                "Aucune lithosphère, même si un noyau est présent;\n" +
                "Aucune trace d’eau; \n" +
                "Température dans la partie extérieure des nuages d’environ -214oC\n" +
                "Révolution de 84,3 années terrestres;\n" +
                "Rotation de 17,2 heures terrestres;\n" +
                "Rotation rétrograde (sens de rotation horaire);\n" +
                "27 satellites connus.", "s1077i17.jpg", Planete.PlaneteType.Jeovienne));
        planetes.add(new Planete(8, "Neptune", "Qualifiée de géante de glace\n" +
                "Présence de gaz bleutés formant une atmosphère d’hydrogène (H2)\n" +
                ", d’hélium (He) et de méthane (CH4)\n" +
                ";\n" +
                "Aucune lithosphère, même si un noyau est présent; \n" +
                "Aucune trace d’eau; \n" +
                "Température dans la partie extérieure des nuages d’environ -225oC\n" +
                "Vents violents pouvant aller jusqu’à 2000 km/h;\n" +
                "Révolution de 164,8 années terrestres;\n" +
                "Rotation de 16,11 heures terrestres;\n" +
                "14 satellites connus.", "s1077i18.jpg", Planete.PlaneteType.Jeovienne));
    }
    public static ArrayList<Planete> getAll() {
        return planetes;
    }
    public static ArrayList<Planete> getByType(Planete.PlaneteType type) {
        ArrayList<Planete> retour = new ArrayList<>();
        for (Planete p : planetes)
            if (p.getType() == type)
                retour.add(p);
        return retour;
    }
    public static Planete getById(int id) {
        for (Planete p : planetes)
            if (id == p.getId())
                return p;
        return null;
    }
}
