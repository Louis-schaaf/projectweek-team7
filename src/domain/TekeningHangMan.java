package domain;

public class TekeningHangMan extends Tekening{

    public TekeningHangMan() {
        super("HangMan");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);

        hoofd.setZichtbaar(false);
        oogLinks.setZichtbaar(false);
        oogRechts.setZichtbaar(false);
        neus.setZichtbaar(false);
        mond.setZichtbaar(false);
        lijf.setZichtbaar(false);
        beenLinks.setZichtbaar(false);
        beenRechts.setZichtbaar(false);
        voetLinks.setZichtbaar(false);
        voetRechts.setZichtbaar(false);
        armLinks.setZichtbaar(false);
        armRechts.setZichtbaar(false);
        handLinks.setZichtbaar(false);
        handRechts.setZichtbaar(false);


        super.voegToe(galgBodem);
        super.voegToe(galgStaaf);
        super.voegToe(hangbar);
        super.voegToe(koord);
        super.voegToe(hoofd);
        super.voegToe(oogLinks);
        super.voegToe(oogRechts);
        super.voegToe(neus);
        super.voegToe(mond);
        super.voegToe(lijf);
        super.voegToe(beenLinks);
        super.voegToe(beenRechts);
        super.voegToe(voetLinks);
        super.voegToe(voetRechts);
        super.voegToe(armLinks);
        super.voegToe(armRechts);
        super.voegToe(handLinks);
        super.voegToe(handRechts);




    }

    public int getAantalOnzichtBaar(){
        int teller = 0;
        int totaalvormen = super.getAantalVormen();

        for (int i = 0; i < totaalvormen; i++) {
            if(!super.getVorm(i).isZichtbaar()){
                teller++;
            }
        }

        return teller;
    }

    public void zetVolgendeZichtbaar(){
        int totaalVormen = super.getAantalVormen();

        for (int i = 0; i < totaalVormen; i++) {
            if(!super.getVorm(i).isZichtbaar()){
                super.getVorm(i).setZichtbaar(true);
                return;
            }
        }

        throw new DomainException("Er zijn geen vormen meer om zichtbaar te maken", new IllegalStateException());

    }


    public void voegToe(Vorm vorm) {
        throw new DomainException("U mag geen vormen toevoegen aan HangMan", new IllegalStateException());
    }


    public void verwijder(Vorm vorm) {
        throw new DomainException("U mag geen vormen verwijderen van HangMan", new IllegalStateException());
    }
}
