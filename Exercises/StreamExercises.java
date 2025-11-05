//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.stream.Stream;
//
//public class StreamExercises {
//    public static int countLines(Path path, int thres) throws IOException{
//        Stream<String> stream=Files.lines(path);
//        return (int)stream.filter(s->s.length()<thres).count();
//    }
//    public static List<String> collectWords(Path path) throws IOException{
//        Stream<String> stream=Files.lines(path);
//
//    }
//}
