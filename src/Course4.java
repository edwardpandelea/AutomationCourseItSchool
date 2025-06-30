import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course4 {
    public static void main(String[] args) {
//        try{
//            int rez = 10 / 0;
//        }catch (ArithmeticException e){
//            System.out.println("Nu se poate imparti la 0!");
//        }finally{
//            System.out.println("Aceasta se executa mereu!");
//        }

//        try {
//            String text = null;
//            System.out.println(text.length());
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Stringul este gol!");
//        }catch (NullPointerException e){
//            System.out.println("Variabila este nula");
//        }

        // file manipulation

//        try {
//            File f = new File("exemplu.txt");
//            if(f.createNewFile())
//            {
//                System.out.println("File created.");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//            try {
//                FileWriter fw = new FileWriter("exemplu.txt");
//                fw.write("Linia1\nLinia2\nLinia3\n");
//                fw.close();
//            }catch (Exception e)
//            {
//                e.printStackTrace();
//            }

//        try {
//            Scanner sc = new Scanner(new File("exemplu.txt"));
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                System.out.println(line);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }



//            File f = new File("exemplu2.txt");
//            if(f.exists() && f.delete()) {
//                System.out.println("Fisierul a fost sters!");
//            }else {
//                System.out.println("Fisierul nu exista!");
//            }
//        String linieDeSters = "masina";
//        File input = new File("exemplu.txt");
//        deleteLine(input, linieDeSters);

        System.out.println("===================1======================");
        int[] nr = {23,44,65,78,22,11};
        for (Integer i : nr) {
            if(i % 2 ==0)
            {
                System.out.println(i);
            }
        }
        System.out.println("===================2======================");
        int[][] matrice = {
                {2,3},
                {22,33},
                {12, 5}
        };
        for(int i = 0; i< matrice.length;i++)
        {
            for (int j = 0; j < matrice[i].length;j++)
            {
                if(matrice[i][j] > 10)
                {
                    System.out.println(matrice[i][j]);
                }
            }
        }
        System.out.println("===================3======================");
        int[] arr = {12,32,54,66,22,445};
        int suma = 0;
        for(int numar : arr)
        {
            suma += numar;
        }
        System.out.println("Suma este: " + suma);

        System.out.println("===================4======================");
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        System.out.println(strings.indexOf("C"));
        System.out.println("===================5======================");
        int [][] arr2D = {
                {14,32,43},
                {22,42,44},
                {45,33,12}
        };
        int nrDeGasit = 33;
        for(int i = 0; i < arr2D.length; i++)
        {
            for(int j = 0; j < arr2D[i].length; j++)
            {
                if(nrDeGasit == arr2D[i][j]){
                    System.out.println("Numarul este: " + nrDeGasit + ", iar pozitia lui este: arr[" + i + "]" + "[" + j + "]");
                }
            }
        }

        System.out.println("===================6======================");
        String str = "null";
        isEmptyString(str);
        System.out.println("===================7======================");

        try {
                File f = new File("file.txt");
                f.createNewFile();
                FileWriter fw = new FileWriter("file.txt");
                fw.write("Rand1\nRand2\nRand3\n");
                fw.close();
                if(f.exists())
                {
                    System.out.println("Fisier creat!");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        System.out.println("===================8======================");
        try {
            Scanner sc = new Scanner(new File("file.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println("===================9======================");
//        File f = new File("C:\\Users\\eduar\\Desktop\\studyspace\\AutomationCourseItSchool\\file.txt");
//            if(f.exists() && f.delete()) {
//                System.out.println("Fisierul a fost sters!");
//            }else {
//                System.out.println("Fisierul nu exista!");
//            }
        System.out.println("===================10======================");
        File f2 = new File("file.txt");
        deleteLine(f2, "Rand2");
    }

    static void isEmptyString(String str) {
        if(str == null || str.isEmpty()) {
            throw new NullPointerException("Empty String");
        }
        System.out.println("Text valid");
    }


    static void deleteLine(File input, String linieDeSters)
    {
        try{
            File temp = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(input));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
            String linie;
            while ((linie = reader.readLine()) != null) {
                if(!linie.toLowerCase().trim().equals(linieDeSters.toLowerCase()))
                {
                    writer.write(linie + System.lineSeparator());

                }
            }
            reader.close();
            writer.close();
            input.delete();
            temp.renameTo(input);
            System.out.println("Linia a fost stearsa.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
