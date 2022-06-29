package by.it.marchenko.stream;

import java.io.StreamTokenizer;
import java.util.stream.Stream;

public class jd01_01 {

    public static final String HELLO_STREAM = "Hello stream";

    public static void main(String[] args) {
        Stream<String> helloStream = Stream.of(HELLO_STREAM);
        //HELLO_STREAM.chars().forEach(s -> System.out::println);
    }
}
