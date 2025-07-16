package Course8;

import java.util.Date;

public class Factura {
    int nrFactura;
    String valoare;
    Date data;

    public Factura(int nrFactura, String valoare) {
        this.nrFactura = nrFactura;
        this.valoare = valoare;
        this.data = new Date();
    }

    public void afiseazaFactura()
    {
        System.out.println("NrFactura: "+nrFactura);
        System.out.println("Valoare: "+valoare);
        System.out.println("Data: "+data);
    }
}
