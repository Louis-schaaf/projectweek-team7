package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Speler;

public class SpelerTest {
	
	private String naam;
	private String anderenaam;
	private int positiveScore;
	private int negativeScore;
	private Speler speler;

	@Before
	public void setUp() throws Exception {
		naam = "Lars";
		anderenaam = "Lies";
		positiveScore = 5;
		negativeScore = -5;
		speler = new Speler(naam);
	}

	@Test
	public void Speler_moet_speler_aanmaken_met_gegeven_naam() {
		speler = new Speler(naam);
		assertEquals(naam, speler.getNaam());
		assertEquals(0, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void Speler_moet_exception_gooien_als_naam_null() {
		speler = new Speler(null);
	}
	
	@Test (expected = DomainException.class)
	public void Speler_moet_exception_gooien_als_naam_bestaat_uit_enkel_spaties() {
		speler = new Speler("   ");
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_naam_en_score_gelijk_zijn(){
		speler.addToScore(positiveScore);
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(positiveScore);
		
		assertTrue(speler.equals(andereSpeler));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(speler.equals(null));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_speler_een_andere_naam_heeft(){
		Speler andereSpeler = new Speler(anderenaam);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_speler_aan_andere_score_heeft(){
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(positiveScore);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void addToScore_moet_gegeven_score_toevoegen_aan_bestaande_score(){
		speler.addToScore(positiveScore);
		assertEquals(positiveScore, speler.getScore());
	}
	
	@Test
	public void addtoScore_mag_negatieve_score_toevoegen_als_de_resulterende_score_niet_negatief_wordt(){
		speler.addToScore(positiveScore);
		speler.addToScore(positiveScore);
		speler.addToScore(negativeScore);
		assertEquals(positiveScore, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void addToScore_moet_exception_gooien_als_resulterende_score_negatief_wordt(){
		speler.addToScore(negativeScore);
	}
}
