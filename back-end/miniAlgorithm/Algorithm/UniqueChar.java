package Algorithm;

import java.util.Arrays;

public class UniqueChar {
    public boolean isUniqueString(String text ){

        char[] charArray = text.toCharArray();

        Arrays.sort(charArray);
        for (int i=0; i<text.length(); i++){
            for (int j=i+1; j<text.length(); j++){
                if(charArray[i] == charArray[j]){
                    return false;

                }
            }
        }
        return true;
    }
}
