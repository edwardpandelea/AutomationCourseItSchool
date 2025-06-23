import java.util.Scanner;

public class Course2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        //      Tipuri de date primitive:

        //  A. Numere intregi:
        // 1. Int
        // int [-2^31 .. -2^31-1]
        int a = 2137483647;
        // 2. Long [... 2^63-1]
        // 3. Short [-32768 ... 32767]
        short c = 32767;
        // 4. byte [-128 ... 127]
        byte d = 127;

        //  B. Numbere Reale (cu zecimale)
        // 1. Float => 6,7 zecimale
        // 2. Double => 15-16 zecimale

        //  C. Alte tipuri
        // 1. Boolean = valori logice - true & false
        // 2. Char = un singur caracter (a, b, c, $)

        //      Tipuri de date non-primitive (complexe)

        // String - sir de caractere
        // Arrays - tablouri (colectie de valori de acelasi tip)
        // Classes
        // Interfaces
        // Enums

        // Casting
        // Widening Conversion
        int nrInterg = 15;
        double nrReal = nrInterg;
        System.out.println(nrReal);

        // Narrowing Casting
        double nrReal2 = 5.51;
        int nrIntreg2 = (int) nrReal2;
        System.out.println(nrIntreg2);
        double round = Math.round(5.49);
        System.out.println(round);

        //      Operatori
        // Aritmetici
        // + - * / %
        int op1 = 13;
        int op2 = 5;
        System.out.println("Valoarea este: " + (op1 + op2));
        System.out.println("Valoarea este: " + (op1 - op2));
        System.out.println("Valoarea este: " + (op1 * op2));
        System.out.println("Valoarea este: " + (op1 / op2));
        System.out.println("Valoarea este: " + (op1 % op2));

        // Atributie
        // =, +=, -=, *=, /=, %=
        System.out.println("============Operatori=de=Atributie================");
        System.out.println("Valoarea este: " + (op1+=op2));
        System.out.println("Valoarea este: " + (op1-=op2));
        System.out.println("Valoarea este: " + (op1*=op2));
        System.out.println("Valoarea este: " + (op1/=op2));
        System.out.println("Valoarea este: " + (op1%=op2));

        // Logice
        // && (and), || (or), ! (not)
        System.out.println("============Operatori=Logici================");
        System.out.println(op1 > 10 && op1 < 7);
        System.out.println(op1 > 10 || op1 < 7);
        System.out.println(!(op1 > 10));
        // Comparatie
        System.out.println("============Operatori=de=Comparatie================");
        // >, <, >=, <=, ==, !=
        System.out.println(op1 > 13);
        System.out.println(op1 < 13);
        System.out.println(op1 >= 13);
        System.out.println(op1 <= 13);
        System.out.println(op1 == 13);
        System.out.println(op1 != 13);

        // Math introduction
        System.out.println("============Math=Introduction================");
        System.out.println(Math.max(66,12));
        System.out.println(Math.min(66,12));
        System.out.println(((int) Math.sqrt(121)));
        System.out.println(((int) Math.pow(2.0, 3.0)));
        System.out.println(Math.abs(-22));
        System.out.println(Math.random()); // 0.0 ... < 1.0
        int random = (int) (Math.random() * 10); // 0 ... 9
        System.out.println(random);

        System.out.println("============Exercitii================");
        //TODO
        //1. Declară două variabile int și afișează suma, diferența, produsul, câtul și restul împărțirii lor.
        //2. Creează o variabilă String numită nume și o variabilă int numită varsta. Afișează un mesaj de forma: "Salut, numele meu este [nume] și am [varsta] ani."
        //3. Declară o variabilă double cu o valoare zecimală și convertește-o într-o variabilă int. Afișează ambele valori.
        //4. Declară o variabilă int, modifică-i valoarea folosind +=, -=, *=, /= și afișează rezultatul după fiecare pas.
        //5. Verifică dacă o variabilă int este mai mare decât 100, mai mică sau egală cu 50 și diferită de 75. Afișează rezultatele folosind operatori de comparație.
        //6. Declară trei variabile boolean și construiește expresii logice folosind &&, || și !. Afișează rezultatul fiecărei expresii.
        //7. Declară trei variabile int (a = 5, b = 10, c = 15) și afișează rezultatul pentru a + b * c, (a + b) * c și c % b.
        //8. Declară trei variabile String (prenume, nume, oraș) și construiește un mesaj de forma: "Prenume Nume locuiește în Oraș."
        //9. Declară o variabilă int, aplică ++ și --, și afișează valoarea înainte și după fiecare modificare.
        //10. Declară trei variabile int (x, y, z) și atribuie-le aceeași valoare într-o singură linie. Afișează suma lor.

        System.out.println("================1====================");
        int num1= 10, num2 = 6;
        System.out.println("Suma este: " + (num1 + num2));
        System.out.println("Diferenta este: " + (num1 - num2));
        System.out.println("Produsul este: " + (num1 * num2));
        System.out.println("Rezultatul impratirii este: " + (num1 / num2));
        System.out.println("Restul este: " + (num1 % num2));
        System.out.println("================2====================");
        String nume = "Ana";
        int varsta = 25;
        System.out.println("Salut, numele meu este " + nume + " si am " + varsta + " ani.");
        System.out.println("================3====================");
        double num3 = 12.5;
        System.out.println(num3);
        int num4 = (int) num3;
        System.out.println(num4);
        System.out.println("================4====================");
        int num5 = 12;
        System.out.println(num5 += 1);
        System.out.println(num5 -= 1);
        System.out.println(num5 *= 1);
        System.out.println(num5 /= 1);
        System.out.println("================5====================");
        int num6 = 33;
        System.out.println(num6 > 100);
        System.out.println(num6 <= 50);
        System.out.println(num6 != 75);
        System.out.println("================6====================");
        boolean isTrue = true;
        boolean isFalse = false;
        boolean ran = true;
        System.out.println(isTrue && ran);
        System.out.println(isFalse || ran);
        System.out.println(!ran);
        System.out.println("================7====================");
        int x = 5, y = 10, z = 15;
        System.out.println(x + y * z);
        System.out.println((x+y) * z);
        System.out.println(z % y);
        System.out.println("================8====================");
        String prenume = "Eduard";
        String lastName = "Pandelea";
        String oras = "Bucuresti";
        System.out.println(prenume + " " + lastName + " locuieste in " + oras + ".");
        System.out.println("================9====================");
        int before = 1;
        System.out.println("Valoare initiala: " + before);
        before++;
        System.out.println("Valoare incrementata: " + before);
        before--;
        System.out.println("Valoare decrementata: " + before);
        System.out.println("================10====================");
        int i = 10, j = 15, k = 20;
        System.out.println("Suma este: " + (i + j + k));
    }
}
