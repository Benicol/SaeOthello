/*
 * SetCouleur.java                                      1 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;


/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class Theme {
    
    private String couleurJ1;
    
    private String couleurJ2;
    
    private String couleurActive;
    
    /** TODO comment intial state
     * @param couleurJ1
     * @param couleurJ2
     */
    public Theme(String couleurJ1, String couleurJ2) {
        this.couleurJ1 = couleurJ1;
        this.couleurJ2 = couleurJ2;
        this.couleurActive = couleurJ2;
    }

    /** @return valeur de couleurJ1 */
    public String getCouleurJ1() {
        return couleurJ1;
    }

    /** @return valeur de couleurJ2 */
    public String getCouleurJ2() {
        return couleurJ2;
    }
    
    /** @return valeur de couleurJ2 */
    public String getCouleurActive() {
        return couleurActive;
    }
    
    /***/
    public void switchCouleurActive() {
        if (couleurActive.equals(couleurJ1)) {
            couleurActive = couleurJ2;
        } else {
            couleurActive = couleurJ1;
        }
    }
    
    /** @param couleur 
     * @return valeur de couleurJ2 */
    public String getCouleurOppose(String couleur) {
       if (couleurJ1.equals(couleur)) {
           return couleurJ2;
       } else {
           return couleurJ1;
       }
    }
}