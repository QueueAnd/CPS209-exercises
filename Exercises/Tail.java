import java.util.ArrayList;
import java.util.List;

public class Tail extends FileProcessor<List<String>> {
    private int data;
    private int count;
    List<String> result = new ArrayList<String>();
    public Tail(int n){
        data=n;
    }
    @Override
    protected void startFile() {

    }

    @Override
    protected void processLine(String line) {
        result.add(line);
    }

    @Override
    protected List<String> endFile() {
        if(data>result.size()){
            System.out.println(result.size());
            return result;
        }
        System.out.println(result.subList(Math.max(0, result.size()-1-data), result.size()-1).size());
        return result.subList(Math.max(0, result.size()-data), result.size());
    }
}
