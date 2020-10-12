
import java.util.*;

public class WordCount {

    static void wordCount(String input) {
        TreeSet<String> wordSet = new TreeSet<>();
        LinkedList<String> wordList = new LinkedList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreElements()) {
            String word = st.nextToken();
            wordSet.add(word);
            wordList.add(word);
        }
        for (String wordS : wordSet) {
            int count = 0;
            for (String wordL : wordList) {
                if (wordS.equals(wordL)) {
                    count++;
                }
            }
            wordMap.put(wordS, count);
        }

        printResult(wordMap, wordSet);

    }

    static void letterCount(String input) {
        Map<String, Integer> letterMap = new HashMap<>();
        TreeSet<String> letterSet = new TreeSet<>();
        LinkedList<String> letterList = new LinkedList<>();
        
        input = input.replaceAll("", " ");
        StringTokenizer st = new StringTokenizer(input, " ");
         
        while (st.hasMoreElements()){
            String letter = st.nextToken();
            letterList.add(letter);
            letterSet.add(letter);
        }
        
        for (String letterS:letterSet){
            int count = 0;
            for (String letterL: letterList){
                if(letterS.equals(letterL)){
                    count++;
                }
            }
            letterMap.put(letterS, count);
        }
        printResult(letterMap, letterSet);
        
    }

    static void printResult(Map<String, Integer> Map, TreeSet<String> Set) {
        int size = Map.size();
        int index = 0;
        System.out.print("{");
        for (String object : Set) {
            if (index == size - 1) {
                System.out.print(object + "=" + Map.get(object));
            } else {
                System.out.print(object + "=" + Map.get(object));
                System.out.print(", ");
                index++;
            }
        }
        System.out.print("}");
        System.out.println("");
    }

}
