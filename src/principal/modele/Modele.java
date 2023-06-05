/*
 * Modele.java                                         30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import javafx.scene.shape.Circle;
import principal.EchangeurDeVue;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

/** TODO comment class responsibility (SRP)
 * @author groupe32
 *
 */
public class Modele {
    
    /* DECLARATION DES VARIABLES */
    /* Permet de stocker en mémoire le dernier menu ouvert par le joueur */
    private static int dernierMenuOuvert = 0;
    
    /* Permet de savoir si la partie vient d'une charge */
    private static boolean partieCharge = false;
    
    /* Permet de stocker en mémoire le type de partie (1 joueur ou 2 joueurs) */
    private static boolean mode1Joueur;
    
    /* Permet de stocker en mémoire la difficulté choisie en mode 1 joueur */
    private static boolean mode1JoueurDifficile = false;
    
    /* Permet de stocker en mémoire si le dernier joueur a déjà passé son tour */
    private static boolean joueurPrecedentPasser = false;

    /* Permet de stocker en mémoire les informations concernant le joueur 1 */
    private static Joueur joueur1 = new Joueur(null);

    /* Permet de stocker en mémoire les informations concernant le joueur 2 */
    private static Joueur joueur2 = new Joueur(null);
    
    /* Permet de stocker en mémoire le pseudo du joueur ayant gagné la partie */
    private static String PseudoVainqueur;
    
    /* Permet de stocker en mémoire le thème de couleur choisi */
    private static Theme palette;
    
    /* Permet de stocker en mémoire l'état du plateau de jeu */
    private static Plateau plateauJeu = new Plateau();
    
    /* Permet de connaître l'état des cercles matérialisant les jetons FIXME : je dirais pas de la merde ?*/
    private static Circle[][] cercles;
    
    /* Permet de connaître l'état des boutons sur chaque case du plateau */
    private static Button[][] buttons;
    


    /** 
     * Permet d'obtenir les informations concernant les couleurs utilisés pour 
     * cette partie.
     * @return valeur de palette  
     */
    public static Theme getPalette() {
        return palette;
    }

    /** @param palette nouvelle valeur de palette */
    public static void setPalette(Theme palette) {
        Modele.palette = palette;
    }

    /** @return valeur de pseudoVainqueur */
    public static String getPseudoVainqueur() {
        return PseudoVainqueur;
    }

    /** @param pseudoVainqueur nouvelle valeur de pseudoVainqueur */
    public static void setPseudoVainqueur(String pseudoVainqueur) {
        PseudoVainqueur = pseudoVainqueur;
    }

    /** @return valeur de dernierMenuOuvert */
    public static int getDernierMenuOuvert() {
        return dernierMenuOuvert;
    }

    /** @param dernierMenuOuvert nouvelle valeur de dernierMenuOuvert */
    public static void setDernierMenuOuvert(int dernierMenuOuvert) {
        Modele.dernierMenuOuvert = dernierMenuOuvert;
    }

    /** @return valeur de mode1Joueur */
    public static boolean isMode1Joueur() {
        return mode1Joueur;
    }

    /** @param mode1Joueur nouvelle valeur de mode1Joueur */
    public static void setMode1Joueur(boolean mode1Joueur) {
        Modele.mode1Joueur = mode1Joueur;
    }

    /** @return valeur de joueur1 */
    public static Joueur getJoueur1() {
        return joueur1;
    }

    /** @param joueur1 nouvelle valeur de joueur1 */
    public static void setJoueur1(Joueur joueur1) {
        Modele.joueur1 = joueur1;
    }

    /** @return valeur de joueur2 */
    public static Joueur getJoueur2() {
        return joueur2;
    }

    /** @param joueur2 nouvelle valeur de joueur2 */
    public static void setJoueur2(Joueur joueur2) {
        Modele.joueur2 = joueur2;
    }

    /** @return valeur de mode1JoueurDifficile */
    public static boolean isMode1JoueurDifficile() {
        return mode1JoueurDifficile;
    }

    /** @param mode1JoueurDifficile nouvelle valeur de mode1JoueurDifficile */
    public static void setMode1JoueurDifficile(boolean mode1JoueurDifficile) {
        Modele.mode1JoueurDifficile = mode1JoueurDifficile;
    }

    /** @return valeur de joueurPrecedentPasser */
    public static boolean isJoueurPrecedentPasser() {
        return joueurPrecedentPasser;
    }

    /** @param joueurPrecedentPasser nouvelle valeur de joueurPrecedentPasser */
    public static void setJoueurPrecedentPasser(boolean joueurPrecedentPasser) {
        Modele.joueurPrecedentPasser = joueurPrecedentPasser;
    }

    /** @return valeur de plateauJeu */
    public static Plateau getPlateauJeu() {
        return plateauJeu;
    }

    /** @param plateauJeu nouvelle valeur de plateauJeu */
    public static void setPlateauJeu(Plateau plateauJeu) {
        Modele.plateauJeu = plateauJeu;
    }

    /** @return valeur de cercles */
    public static Circle[][] getCercles() {
        return cercles;
    }

    /** @return valeur de partieCharge */
    public static boolean isPartieCharge() {
        return partieCharge;
    }

    /** @param partieCharge nouvelle valeur de partieCharge */
    public static void setPartieCharge(boolean partieCharge) {
        Modele.partieCharge = partieCharge;
    }

