import java.util.Iterator;

public class PrimeGens{
    public static class TwinPrimes implements Iterator<Integer> {
        private int k=0;
        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public Integer next() {
            while(true){
                if(Primes.isPrime(Primes.kthPrime(k)+2)){
                    return Primes.kthPrime(k++);
                }
                k++;
            }
        }
    }
    public static class SafePrimes implements Iterator<Integer> {
        private int k=0;
        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public Integer next() {
            while(true){
                if(Primes.isPrime(Primes.kthPrime(k)*2+1)){
                    int nextPrime=Primes.kthPrime(k)*2+1;
                    k++;
                    return nextPrime;
                }
                k++;
            }
        }
    }
    public static class StrongPrimes implements Iterator<Integer> {
        private int k=1;
        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public Integer next() {
            while(true){
                if(Primes.kthPrime(k)>(Primes.kthPrime(k+1)+Primes.kthPrime(k-1))/2){
                    return Primes.kthPrime(k++);
                }
                k++;
            }
        }
    }
}
