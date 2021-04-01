package Domain.model;

public class Woord {
    private String woord, niveau;

    public Woord(){

    }


    public void setWoord(String woord) {
        if(woord == null || woord.trim().isEmpty()) throw new DomainException("Woord mag niet leeg zijn.", new IllegalArgumentException());
        this.woord = woord;
    }

    public void setNiveau(String niveau){
        if(niveau == null || niveau.equals("Beginner") || niveau.equals("Expert")){
            this.niveau = niveau;
        } else if(niveau.equals("")){
            this.niveau = null;
        }else {
            throw new DomainException("Het niveau dat u ingaf is incorrect.", new IllegalArgumentException());
        }
    }

    public String getWoord() {
        return this.woord;
    }

    public String getNiveau() {
        return niveau;
    }
}
