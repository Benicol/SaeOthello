/*
 * EnsembleDesVues.java                                              30/05/2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

/**
 * Classe outil qui établit la correspondance entre un code de vue (sous la
 * forme d'un entier) et le nom du fichier fxml contenant la vue associée à ce
 * code. 
 * @author Groupe 32
 */
public class EnsembleDesVues {

    /** Code de la vue menu principale */
    public static final int VUE_MENU_PRINCIPAL = 0;

    /** Code de la vue de jeu */
    public static final int VUE_JEU = 1;
    
    /** Code de la vue du pseudo */
    public static final int VUE_PSEUDO = 2;
    
    /** Code de la vue de égalite */
    public static final int VUE_EGALITE = 3;
    
    /** Code de la vue de victoire */
    public static final int VUE_VICTOIRE = 4;
    
    /** Code de la vue de menu en jeu */
    public static final int VUE_MENU_EN_JEU = 5;
    
    /** Code de la vue des règles */
    public static final int VUE_REGLES = 6;
    
    /** Code de la vue des règles "fin de partie" */
    public static final int VUE_REGLES_FIN_DE_PARTIE = 7;
    
    /** Code de la vue des règles "comment jouer" */
    public static final int VUE_REGLES_COMMENT_JOUER = 8;
    
    /** Code de la vue du menu des options */
    public static final int VUE_MENU_OPTIONS = 9;
    
    /** Code de la vue de sauvegarde */
    public static final int VUE_SAUVEGARDE = 10;
    
    /** Code de la vue de chargement */
    public static final int VUE_CHARGER = 11;
    

    /**
     * Tableau contenant les noms des fichiers fxml des différentes vues 75 de
     * l'application. Il y a une correspondance entre l'indice de la case du tableau
     * et le code de la vue défini en tant que constante
     */
    private static final String[] NOM_DES_VUES = { "InterfaceMenuPrincipal.fxml", 
                                                   "VueJeu.fxml", 
                                                   "Pseudo.fxml", 
                                                   "Egalite.fxml", 
                                                   "Victoire.fxml",
                                                   "JeuMenu.fxml",
                                                   "Regles.fxml",
                                                   "ReglesFinPartie.fxml",
                                                   "ReglesCommentJouer.fxml",
                                                   "InterfaceMenuOptions.fxml",
                                                   "Sauvegarde.fxml",
                                                   "Charger.fxml"};

    /**
     * Renvoie le nom du fichier fxml contenant la vue dont le code est donné en
     * paramètre
     * @param codeVue code de la vue dont le fichier fxml doit être renvoyé
     * @return une chaîne contenant le nom du fichier fxml
     * @throw IllegalArgumentException levée si le code argument n'est pas valide
     */
    public static String getNomVue(int codeVue) {
        if (codeVue < 0 || codeVue >= NOM_DES_VUES.length) {
            throw new IllegalArgumentException("Code vue " + codeVue + " invalide");
        }
        return NOM_DES_VUES[codeVue];
    }
}