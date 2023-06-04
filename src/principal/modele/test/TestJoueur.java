/*
 * TestJoueur.java                                      2 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.modele.Joueur;

/** 
 * Test Unitaire de la classe 
 * @author groupe32
 */
class TestJoueur {

     /* fixture de test */
	private Joueur joueurVide;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    
    /**
     * Initialisation de plusieurs object Joueur
     */
    @BeforeEach 
    void InitialiserJeton(){
    	joueurVide = new Joueur(null);
        joueur1 = new Joueur("pseudo1");
        
        joueur2 = new Joueur("pseudo2");
        joueur2.incrementer();
        joueur2.incrementer();
        joueur2.incrementer();
        
        joueur3 = new Joueur("987654321");
        for (int i = 1; i <= 300; i++) {
    		assertDoesNotThrow(() -> joueur3.incrementer());;
    	}
        
    }
    
    /**
     * Test method for {@link principal.modele.Joueur#Joueur(java.lang.String)}.
     */
    @Test
    void testJoueur() {
        assertDoesNotThrow(() -> new Joueur(null));
        assertEquals(joueurVide.getScore(),0);
        assertEquals(joueurVide.getPseudo(),null);
    }

    /**
     * Test method for {@link principal.modele.Joueur#getScore()}.
     */
    @Test
    void testGetScore() {
    	assertDoesNotThrow(() -> joueur1.getScore());
    	assertEquals(joueur2.getScore(),3);
    	for (int i = 1; i < 100000; i++) {
    		joueur1.incrementer();
    		assertEquals(joueur1.getScore(),i);
    	}
    }

    /**
     * Test method for {@link principal.modele.Joueur#getPseudo()}.
     */
    @Test
    void testGetPseudo() {
    	assertEquals(joueur1.getPseudo(),"pseudo1");
    	assertEquals(joueur2.getPseudo(),"pseudo2");
    	assertNotEquals(joueur2.getPseudo(),"pseudo1");
    	assertEquals(joueur3.getPseudo(),"987654321");
        
    }

    /**
     * Test method for {@link principal.modele.Joueur#incrementer(int)}.
     */
    @Test
    void testIncrementer() {
    	assertDoesNotThrow(() -> joueur1.incrementer());
    	for (int i = 1; i < 100000; i++) {
    		assertDoesNotThrow(() -> joueur1.incrementer());;
    	}
    	
    }

    /**
     * Test method for {@link principal.modele.Joueur#decrementer(int)}.
     */
    @Test
    void testDecrementer() {
    	for (int i = 1; i <= 300; i++) {
    		assertDoesNotThrow(() -> joueur3.decrementer());
    	}
    	assertEquals(joueur3.getScore(),0);
    	assertThrows(IllegalArgumentException.class, () -> 
    							joueurVide.decrementer());
    }

}
