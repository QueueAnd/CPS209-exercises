import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExercises {
    public static int countLines(Path path, int thres) throws IOException{
        Stream<String> stream=Files.lines(path);
        return (int)stream.filter(s->s.length()>=thres).count();
    }
    public static List<String> collectWords(Path path) throws IOException{
        Stream<String> stream=Files.lines(path)
                .map(String::toLowerCase)
                .flatMap(s-> Arrays.stream(s.split("[^a-z]+")))
                .filter(Predicate.not(String::isEmpty))
                .sorted()
                .distinct();
        return stream.toList();
    }
}
