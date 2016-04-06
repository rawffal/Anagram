package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();

    private HashSet<String> wordSet = new HashSet<>();
    private ArrayList<String> wordList = new ArrayList<>();
    private HashMap<String, ArrayList> lettersToWord = new HashMap<>();

    /* CONSTRUCTOR */
    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            /* Hashset */
            wordSet.add(line);
            /* ArrayList */
            wordList.add(line);
            Arrays.sort(line.toCharArray());
            String sorted = new String(line);
            /*Condition Check*/
            if (lettersToWord.containsKey(sorted)) {
                lettersToWord.get(sorted).add(line);
            } else {
                lettersToWord.put(sorted, new ArrayList<String>());
                lettersToWord.get(sorted).add(line);
            }
        }
    }

    public boolean isGoodWord(String word, String base) {
        return word.contains(base);
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();

        Arrays.sort(word.toCharArray());
        String sorted = new String(word);
        Log.d("Sorted", sorted);
        result = lettersToWord.get(sorted);

            Log.d("Result", result.get(0));

        return result;
    }

    public String pickGoodStarterWord() {
        return "post";
    }
}
