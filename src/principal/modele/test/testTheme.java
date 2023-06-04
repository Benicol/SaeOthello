/*
 * TestSetCouleur.java                                      1 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.modele.Theme;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
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

}
