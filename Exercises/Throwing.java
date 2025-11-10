import java.io.IOException;
import java.util.Scanner;
public class Throwing
{

    public static void main(String[] args)
    {
        try{
            int x = getInt();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int getInt() throws IOException {
// your code goes here
        Scanner scanner= new Scanner(System.in);
        return scanner.nextInt();
    }
}

