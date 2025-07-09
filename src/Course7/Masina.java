package Course7;

public class Masina {
    String marca;
    String an;

    public Masina(String marca, String an) {
        this.marca = marca;
        this.an = an;
    }

    public void showDetails()
    {
        System.out.println("Marca: " + marca);
        System.out.println("An: " + an);
    }

}
