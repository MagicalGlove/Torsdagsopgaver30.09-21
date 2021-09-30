import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                                // checks if there's more lines in the file
        {
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");                    // Creates and array of strings, where each element is a single word from the file.
        System.out.println(text.length);

        //printWordsStartingWith("Ø");

        //printWordsOfLength(3);

        //printLongestWord();

        //printFirstHalfOfEachWord();

        //printMostFrequentLetter();

        printLeastFrequentLetter();


        //test dine metoder ved at kalde dem her:


    }

    private static void printLeastFrequentLetter() {

        ArrayList<Character> bogstaver = new ArrayList<>();

        for(int i=0; i<text.length; i++){
            String ord = text[i].toLowerCase();

            for(int j=0; j<ord.length();j++){
                bogstaver.add(ord.charAt(j));
            }
        }
        char[] AlfabetArray = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y', 'z','æ','ø','å'};
        char LeastUsedLetter = ' ';
        char currentLetter;
        int current_freq;
        int lowest_freq = -1;

        for(int i=0;i<AlfabetArray.length;i++) {
            currentLetter = AlfabetArray[i];
            current_freq = Collections.frequency(bogstaver, currentLetter);
            if (current_freq < lowest_freq || lowest_freq == -1 ){
                LeastUsedLetter = currentLetter;
                lowest_freq = current_freq;
            }
        }
        for(int j = 0; j < AlfabetArray.length; j++){
            int tmp = Collections.frequency(bogstaver, AlfabetArray[j]);
            if(tmp == lowest_freq){
                System.out.println(AlfabetArray[j]);
            }
        }
        System.out.println("Dette er de mindste anvendte bogstaver");
    }

    private static void printMostFrequentLetter() {
        ArrayList<Character> bogstaver = new ArrayList<>();

        for(int i=0; i<text.length; i++){
            String ord = text[i].toLowerCase();

            for(int j=0; j<ord.length();j++){
                bogstaver.add(ord.charAt(j));
            }
        }
        char[] AlfabetArray = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','æ','ø','å'};
        char MostUsedLetter = ' ';
        char currentLetter;
        int current_freq;
        int highest_freq = 0;

        for(int i=0;i<AlfabetArray.length;i++) {
            currentLetter = AlfabetArray[i];
            current_freq = Collections.frequency(bogstaver, currentLetter);
            if (current_freq > highest_freq){
                 MostUsedLetter = currentLetter;
                 highest_freq = current_freq;
            }
        }
        System.out.println("Det mest anvendte bogstav er " +MostUsedLetter);
        System.out.println("Der var " +highest_freq+ " " +MostUsedLetter+ "'er");
    }

    private static void printFirstHalfOfEachWord() {
        for(int i=0;i<text.length; i++){
            System.out.println(text[i].substring(0,text[i].length()/2)); //Bruger en substring til at printe den første halvdel af hvert ord
        }

    }

    private static void printLongestWord() {
        String longest_word = "";    //Denne string indeholder mit længste ord
        String current;              // Nuværende ord som holdes

        for(int i=0; i<text.length;i++) {      //Mit for-loop, som går igennem teksten ord for ord, og holder på det længste
            current = text[i];
            if(current.length() > longest_word.length()){
                longest_word = current;
            }
        }
        System.out.println("Dette er det længste ord: " +longest_word);
    }



    private static void printWordsOfLength(int l)
    {
        boolean wordisvalid = true;

        for (String s : text)
        {
            if (s.length() == l)
            {
                if (s.contains(",") || s.contains("."))
                {
                    wordisvalid = false;
                }

                if (wordisvalid)
                {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern)
    {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase()))
            {
                System.out.println(s);
            }
        }
    }

    //skriv dine metoder herunder:



}
