package Programista;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);
        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java");
        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);
        List<Programmer> programmers = Arrays.asList(programmer1, programmer2, programmer3, programmer4,
                programmer5, programmer6, programmer7, programmer8, programmer9);
        System.out.println(programmers);


        List<Programmer> programisciMezczyzni = programmers.stream()
                .filter(person -> person.getPerson().isMale)
                .collect(Collectors.toList());
        System.out.println(programisciMezczyzni);
//        programisciMezczyzni.stream().forEach(System.out::println);

        List<Programmer> niepelnoletniProgramisciPiszacyWCobolu = programmers.stream()
                .filter(person -> person.getPerson().getAge() < 18 && person.getLanguages().contains("Cobol"))
                .collect(Collectors.toList());
        System.out.println(niepelnoletniProgramisciPiszacyWCobolu);

        List<Programmer> programisciZnajacyWiecejNizJedenJezyk = programmers.stream()
                .filter(person -> person.getLanguages().size() > 1)
                .collect(Collectors.toList());
        System.out.println(programisciZnajacyWiecejNizJedenJezyk);

        List<String> l1 = Arrays.asList("Java", "Cpp");
        List<Programmer> programistkiZnajaceJaveICpp = programmers.stream()
                .filter(person -> !person.getPerson().isMale && person.getLanguages().containsAll(l1))
                .collect(Collectors.toList());
        System.out.println(programistkiZnajaceJaveICpp);

        List<String> imionaMeskie = programmers.stream()
                .filter(person -> person.getPerson().isMale)
//                .filter(person -> !person.getPerson().getFirstName().endsWith("a"))
                .map(person -> person.getPerson().getFirstName())
                .collect(Collectors.toList());
        System.out.println(imionaMeskie);

        List<String> wszystkieJezyki = programmers.stream()
                .flatMap(person -> person.getLanguages().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(wszystkieJezyki);
//        Set<String> jezyki = new HashSet<>()

        List<String> nazwiskaProgramistowZnajacychWiecejNizJedenJezyk = programmers.stream()
                .filter(person -> person.getLanguages().size() > 2)
                .map(person -> person.getPerson().getLastName())
                .collect(Collectors.toList());
        System.out.println(nazwiskaProgramistowZnajacychWiecejNizJedenJezyk);

        Boolean czyOsobaNieZnajacaZadnegoJezyka = programmers.stream()
                .anyMatch(person -> person.getLanguages().isEmpty());
        System.out.println(czyOsobaNieZnajacaZadnegoJezyka);

        Long iloscWszystkichJezykow = programmers.stream()
                .filter(person -> !person.getPerson().isMale)
                .flatMap(person -> person.getLanguages().stream())
                .distinct()
//                .collect(Collectors.toList())
//                int a = iloscWszystkichJezykow.size
//                System.out.println(a);
                .count();
        System.out.println(iloscWszystkichJezykow);


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o2.length() > o1.length()) {
                    return -1;
                }
                return 0;
            }
        };

        Optional<String> linia = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bel\\IdeaProjects\\Streamy\\src\\main\\java\\Programista\\fff.txt"))) {
            linia = reader.lines().max(comparator);
            linia.ifPresent(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}