package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OmhullendeTest {

	private Punt linkerBovenhoek;
	private int breedte, hoogte;
	private Omhullende omhullende;

	@Before
	public void setUp() {
		linkerBovenhoek = new Punt(200, 200);
		breedte = 20;
		hoogte = 40;
		omhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
	}

	@Test
	public void Omhullende_moet_omhullende_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() {
		Omhullende omhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
		assertEquals(linkerBovenhoek, omhullende.getLinkerBovenhoek());
		assertEquals(hoogte, omhullende.getHoogte());
		assertEquals(breedte, omhullende.getBreedte());
	}
	
	@Test (expected = DomainException.class)
	public void Omhullende_Moet_exception_gooien_als_linkerbovenhoek_null()  {
		new Omhullende(null, breedte, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Omhullende_Moet_exception_gooien_als_breedte_kleiner_dan_0()  {
		new Omhullende(linkerBovenhoek, -1, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Omhullende_Moet_exception_gooien_als_hoogte_kleiner_dan_0()  {
		new Omhullende(linkerBovenhoek, breedte, -1);
	}

	@Test
	public void Omhullende_Moet_omhullende_maken_als_breedte_gelijk_aan_0()  {
		Omhullende omhullende = new Omhullende(linkerBovenhoek,0, hoogte);
		assertEquals(0, omhullende.getBreedte());
	}
	
	@Test
	public void Omhullende_Moet_omhullende_maken_als_hoogte_gelijk_aan_0()  {
		Omhullende omhullende = new Omhullende(linkerBovenhoek,breedte, 0);
		assertEquals(0, omhullende.getHoogte());
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn(){
		Omhullende zelfdeOmhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
		assertTrue(omhullende.equals(zelfdeOmhullende));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt(){
		Punt andereLinkerBovenhoek = new Punt(100,100);
		Omhullende verschillendeOmhullende = new Omhullende(andereLinkerBovenhoek, breedte, hoogte);
		assertFalse(omhullende.equals(verschillendeOmhullende));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_breedte_verschilt(){
		Omhullende verschillendeOmhullende = new Omhullende(linkerBovenhoek, breedte + 10, hoogte);
		assertFalse(omhullende.equals(verschillendeOmhullende));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoogte_verschilt(){
		Omhullende verschillendeOmhullende = new Omhullende(linkerBovenhoek, breedte, hoogte + 10);
		assertFalse(omhullende.equals(verschillendeOmhullende));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(omhullende.equals(null));
	}
}
