package stringmanipulations;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is created for Data Manipulations
 * May contains child classes for multiple data types like String, Integer, Double etc..
 * *
 */
public class Consol {

    /**
     * This class contains various methods for manipulating text (such as
     * finding the longest words in a text.
     *
     * @author Ramazan Kali
     **/
    public static class Text {

        /**
         * This method returns all the words of a text without any null or " "
         * It returns a list of words
         * It removes all special characters like '/','?','.',''' etc...
         */
        public static List<String> findwords(String text) {

            List<String> listOfWords=
                    Arrays.
                            stream(text.replaceAll("[!?'’.\",]", " ").split(" ")).
                            map(word -> word.replaceAll(" ", "")).
                            filter(word->word.length() != 0).
                            collect(Collectors.toList());

            return listOfWords;
        }


        /**
         * This method returns the longest word in a text or returns null
         * It removes all special characters like '/','?','.',''' etc...
         */
        public static String findFirstLongestWord(String text) {

            return Arrays.stream(text.replaceAll("[!?'’.\",]", " ").split(" ")).
                    map(word -> word.replaceAll(" ", "")).
                    max(Comparator.comparingInt(String::length)).
                    orElse(null);
        }

        public static int findLenghtOfTheLongestWord(String text) {

            return Arrays.stream(text.replaceAll("[!?'’.\",]", " ").split(" ")).
                    map(word -> word.replaceAll(" ", "")).
                    max(Comparator.comparingInt(String::length)).
                    orElse(null).length();
        }



        /*
         * This method accepts @param text String
         * Generates a Map<Integer,List<String>> -> Map<K,V>
         * Where V is a list of Words as a String type
         * Each K is an Integer equals to the lenght of words in the Value
         * All keys are reproduced from the @param text by replaceAll and splitting methods to eliminate special characters
         * */
        public static Map<Integer, List<String>> getWordsAsAMapWithSizesInAText(String text) {

            //replaces special characters that may be used in a regular sentence
            // and removes white space in the last step
            List<String> listOfWords =
                    Arrays.
                            stream(text.replaceAll("[!?’'.\",]", " ").split(" ")).
                            map(word -> word.replaceAll(" ", "")).
                            filter(word->word.length() != 0).
                            collect(Collectors.toList());

            //Creates the keyset with existing words' lengths
            Set<Integer> keySet = listOfWords.
                    stream().
                    map(String::length).
                    collect(Collectors.toSet());

            //creates and empty map with keySet same As word lengths and values initialized with an empty ArrayList<String>
            Map<Integer, List<String>> mapOfLengthAndWordLists = new HashMap<>();
            keySet.
                    forEach(length ->
                    {
                        mapOfLengthAndWordLists.put(length, new ArrayList<String>());
                    });

            //adds each word to related (key, value) list Map<Length,List<Words>>
            listOfWords.
                    forEach(word ->
                    {
                        mapOfLengthAndWordLists.get(word.length()).add(word);
                    });

            return mapOfLengthAndWordLists;
        }

        /**
         * Accepts a @param text as a String and returns a Map<Integer,List<String>>
         * where Key is an Integer equal to the length of the words
         * List<String> are the words where their lengths are equal to the Key (Integer)
         **/
        public static Map<Integer, List<String>> findTheLongestWordsInAText(String text) {
            Map<Integer, List<String>> resultMap = new HashMap<>();

            /*replaces "," commas with spaces " " then splits by space " "
             * In case of existence of "." it accepts as a second text and takes the first text only
             * removes blank elements
             * */
            List<String> listOfWords =
                    Arrays.
                            stream(text.replaceAll("[!?'’.\",]", " ").split(" ")).
                            map(word -> word.replaceAll(" ", "")).
                            filter(word->word.length() != 0).
                            collect(Collectors.toList());

            //finds the lenghts of the longest word
            int longestWordsLength =listOfWords.isEmpty() ? 0:
                    listOfWords.
                            stream().
                            reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2).get().length();

            /*puts the words into a list and than into a map with its lenghts where length = maximum length */
            resultMap.put(
                    longestWordsLength,
                    listOfWords.
                            stream().
                            filter(word -> word.length() == longestWordsLength).
                            map(word -> word).
                            collect(Collectors.toList()));


            return resultMap;
        }

    }
}
