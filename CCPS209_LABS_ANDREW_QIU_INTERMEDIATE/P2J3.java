import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2J3 {
    public static void reverseAscendingSubarrays(int[] items){
        List<Integer> results = new ArrayList<Integer>();
        List<Integer> tempArray= new ArrayList<>();
        int startIndex=0;
        for(int i = 1; i < items.length; i++) {
            if (i >= items.length - 1 && items[i] > items[i - 1]) {
                for (int j = i; j >= startIndex; j--) {
                    results.add(items[j]);
                }
            }
            if (items[i] < items[i - 1]) {
                for (int j = i - 1; j >= startIndex; j--) {
                    results.add(items[j]);
                }
                    startIndex = i;
                }
            }
        for(int d=0; d<results.size(); d++){
            items[d]=results.get(d);
        }
    }
    public static String pancakeScramble(String text){
        for(int i=2; i<=text.length(); i++){
            text=new StringBuilder(text.substring(0, i)).reverse().toString()+text.substring(i);
        }
        return text;
    }
    public static String reverseVowels(String text){
        List<Character> vowels=new ArrayList<>();
        String vowelIndex="aieouAEIOU";
        char[] textCharArray=text.toCharArray();
        for(int i=0; i<text.length(); i++){
            if(vowelIndex.indexOf(textCharArray[i])!=-1){
                vowels.add(text.charAt(i));
            }
        }
        int count=vowels.size()-1;
        for(int j=0; j<textCharArray.length; j++){
            if(vowelIndex.indexOf(textCharArray[j])!=-1){
                if(Character.isUpperCase(textCharArray[j])){
                    textCharArray[j]=Character.toUpperCase(vowels.get(count));
                } else {
                    textCharArray[j]=Character.toLowerCase(vowels.get(count));
                }
                count--;
            }
        }
        return String.valueOf(textCharArray);
    }
}
