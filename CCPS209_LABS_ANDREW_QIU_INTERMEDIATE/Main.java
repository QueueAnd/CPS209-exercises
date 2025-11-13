import java.util.zip.CRC32;

public class Main
{
    public static void main(String[] args)
    {
        CRC32 check = new CRC32();
        for(int k = 0; k < 30_000; k++) {
            check.update(Primes.kthPrime(k));
        }
        System.out.println(Primes.factorize(220));
    }
}
