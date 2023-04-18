import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Pell Sequence
//0, 1, 2, 5, 12, 29, 70, 169, 408, 985, 2378

public class Sequences {
    public static void main(String[] args) {
        System.out.println("Please input a number that you want to generate for this sequence.");
        Scanner scnr = new Scanner(System.in);
        int num = scnr.nextInt();
        ArrayList<Integer> pell = pellSequence(num);
       
        String fileName = String.format("%sSequence.txt", num);
        FileOutputStream fileStream = null;
        try {
            fileStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + fileName);
        }
        PrintWriter outFS = new PrintWriter(fileStream);
        outFS.println("Pell Sequence: " + pell);
        outFS.close();
    }

    public static ArrayList<Integer> pellSequence(int n) {
        ArrayList<Integer> pellList = new ArrayList<Integer>();
        if (n <= 0) {
            return pellList;
        } else if (n == 1) {
            pellList.add(0);
            return pellList;
        } else if (n == 2) {
            pellList.add(0);
            pellList.add(1);
            return pellList;
        } else {
            pellList = pellSequence(n - 1);
            pellList.add(2 * pellList.get(n - 2) + pellList.get(n - 3));
            return pellList;
        }
    }
}
