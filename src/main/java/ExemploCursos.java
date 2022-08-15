import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        cursos.forEach(c -> System.out.println(c.getNome()));

        OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();

        Stream<String> nomes = cursos.stream().map(Curso::getNome);
        System.out.println(nomes);
        System.out.println(media);

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        cursos = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c-> c.getNome(),
                        c ->c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        cursos.stream().forEach(c -> System.out.println(c.getNome()));
    }
}
