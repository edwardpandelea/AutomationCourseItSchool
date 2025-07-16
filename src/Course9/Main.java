package Course9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    //  patratePerfecte();
    //  frecventa();
    //  cifrePare();
    //  sumaCifrePareSiImpare();
    //  valoriDistincte();
    //  triunghiValid();
    }

    public static void triunghiValid(){
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[3];
        System.out.println("Introduceți cele 3 numere:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        if(arr[0] + arr[1] > arr[2] &&
                arr[0] + arr[2] > arr[1] &&
                arr[1] + arr[2] > arr[0]){
            System.out.println("Triunghi valid");
        } else {
            System.out.println("Triunghi invalid");
        }

        scanner.close();


    }
    public static void valoriDistincte(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("N: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Introduceți cele " + n + " numere:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Set<Integer> distincte = new HashSet<>();
        for (int num : arr)
        {
            distincte.add(num);
        }
        System.out.println("Numerele distincte sunt: " + distincte.toString());
    }

    public static void sumaCifrePareSiImpare(){
        Scanner scanner = new Scanner(System.in);
        char [] num = scanner.nextLine().toCharArray();

        int sumaImpare = 0;
        int sumaPare = 0;
        for (char i : num) {
            int val = Character.getNumericValue(i);
            if (val % 2 == 0){
                sumaPare += val;
            }else{
                sumaImpare += val;
            }
        }
        System.out.println("Suma cifre pare: " + sumaPare);
        System.out.println("Suma cifre impare: " + sumaImpare);
        scanner.close();
    }

    public static void cifrePare()
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num % 2 == 0){
            System.out.println("Numarul este par");
        }else{
            System.out.println("Numarul este impar");
        }
    }

    public static void patratePerfecte(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("N: ");
        int N = scanner.nextInt();

        System.out.println("Pătratele perfecte ≤ " + N + " sunt:");
        int i = 1;
        while (i * i <= N) {
            System.out.print((i * i) + " ");
            i++;
        }

        scanner.close();
    }

    public static void frecventa(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("N: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Introduceți cele " + n + " numere:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxCount = 0;
        int num = arr[0];
        for (int i = 0; i < n; i++)
        {
            int currentCount = 0;
            for (int j = 0; j < n; j++)
            {
                if (arr[i] == arr[j])
                {
                    currentCount++;
                }
                if (currentCount > maxCount)
                {
                    maxCount = currentCount;
                    num = arr[i];
                }
            }
        }
        System.out.println("Numărul cu cea mai mare frecvență: " + num);
        System.out.println("Apare de " + maxCount + " ori.");
    }
}
