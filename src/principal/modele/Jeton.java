/*
 * Jeton.java                                      25 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** 
 * Jeton défini par sa couleur permettant de jouer au jeu de l'Othello.
 * Un jeton peut être de deux couleurs seulement : 
 *  - soit la couleur du joueur 1
 *  - soit la couleur du joueur 2
 * @author groupe 32
 */
public class Jeton {
    
    /* Couleur du jeton à true si correspond à la couleur du joueur 1 */
    private boolean couleurJ1;
    
    /* true si le jeton est affiché à l'écran */
    private boolean afficher;
    
    /** 
     * Constructeur produisant un Jeton d'Othello, soit blanc, soit noir
     */
    public Jeton(){
        this.couleurJ1 = false;
        this.afficher = false;
    }
    
    /** 
     * Permet de connaître la couleur d'un jeton.
     * @return true si le jeton est blanc, false sinon 
     */
    public boolean isCouleurJ1() {
        return this.couleurJ1;
    }

    /** 
     * Permet de changer la couleur d'un jeton
     * @param couleurJ1 la couleur qui va remplacer la couleur actuelle du jeton
     */
    public void setCouleurJ1(boolean couleurJ1) {
        this.couleurJ1 = couleurJ1;
    }

    /** 
     * Permet de savoir si un jeton est affiché à l'écran
     * @return valeur de afficher 
     */
    public boolean isAfficher() {
        return afficher;
    }

    /**
     * Permet d'afficher un jeton à l'écran.
     */
    public void devientAfficher() {
        this.afficher = true;
    }
    
    /** 
     * Permet d'inverser la couleur d'un jeton (de blanc, il passe à noir).
     */
    public void switchCouleurJ1() {
        couleurJ1 = !couleurJ1;
    }

    /** 
     * Permet de changer l'état d'afficher pour faire apparaître ou 
     * disparaître un jeton. 
     * @param afficher nouvelle valeur à attribuer à afficher 
     */
    public void setAfficher(boolean afficher) {
        this.afficher = afficher;
    }
    
    
}
