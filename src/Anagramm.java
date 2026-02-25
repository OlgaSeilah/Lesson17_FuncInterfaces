import java.util.HashMap;
import java.util.Map;

public class Anagramm {

    public static void main(String[] args) {
        String baseWord = "electricity";

        System.out.println(baseWord + " | " + "electric" + " -> " + isAnagram(baseWord, "electric"));
        System.out.println(baseWord + " | " + "city" + " -> " + isAnagram(baseWord, "city"));
        System.out.println(baseWord + " | " + "tet" + " -> " + isAnagram(baseWord, "tet"));
        System.out.println(baseWord + " | " + "let" + " -> " + isAnagram(baseWord, "let"));
        System.out.println(baseWord + " | " + "tree" + " -> " + isAnagram(baseWord, "tree"));
        System.out.println(baseWord + " | " + "critic" + " -> " + isAnagram(baseWord, "critic"));

        System.out.println(baseWord + " | " + "tot" + " -> " + isAnagram(baseWord, "tot"));
        System.out.println(baseWord + " | " + "tet " + " -> " + isAnagram(baseWord, "tet "));
        System.out.println(baseWord + " | " + "teeeet" + " -> " + isAnagram(baseWord, "teeeet"));
        System.out.println(baseWord + " | " + " toot" + " -> " + isAnagram(baseWord, " toot"));
        System.out.println(baseWord + " | " + "1tot" + " -> " + isAnagram(baseWord, "1tot"));
        System.out.println(isAnagram(baseWord, "electricityy"));

    }

    public static boolean isAnagram(String word, String anagram) {
        if (word.isEmpty() || anagram.isEmpty()) return false;
        if (word.length() < anagram.length()) return false;

        Map<Character, Integer> wordLettersMap = countLetters(word);
        Map<Character, Integer> anagramLettersMap = countLetters(anagram);

        for (Map.Entry<Character, Integer> entry : anagramLettersMap.entrySet()) {

            if (wordLettersMap.containsKey(entry.getKey())) {
                if (!Character.isLetter(entry.getKey())) {
                    return false;
                }
                if (entry.getValue() <= wordLettersMap.get(entry.getKey())) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> countLetters(String word) {
        Map<Character, Integer> countOfLettersInOriginalWord = new HashMap<>();

        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            char letter = sb.charAt(i);
            if (countOfLettersInOriginalWord.containsKey(letter)) {
                countOfLettersInOriginalWord.put(letter, countOfLettersInOriginalWord.get(letter) + 1);
            } else {
                countOfLettersInOriginalWord.put(letter, 1);
            }
        }
        return countOfLettersInOriginalWord;
    }
}
