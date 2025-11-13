import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

    private static List<Integer> primes=new ArrayList<Integer>();
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
          if(primes.size()==0){
              primes.add(2);
          }
          int toTest=primes.get(primes.size()-1);
          while(true){
              if(primes.size()>k){
                  return primes.get(k);
              }
              toTest++;
              if(isPrime(toTest)){
                  primes.add(toTest);
              }
          }

    }
    public static List<Integer> factorize(int n){
        List<Integer> factors=new ArrayList<Integer>();
        int factor=0;
        while(!isPrime(n)){
            if(n%primes.get(factor)==0){
                n/=primes.get(factor);
                factors.add(primes.get(factor));
            } else {
                factor++;
            }
        }
        factors.add(n);
        return factors;
    }
}
