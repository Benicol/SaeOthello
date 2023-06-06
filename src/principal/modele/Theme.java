/*
 * Theme.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;


/**
 * Theme stocke les couleurs 
 * 
 * @author groupe32
 */
public class Theme {
    
    /* DECLARATION DES VARIABLES */
    /* Couleur du joueur 1, stockée sous sa forme hexadécimale */
    private String couleurJ1;
    
    /* Couleur du joueur 2, stockée sous sa forme hexadécimale */
    private String couleurJ2;
    
    /* Permet de savoir si c'est au tour du joueur 1 ou du joueur 2 */
    private boolean couleurActiveIsJ1;
    
    /* Permet de savoir si le joueur 1 est l'ordinateur */
    private boolean couleurOrdinateurIsJ1;
    
    /** 
     * Thème permettant de définir la couleur utilisée par le
     * premier joueur et par le second joueur. 
     * @param couleurJ1 la couleur en hexadécimal des jetons du joueur 1
     * @param couleurJ2 la couleur en hexadécimal des jetons du joueur 2
     */
    public Theme(String couleurJ1, String couleurJ2) {
        this.couleurJ1 = couleurJ1;
        this.couleurJ2 = couleurJ2;
        this.couleurActiveIsJ1 = false;
        this.couleurOrdinateurIsJ1 = true;
    }

    /** 
     * Permet d'obtenir la couleur utilisée par le joueur 1
     * @return valeur de couleurJ1 
     */
    public String getCouleurJ1() {
        return couleurJ1;
    }

    /** 
     * Permet d'obtenir la couleur utilisée par le joueur 2
     * @return valeur de couleurJ2 
     */
    public String getCouleurJ2() {
        return couleurJ2;
    }
    
    /** 
     * Permet d'obtenir la couleur utilisée par le joueur dont c'est le tour
     * @return la couleur en hexadécimal des jetons du joueur actif 
     */
    public String getCouleurActive() {
        return couleurActiveIsJ1 ? couleurJ1 : couleurJ2;
    }
    
    /** 
     * Permet de revenir à une situation initiale où le joueur actif est le 
     * joueur 2.
     */
    public void resetCouleurActive() {
        couleurActiveIsJ1 = false;
    }
    
    /**
     * Permet de changer la couleur du joueur actif. FIXME: pas sûre d'avoir bien expliqué en fait
     */
    public void switchCouleurActive() {
        couleurActiveIsJ1 = !couleurActiveIsJ1;
    }
    
    /** 
     * Permet de connaître la seconde couleur utilisée durant cette partie.
     * @param couleur la couleur de l'un des deux joueurs durant cette partie.
     * @return la couleur de J1 en hexadécimal si la couleur en param est J2, 
     * la couleur de J2 sinon */
    public String getCouleurOppose(String couleur) {
       if (couleurJ1.equals(couleur)) {
           return couleurJ2;
       } else {
           return couleurJ1;
       }
    }

    /** 
     * Permet de connaître quelle est la couleur jouée par l'ordinateur
     * @return la valeur en hexadécimal de la couleur jouée par l'ordinateur 
     */
    public String getCouleurOrdinateur() {
        return couleurOrdinateurIsJ1 ? couleurJ1 : couleurJ2;
    }

    /** 
     * Permet de définir si la couleur de l'ordinateur sera celle de J1 ou de J2
     * @param couleurOrdinateurIsJ1 décide que la couleur de l'ordinateur 
     * représente le joueur 1 si true, et false sinon.
     */
    public void setCouleurOrdinateurIsJ1(boolean couleurOrdinateurIsJ1) {
        this.couleurOrdinateurIsJ1 = couleurOrdinateurIsJ1;
    }

    /** 
     * Permet de changer la couleur du premier joueur.
     * @param couleurJ1 nouvelle valeur en hexadécimal de couleurJ1 
     */
    public void setCouleurJ1(String couleurJ1) {
        this.couleurJ1 = couleurJ1;
    }

    /** 
     * Permet de changer la couleur du second joueur.
     * @param couleurJ2 nouvelle valeur en hexadécimal de couleurJ1 
     */
    public void setCouleurJ2(String couleurJ2) {
        this.couleurJ2 = couleurJ2;
    }

    /** 
     * Permet de savoir si la couleur active (dont c'est le tour) est le joueur 1
     * @return true si couleur active est le joueur 1, false sinon.
     */
    public boolean getCouleurActiveIsJ1() {
        return couleurActiveIsJ1;
    }

    /** 
     * Permet de modifier l'information concernant le fait que la couleur active 
     * représente le joueur 1
     * @param couleurActiveIsJ1 nouvelle valeur de couleurActiveIsJ1 
     */
    public void setCouleurActiveIsJ1(boolean couleurActiveIsJ1) {
        this.couleurActiveIsJ1 = couleurActiveIsJ1;
    }

    /** 
     * Permet de savoir si la couleur de l'ordinateur correspond au joueur 1.
     * @return true si l'ordinateur est J1, false sinon 
     */
    public boolean getCouleurOrdinateurIsJ1() {
        return couleurOrdinateurIsJ1;
    }
    
}