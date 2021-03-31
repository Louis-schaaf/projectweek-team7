package domain;

public class HintWoord {
    private HintLetter[] hintwoord;

    public HintWoord(String woord) {
        hintwoord = new HintLetter[woord.length()];
        for (int i=0; i< woord.length();i++) {
            hintwoord[i] = new HintLetter(woord.charAt(i));
        }

    }

    public boolean raad(char letter) {
        boolean result = false;
        for (HintLetter l : hintwoord) {
            if(l.raad(letter)) {
                result =true;}
        }
        return result;

    }

    public boolean isGeraden() {
        for (HintLetter letter : hintwoord) {
            if (!letter.isGeraden()) {
                return false;
            }
        }
        return true;
    }

    public String getWoord() {
       StringBuffer woord = new StringBuffer();
       for (HintLetter letter : hintwoord) {
           woord.append(letter.getLetter());
       }
       String result = woord.toString();
       return result;
    }

    @Override
    public String toString() {
        StringBuffer woord = new StringBuffer();
        for (HintLetter letter : hintwoord) {
            woord.append(letter.toChar());
        }
        String result = woord.toString();
        return result;
    }
}
