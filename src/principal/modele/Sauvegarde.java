/*
 * Sauvegarde.java                                      4 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * TODO comment class responsibility (SRP)
 * @author groupe 32
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
    }

    /** TODO comment method role
     */
    public void enregistrer() {
        joueur1 = Modele.getJoueur1();
        joueur2 = Modele.getJoueur2();
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
     * @param sauvegardeImporter 
     * 
     */
    public void importer(String sauvegardeImporter) {
        String[] separerParties = sauvegardeImporter.split("[|]");
        this.nom = separerParties[0];
        this.joueur1 = new Joueur(separerParties[1]);
        this.joueur1.setScore(Integer.parseInt(separerParties[2]));
        this.joueur2 = new Joueur(separerParties[3]);
        this.joueur2.setScore(Integer.parseInt(separerParties[4]));
        Modele.setJoueur1(joueur1);
        Modele.setJoueur2(joueur2);
        Modele.setMode1Joueur(separerParties[5].equals("1"));
        Modele.setMode1JoueurDifficile(separerParties[6].equals("1"));
        Modele.setJoueurPrecedentPasser(separerParties[7].equals("1"));
        Modele.getPalette().setCouleurActiveIsJ1(separerParties[8].equals("1"));
        Modele.getPalette().setCouleurOrdinateurIsJ1(separerParties[9].equals("1"));
        String[] tableauDePairs = separerParties[10].split("/");
        String[][] matriceAFormater = new String[tableauDePairs.length][2];
        for (int i = 0; i < matriceAFormater.length; i++) {
            String[] tmp = tableauDePairs[i].split(",");
            matriceAFormater[i][0] = tmp[0];
            matriceAFormater[i][1] = tmp[1];
        }
        Jeton[][] matriceTmp = new Jeton[8][8];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                matriceTmp[x][y] = new Jeton();
                matriceTmp[x][y].setAfficher(matriceAFormater[x * 8 + y][0].equals(
                                                                          "1"));
                matriceTmp[x][y].setCouleurJ1(matriceAFormater[x * 8 + y][1].equals(
                                                                          "1"));
            }
        }
        Modele.getPlateauJeu().setMatriceJeton(matriceTmp);
        Modele.setPartieCharge(true);
    }
}
