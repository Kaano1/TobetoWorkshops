package Algorithm;

import java.util.HashMap;

public class CharCount {
    public void countChar(String text){
        HashMap<Character, Integer> charCount = new HashMap<>();

        text = text.toLowerCase();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c))
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : charCount.keySet())
            System.out.println(c + ":" + charCount.get(c));
    }
}
