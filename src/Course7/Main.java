package Course7;

public class Main {
    public static void main(String[] args) {
//        Carte carte = new Carte("Titlu");
//        carte.afiseazaDate();
//        Calculator c = new Calculator();
//        System.out.println(c.aduna(1, 2));
//        System.out.println(c.aduna(1, 2, 5));
//        System.out.println(c.aduna(1.1, 3.2));
//        Animal a1 = new Caine();
//        a1.sunet();
//        Animal a2 = new Pisica();
//        a2.sunet();
        System.out.println("=====================1=====================");
        Masina m = new Masina("Ford", "2025");
        m.showDetails();
        System.out.println("=====================2=====================");
        Carte c = new Carte();
        System.out.println("=====================3=====================");
        Student s1 = new Student();
        System.out.println(s1.name + " " + s1.age);
        Student s2 = new Student("Eduard", 24);
        System.out.println(s2.name + " " + s2.age);
        System.out.println("=====================4=====================");
        Film f1 = new Film("Lord of the Rings");
        System.out.println(f1.title + " " + f1.rating);
        Film f2 = new Film("Lord of the Rings", 8.9);
        System.out.println(f2.title + " " + f2.rating);
        System.out.println("=====================5=====================");
        Utilizator u = new Utilizator();
        u.setPass("pass");
        //System.out.println(u.pass);
        System.out.println("=====================6=====================");
        Contor c1 = new Contor();
        Contor c2 = new Contor();
        Contor c3 = new Contor();
        System.out.println("=====================7=====================");
        ConstantaMath math = new ConstantaMath();
        //math.PI +=1; --> Deoarece parametrii de tip final nu se pot modifica dupa ce au fost initializati
        System.out.println("=====================8=====================");
        Caine2 caine = new Caine2();
        caine.testRespiratie();
        caine.respira();
        System.out.println("=====================9=====================");
        Calculator calc1 = new Calculator();
        System.out.println(calc1.aduna(4, 6));
        System.out.println(calc1.aduna(8.1, 2.39));
        System.out.println("=====================10=====================");
        Vehicul v1 = new Bicicleta();
        v1.porneste();
        Vehicul v2 = new Masina2();
        v2.porneste();
    }
}
