public class MainTest {
    public static void main(String[] args) {
        int[] c1 = { 99, 0, 0, 0, 0, 0, 0, 0 };
        Polynomial p1 = new Polynomial(c1);
        System.out.println(p1.getDegree());
    }
}
