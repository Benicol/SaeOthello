/*
 * PlateauDeJeu.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** TODO comment class responsibility (SRP)
 * @author groupe32
 *
 */
public class Plateau {
    
    /* taille de la matrice qui représente le plateau de jeu */
    private final int TAILLE = 8;
    
    /* Matrice qui représente le plateau de jeu */
    private Object[][] matrice;
    
    /** TODO comment intial state
     * 
     */
    public Plateau () {
        super();
        this.matrice = new Object[TAILLE][TAILLE];
    }
    
    /** TODO comment method role
     * @return true si le jeton peut être joué, false sinon
     */
    public boolean isJouable() {
        
        return false; //bouchon
    }

}
