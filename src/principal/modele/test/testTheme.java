/*
 * TestSetCouleur.java                                      1 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Paint;
import principal.modele.Theme;

/** 
 * méthode de test de la classe Theme.java
 * @author groupe32
 */
class TestSetCouleur {
    Theme test = new Theme("#FFFFFF", "#000000");
    

    /**
     * Test method for {@link principal.modele.SetCouleur#getCouleurJ1()}.
     */
    @Test
    void testGetCouleurJ1() {
        assertEquals("#FFFFFF", test.getCouleurJ1());
        assertNotEquals("#FFFFFF", test.getCouleurJ2());
    }

    /**
     * Test method for {@link principal.modele.SetCouleur#getCouleurJ2()}.
     */
    @Test
    void testGetCouleurJ2() {
        assertEquals("#000000", test.getCouleurJ2());
        assertNotEquals("#000000", test.getCouleurJ1());
    }

    /**
     * Test method for {@link principal.modele.SetCouleur#getCouleurOppose(javafx.scene.paint.Paint)}.
     */
    @Test
    void testGetCouleurOppose() {
        assertEquals("#000000", test.getCouleurOppose("#FFFFFF"));
        assertEquals("#FFFFFF", test.getCouleurOppose("#000000"));
    }

    /**
     * Test method for {@link principal.modele.SetCouleur#getCouleurActive(javafx.scene.paint.Paint)}.
     */
    @Test
    void testGetCouleurActive() {
        assertEquals("#000000", test.getCouleurActive());
        assertNotEquals("#FFFFFF", test.getCouleurActive());
    }

    /**
     * Test method for {@link principal.modele.SetCouleur#switchCouleurActive(javafx.scene.paint.Paint)}.
     */
    @Test
    void testSwitchCouleurActive() {
        assertDoesNotThrow(() -> test.switchCouleurActive());
    }



}
