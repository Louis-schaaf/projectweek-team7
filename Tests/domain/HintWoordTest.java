package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class HintWoordTest {

    @Test
    public void HintWoord_moet_HintWoord_aanmaken_waarvan_alle_letters_verborgen_zijn() {
        String woord = "test";

        HintWoord hint = new HintWoord(woord);

        assertEquals(woord, hint.getWoord());

        assertEquals("_ _ _ _", hint.toString());
        assertFalse(hint.isGeraden());
    }

    @Test (expected = DomainException.class)
    public void HintWoord_moet_exception_gooien_als_woord_null(){
        new HintWoord(null);
    }

    @Test (expected = DomainException.class)
    public void HintWoord_moet_exception_gooien_als_woord_lege_string(){
        new HintWoord("");
    }

    @Test
    public void raad_moet_false_geven_als_letter_niet_in_woord(){
        HintWoord hint = new HintWoord("test");
        assertFalse(hint.raad('a'));
        assertFalse(hint.isGeraden());
    }

    @Test
    public void raad_moet_false_geven_als_letter_in_woord_maar_reeds_geraden(){
        HintWoord hint = new HintWoord("test");
        assertTrue(hint.raad('e'));
        assertFalse(hint.raad('e'));
        assertFalse(hint.isGeraden());
    }

    @Test
    public void raad_moet_true_geven_en_hint_aanpassen_als_letter_in_woord(){
        HintWoord hint = new HintWoord("test");
        assertTrue(hint.raad('e'));
        assertEquals("_ e _ _", hint.toString());
        assertFalse(hint.isGeraden());
    }

    @Test
    public void raad_moet_true_geven_en_hint_aanpassen_als_letter_in_woord_maar_in_verkeerde_case(){
        HintWoord hint = new HintWoord("test");
        assertTrue(hint.raad('E'));
        assertEquals("_ e _ _", hint.toString());
        assertFalse(hint.isGeraden());
    }

    @Test
    public void raad_moet_true_geven_en_hint__op_meerdere_plaatsen_aanpassen_als_letter_meermaals_in_woord(){
        HintWoord hint = new HintWoord("test");
        assertTrue(hint.raad('t'));
        assertEquals("t _ _ t", hint.toString());
        assertFalse(hint.isGeraden());
    }

    @Test
    public void isGeraden_geeft_true_als_alle_letters_geraden(){
        HintWoord hint = new HintWoord("test");
        assertTrue(hint.raad('e'));
        assertTrue(hint.raad('t'));
        assertTrue(hint.raad('s'));

        assertTrue(hint.isGeraden());
    }

}
