import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P2J6 {
    public static List<Integer> sumOfDistinctCubes(int n){
        LinkedList<Integer> results=new LinkedList<>();
        P2J6.sumOfDistinctCubes(n, findHighestCube(n), results);
        return results;
    }
    private static boolean sumOfDistinctCubes(int n, int c, LinkedList<Integer> SoFar){
        if(n==0){
            return true;
        } else if (c==0 || n < 0 || (Math.pow(c, 2)*Math.pow(c+1, 2))/4<n){
            return false;
        } else {
            SoFar.add(c);
            if(!(sumOfDistinctCubes(n-c*c*c,c-1,SoFar))){
                SoFar.removeLast();
                if(sumOfDistinctCubes(n, c-1, SoFar)){
                    return true;
                }

            } else {
                return true;
            };
        }
        return false;
    }
    private static int findHighestCube(int n){
        int count=1;
        while(true){
            double temp=count*count*count;
            if(temp==n){
                return count;
            }
            else if(temp>=n){
                return count-1;
            }
            count+=1;
        }
    }
    public static List<String> forbiddenSubstrings(String alphabet, int n, List<String> tabu){
        List<String> result=new ArrayList<>();
        forbiddenSubstrings(alphabet, n, tabu, "", result);
        return result;
    }
    private static void forbiddenSubstrings(String alphabet, int n, List<String> tabu, String soFar, List<String> result){
        for(String str:tabu) {
            if (soFar.endsWith(str)) {
                return;
            }
        }
        if (soFar.length()==n){
            result.add(soFar);
            return;
        }
        for(int i=0; i<alphabet.length(); i++){
            forbiddenSubstrings(alphabet,n,tabu,soFar+alphabet.charAt(i),result);
        }
    }
}

