/*
 * Sauvegarde.java                                      4 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class Sauvegarde {
    
    private String nom;
    
    private Joueur joueur1;
    
    private Joueur joueur2;

    /** TODO comment intial state
     * @param nom
     */
    public Sauvegarde(String nom) {
        super();
        this.nom = nom;
        joueur1 = Modele.getJoueur1();
        joueur2 = Modele.getJoueur2();
    }

    /** TODO comment method role
     */
    public void enregistrer() {
        String resultat = "";
        resultat += nom + "|";
        resultat += joueur1.getPseudo() + "|" + joueur1.getScore() + "|";
        resultat += joueur2.getPseudo() + "|" + joueur2.getScore() + "|";
        resultat += (Modele.isMode1Joueur() ? 1 : 0) + "|";
        resultat += (Modele.isMode1JoueurDifficile() ? 1 : 0) + "|";
        resultat += (Modele.isJoueurPrecedentPasser() ? 1 : 0) + "|";
        resultat += (Modele.getPalette().getCouleurActiveIsJ1() ? 1 : 0) + "|";
        resultat += (Modele.getPalette().getCouleurOrdinateurIsJ1() ? 1 : 0) 
                 + "|";
        Jeton[][] matriceJetons = Modele.getPlateauJeu().getMatriceJeton();
        for (Jeton[] arrayElt : matriceJetons) {
            for (Jeton elt : arrayElt) {
                resultat += (elt.isAfficher() ? 1 : 0) + ",";
                resultat += (elt.isCouleurJ1() ? 1 : 0) + "/";
            }
        }
        resultat = resultat.substring(0, resultat.length() -1 );
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                                                      "sauvegardes.txt", true));
            writer.append(resultat + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** TODO comment method role
     * 
     */
    public void importer() {
        // TODO Auto-generated method stub
    }
}
