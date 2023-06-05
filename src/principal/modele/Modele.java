/*
 * Modele.java                                         30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

import javafx.scene.shape.Circle;
import principal.EchangeurDeVue;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

/** 
 * TODO comment class responsibility (SRP)
 * @author groupe 32
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
    
    /* Permet de connaître l'état des cercles matérialisant les jetons FIXME : je dis pas de la merde ?*/
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

    /** 
     * Permet de définir les couleurs de la palette utilisée pour cette partie
     * @param palette nouvelle valeur de palette 
     */
    public static void setPalette(Theme palette) {
        Modele.palette = palette;
    }

    /** 
     * Permet d'obtenir le pseudo du vainqueur.
     * @return valeur de pseudoVainqueur 
     */
    public static String getPseudoVainqueur() {
        return PseudoVainqueur;
    }

    /** 
     * Permet de définir le pseudo du vainqueur.
     * @param pseudoVainqueur nouvelle valeur de pseudoVainqueur 
     */
    public static void setPseudoVainqueur(String pseudoVainqueur) {
        PseudoVainqueur = pseudoVainqueur;
    }

    /** 
     * Permet d'obtenir l'indice du dernier menu ouvert.
     * @return valeur représentant l'indice du dernier menu ouvert
     */
    public static int getDernierMenuOuvert() {
        return dernierMenuOuvert;
    }

    /** 
     * Permet de définir quel a été le dernier menu ouvert en donnant l'indice
     * dans le tableau de navigation des pages. FIXME: mieux dire ça
     * @param dernierMenuOuvert nouvelle valeur de dernierMenuOuvert 
     */
    public static void setDernierMenuOuvert(int dernierMenuOuvert) {
        Modele.dernierMenuOuvert = dernierMenuOuvert;
    }

    /** 
     * Permet de savoir si la partie se joue à 1 ou 2 joueurs.
     * @return mode1Joueur true si la partie est en 1 joueur, false sinon
     */
    public static boolean isMode1Joueur() {
        return mode1Joueur;
    }

    /** 
     * Permet de définir le mode choisi (1 ou 2 joueurs).
     * @param mode1Joueur nouvelle valeur de mode1Joueur 
     */
    public static void setMode1Joueur(boolean mode1Joueur) {
        Modele.mode1Joueur = mode1Joueur;
    }

    /**
     * Permet de connaître le joueur 1  
     * @return joueur1 contenant les informations du joueur 1
     */
    public static Joueur getJoueur1() {
        return joueur1;
    }

    /** 
     * Permet de définir qui est le joueur 1
     * @param joueur1 nouvelle valeur de joueur1 
     */
    public static void setJoueur1(Joueur joueur1) {
        Modele.joueur1 = joueur1;
    }

    /**
     * Permet de connaître le joueur 2  
     * @return joueur2 contenant les informations du joueur 2
     */
    public static Joueur getJoueur2() {
        return joueur2;
    }

    /** 
     * Permet de définir qui est le joueur 2
     * @param joueur2 nouvelle valeur de joueur2 
     */
    public static void setJoueur2(Joueur joueur2) {
        Modele.joueur2 = joueur2;
    }

    /** 
     * Permet de savoir si l'ordinateur est réglé en facile ou en difficile
     * pour le mode 1 joueur.
     * @return mode1JoueurDifficile true si la difficulté est "ON", false si 
     * elle est "OFF".
     */
    public static boolean isMode1JoueurDifficile() {
        return mode1JoueurDifficile;
    }

    /** 
     * Permet de changer le niveau de difficulté en mode 1 joueur
     * @param mode1JoueurDifficile nouvelle valeur de mode1JoueurDifficile 
     */
    public static void setMode1JoueurDifficile(boolean mode1JoueurDifficile) {
        Modele.mode1JoueurDifficile = mode1JoueurDifficile;
    }

    /** 
     * Permet de savoir si le joueur précédent a déjà passé son tour ou non
     * @return joueurPrecedentPasser true si le joueur précédent a passé son
     * tour, false sinon
     */
    public static boolean isJoueurPrecedentPasser() {
        return joueurPrecedentPasser;
    }

    /** 
     * Permet de définir si le joueur précédent a déjà passé son tour ou non
     * @param joueurPrecedentPasser nouvelle valeur de joueurPrecedentPasser 
     */
    public static void setJoueurPrecedentPasser(boolean joueurPrecedentPasser) {
        Modele.joueurPrecedentPasser = joueurPrecedentPasser;
    }

    /** 
     * Permet de connaître le plateau de jeu actuel
     * @return valeur de plateauJeu 
     */
    public static Plateau getPlateauJeu() {
        return plateauJeu;
    }

    /** 
     * Permet de définir le plateau de jeu actuel
     * @param plateauJeu nouvelle valeur de plateauJeu 
     */
    public static void setPlateauJeu(Plateau plateauJeu) {
        Modele.plateauJeu = plateauJeu;
    }

    /** 
     * FIXME : ché pas quoi dire
     * @return valeur de cercles 
     */
    public static Circle[][] getCercles() {
        return cercles;
    }

    /** 
     * Permet de savoir si la partie provient d'une sauvegarde ou pas.
     * @return valeur de partieCharge
     */
    public static boolean isPartieCharge() {
        return partieCharge;
    }

    /** 
     * Permet de définir si la partie provient d'une sauvegarde ou pas.
     * @param partieCharge nouvelle valeur de partieCharge 
     */
    public static void setPartieCharge(boolean partieCharge) {
        Modele.partieCharge = partieCharge;
    }

    /** 
     * FIXME
     * @param cercles nouvelle valeur de cercles 
     */
    public static void setCercles(Circle[][] cercles) {
        Modele.cercles = cercles;
    }

    /** 
     * Permet de connaître tous les boutons des différentes cases du plateau
     * @return valeur de buttons 
     */
    public static Button[][] getButtons() {
        return buttons;
    }

    /** 
     * Permet de définir tous les boutons des différentes cases du plateau
     * @param buttons nouvelle valeur de buttons 
     */
    public static void setButtons(Button[][] buttons) {
        Modele.buttons = buttons;
    } 
    
    /** 
     * Permet de savoir si c'est au joueur humain de jouer ou à l'ordinateur.
     * @return un booléen à true s'il s'agit bien du tour de l'ordinateur, false
     * sinon.
     */
    public static boolean estTourOrdinateur() {
        return (Modele.isMode1Joueur() && Modele.getPalette().getCouleurActive().equals(
                Modele.getPalette().getCouleurOrdinateur()));
    }
    
    /** 
     * Méthode permettant de changer de vue en fonction des scores obtenus en 
     * fin de partie.
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
    
    /** 
     * Méthode permettant de tester si tous les jetons ont été posés.
     * Si tel est le cas, cela déclenche une fin de partie.
     */
    public static void testFin() {
        if (Modele.getJoueur1().getScore() + Modele.getJoueur2().getScore() == 64) {
            Modele.fin();
        }
    }
    
    /**
     * Permet de changer la couleur d'un cercle d'une couleur à la couleur 
     * de l'adversaire.
     * @param x les coordonnées en x du cercle à changer
     * @param y les coordonnées en y du cercle à changer
     */
    public static void changeCouleur(int x, int y) {
        System.out.println(x + "|" + y);
        if (Modele.getCercles()[x][y].getFill().equals(Paint.valueOf(Modele.getPalette().getCouleurJ1()))) {
            changeCouleurJ2(x, y);

        } else {
            changeCouleurJ1(x, y);
        }
    }

    /* change la couleur d'un jeton du joueur 2 en jeton de la couleur du 
     * joueur 1 puis met à jour les scores. */
    private static void changeCouleurJ1(int x, int y) {
        Modele.getCercles()[x][y].setFill(Paint.valueOf(Modele.getPalette().getCouleurJ1()));
        Modele.getJoueur1().incrementer();
        Modele.getJoueur2().decrementer();
    }

    /* change la couleur d'un jeton du joueur 1 en jeton de la couleur du 
     * joueur 2 puis met à jour les scores. */
    private static void changeCouleurJ2(int x, int y) {
        Modele.getCercles()[x][y].setFill(Paint.valueOf(Modele.getPalette().getCouleurJ2()));
        Modele.getJoueur2().incrementer();
        Modele.getJoueur1().decrementer();
        ;
    }
    
    /** 
     * Permet de changer la couleur de chaque jetons encadrés par deux jetons de
     * même couleur. FIXME: mieux expliquer
     * @param coords les coordonnées d'un jeton avec en indice 0 les coordonnées
     * en x et en indice 1 les coordonnées en y.
     * @return le nombre de jetons se faisant retourner de la sorte. 
     */
    public static int retournerJetons(int[] coords) {
        int[][] tmp = Modele.getPlateauJeu().retournerJetons(coords[0], coords[1]);
        Modele.getPlateauJeu().changeCouleurArray(tmp);
        for (int[] element : tmp) {
            changeCouleur(element[0], element[1]);
        }
        return tmp.length;
    }
    
    /** 
     * Permet de redéfinir comme inutilisable tous les boutons placés sur les 
     * cases du plateau.
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
    
    /** 
     * Gère l'affichage des contours en pointillé des boutons (les emplacements
     * jouables pour le joueur)
     * @param x les coordonnées en x
     * @param y les coordonnées en y
     * @param couleur la valeur en hexadécimal de la couleur à afficher
     */
    public static void afficherContourBoutton(int x, int y, String couleur) {
        Modele.getButtons()[x][y].setStyle("-fx-border-color: " + couleur + " ;" + " -fx-border-radius: 50;"
                + " -fx-border-style: segments(5, 5, 5, 5);" + " -fx-border-width: 2;"
                + " -fx-background-color: #ff000000;");
    }
    
    /** 
     * Permet d'afficher tous les emplacements jouables pour le joueur et de
     * rendre cliquable les jetons qui y sont associés.     * 
     * @param couleur couleur la valeur en hexadécimal de la couleur à afficher
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
     * 
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

    /** 
     * Défini l'action effectué par l'ordinateur, soit l'emplacement choisi par
     * celui-ci pour poser son jeton. Son choix dépendra du mode de difficulté
     * pré-établi.
     * @return actionOrdinateur, qui contient les coordonnées d'un jeton avec en
     *  indice 0 les coordonnées en x et en indice 1 les coordonnées en y. Ces 
     *  coordonnées représente l'emplacement choisi par l'ordinateur pour poser
     *  son jeton.
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