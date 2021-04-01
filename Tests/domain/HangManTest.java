package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HangManTest {

    private HangMan hangman;
    private Speler geldigeSpeler;
    private WoordenLijst geldigeWoordenlijst;
    private WoordenLijst woordenlijstMetEnkelWoordTest;

    @Before
    public void setUp() throws Exception {
        geldigeSpeler = new Speler("naam");

        geldigeWoordenlijst = new WoordenLijst();
        geldigeWoordenlijst.voegToe("test");

        hangman = new HangMan(geldigeSpeler, geldigeWoordenlijst);

        woordenlijstMetEnkelWoordTest = new WoordenLijst();
        woordenlijstMetEnkelWoordTest.voegToe("test");
    }

    @Test
    public void HangMan_moet_een_HangMan_spel_maken_en_initialiseren_voor_de_gegeven_speler_met_de_gegeven_woordenlijst() {
        hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
        assertEquals(geldigeSpeler, hangman.getSpeler());
        assertFalse(hangman.isGameOver());
        assertFalse(hangman.isGewonnen());
        assertEquals("_ _ _ _", hangman.getHint());
    }

    @Test (expected = DomainException.class)
    public void HangMan_moet_een_exception_gooien_als_gegeven_speler_null() {
        hangman = new HangMan(null, geldigeWoordenlijst);
    }

    @Test (expected = DomainException.class)
    public void HangMan_moet_een_exception_gooien_als_gegeven_woordenlijst_null() {
        hangman = new HangMan(geldigeSpeler, null);
    }

    @Test (expected = DomainException.class)
    public void HangMan_moet_een_exception_gooien_als_gegeven_woordenlijst_leeg() {
        WoordenLijst legeWoordenlijst = new WoordenLijst();
        assertEquals(0, legeWoordenlijst.getAantalWoorden());
        hangman = new HangMan(geldigeSpeler, legeWoordenlijst);
    }

    // De testen voor wat er gebeurt als je een foutieve letter (null, leeg, meer dan 1 karakter)
    // meegeeft, worden hier niet herhaald, die zitten al in de HintWoordTest
    @Test
    public void raad_moet_volgende_zichtbaar_zetten_indien_fout_geraden(){
        hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
        char letter = 'a';
        assertEquals(14, hangman.getTekening().getAantalOnzichtBaar());

        assertFalse(hangman.raad(letter));
        assertEquals(13, hangman.getTekening().getAantalOnzichtBaar());
        assertFalse(hangman.isGameOver());
        assertFalse(hangman.isGewonnen());
    }

    @Test
    public void raad_mag_volgende_niet_zichtbaar_zetten_indien_juist_geraden(){
        hangman = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
        char letter = 'e';
        assertEquals(14, hangman.getTekening().getAantalOnzichtBaar());

        hangman.raad(letter);
        assertEquals(14, hangman.getTekening().getAantalOnzichtBaar());
        assertFalse(hangman.isGameOver());
        assertFalse(hangman.isGewonnen());
    }

    @Test
    public void raad_mag_volgende_niet_zichtbaar_zetten_en_gewonnen_op_true_als_laatste_letter_juist_geraden(){
        HangMan hangmanOp1NaGeraden = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
        assertTrue(hangmanOp1NaGeraden.raad('t'));
        assertTrue(hangmanOp1NaGeraden.raad('e'));

        assertTrue(hangmanOp1NaGeraden.raad('s'));

        assertEquals(14, hangmanOp1NaGeraden.getTekening().getAantalOnzichtBaar());
        assertFalse(hangmanOp1NaGeraden.isGameOver());
        assertTrue(hangmanOp1NaGeraden.isGewonnen());
    }

    @Test
    public void raad_moet_volledige_afbeelding_zichtbaar_zetten_en_gameover_op_true_als_laatste_kans_fout_geraden(){
        HangMan hangmanNietGeradenEn13FouteAntwoorden = new HangMan(geldigeSpeler, woordenlijstMetEnkelWoordTest);
        for(int i = 0; i < 13; i++){
            assertFalse(hangmanNietGeradenEn13FouteAntwoorden.raad('a'));
        }

        assertFalse(hangmanNietGeradenEn13FouteAntwoorden.raad('o'));

        assertEquals(0, hangmanNietGeradenEn13FouteAntwoorden.getTekening().getAantalOnzichtBaar());
        assertTrue(hangmanNietGeradenEn13FouteAntwoorden.isGameOver());
        assertFalse(hangmanNietGeradenEn13FouteAntwoorden.isGewonnen());
    }

}