    /** @param cercles nouvelle valeur de cercles */
    public static void setCercles(Circle[][] cercles) {
        Modele.cercles = cercles;
    }

    /** @return valeur de buttons */
    public static Button[][] getButtons() {
        return buttons;
    }

    /** @param buttons nouvelle valeur de buttons */
    public static void setButtons(Button[][] buttons) {
        Modele.buttons = buttons;
    } 
    
    /** TODO comment method role
     * @return TODO
     */
    public static boolean estTourOrdinateur() {
        return (Modele.isMode1Joueur() && Modele.getPalette().getCouleurActive().equals(
                Modele.getPalette().getCouleurOrdinateur()));
    }
    
    /** TODO comment method role
     * 
     */
    public static void fin() {
        EchangeurDeVue.supprimerCache(1);
        if (Modele.getJoueur1().getScore() > Modele.getJoueur2().getScore()) {
            Modele.setPseudoVainqueur(Modele.getJoueur1().getPseudo());
            EchangeurDeVue.echangerAvec(4, false);
        } else if (Modele.getJoueur1().getScore() < Modele.getJoueur2().getScore()) {
            Modele.setPseudoVainqueur(Modele.getJoueur2().getPseudo());
            EchangeurDeVue.echangerAvec(4, false);
        } else {
            EchangeurDeVue.echangerAvec(3, false);
        }
    }
    
    /** TODO comment method role
     * 
     */
    public static void testFin() {
        if (Modele.getJoueur1().getScore() + Modele.getJoueur2().getScore() == 64) {
            Modele.fin();
        }
    }
    
    /** TODO comment method role
     * @param x
     * @param y
     */
    public static void changeCouleur(int x, int y) {
        System.out.println(x + "|" + y);
        if (Modele.getCercles()[x][y].getFill().equals(Paint.valueOf(Modele.getPalette().getCouleurJ1()))) {
            changeCouleurJ2(x, y);

        } else {
            changeCouleurJ1(x, y);
        }
    }

    private static void changeCouleurJ1(int x, int y) {
        Modele.getCercles()[x][y].setFill(Paint.valueOf(Modele.getPalette().getCouleurJ1()));
        Modele.getJoueur1().incrementer();
        Modele.getJoueur2().decrementer();
    }

    private static void changeCouleurJ2(int x, int y) {
        Modele.getCercles()[x][y].setFill(Paint.valueOf(Modele.getPalette().getCouleurJ2()));
        Modele.getJoueur2().incrementer();
        Modele.getJoueur1().decrementer();
        ;
    }
    
    /** TODO comment method role
     * @param coords
     * @return TODO
     */
    public static int retournerJetons(int[] coords) {
        int[][] tmp = Modele.getPlateauJeu().retournerJetons(coords[0], coords[1]);
        Modele.getPlateauJeu().changeCouleurArray(tmp);
        for (int[] element : tmp) {
            changeCouleur(element[0], element[1]);
        }
        return tmp.length;
    }
    
    /** TODO comment method role
     * 
     */
    public static void resetAllPlayables() {
        for (Button[] eltListe : Modele.getButtons()) {
            for (Button elt : eltListe) {
                elt.setStyle("-fx-border-color: #ff000000;" + "-fx-border-radius: 50;"
                        + " -fx-border-style: segments(5, 5, 5, 5);" + " -fx-border-width: 2;"
                        + " -fx-background-color: #ff000000;");
                elt.setDisable(true);
            }
        }
    }
    
    /** TODO comment method role
     * @param x
     * @param y
     * @param couleur
     */
    public static void afficherContourBoutton(int x, int y, String couleur) {
        Modele.getButtons()[x][y].setStyle("-fx-border-color: " + couleur + " ;" + " -fx-border-radius: 50;"
                + " -fx-border-style: segments(5, 5, 5, 5);" + " -fx-border-width: 2;"
                + " -fx-background-color: #ff000000;");
    }
    
    /** TODO comment method role
     * @param couleur
     */
    public static void NouveauJouables(String couleur) {
        Modele.resetAllPlayables();
        int[][] coordsJouable = Modele.getPlateauJeu().chercherPlacementsPossible();
        for (int[] elt : coordsJouable) {
            Modele.afficherContourBoutton(elt[0], elt[1], couleur);
            Modele.getButtons()[elt[0]][elt[1]].setDisable(false);
        }
    }
    
    /**
     * TODO comment method role
     * 
     * @param x
     * @param y
     * @param couleur 
     * @param cercle 
     */
    public static void creerCercleModele(Integer x, Integer y, Paint couleur, Circle cercle) { //TODO
        Modele.getPlateauJeu().jetonExiste(x, y, couleur);
        if (!Modele.isPartieCharge()) {
            if (couleur.equals(Paint.valueOf(Modele.getPalette().getCouleurJ1()))) {
                Modele.getJoueur1().incrementer();
            } else {
                Modele.getJoueur2().incrementer();
            }
        }
        Modele.getCercles()[x][y] = cercle;
    }

    /** TODO comment method role
     * @return TODO
     * 
     */
    public static int[] checkOrdinateur() {
        int[] actionOrdinateur = new int[2];
        if (Modele.isMode1JoueurDifficile()) {
            actionOrdinateur = Modele.getPlateauJeu().ordinateurDifficile();
        } else {
            actionOrdinateur = Modele.getPlateauJeu().ordinateurFacile();
        }
        return actionOrdinateur;
    }
}