package principal.modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.modele.Joueur;
import principal.modele.Modele;
import principal.modele.Plateau;
import principal.modele.Theme;

class TestModele {
	
	/* fixture de test */
	private Theme theme1;
	private Theme theme2;
	private Theme theme3;
	
	private Joueur joueur1;
	private Joueur joueur1bis;
	private Joueur joueur2;
	private Joueur joueur2bis;
	
	private Plateau plateau1;
	private Plateau plateau2;
	private Plateau plateau3;
	
	/**
     * Initialisation de plusieurs object Joueur,Theme et Plateau pour initialiser le modele
     */
	@BeforeEach 
    void InitialiserModele(){
    	theme1 = new Theme("#000000","#FFFFFF");
    	Modele.setPalette(theme1);
    	
    	theme2 = new Theme("#496BAB","#B00909");
    	theme3 = new Theme("#FFFFFF","#789CDF");
    	
    	joueur1  = new Joueur("Power Rangers");
    	joueur1bis = new Joueur("Force Rouge");
    	joueur2 = new Joueur("Force Bleu");
    	joueur2bis = new Joueur("Force Doré");
    	
    	plateau1 = new Plateau();
    	plateau2 = new Plateau();
    	plateau3 = new Plateau();
    	
        
    	
    	Modele.setPlateauJeu(plateau1);
    	Modele.setPseudoVainqueur("Noah");
    	Modele.setJoueur1(joueur1);
    	Modele.setJoueur2(joueur2);
    	Modele.setDernierMenuOuvert(4);
    	Modele.setPartieCharge(true);
    }

	/**
     * Test method for {@link principal.modele.Modele#getPalette()}.
     */
	@Test
	void testGetPalette() {
		assertDoesNotThrow(() -> Modele.getPalette());
		assertEquals(Modele.getPalette(), theme1);
		assertNotEquals(Modele.getPalette(), theme2);
		assertNotEquals(Modele.getPalette(), theme3);
	}

	/**
     * Test method for {@link principal.modele.Modele#setPalette(Theme)}.
     */
	@Test
	void testSetPalette() {
		assertDoesNotThrow(() -> Modele.setPalette(theme3));
		assertEquals(Modele.getPalette(), theme3);
		assertNotEquals(Modele.getPalette(), theme2);
		Modele.setPalette(theme2);
		assertEquals(Modele.getPalette(), theme2);
		assertNotEquals(Modele.getPalette(), theme1);
	}

	/**
     * Test method for {@link principal.modele.Modele#getPseudoVainqueur()}.
     */
	@Test
	void testGetPseudoVainqueur() {
		assertDoesNotThrow(() -> Modele.getPseudoVainqueur());
		assertEquals(Modele.getPseudoVainqueur(),"Noah");
		assertNotEquals(Modele.getPseudoVainqueur(),"Jodie");
	}

	/**
     * Test method for {@link principal.modele.Modele#setPseudoVainqueur(String)}.
     */
	@Test
	void testSetPseudoVainqueur() {
		assertDoesNotThrow(() -> Modele.setPseudoVainqueur("Loline"));
		assertEquals(Modele.getPseudoVainqueur(),"Loline");
		assertNotEquals(Modele.getPseudoVainqueur(),"Noah");
		Modele.setPseudoVainqueur("Benjamin");
		assertEquals(Modele.getPseudoVainqueur(),"Benjamin");
		assertNotEquals(Modele.getPseudoVainqueur(),"Jodie");
	}

	/**
     * Test method for {@link principal.modele.Modele#getDernierMenuOuvert()}.
     */
	@Test
	void testGetDernierMenuOuvert() {
		assertDoesNotThrow(() -> Modele.getDernierMenuOuvert());
		assertEquals(Modele.getDernierMenuOuvert(),4);
		assertNotEquals(Modele.getDernierMenuOuvert(),7);
	}

	/**
     * Test method for {@link principal.modele.Modele#setDernierMenuOuvert(int)}.
     */
	@Test
	void testSetDernierMenuOuvert() {
		assertDoesNotThrow(() -> Modele.setDernierMenuOuvert(1));
		assertEquals(Modele.getDernierMenuOuvert(),1);
		assertNotEquals(Modele.getDernierMenuOuvert(),4);
		Modele.setDernierMenuOuvert(3);
		assertEquals(Modele.getDernierMenuOuvert(),3);
		assertNotEquals(Modele.getDernierMenuOuvert(),1);
	}

	/**
     * Test method for {@link principal.modele.Modele#isMode1Joueur()}.
     */
	@Test
	void testIsMode1Joueur() {
		assertDoesNotThrow(() -> Modele.isMode1Joueur());
		assertFalse(Modele.isMode1Joueur());
		assertTrue(!Modele.isMode1Joueur());
	}

	/**
     * Test method for {@link principal.modele.Modele#setMode1Joueur(boolean)}.
     */
	@Test
	void testSetMode1Joueur() {
		assertDoesNotThrow(() -> Modele.setMode1Joueur(true));
		assertTrue(Modele.isMode1Joueur());
		assertFalse(!Modele.isMode1Joueur());
	}

