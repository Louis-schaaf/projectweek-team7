package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TekeningHangManTest {
    private TekeningHangMan hangMan;
    private Vorm vorm;



    @Before
    public void setUp() throws Exception {
        hangMan = new TekeningHangMan();
        vorm = new Rechthoek(new Punt(10,10),5,5);
    }

    @Test
    public void constructor_maakt_nieuw_object(){
        TekeningHangMan hangMannetje = new TekeningHangMan();
        assertEquals(18,hangMannetje.getAantalVormen());
        assertEquals("HangMan",hangMannetje.getNaam());
    }

    @Test
    public void getAantalOnzichtBaar() {
        assertEquals(14,hangMan.getAantalOnzichtBaar());
    }

    @Test
    public void zetVolgendeZichtbaar() {
        assertEquals(14,hangMan.getAantalOnzichtBaar());
        hangMan.zetVolgendeZichtbaar();
        assertEquals(13,hangMan.getAantalOnzichtBaar());

    }

    @Test (expected=DomainException.class)
    public void voegToe() {
        hangMan.voegToe(vorm);
    }

    @Test (expected=DomainException.class)
    public void verwijder() {
        hangMan.verwijder(vorm);
    }
}
