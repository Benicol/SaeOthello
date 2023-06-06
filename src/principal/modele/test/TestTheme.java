package principal.modele.test;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.modele.Jeton;
import principal.modele.Plateau;
import principal.modele.Theme;

class TestTheme {

	
	/* fixture de test */
    private Theme theme1;
    private Theme theme2;
    private Theme theme3;
    
    /**
     * Initialisation de plusieurs object Theme
     */
    @BeforeEach 
    void InitialiserTheme(){
    	theme1 = new Theme("#000000","#FFFFFF");
    	theme1.switchCouleurActive();
    	
    	
        theme2 = new Theme("#FFFFFF","#000000");
        theme2.switchCouleurActive();
        
        theme3 = new Theme("#ABCDEF","#CFC3F7");
        theme3.setCouleurOrdinateurIsJ1(false);
    }
    
    /**
     * Test method for {@link principal.modele.Theme#Theme(String,String)}.
     */
	@Test
	void testTheme() {
		assertDoesNotThrow(() -> new Theme("#000000","#FFFFFF"));
	}

	/**
     * Test method for {@link principal.modele.Theme#getCouleurJ1()}.
     */
	@Test
	void testGetCouleurJ1() {
		assertDoesNotThrow(() -> theme1.getCouleurJ1());
		assertEquals(theme1.getCouleurJ1(),"#000000");
		assertEquals(theme2.getCouleurJ1(),"#FFFFFF");
		assertEquals(theme3.getCouleurJ1(),"#ABCDEF");
		assertNotEquals(theme1.getCouleurJ1(),"#FFFFFF");
		assertNotEquals(theme2.getCouleurJ1(),"#000000");
		assertNotEquals(theme3.getCouleurJ1(),"#CFC3F7");
	}

	/**
     * Test method for {@link principal.modele.Theme#getCouleurJ2()}.
     */
	@Test
	void testGetCouleurJ2() {
		assertDoesNotThrow(() -> theme1.getCouleurJ2());
		assertNotEquals(theme1.getCouleurJ2(),"#000000");
		assertNotEquals(theme2.getCouleurJ2(),"#FFFFFF");
		assertNotEquals(theme3.getCouleurJ2(),"#ABCDEF");
		assertEquals(theme1.getCouleurJ2(),"#FFFFFF");
		assertEquals(theme2.getCouleurJ2(),"#000000");
		assertEquals(theme3.getCouleurJ2(),"#CFC3F7");
	}

	/**
     * Test method for {@link principal.modele.Theme#getCouleurActive()}.
     */
	@Test
	void testGetCouleurActive() {
		assertDoesNotThrow(() -> theme1.getCouleurActive());
		assertEquals(theme1.getCouleurActive(),"#000000");
		assertEquals(theme2.getCouleurActive(),"#FFFFFF");
		assertEquals(theme3.getCouleurActive(),"#CFC3F7");
		assertNotEquals(theme1.getCouleurActive(),"#FFFFFF");
		assertNotEquals(theme2.getCouleurActive(),"#000000");
		assertNotEquals(theme3.getCouleurActive(),"#ABCDEF");
	}

	/**
     * Test method for {@link principal.modele.Theme#resetCouleurActive()}.
     */
	@Test
	void testResetCouleurActive() {
		assertDoesNotThrow(() -> theme1.resetCouleurActive());
		theme1.resetCouleurActive();
		theme2.resetCouleurActive();
		assertEquals(theme1.getCouleurActive(),"#FFFFFF");
		assertEquals(theme2.getCouleurActive(),"#000000");
		assertNotEquals(theme1.getCouleurActive(),"#000000");
		assertNotEquals(theme2.getCouleurActive(),"#FFFFFF");
	}

	/**
     * Test method for {@link principal.modele.Theme#switchCouleurActive()}.
     */
	@Test
	void testSwitchCouleurActive() {
		assertDoesNotThrow(() -> theme1.switchCouleurActive());
		theme1.switchCouleurActive();
		theme2.switchCouleurActive();
		theme3.switchCouleurActive();
		assertEquals(theme1.getCouleurActive(),"#000000");
		assertEquals(theme2.getCouleurActive(),"#000000");
		assertEquals(theme3.getCouleurActive(),"#ABCDEF");
	}
	