	/**
     * Test method for {@link principal.modele.Modele#getJoueur1()}.
     */
	@Test
	void testGetJoueur1() {
		assertDoesNotThrow(() -> Modele.getJoueur1());
		assertEquals(Modele.getJoueur1(),joueur1);
		assertNotEquals(Modele.getJoueur1(),joueur1bis);
	}

	/**
     * Test method for {@link principal.modele.Modele#setJoueur1(Joueur)}.
     */
	@Test
	void testSetJoueur1() {
		assertDoesNotThrow(() -> Modele.setJoueur1(joueur1bis));
		assertNotEquals(Modele.getJoueur1(),joueur1);
		assertEquals(Modele.getJoueur1(),joueur1bis);
	}

	/**
     * Test method for {@link principal.modele.Modele#getJoueur2()}.
     */
	@Test
	void testGetJoueur2() {
		assertDoesNotThrow(() -> Modele.getJoueur2());
		assertEquals(Modele.getJoueur2(),joueur2);
		assertNotEquals(Modele.getJoueur2(),joueur2bis);
	}

	/**
     * Test method for {@link principal.modele.Modele#setJoueur2(Joueur)}.
     */
	@Test
	void testSetJoueur2() {
		assertDoesNotThrow(() -> Modele.setJoueur2(joueur2bis));
		assertNotEquals(Modele.getJoueur2(),joueur2);
		assertEquals(Modele.getJoueur2(),joueur2bis);
	}

	/**
     * Test method for {@link principal.modele.Modele#isMode1JoueurDifficile()}.
     */
	@Test
	void testIsMode1JoueurDifficile() {
		assertDoesNotThrow(() -> Modele.isMode1JoueurDifficile());
		assertFalse(Modele.isMode1JoueurDifficile());
		assertTrue(!Modele.isMode1JoueurDifficile());
	}
    
	/**
     * Test method for {@link principal.modele.Modele#setMode1JoueurDifficile(boolean)}.
     */
	@Test
	void testSetMode1JoueurDifficile() {
		assertDoesNotThrow(() -> Modele.setMode1JoueurDifficile(true));
		assertTrue(Modele.isMode1JoueurDifficile());
		assertFalse(!Modele.isMode1JoueurDifficile());
	}

	/**
     * Test method for {@link principal.modele.Modele#isJoueurPrecedentPasser()}.
     */
	@Test
	void testIsJoueurPrecedentPasser() {
		assertDoesNotThrow(() -> Modele.isJoueurPrecedentPasser());
		assertTrue(Modele.isJoueurPrecedentPasser());
		assertFalse(!Modele.isJoueurPrecedentPasser());
	}

	/**
     * Test method for {@link principal.modele.Modele#setJoueurPrecedentPasser(boolean)}.
     */
	@Test
	void testSetJoueurPrecedentPasser() {
		assertDoesNotThrow(() -> Modele.setJoueurPrecedentPasser(true));
		assertTrue(Modele.isJoueurPrecedentPasser());
		assertFalse(!Modele.isJoueurPrecedentPasser());
	}

	/**
     * Test method for {@link principal.modele.Modele#getPlateauJeu()}.
     */
	@Test
	void testGetPlateauJeu() {
		assertDoesNotThrow(() -> Modele.getPlateauJeu());
		assertEquals(Modele.getPlateauJeu(),plateau1);
		assertNotEquals(Modele.getPlateauJeu(),plateau2);
		assertNotEquals(Modele.getPlateauJeu(),plateau3);
	}

	/**
     * Test method for {@link principal.modele.Modele#setPlateauJeu(Plateau)}.
     */
	@Test
	void testSetPlateauJeu() {
		assertDoesNotThrow(() -> Modele.setPlateauJeu(plateau2));
		assertNotEquals(Modele.getPlateauJeu(),plateau1);
		assertEquals(Modele.getPlateauJeu(),plateau2);
		assertNotEquals(Modele.getPlateauJeu(),plateau3);
		Modele.setPlateauJeu(plateau3);
		assertNotEquals(Modele.getPlateauJeu(),plateau1);
		assertEquals(Modele.getPlateauJeu(),plateau3);
		assertNotEquals(Modele.getPlateauJeu(),plateau2);
	}

	/**
     * Test method for {@link principal.modele.Modele#isPartieCharge()}.
     */
	@Test
	void testIsPartieCharge() {
		assertDoesNotThrow(() -> Modele.isPartieCharge());
		assertTrue(Modele.isPartieCharge());
		assertFalse(!Modele.isPartieCharge());
	}

	/**
     * Test method for {@link principal.modele.Modele#setPartieCharge(false)}.
     */
	@Test
	void testSetPartieCharge() {
		assertDoesNotThrow(() -> Modele.setPartieCharge(false));
		assertFalse(Modele.isPartieCharge());
		assertTrue(!Modele.isPartieCharge());
	}

	/**
     * Test method for {@link principal.modele.Modele#estTourOrdinateur()}.
     */
	@Test
	void testEstTourOrdinateur() {
		assertDoesNotThrow(() -> Modele.estTourOrdinateur());
		assertFalse(Modele.estTourOrdinateur());
		assertTrue(!Modele.estTourOrdinateur());
	}
}
