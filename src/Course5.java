public class Course5 {
    static class Cerc
    {
        double raza;

        public double aria(){
            return 3.14 * (Math.pow(raza,2));
        }
    }

    static class Dreptunghi{
        double lungime;
        double latime;

        public double aria()
        {
            return lungime * latime;
        }
    }

    static class Temperatura{
        public void convert(double tempCelsius)
        {
            System.out.println("Temperatura in Fahrenheit: " + ((tempCelsius * 9/5) + 32) + "°F");
        }
    }

    static class Banca{
        double sold;

        public void adaugaBani(double bani)
        {
            sold += bani;
            System.out.println("Sold total: " + sold);
        }
        public void scoateBani(double bani)
        {
            sold -= bani;
            System.out.println("Sold total: " + sold);
        }
    }

    static class Examen{
        public void calculeazaMedia(double nota1, double nota2, double nota3)
        {
            System.out.println("Media este: " + (nota1 + nota2 + nota3) / 3);
        }
    }

    static class Timp{
        public void Ore(int minuteTotale)
        {
            int ore = minuteTotale / 60;
            int minute = minuteTotale % 60;
            System.out.println(ore + "h" + minute + "min");
        }
    }

    static class CalculatorSimplu
    {
        public void Adunare(double a, double b)
        {
            System.out.println(a + b);
        }

        public void Scadere(double a, double b)
        {
            System.out.println(a - b);
        }
        public void Inmultire(double a, double b)
        {
            System.out.println(a * b);
        }
        public void Impartire(double a, double b)
        {
            System.out.println(a / b);
        }
    }

    static class PretTVA{
        public void pretNet(double pretBrut)
        {
            double pretNet = pretBrut - (pretBrut * 0.19);
            System.out.println("Pretul net este: " + pretNet);
        }
    }


    public static void main(String[] args) {
        System.out.println("===================1======================");
        Cerc c = new Cerc();
        c.raza = 3;
        System.out.println("Aria cercului este: " + c.aria());
        System.out.println("===================2======================");
        Dreptunghi d = new Dreptunghi();
        d.lungime = 3;
        d.latime = 6;
        System.out.println("Aria dreptunghiului este: " + d.aria());
        System.out.println("===================3======================");
        Temperatura t = new Temperatura();
        t.convert(23.0);
        System.out.println("===================4======================");
        Banca b = new Banca();
        b.adaugaBani(25.0);
        b.scoateBani(12.32);
        System.out.println("===================5======================");
        Examen e = new Examen();
        e.calculeazaMedia(3,6.3,9.6);
        System.out.println("===================6======================");
        Timp timp = new Timp();
        timp.Ore(130);
        System.out.println("===================7======================");
        CalculatorSimplu cs = new CalculatorSimplu();
        cs.Adunare(5, 7);
        cs.Scadere(43, 23);
        cs.Inmultire(4, 2);
        cs.Impartire(12, 2);
        System.out.println("===================8======================");
        PretTVA pretTVA = new PretTVA();
        pretTVA.pretNet(25.0);
    }

}
