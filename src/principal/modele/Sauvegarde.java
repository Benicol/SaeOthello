/*
 * Sauvegarde.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * Une sauvegarde permet de garder en mémoire l'état actuel d'une partie :
 *     - le placement actuel des jetons
 *     - qui est le premier joueur
 *     - quels sont les noms et scores du ou des joueurs
 *     - quel est le mode de jeu (1 ou 2 joueurs)
 *     - quel est le mode de difficulté (peut importe le mode de jeu)
 *     - si le dernier joueur a passé son tour
 *     - si le ordinateur est entrein de jouer
 *     - où l'ordinateur veut jouer
 *     - quelle est la couleur active
 *     - qui joue l'ordinateur (J1 ou J2)
 * @author groupe 32
 */
public class Sauvegarde {
    
	/* Le nom choisi par l'utilisateur pour la sauvegarde */
    private String nom;
    
    /* Le premier joueur */
    private Joueur joueur1;
    
    /* Le second joueur */
    private Joueur joueur2;

    /** 
     * Constructeur d'une sauvegarde 
     * @param nom le nom choisi par l'utilisateur pour désigner sa sauvegarde
     */
    public Sauvegarde(String nom) {
        super();
        this.nom = nom;
    }

    /**
     * Méthode permettant d'enregistrer une nouvelle sauvegarde.
     * Si une sauvegarde est créée et qu'une autre existait déjà
     *  avec le même nom, celle-ci est remplacée.
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
        resultat += (Modele.isOrdinateurIsWaiting() ? 1 : 0) + "|";
        resultat += (Modele.isJoueurPrecedentPasser() ? 1 : 0) + "|";
        resultat += (Modele.getPalette().getCouleurActiveIsJ1() ? 1 : 0) + "|";
        resultat += (Modele.getPalette().getCouleurOrdinateurIsJ1() ? 1 : 0) 
                 + "|";
        resultat += Modele.getOrdinateurVeutJouer()[0] + "," 
                  + Modele.getOrdinateurVeutJouer()[1] + "|";
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

    /**
     *  Permet de charger une partie, ce qui correspond à l'importation 
     *  d'un objet Sauvegarde vers le Modèle.
     * @param sauvegardeImporter le nom de la sauvegarde à charger
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
        Modele.setOrdinateurIsWaiting(separerParties[7].equals("1"));
        Modele.setJoueurPrecedentPasser(separerParties[8].equals("1"));
        Modele.getPalette().setCouleurActiveIsJ1(separerParties[9].equals("1"));
        Modele.getPalette().setCouleurOrdinateurIsJ1(separerParties[10].equals("1"));
        String[] coordsOrdinateurJoueString = separerParties[11].split(",");
        int[] coordsOrdinateurJoue = {
                Integer.parseInt(coordsOrdinateurJoueString[0]), 
                Integer.parseInt(coordsOrdinateurJoueString[1])};
        Modele.setOrdinateurVeutJouer(coordsOrdinateurJoue);
        String[] tableauDePairs = separerParties[12].split("/");
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
