/*
 * SetCouleur.java                                      1 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele;


/** TODO comment class responsibility (SRP)
 * @author groupe32
 *
 */
public class Theme {
    
    private String couleurJ1;
    
    private String couleurJ2;
    
    private boolean couleurActiveIsJ1;
    
    private boolean couleurOrdinateurIsJ1;
    
    /** TODO comment intial state
     * @param couleurJ1
     * @param couleurJ2
     */
    public Theme(String couleurJ1, String couleurJ2) {
        this.couleurJ1 = couleurJ1;
        this.couleurJ2 = couleurJ2;
        this.couleurActiveIsJ1 = false;
        this.couleurOrdinateurIsJ1 = true;
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
        return couleurActiveIsJ1 ? couleurJ1 : couleurJ2;
    }
    
    /** TODO comment method role
     * 
     */
    public void resetCouleurActive() {
        couleurActiveIsJ1 = false;
    }
    
    /***/
    public void switchCouleurActive() {
        couleurActiveIsJ1 = !couleurActiveIsJ1;
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

    /** @return valeur de couleurOrdinateur */
    public String getCouleurOrdinateur() {
        return couleurOrdinateurIsJ1 ? couleurJ1 : couleurJ2;
    }

    /** @param couleurOrdinateurIsJ1 */
    public void setCouleurOrdinateurIsJ1(boolean couleurOrdinateurIsJ1) {
        this.couleurOrdinateurIsJ1 = couleurOrdinateurIsJ1;
    }

    /** @param couleurJ1 nouvelle valeur de couleurJ1 */
    public void setCouleurJ1(String couleurJ1) {
        this.couleurJ1 = couleurJ1;
    }

    /** @param couleurJ2 nouvelle valeur de couleurJ2 */
    public void setCouleurJ2(String couleurJ2) {
        this.couleurJ2 = couleurJ2;
    }

    /** @return valeur de couleurActiveIsJ1 */
    public boolean getCouleurActiveIsJ1() {
        return couleurActiveIsJ1;
    }

    /** @param couleurActiveIsJ1 nouvelle valeur de couleurActiveIsJ1 */
    public void setCouleurActiveIsJ1(boolean couleurActiveIsJ1) {
        this.couleurActiveIsJ1 = couleurActiveIsJ1;
    }

    /** @return valeur de couleurOrdinateurIsJ1 */
    public boolean getCouleurOrdinateurIsJ1() {
        return couleurOrdinateurIsJ1;
    }
    
}