import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P2J5 {
    private static List<BigInteger> fibs = new ArrayList<>();
    static { fibs.add(BigInteger.ONE); fibs.add(BigInteger.TWO); }
    public static List<BigInteger> fibonacciSum(BigInteger n) {
        List<BigInteger> results=new ArrayList<>();
        while (n.compareTo(fibs.get(fibs.size()-1)) > 0) {
            fibs.add(fibs.get(fibs.size()-1).add(fibs.get(fibs.size()-2)));
        }
        int index=fibs.size()-1;
        BigInteger f=BigInteger.ZERO;
        while (n.compareTo(fibs.get(index)) < 0) {
            index-=1;
        }
        for(int i=fibs.size()-1; i>=0; i--){
            if(n.compareTo(fibs.get(i)) >= 0) {
                results.add(fibs.get(i));
                n=n.subtract(fibs.get(i));
                if(n.equals(BigInteger.ZERO)) {
                    return results;
                }
            }
        }
        return new ArrayList<BigInteger>() {};
    }
    public static BigInteger sevenZero(int n){
        BigInteger num =BigInteger.valueOf(7);
        if((n%2==0) || (n%5==0)){
            int max=findMaxFactor(n);
            return generateSevens(n, max);
        } else {
            while(true){
                if(num.remainder(BigInteger.valueOf(n)).equals(BigInteger.ZERO)){
                    return num;
                } else {
                    num=num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(7));
                }
            }
        }
    }
    public static int findMaxFactor(int n){
        int fives=0, twos=0;
        int temp=n;
        while(temp%2==0){
            twos++;
            temp/=2;
        }
        while (temp % 5 == 0) {
            fives++;
            temp/=5;
        }
        return Math.max(fives,twos);
    }
    public static BigInteger generateSevens(int n, int max){
        int length=max+1;
        while(true){
//            for(int sevens=1; sevens<length-max; sevens++){
//                BigInteger temp=BigInteger.valueOf(7);
//                for(int i=1; i<sevens; i++) {
//                    temp=temp.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(7));
//                }
//                for(int i=1; i<length-sevens; i++){
//                    temp=temp.multiply(BigInteger.valueOf(10));
//                }
//                if(temp.remainder(BigInteger.valueOf(n)).equals(BigInteger.ZERO)){
//                    return temp;
//                }
//            }
//            length+=1;
        }
    }
}


