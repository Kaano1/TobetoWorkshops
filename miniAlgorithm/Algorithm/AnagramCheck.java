package Algorithm;

import java.util.Arrays;

public class AnagramCheck {
    public boolean anagramFind(String text1, String text2) {
        if(text1.length() != text2.length()){
            return false;
        }

        char[] charText1 = text1.toCharArray();
        char[] charText2 = text2.toCharArray();

        Arrays.sort(charText1);
        Arrays.sort(charText2);

        return Arrays.equals(charText1, charText2);
    }


}
