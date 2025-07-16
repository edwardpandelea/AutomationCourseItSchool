package Course8;

public class Produs {
    final String codProdus;

    public Produs(String codProdus) {
        this.codProdus = codProdus;
    }

    public void afiseazaDetaliile()
    {
        System.out.println("CodProd: " + this.codProdus);
    }
}
