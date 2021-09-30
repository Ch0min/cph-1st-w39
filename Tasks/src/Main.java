import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine()) {                     // checks if theres more lines in the file
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");                    // Creates and array of strings, where each element is a single word from the file.
        System.out.println(text.length);


        printWordsOfLength(5);
        printWordsStartingWith("Ø");

        System.out.println("\nTaskOne - Longest words");
        printLongestWord();

        System.out.println("\nTaskTwo - First half words");
        printFirstHalfOfEachWord();

        //test dine metoder ved at kalde dem her:

    }

    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (String s : text) {
            if (s.length() == l) {
                if (s.contains(",") || s.contains(".")) {
                    wordisvalid = false;
                }

                if (wordisvalid) {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern) {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    private static void printLongestWord() {
        String longestWord = "";
        int count = 0;
        for (String s : text) {
            if (s.length() > count) {
                longestWord = s;
                count = s.length();
                System.out.println("Longest word is " + longestWord);
                count++;
            }
        }
    }

    private static void printFirstHalfOfEachWord() {
        int count = 0;
        for (String s : text) {
            if (s.length() > count) {
                System.out.println("Printing first half of the words: " + s.substring(0, s.length()/2));
               count++;
            }
        }
    }
}