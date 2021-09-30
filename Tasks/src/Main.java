import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        System.out.println("\nTaskThree - Most frequent character");
        printMostFrequentLetter();

        System.out.println("\nTaskFour - Less frequent character");
        printLessFrequentLetter();


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
                System.out.println("Printing first half of the words: " + s.substring(0, s.length() / 2));
                count++;
            }
        }
    }

    private static void printMostFrequentLetter() {
        char[] letters = new char[29];
        int[] amountOfLetters = new int[29];

        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            letters[count] = c;
            count++;
        }
        // Danish letters
        letters[26] = 'æ';
        letters[27] = 'ø';
        letters[28] = 'å';

        for (String s : text) {
            for (char c : s.toLowerCase().toCharArray()) {
                for (int j = 0; j < letters.length; j++) {
                    if (c == letters[j]) {
                        amountOfLetters[j]++;
                        break;
                    }
                }
            }
        }
        int indexCount = 0;
        for (int j = 0; j < amountOfLetters.length; j++) {
            if (amountOfLetters[j] > amountOfLetters[indexCount]) {
                indexCount = j;
            }
        }
        System.out.println("Most frequent character: " + letters[indexCount] + " : " + amountOfLetters[indexCount] + " times");
    }

    private static void printLessFrequentLetter() {
        char[] letters = new char[29];
        int[] amountOfLetters = new int[29];

        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            letters[count] = c;
            count++;
        }
        // Danish letters
        letters[26] = 'æ';
        letters[27] = 'ø';
        letters[28] = 'å';

        for (String s : text) {
            for (char c : s.toLowerCase().toCharArray()) {
                for (int j = 0; j < letters.length; j++) {
                    if (c == letters[j]) {
                        amountOfLetters[j]--;
                        break;
                    }
                }
            }
        }
        int indexCount = 0;
        for (int j = letters.length - 1; j > 0; j--) {
            if (amountOfLetters[j] > amountOfLetters[indexCount]) {
                indexCount = j;
            }
        }
        System.out.println("Less frequent character: " + letters[indexCount] + " : " + amountOfLetters[indexCount] + " times");
    }


}
