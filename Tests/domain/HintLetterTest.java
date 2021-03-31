package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HintLetterTest {
    @Test
    public void HintLetter_moet_HintLetter_maken_die_niet_geraden_is() {
        HintLetter letter = new HintLetter('a');

        assertFalse(letter.isGeraden());
    }

    @Test
    public void raad_moet_true_teruggeven_en_op_geraden_zetten_als_juiste_letter() {
        HintLetter letter = new HintLetter('x');

        assertTrue(letter.raad('x'));
        assertTrue(letter.isGeraden());
    }

    @Test
    public void raad_moet_true_teruggeven_en_op_geraden_zetten_als_juiste_letter_maar_upperCase_in_plaats_van_lowercase() {
        HintLetter letter = new HintLetter('x');

        assertTrue(letter.raad('X'));
        assertTrue(letter.isGeraden());
    }

    @Test
    public void raad_moet_true_teruggeven_en_op_geraden_zetten_als_juiste_letter_maar_lowerCase_in_plaats_van_uppercase() {
        HintLetter letter = new HintLetter('X');

        assertTrue(letter.raad('x'));
        assertTrue(letter.isGeraden());
    }

    @Test
    public void raad_moet_false_teruggeven_als_verkeerde_letter() {
        HintLetter letter = new HintLetter('x');

        assertFalse(letter.raad('y'));
        assertFalse(letter.isGeraden());
    }

    @Test
    public void raad_moet_false_teruggeven_maar_op_geraden_laten_staan_als_juiste_letter_maar_reeds_geraden() {
        HintLetter letter = new HintLetter('f');

        assertTrue(letter.raad('f'));
        assertTrue(letter.isGeraden());
        assertFalse(letter.raad('f'));
    }

    @Test
    public void toChar_moet_letter_tonen_als_geraden() {
        HintLetter letter = new HintLetter('x');
        assertTrue(letter.raad('x'));

        assertEquals('x', letter.toChar());
        ;
    }

    @Test
    public void toChar_moet_streepje_teruggeven_als_niet_geraden() {
        HintLetter letter = new HintLetter('x');

        assertEquals('_', letter.toChar());
    }

    @Test
    public void getLetter_moet_letter_teruggeven_als_geraden() {
        HintLetter letter = new HintLetter('x');
        assertTrue(letter.raad('x'));

        assertEquals('x', letter.toChar());
    }

    @Test
    public void getLetter_moet_letter_teruggeven_als_niet_geraden() {
        HintLetter letter = new HintLetter('x');

        assertEquals('x', letter.getLetter());
    }
}