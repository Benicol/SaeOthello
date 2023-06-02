/*
 * TestJoueur.java                                      2 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.modele.Jeton;
import principal.modele.Joueur;

/** 
 * Test Unitaire de la classe 
 * @author groupe32
 *
 */
class TestJoueur {


     /* fixture de test */
     
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    
    
    /**
     * Initialisation de plusieurs object Joueur
     */
    @BeforeEach 
    void InitialiserJeton(){
        joueur1 = new Joueur("pseudo1");
        
        joueur1 = new Joueur("pseudo2");
        
        joueur1 = new Joueur("pseudo3");
        
    }
    
    /**
     * Test method for {@link principal.modele.Joueur#Joueur(java.lang.String)}.
     */
    @Test
    void testJoueur() {
        assertDoesNotThrow(() -> new Joueur(null));
    }

    /**
     * Test method for {@link principal.modele.Joueur#getScore()}.
     */
    @Test
    void testGetScore() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link principal.modele.Joueur#getPseudo()}.
     */
    @Test
    void testGetPseudo() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link principal.modele.Joueur#incrementer(int)}.
     */
    @Test
    void testIncrementer() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link principal.modele.Joueur#decrementer(int)}.
     */
    @Test
    void testDecrementer() {
        fail("Not yet implemented");
    }

}
