package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TekeningTest {
	private Vorm gebouw, gebouw2;
	private Vorm dak;
	private Vorm deur;
	private Vorm raam;
	private Vorm deurknop;
	private Vorm raambalk1;
	private Vorm raambalk2;
	private Vorm schouwNietInTekening;
	private Tekening tekening;
	
	@Before
	public void setUp() {
		gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
		gebouw2 = new Rechthoek(new Punt(100, 200), 200, 180);
		dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
		deur = new Rechthoek(new Punt(130, 280), 50,100);
		raam = new Rechthoek(new Punt(210, 220), 80, 60);
		deurknop = new Cirkel(new Punt(170, 320), 2);
		raambalk1 = new LijnStuk(new Punt(210, 250), new Punt(290, 250));
		raambalk2 = new LijnStuk(new Punt(250, 220), new Punt(250, 280));
		schouwNietInTekening = new Rechthoek(new Punt(150, 150), 20,40);
		tekening = new Tekening("tekening");
	}

	@Test
	public void Tekening_moet_een_tekening_aanmaken_met_een_geldige_naam_en_0_vormen() {
		Tekening huis = new Tekening("huis");
		assertEquals("huis", huis.getNaam());
		assertEquals(0, huis.getAantalVormen());
	}

	@Test (expected = DomainException.class)
	public void Tekening_moet_exception_gooien_als_naam_null() {
		new Tekening(null);
	}

	@Test (expected = DomainException.class)
	public void Tekening_moet_exception_gooien_als_naam_leeg() {
		new Tekening("");
	}

	@Test 
	public void getAantalVormen_moet_aantal_vormen_teruggeven() {
		Tekening huis = createHuisZonderShouw();
		assertEquals(7, huis.getAantalVormen());
	}

	@Test
	public void bevat_geeft_true_als_gegeven_vorm_deel_uitmaakt_van_de_tekening(){
		Tekening huis = createHuisZonderShouw();
		assertTrue(huis.bevat(deur));
	}

	@Test
	public void bevat_geeft_false__als_gegeven_vorm_geen_deel_uitmaakt_van_de_tekening(){
		Tekening huis = createHuisZonderShouw();
		assertFalse(huis.bevat(schouwNietInTekening));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		Tekening huis = createHuisZonderShouw();
		assertFalse(huis.equals(null));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_verschillend_aantal_vormen(){
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouw = createHuisMetSchouw();
		assertFalse(huis.equals(huisMetSchouw));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_ander_vorm(){
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
		assertFalse(huis.equals(huisMetSchouwZonderDeur));
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_andere_volgorde(){
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
		huisMetSchouwZonderDeur.verwijder(schouwNietInTekening);
		huisMetSchouwZonderDeur.voegToe(deur);
		assertTrue(huis.equals(huisMetSchouwZonderDeur));
	}
	
	@Test
	public void equals_moet_true_teruggeven_alsparameter_tekening_is_met_zelfde_aantal_vormen_zelfde_volgorde(){
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouw = createHuisMetSchouw();
		huisMetSchouw.verwijder(schouwNietInTekening);
		assertTrue(huis.equals(huisMetSchouw));
	}

	@Test (expected = DomainException.class)
	public void voeg_toe_met_vorm_null_Gooit_exception(){
		tekening.voegToe(null);
	}

	@Test (expected = DomainException.class)
	public void voeg_toe_met_bestaande_vorm_gooit_exception(){
		tekening.voegToe(gebouw);
		tekening.voegToe(gebouw2);
	}

	@Test
	public void voeg_toe_met_correcte_vorm_voegt_vorm_toe(){
		tekening.voegToe(gebouw);
		assertEquals(gebouw,tekening.getVorm(0));
	}

	@Test (expected = DomainException.class)
	public void getvorm_met_negatieve_index_gooit_exception(){
		tekening.getVorm(-3);
	}

	@Test (expected = DomainException.class)
	public void getvorm_met_te_grote_index_gooit_exception(){
		tekening.voegToe(gebouw);
		tekening.getVorm(1);
	}

	@Test
	public void getVorm_met_correcte_index_geeft_vorm_terug(){
		tekening.voegToe(gebouw);
		assertEquals(gebouw, tekening.getVorm(0));
	}

	@Test (expected = DomainException.class)
	public void verwijder_met_verkeerde_vorm_gooit_exception(){
		tekening.verwijder(gebouw);
	}

	@Test
	public void verwijder_met_correct_element_verwijderd_element(){
		tekening.voegToe(gebouw);
		tekening.verwijder(gebouw);
		assertEquals(0,tekening.getAantalVormen());
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_rechthoek_beginPunt_juist_en_breedte_Buiten_tekening_gooit_exception(){
		Punt punt = new Punt(10,10);
		Rechthoek rechthoek = new Rechthoek(punt,500,10);
		tekening.voegToe(rechthoek);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_rechthoek_beginPunt_juist_en_hoogte_Buiten_tekening_gooit_exception(){
		Punt punt = new Punt(10,10);
		Rechthoek rechthoek = new Rechthoek(punt,10,500);
		tekening.voegToe(rechthoek);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_lijnstuk_beginPunt_x_Buiten_tekening_gooit_exception(){
		Punt beginPunt = new Punt(500,10);
		Punt eindPunt = new Punt(10,10);
		LijnStuk lijnStuk = new LijnStuk(beginPunt,eindPunt);
		tekening.voegToe(lijnStuk);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_lijnstuk_beginPunt_y_Buiten_tekening_gooit_exception(){
		Punt beginPunt = new Punt(10,500);
		Punt eindPunt = new Punt(10,10);
		LijnStuk lijnStuk = new LijnStuk(beginPunt,eindPunt);
		tekening.voegToe(lijnStuk);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_lijnstuk_eindPunt_x_Buiten_tekening_gooit_exception(){
		Punt beginPunt = new Punt(10,10);
		Punt eindPunt = new Punt(500,10);
		LijnStuk lijnStuk = new LijnStuk(beginPunt,eindPunt);
		tekening.voegToe(lijnStuk);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_lijnstuk_eindPunt_y_Buiten_tekening_gooit_exception(){
		Punt beginPunt = new Punt(10,10);
		Punt eindPunt = new Punt(10,500);
		LijnStuk lijnStuk = new LijnStuk(beginPunt,eindPunt);
		tekening.voegToe(lijnStuk);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_cirkel_met_straal_Buiten_tekening_gooit_exception(){
		Punt middenPunt = new Punt(10,10);
		Cirkel cirkel = new Cirkel(middenPunt,500);
		tekening.voegToe(cirkel);
	}

	@Test(expected = DomainException.class)
	public void voegToe_met_driehoek_met_punt_Buiten_tekening_gooit_exception(){
		Punt hoekpunt1 = new Punt(10,10);
		Punt hoekpunt2 = new Punt(20,20);
		Punt hoekpunt3 = new Punt(500,520);
		Driehoek driehoek = new Driehoek(hoekpunt1,hoekpunt3,hoekpunt2);
		tekening.voegToe(driehoek);
	}

	public Tekening createHuisMetSchouw() {
		Tekening huisMetSchouw = new Tekening("huisMetSchouw");
		huisMetSchouw.voegToe(gebouw);
		huisMetSchouw.voegToe(dak);
		huisMetSchouw.voegToe(deur);
		huisMetSchouw.voegToe(raam);
		huisMetSchouw.voegToe(deurknop);
		huisMetSchouw.voegToe(raambalk1);
		huisMetSchouw.voegToe(raambalk2);
		huisMetSchouw.voegToe(schouwNietInTekening);
		return huisMetSchouw;
	}

	public Tekening createHuisZonderShouw() {
		Tekening huis = new Tekening("huis");
		huis.voegToe(gebouw);
		huis.voegToe(dak);
		huis.voegToe(deur);
		huis.voegToe(raam);
		huis.voegToe(deurknop);
		huis.voegToe(raambalk1);
		huis.voegToe(raambalk2);
		return huis;
	}

	public Tekening createHuisMetSchouwZonderDeur() {

		Tekening huisMetSchouwZonderDeur = new Tekening("huisMetSchouwZonderDeur");
		huisMetSchouwZonderDeur.voegToe(gebouw);
		huisMetSchouwZonderDeur.voegToe(dak);
		huisMetSchouwZonderDeur.voegToe(raam);
		huisMetSchouwZonderDeur.voegToe(deurknop);
		huisMetSchouwZonderDeur.voegToe(raambalk1);
		huisMetSchouwZonderDeur.voegToe(raambalk2);
		huisMetSchouwZonderDeur.voegToe(schouwNietInTekening);
		return huisMetSchouwZonderDeur;
	}


}
