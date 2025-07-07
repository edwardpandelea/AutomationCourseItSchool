import java.util.Calendar;
import java.util.List;

public class Course6 {
//    static class Animal{
//        String nume = "Animal";
//    }
//    static class Caine extends Animal{
//        void afiseazaNume(){
//            System.out.println(nume);
//        }
//    }

//    static class Vehicul{
//        void pornesteMotorul()
//        {
//            System.out.println("Motor pornit");
//        }
//    }
//
//    static class Masina extends Vehicul{
//        void condus(){
//            System.out.println("Conduci masina!");
//        }
//    }
//
//    static class Persoana{
//        String nume;
//        int varsta;
//        void afiseazaDate()
//        {
//            System.out.println("Nume: " + this.nume);
//            System.out.println("Varsta: " + this.varsta);
//        }
//
//    }
//
//    static class Student extends Persoana{
//        String universitate;
//        void afiseazaUnivesitate(){
//            System.out.println("Universitate: " + this.universitate);
//        }
//    }
//
//    static class vehicul{
//        void ruleaza(){
//            System.out.println("Vehiculul se deplaseaza");
//        }
//    }
//    static class masina extends vehicul{
//        void accelereaza(){
//            System.out.println("Masina accelereaza");
//        }
//    }
//
//    static class Electrica extends masina{
//        void incarca(){
//            System.out.println("Masina electrica se incarca");
//        }
//    }
//
    static class Animal{
        void faceSunet()
        {
            System.out.println("Ham!");
        }
    }
    static class Pisica extends Animal{
        void faceSunet()
        {
            System.out.println("Meow!");
        }
    }

    static class Persoana{
        String nume;
        String prenume;
        String numeLiceu;

        public Persoana(String nume, String prenume, String numeLiceu)
        {
            this.nume = nume;
            this.prenume = prenume;
            this.numeLiceu = numeLiceu;
        }
    }

    static class Elev extends Persoana{

        public Elev(String nume, String prenume, String numeLiceu) {
            super(nume, prenume, numeLiceu);
        }

        void verificaMedia(int media)
        {
            if (media >= 5)
            {
                System.out.println("Elevul: " + this.nume + " " +  this.prenume);
                System.out.println("Liceul:  " + this.numeLiceu);
                System.out.println("Stare: Promovat");
            }else{
                System.out.println("Elevul: " + this.nume + " " +  this.prenume);
                System.out.println("Liceul:  " + this.numeLiceu);
                System.out.println("Stare: Nepromovat");
            }
        }

        void verificaBursa(double media)
        {
            if (media >= 8.5)
            {
                System.out.println("Elevul " + this.nume + " " +  this.prenume + " primeste bursa!");
            }else{
                System.out.println("Elevul " + this.nume + " " +  this.prenume + " NU primeste bursa!");
            }
        }

    }

    static void autonomie(int nivelBaterie)
    {
        if (nivelBaterie < 20)
        {
            System.out.println("Avertisment!");
        }
    }

    static void tipVehicul(int nrRoti)
    {
        switch (nrRoti){
            case 1:
                System.out.println("Monociclu");
                break;
            case 2:
                System.out.println("Bicicleta/Motocicleta");
                break;
            case 3:
                System.out.println("Tricileta electrica");
                break;
            case 4:
                System.out.println("Masina");
                break;
        }
    }

    static double calculBonus(double salariu, int vechime)
    {
        double bonus;
        if(vechime > 5)
        {
            bonus = 0.2;
        }else{
            bonus = 0.1;
        }
        return salariu * bonus;
    }

    static void dobanda(double sold, double dobandaLunara)
    {
        for (int i = 1; i <= 6; i++)
        {
            sold += sold * dobandaLunara;
            System.out.println("Luna " + i + ": " + sold);
        }
    }

    static void numarPagina(int nrTotalPagini)
    {
        int i= 0;
        while(i <= nrTotalPagini)
        {
            System.out.println("Citim pagina " + i);
            i++;
        }
    }

    static void totalPreturi(int[] preturi)
    {
        int total = 0;
        for (int i : preturi) {
            total += i;
        }
        System.out.println("Total preturi: " + total);
    }

    static void verificaBateria(int procentBaterie)
    {
        if(procentBaterie < 15)
        {
            System.out.println("Bateria este sub 15%!");
        }
    }


    public static void main(String[] args) {
//        Caine c = new Caine();
//        c.afiseazaNume();
//        Masina m =  new Masina();
//        m.pornesteMotorul();
//        m.condus();
//        Student s1 = new Student();
//        s1.nume = "Marin";
//        s1.varsta = 18;
//        s1.universitate = "ASE";
//        s1.afiseazaDate();
//        s1.afiseazaUnivesitate();
//        Electrica e = new Electrica();
//        e.ruleaza();
//        e.accelereaza();
//        e.incarca();
        System.out.println("======================1=======================");
        Pisica p = new  Pisica();
        p.faceSunet();
        System.out.println("======================2=======================");
        Elev elev = new Elev("Pandelea", "Eduard", "Lic. Al. Rosetti");
        elev.verificaMedia(10);
        System.out.println("======================3=======================");
        autonomie(18);
        System.out.println("======================4=======================");
        tipVehicul(3);
        tipVehicul(2);
        tipVehicul(4);
        System.out.println("======================5=======================");
        System.out.println(calculBonus(5000, 6));
        System.out.println(calculBonus(5000, 3));
        System.out.println("======================6=======================");
        dobanda(10000, 0.24);
        System.out.println("======================7=======================");
        numarPagina(100);
        System.out.println("======================8=======================");
        elev.verificaBursa(9.1);
        System.out.println("======================9=======================");
        Calendar dataCurenta = Calendar.getInstance();
        Calendar dataExpirare = Calendar.getInstance();
        dataExpirare.set(2025, Calendar.SEPTEMBER, 12);
        if (dataCurenta.compareTo(dataExpirare) > 0)
        {
            System.out.println("Produsul este expirat!");
        }else{
            System.out.println("Produsul nu este expirat!");
        }
        System.out.println("======================10=======================");
        int[] preturi = {1,2,4,7,123,23,543};
        totalPreturi(preturi);
        System.out.println("======================11=======================");
        verificaBateria(12);
        System.out.println("======================12=======================");
        int nrPasageri = 16;
        if (nrPasageri == 0){
            System.out.println("Autobuz gol!");
        }else if(nrPasageri > 10){
            System.out.println("Autobuz pe jumatate plin!");
        }else{
            System.out.println("Autobuz plin!");
        }




    }
}


