package domain;

import static java.lang.Character.toLowerCase;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = letter;
        this.isGeraden= false;
    }

    public char getLetter() {
        return this.letter;
    }

    public boolean raad(char character) {
        if (toLowerCase(character) == toLowerCase(this.letter) && !isGeraden) {
            this.isGeraden = true;
            return true;
        }
        return false;
    }

    public char toChar() {
        if (isGeraden) {
            return letter;
        }
        return '_';

    }

    public boolean isGeraden() {
        return isGeraden;
    }

}
