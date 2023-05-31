/*
 * Jeton.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** 
 * Jeton défini par sa couleur permettant de jouer au jeu de l'Othello
 * @author groupe32
 */
public class Jeton {
    
    /* Couleur du jeton */
    private boolean blanc ;
    
    /** 
     * Définition d'un Jeton de Othello qui est soit blanc soit noir
     * @param blanc true si il est blanc et false si il est noir
     */
    public Jeton(boolean blanc){
        super();
        this.blanc = blanc;
    }
    
    /** @return true si le jeton est blanc, false sinon */
    public boolean isBlanc() {
        return this.blanc;
    }

    /** @param blanc nouvelle valeur de blanc */
    public void setBlanc(boolean blanc) {
        this.blanc = blanc;
    }
}
