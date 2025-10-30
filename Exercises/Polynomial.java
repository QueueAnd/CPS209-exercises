import java.util.ArrayList;

public class Polynomial {
    @Override
    public String toString() {
        return "Hello!";
    }

    int[] coefficients;

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients.clone();
        for(int i=0; i<coefficients.length;i++){
        }
        System.out.println();
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
        int maxIndex=Math.max(getDegree(), other.getDegree())+1;
        int[] result=new int[maxIndex];
        for(int i=0; i<maxIndex; i++) {
            result[i]=getCoefficient(i)+other.getCoefficient(i);
        }
        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial other) {
        int maxDegree=Math.max(getDegree(), other.getDegree());
        int newMaxIndex=maxDegree+1;
        int multipliedMaxIndex=maxDegree*maxDegree+1;
        int[] results=new int[multipliedMaxIndex];
        for(int i=0; i<newMaxIndex; i++){
            results[i*i]=getCoefficient(i)*other.getCoefficient(i);
        }
        return new Polynomial(results);
    }
}