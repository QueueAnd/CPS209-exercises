import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
    public static boolean isPrime(int n){
        if(n==0||n==1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int kthPrime(int k){
        boolean[] isPrime = new boolean[k+1];
        Arrays.fill(isPrime,true);
        for(int i=2; i<=k; i++){
            isPrime[i]=true;
            for(int j=i*i; j<=Math.sqrt(i); j++){
                isPrime[j]=false;
                j*=j;
            }
        }
        int count=0;
        for(int i=0)
    }
//    public static LIst<Integer> factorize(int n){
//
//    }
}
