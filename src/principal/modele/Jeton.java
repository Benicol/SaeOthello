/*
 * Jeton.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** 
 * Jeton défini par sa couleur permettant de jouer au jeu de l'Othello
 * @author groupe 32
 */
public class Jeton {
    
    /* Couleur du jeton */
    private boolean couleurJ1;
    
    /* true si le jeton est afficher */
    private boolean afficher;
    
    /** 
     * Définition d'un Jeton de Othello qui est soit blanc soit noir
     * @param blanc true si il est blanc et false si il est noir
     */
    public Jeton(){
        this.couleurJ1 = false;
        this.afficher = false;
    }
    
    /** @return true si le jeton est blanc, false sinon */
    public boolean isCouleurJ1() {
        return this.couleurJ1;
    }

    /** @param couleurJ1 */
    public void setCouleurJ1(boolean couleurJ1) {
        this.couleurJ1 = couleurJ1;
    }

    /** @return valeur de afficher */
    public boolean isAfficher() {
        return afficher;
    }

    /** @param afficher nouvelle valeur de afficher */
    public void devientAfficher() {
        this.afficher = true;
    }
    
    /** @param afficher nouvelle valeur de afficher */
    public void switchCouleurJ1() {
        couleurJ1 = !couleurJ1;
    }

    /** @param afficher nouvelle valeur de afficher */
    public void setAfficher(boolean afficher) {
        this.afficher = afficher;
    }
    
    
}
