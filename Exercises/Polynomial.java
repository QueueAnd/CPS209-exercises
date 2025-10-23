import java.util.ArrayList;

public class Polynomial {
    @Override
    public String toString() {
        return "Hello!";
    }

    int[] coefficients;

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients.clone();
    }

    public int getDegree() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    public int getCoefficient(int k) {
        if (k >= 0 && k < coefficients.length) {
            return coefficients[k];
        } else {
            return 0;
        }
    }

    public long evaluate(int x) {
        long result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += (long) (coefficients[i] * (Math.pow(x, i)));
        }
        return result;
    }

    public Polynomial add(Polynomial other) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < coefficients.length; i++) {
            results.add((coefficients[i] + other.getCoefficient(i)));
        }
        return results;
    }

    public Polynomial multiply(Polynomial other) {
        ArrayList<Integer> results = new ArrayList<>(coefficients.length - 1);
        for (int i = 0; i < coefficients.length; i++) {
            results.set(i * i, coefficients[i] * coefficients[i]);
        }
        System.out.println(results);
        return results;
    }
}