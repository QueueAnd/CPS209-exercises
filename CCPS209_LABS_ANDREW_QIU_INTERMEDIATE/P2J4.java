import java.util.*;

public class P2J4 {
    public static List<Integer> runningMedianOfThree(List<Integer> items){
        if(items.size()<3){
            return items;
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(items.get(0));
        result.add(items.get(1));
        for(int i=2; i<items.size(); i++){
            int[] subArray=new int[3];
            for(int j=0; j<3; j++){subArray[j]=items.get(i-j);}
            Arrays.sort(subArray);
            result.add(subArray[1]);
        }
        return result;
    }
    public static int firstMissingPositive(List<Integer> items){
        boolean[] flag=new boolean[items.size()+2];
        for(int i: items){
            if(!(i>=flag.length)){
                flag[i]=true;
            }
        }
        for(int i=1; i<flag.length; i++){
            if(!flag[i]){
                return i;
            }
        }
        return 1;
    }
    public static void sortByElementFrequency(List<Integer> items){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        class compareThing implements Comparator<Integer>{

            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1)<map.get(o2)){
                    return 1;
                } else if (map.get(o1)>map.get(o2)){
                    return -1;
                } else if (o1>o2){
                    return 1;
                } else if (o1<o2) {
                    return -1;
                }
                return 0;
            }
        }

        for(int i: items){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        Collections.sort(items, new compareThing());
    }
    public static List<Integer> factorFactorial(int n){
        List<Integer> results=new ArrayList<>();
        int temp;
        if(n==0 || n==1){
            return results;
        }
        for(int i=n; i>=2; i--){
            temp=i;
            while(temp%2==0){
                results.add(2);
                temp/=2;
            }
            for(int j=3; j<=temp; j+=2){
                while(temp%j==0){
                    results.add(j);
                    temp/=j;
                }
            }
        }
        Collections.sort(results);
        return results;
    }
}
