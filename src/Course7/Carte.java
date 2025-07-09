package Course7;

public class Carte {
    String titlu;
    public Carte(String titlu) {
        this.titlu = titlu;
    }

    void afiseazaDate()
    {
        System.out.println("Titlul cartii: " + titlu);
    }

    public Carte(){
        System.out.println("Carte necunoscuta");
    }
}