	/**
     * Test method for {@link principal.modele.Theme#getCouleurOppose(String)}.
     */
	@Test
	void testGetCouleurOppose() {
		assertDoesNotThrow(() -> theme1.getCouleurOppose(theme1.getCouleurJ1()));
		assertEquals(theme1.getCouleurOppose(theme1.getCouleurJ1()),"#FFFFFF");
		assertEquals(theme2.getCouleurOppose(theme2.getCouleurJ1()),"#000000");
		assertEquals(theme3.getCouleurOppose(theme3.getCouleurJ1()),"#CFC3F7");
		assertEquals(theme2.getCouleurOppose(theme2.getCouleurJ2()),"#FFFFFF");
		assertEquals(theme1.getCouleurOppose(theme1.getCouleurJ2()),"#000000");
		assertEquals(theme3.getCouleurOppose(theme3.getCouleurJ2()),"#ABCDEF");
	}
	
	/**
     * Test method for {@link principal.modele.Theme#getCouleurOrdinateurIsJ1()}.
     */
	@Test
	void testGetCouleurOrdinateurIsJ1() {
		assertDoesNotThrow(() -> theme1.getCouleurOrdinateurIsJ1());
		assertTrue(theme1.getCouleurOrdinateurIsJ1());
		assertTrue(theme2.getCouleurOrdinateurIsJ1());
		assertFalse(theme3.getCouleurOrdinateurIsJ1());
	}

	/**
     * Test method for {@link principal.modele.Theme#getCouleurOrdinateur()}.
     */
	@Test
	void testGetCouleurOrdinateur() {
		assertDoesNotThrow(() -> theme1.getCouleurOrdinateur());
		assertEquals(theme1.getCouleurOrdinateur(),"#000000");
		assertEquals(theme2.getCouleurOrdinateur(),"#FFFFFF");
		assertNotEquals(theme3.getCouleurOrdinateur(),"#ABCDEF");
	}

	/**
     * Test method for {@link principal.modele.Theme#setCouleurOrdinateurIsJ1(boolean)}.
     */
	@Test
	void testSetCouleurOrdinateurIsJ1() {
		assertDoesNotThrow(() -> theme1.setCouleurOrdinateurIsJ1(false));
		theme3.setCouleurOrdinateurIsJ1(true);
		assertFalse(theme1.getCouleurOrdinateurIsJ1());
		assertEquals(theme3.getCouleurOrdinateur(),"#ABCDEF");
	}

	/**
     * Test method for {@link principal.modele.Theme#setCouleurJ1(String)}.
     */
	@Test
	void testSetCouleurJ1() {
		assertDoesNotThrow(() -> theme2.setCouleurJ1("#ABABAB"));
		theme1.setCouleurJ1("#001122");
		assertEquals(theme1.getCouleurJ1(),"#001122");
		assertEquals(theme2.getCouleurJ1(),"#ABABAB");
	}

	/**
     * Test method for {@link principal.modele.Theme#setCouleurJ2(String)}.
     */
	@Test
	void testSetCouleurJ2() {
		assertDoesNotThrow(() -> theme2.setCouleurJ2("#A1B2C3"));
		theme1.setCouleurJ2("#496BAB");
		assertEquals(theme1.getCouleurJ2(),"#496BAB");
		assertEquals(theme2.getCouleurJ2(),"#A1B2C3");
	}

	/**
     * Test method for {@link principal.modele.Theme#getCouleurActiveIsJ1()}.
     */
	@Test
	void testGetCouleurActiveIsJ1() {
		assertDoesNotThrow(() -> theme1.getCouleurActiveIsJ1());
		assertTrue(theme1.getCouleurActiveIsJ1());
		assertTrue(theme2.getCouleurActiveIsJ1());
		assertFalse(theme3.getCouleurActiveIsJ1());
	}

	/**
     * Test method for {@link principal.modele.Theme#setCouleurActiveIsJ1(boolean)}.
     */
	@Test
	void testSetCouleurActiveIsJ1() {
		assertDoesNotThrow(() -> theme2.setCouleurActiveIsJ1(false));
		theme3.setCouleurActiveIsJ1(true);
		assertFalse(theme2.getCouleurActiveIsJ1());
		assertTrue(theme3.getCouleurActiveIsJ1());
	}

}
