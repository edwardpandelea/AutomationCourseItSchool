package Course8;

public class Main {
    public static void main(String[] args) {
    Factura f = new Factura(1, "Val1");
    f.afiseazaFactura();

    ContBancar c = new ContBancar();
    c.depunere(123.2);
    c.depunere(432.22);
    c.retragere(432.22);
    c.verificaSold();


    Angajat a1 = new Angajat("Eduard", "Manager", 1000.0);
    Angajat a2 = new Angajat("Gabriel", "Programator junior", 500.0);
    a1.calculeazaSalariu();
    a2.calculeazaSalariu();

    RezervareHotel rezervareHotel = new RezervareHotel("Eduard");
    RezervareHotel rezervareHotel1 = new RezervareHotel("Gabriel", "Dubla");

    Produs prod = new Produs("1");
    //prod.codProdus = 2;
    prod.afiseazaDetaliile();

    Contor c1 = new Contor();
    c1.totalObiecte();
    Contor c2 = new Contor();
    c2.totalObiecte();
    Contor c3 = new Contor();
    c3.totalObiecte();

    verificaParola("23#4567G8");
    }

    public static void verificaParola(String parola)
    {
        if(parola.length() < 8)
        {
            System.out.println("Parola este prea scurta! Minim 8 caractere");
        } else if (!parola.matches(".*[A-Z].*"))
        {
            System.out.println("Parola nu contine o majuscula!");
        }else if(!parola.matches(".*[!@#$%^&*()_+=\\-{}\\[\\]:;\"'<>,.?/\\\\|`~].*"))
        {
            System.out.println("Parola nu contine un caracter special!");
        }else{
            System.out.println("Parola este corecta!");
        }
    }
}
