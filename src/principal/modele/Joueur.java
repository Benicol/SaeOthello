/*
 * Joueur.java                                      1 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** TODO comment class responsibility (SRP)
 * @author benjamin.nicol
 *
 */
public class Joueur {
    
    private int score;
    
    private String pseudo;
    
    /** TODO comment intial state
     * @param pseudo 
     * 
     */
    public Joueur(String pseudo) {
        this.score = 0;
        this.pseudo = pseudo;
    }

    /** @return valeur de score */
    public int getScore() {
        return score;
    }
    
    /** @return valeur de pseudo */
    public String getPseudo() {
        return pseudo;
    }
    
    /** @param valeur */
    public void incrementer() {
        this.score++;
    }
    
    /** @param valeur */
    public void decrementer() {
        this.score--;
    }
    
    
}
