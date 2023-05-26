/*
 * Controleur.java                                      26 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package controleur.principal;

import modele.principal.Modele;
import vue.principal.Vue;

/** TODO comment class responsibility (SRP)
 * @author jodie.monterde
 *
 */
public class Controleur {

    Modele modele = new Modele();
    
    Vue vue = new Vue();

    /** TODO comment initial state
     * @param modele
     * @param vue
     */
    public Controleur(Modele modele, Vue vue) {
        super();
        this.modele = modele;
        this.vue = vue;
    }
    
    
}
