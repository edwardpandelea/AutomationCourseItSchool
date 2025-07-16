package Course8;

public class Angajat {
    String nume;
    String functie;
    double salariu;

    public Angajat(String nume, String functie, double salariu)
    {
        this.functie = functie;
        this.salariu = salariu;
        this.nume = nume;
    }

    public void calculeazaSalariu()
    {
        double bonus = 0;
        if (functie == "Manager")
        {
            bonus = 0.1;
            this.salariu += (this.salariu * bonus);
            System.out.println("Salariu total " + this.functie+ ": " + this.salariu);
        }else{
            bonus = 0.05;
            this.salariu += (this.salariu * bonus);
            System.out.println("Salariu total " + this.functie+ ": " + this.salariu);
        }


    }

}
