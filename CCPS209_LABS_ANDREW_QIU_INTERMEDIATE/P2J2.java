import java.util.Arrays;
import java.util.HashSet;

public class P2J2 {
    public static String removeDuplicates(String text){
        String string="";
        char temp;
        for(int i=0;i<text.length();){
            temp=text.charAt(i);
            string+=temp;
            while(i<text.length() && text.charAt(i)==temp){
                i++;
            }
        }
        return string;
    }
    public static String uniqueCharacters(String text){
        HashSet<Character> set=new HashSet<Character>();
        String response="";
        for(int i=0;i<text.length();i++){
            if(!set.contains(text.charAt(i))){
                set.add(text.charAt(i));
                response+=text.charAt(i);
            }
        }
        return response;
    }
    public static int countSafeSquaresRooks(int n, boolean[][] rooks){
        boolean[] safeRows=new boolean[n], safeCols=new boolean[n];
        Arrays.fill(safeRows,true);
        Arrays.fill(safeCols,true);
        int rowCount=0;
        int colCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(rooks[i][j]){
                    safeRows[i]=false;
                    safeCols[j]=false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(safeRows[i]){
                rowCount++;
            }
            if(safeCols[i]){
                colCount++;
            }
        }
        return rowCount*colCount;
    }
//    public static int recaman(int n){
//
//    }
}
