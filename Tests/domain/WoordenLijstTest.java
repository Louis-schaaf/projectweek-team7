package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WoordenLijstTest {
	
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstMetEenGeldigWoord;
	private WoordenLijst woordenlijstMetGeldigeWoorden;
	private ArrayList<String> geldigeWoorden;

	@Before
	public void setUp() throws Exception {
		geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");
		
		woordenlijstLeeg = new WoordenLijst();
		
		woordenlijstMetEenGeldigWoord = new WoordenLijst();
		woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));
		
		woordenlijstMetGeldigeWoorden = new WoordenLijst();
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));
		
	}

	@Test
	public void WoordenLijst_moet_een_Woordenlijst_maken_zonder_woorden() {
		WoordenLijst woordenlijstLeeg = new WoordenLijst();
		assertEquals(0,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test
	public void voegToe_moet_een_woord_toevoegen() {
		woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
		
		assertEquals(1,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_null() {
		woordenlijstLeeg.voegToe(null);
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() {
		woordenlijstLeeg.voegToe("");
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() {
		String woordAlInLijst = geldigeWoorden.get(2);

		woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
	}

}