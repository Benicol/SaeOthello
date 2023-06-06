/*
 * Joueur.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** 
 * Joueur permet de manipuler les données relatives au score et au pseudonyme.
 * @author groupe32
 */
public class Joueur {
    
    private int score;
    
    private String pseudo;
    
    /** 
     * Constructeur d'un joueur défini par son pseudo et par son score 
     * (initialisé à zéro en début de partie).
     * @param pseudo le nom choisi pour désigner le joueur
     */
    public Joueur(String pseudo) {
        this.score = 0;
        this.pseudo = pseudo;
    }

    /** 
     * Permet de connaître le score du joueur
     * @return score le nombre de jeton de la couleur du joueur en jeu.
     */
    public int getScore() {
        return score;
    }
    
    /** 
     * Permet de connaître le pseudo du joueur
     * @return pseudo un nom utilisé pour désigner le joueur en jeu
     */
    public String getPseudo() {
        return pseudo;
    }
    
    /** 
     * Permet d'augmenter la valeur du score de 1.
     */
    public void incrementer() {
        this.score++;
    }
    
    /** 
     * Permet de diminuer la valeur du score de 1.
     */
    public void decrementer() {
    	if (score < 1) {
    		throw new IllegalArgumentException("Le score ne peux pas être négatif");
    	}
        this.score--;
    }

    /** 
     * Permet de définir le pseudo du joueur
     * @param pseudo nouvelle valeur de pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /** 
     * Permet de définir le score du joueur
     * @param score nouvelle valeur de score 
     */
    public void setScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Le score ne peux pas être négatif");
        }
        this.score = score;
    }
    
    
}
