public class MainTest {
    public static void main(String[] args) {
        int[] c1 = { 99, 12, 0, 0, 30, 0, 0, 3 };
        int[] c2 = { 99, 0, 3, 0, 15, 0, 0, 0 };
        Polynomial p1 = new Polynomial(c1);
        Polynomial p2=new Polynomial(c2);

        Polynomial thing1=new Polynomial(new int[]{3, 1, 2, 3});
        Polynomial thing2=new Polynomial(new int[]{7, 2, 4, 8});
        thing1.multiply(thing2);
    }
}
