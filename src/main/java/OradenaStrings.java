import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OradenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editando casa do codigo");
        palavras.add("caelum");

        //palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.sort(Comparator.comparing(String::length));

        System.out.println(palavras);


        palavras.forEach(System.out::println);
    }
}