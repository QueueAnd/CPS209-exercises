public class MainTest {
    public static void main(String[] args) {
        int[] c1 = { 99, 12, 0, 0, 30, 0, 0, 3 };
        int[] c2 = { 99, 0, 3, 0, 15, 0, 0, 0 };
        Polynomial p1 = new Polynomial(c1);
        Polynomial p2=new Polynomial(c2);

        int[] t01 = {12, 24, 36, 48};
        int[] t02 = {-42, 99, 17, 101};
        int[] e0 = {-42, 99, 17, 101};
        Polynomial p01 = new Polynomial(t01);
        Polynomial p02 = new Polynomial(t02);
        Polynomial r0 = p01.add(p02);
        Polynomial p0e = new Polynomial(e0);

    }
}
