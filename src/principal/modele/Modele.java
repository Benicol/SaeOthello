/*
 * Modele.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class Modele {

    private static String PseudoJ1;
    
    private static String PseudoVainqueur;
    
    private static int[] scores = new int[2];
    
    private static Theme palette;
    
    private static String PseudoJ2;

    /** @return valeur de pseudoJ1 */
    public static String getPseudoJ1() {
        return PseudoJ1;
    }

    /** @param pseudoJ1 nouvelle valeur de pseudoJ1 */
    public static void setPseudoJ1(String pseudoJ1) {
        PseudoJ1 = pseudoJ1;
    }

    /** @return valeur de pseudoJ2 */
    public static String getPseudoJ2() {
        return PseudoJ2;
    }

    /** @param pseudoJ2 nouvelle valeur de pseudoJ2 */
    public static void setPseudoJ2(String pseudoJ2) {
        PseudoJ2 = pseudoJ2;
    }

    /** @return valeur de palette */
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

    /** @return valeur de scores */
    public static int[] getScores() {
        return scores;
    }

    /** @param scores nouvelle valeur de scores */
    public static void setScores(int[] scores) {
        Modele.scores = scores;
    }
    
    
    
}
