import java.util.List;

public class WordCount extends FileProcessor<List<Integer>>{
    int charCount;
    int wordCount;
    int lineCount;
    protected void startFile(){
        charCount=0;
        wordCount=0;
        lineCount=0;
    }
    protected void processLine(String line){

    }
    protected List<Integer> endFile(){

    }
}
