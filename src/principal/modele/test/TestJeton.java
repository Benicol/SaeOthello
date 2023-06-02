/*
 * TestJeton.java                                      2 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.modele.Jeton;

/** 
 * Test Unitaire de principal.modele.Jeton
 * @author groupe32
 *
 */
class TestJeton {
    
    
    /* fixture de test */
    private Jeton jeton1;
    private Jeton jeton2;
    private Jeton jeton3;
    
    /**
     * Initialisation de plusieurs object Jeton
     */
    @BeforeEach 
    void InitialiserJeton(){
        jeton1 = new Jeton();
        jeton1.setCouleurJ1(true);
        
        jeton2 = new Jeton();
        jeton2.devientAfficher();
        
        jeton3 = new Jeton();
        
    }

    /**
     * Test method for {@link principal.modele.Jeton#Jeton()}.
     */
    @Test
    void testJeton() {
        assertFalse(new Jeton().isCouleurJ1());
        assertFalse(new Jeton().isAfficher());
        assertDoesNotThrow(() -> new Jeton());
    }

    /**
     * Test method for {@link principal.modele.Jeton#isCouleurJ1()}.
     */
    @Test
    void testIsCouleurJ1() {
        assertTrue(jeton1.isCouleurJ1());
        jeton1.setCouleurJ1(false);
        assertFalse(jeton1.isCouleurJ1());
        assertFalse(jeton2.isCouleurJ1());
        assertDoesNotThrow(() -> jeton1.isCouleurJ1());
    }

    /**
     * Test method for {@link principal.modele.Jeton#setCouleurJ1(boolean)}.
     */
    @Test
    void testSetCouleurJ1() {
        jeton2.setCouleurJ1(true);
        assertTrue(jeton2.isCouleurJ1());
        assertFalse(jeton3.isCouleurJ1());
        jeton3.setCouleurJ1(true);
        assertTrue(jeton3.isCouleurJ1());
        assertDoesNotThrow(() -> jeton1.setCouleurJ1(true));
    }

    /**
     * Test method for {@link principal.modele.Jeton#isAfficher()}.
     */
    @Test
    void testIsAfficher() {
         assertTrue(jeton2.isAfficher());
         assertFalse(jeton1.isAfficher());
         assertDoesNotThrow(() -> jeton1.isAfficher());
    }

    /**
     * Test method for {@link principal.modele.Jeton#devientAfficher()}.
     */
    @Test
    void testDevientAfficher() {
        jeton1.devientAfficher();
        assertTrue(jeton1.isAfficher());
        assertDoesNotThrow(() -> jeton1.devientAfficher());
    }

    /**
     * Test method for {@link principal.modele.Jeton#switchCouleurJ1()}.
     */
    @Test
    void testSwitchCouleurJ1() {
        assertTrue(jeton1.isCouleurJ1());
        assertDoesNotThrow(() -> jeton1.switchCouleurJ1());
    }

}
