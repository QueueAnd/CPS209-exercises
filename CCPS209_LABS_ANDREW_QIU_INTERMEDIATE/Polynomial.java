import java.util.ArrayList;
import java.util.Comparator;

public class Polynomial implements Comparable<Polynomial> {
    @Override
    public String toString() {
        return "Hello!";
    }

    int[] coefficients;

    @Override public boolean equals(Object other){
        if(other instanceof Polynomial){
            return compareTo((Polynomial)other)==0;
        }
        return false;
    }
    @Override public int hashCode(){
        int hash=0;
        for (int coefficient : coefficients) {
            hash += hash * coefficient * 33;
        }
        return hash;
    }
    @Override public int compareTo(Polynomial other){

        if (getDegree()>other.getDegree()){
            return 1;
        } else if (getDegree()<other.getDegree()){
            return -1;
        } else {
            for(int i=getDegree(); i>=0; i--){
                if(getCoefficient(i)>other.getCoefficient(i)){
                    return 1;
                } else if (getCoefficient(i)<other.getCoefficient(i)){
                    return -1;
                }
            }
        }
        return 0;
    }

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients.clone();
        for(int i=0; i<coefficients.length;i++){
        }
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
        int maxIndex=maxDegree+1;
        int newMaxIndex=maxDegree*2+1;
        int[] results=new int[newMaxIndex];
        for(int i=0; i<getDegree()+1; i++){
            for(int j=0; j<other.getDegree()+1; j++){
                results[i+j]=results[i+j]+getCoefficient(i)*other.getCoefficient(j);
            }
        }
        return new Polynomial(results);
    }
}