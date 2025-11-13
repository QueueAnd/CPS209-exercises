import java.util.ArrayList;
import java.util.Arrays;
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
        boolean inSpaces=true;
        lineCount++;
        for(char c: line.toCharArray()){
            charCount++;
            if (Character.isWhitespace(c)){
                inSpaces=true;
            } else if (inSpaces) {
                wordCount++;
                inSpaces=false;
            }

        }
    }
    protected List<Integer> endFile(){
        return Arrays.asList(charCount, wordCount, lineCount);
    }
}
