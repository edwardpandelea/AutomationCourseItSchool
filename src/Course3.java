public class Course3 {
    public static void main(String[] args) {
//        int zi = 2 ;
//        if (zi == 1)
//        {
//            System.out.println("Este luni!");
//        } else if (zi==2) {
//            System.out.println("Este marti!");
//        } else{
//            System.out.println("Este ziua " + zi);
//        }
//
//        int day = 4;
//        switch (day){
//            case 1:
//                System.out.println("Este luni!");
//                break;
//            case 2:
//                System.out.println("Este marti!");
//                break;
//            case 3:
//                System.out.println("Este miercuri!");
//                break;
//            case 4:
//                System.out.println("Este joi!");
//                break;
//            case 5:
//                System.out.println("Este vineri!");
//                break;
//        }
//            int i = 1;
//
//            while(i<=5){
//                System.out.println("i= " + i);
//                i++;
//            }
//            int i = 0;
//
//            do{
//                System.out.println(i * 2);
//                i++;
//            }while (i<=10);

//            for(int i=0; i<=10; i++)
//            {
//                System.out.println(i);
//            }
        //TODO
//        1. Verifică dacă un număr întreg este pozitiv, negativ sau zero și afișează un mesaj corespunzător.
//        2. Afișează toate numerele de la 1 la 10 folosind o buclă for.
//        3. Calculează și afișează suma tuturor numerelor de la 1 la 100 folosind o buclă while.
//        4. Verifică dacă o literă dată este o vocală sau o consoană folosind switch.
//        5. Verifică dacă un număr este divizibil atât cu 3, cât și cu 5 și afișează un mesaj corespunzător.
//        6. Afișează un mesaj specific în funcție de o valoare a vârstei: “Copil” (0–12), “Adolescent” (13–17), “Adult” (18+).
//        7. Folosește o buclă do...while pentru a afișa un număr de la 1 la 5.

        System.out.println("=====================1=====================");
            int num = -2;
            if (num > 0)
            {
                System.out.println("Numar pozitiv!");
            } else if (num == 0) {
                System.out.println("Numar 0!");
            } else {
                System.out.println("Numar negativ!");
            }
        System.out.println("=====================2=====================");
        for(int i=1; i<=10; i++)
        {
            System.out.println(i);
        }
        System.out.println("=====================3=====================");
        int j=1;
        int sum = 0;
        while(j<=100)
        {
            sum += j;
            j++;
        }
        System.out.println(sum);
        System.out.println("=====================4=====================");
        char ch = 'c';
        switch (ch){
            case 'a', 'e', 'i', 'o', 'u':
                System.out.println("Vocala: " + ch);
                break;
            default:
                System.out.println("Consoana: " + ch);
                break;
        }
        System.out.println("=====================5=====================");
        int num2 = 15;
        if(num2 % 3 == 0 && num2 % 5 == 0)
        {
            System.out.println("Divizibil cu 3 si cu 5!");
        }else if(num2 % 3 == 0 || num2 % 5 == 0){
            System.out.println("Divizibil cu 3 sau 5!");
        }
        else {
            System.out.println("Nu este divizibil cu 3 sau 5!");
        }
        System.out.println("=====================6=====================");
        int age = 18;
        if (age <= 12 && age > 0)
        {
            System.out.println("Copil");
        }else if (age > 12 && age < 17)
        {
            System.out.println("Adolescent");
        }else if( age >= 18){
            System.out.println("Adult");
        }else{
            System.out.println("Varsta invalida!");
        }

        System.out.println("=====================7=====================");

        int i = 1;
        do{
            System.out.println(i);
            i++;
        }while (i<=5);

    }
}
