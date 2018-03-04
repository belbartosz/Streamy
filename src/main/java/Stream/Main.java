package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Person> lista = new ArrayList<>();

        lista.add(new Person("Jan", "Kowalski", 18, isMale.MALE));
        lista.add(new Person("Marian", "Kwiatkowski", 40, isMale.MALE));
        lista.add(new Person("Zenon", "Polak", 50, isMale.MALE));
        lista.add(new Person("Anna", "Adamska", 16, isMale.FEMALE));
        lista.add(new Person("Monika", "Wisniewska", 25, isMale.FEMALE));


        List<Person> mezczyzni = lista.stream()
                .filter(person -> person.getPlec() == isMale.MALE)
                .collect(Collectors.toList());
        System.out.println(mezczyzni);


        List<Person> dorosleKobiety = lista.stream()
                .filter(person -> person.getPlec() == isMale.FEMALE && person.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println(dorosleKobiety);

        Optional<Person> jacek = lista.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase("Zenon") && person.getAge() >= 18)
                .findFirst();
        jacek.ifPresent(System.out::println);

        List<String> wPrzedziale = lista.stream()
                .filter(person -> person.getAge() >= 15 && person.getAge() <= 19)
                .map(Person::getLastName)
                .collect(Collectors.toList());
        System.out.println(wPrzedziale);

        int sumaWieku = lista.stream()
//                .mapToInt(person -> person.getAge())
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sumaWieku);

        OptionalDouble sredniaWiekuMezczyzn = lista.stream()
                .filter(person -> person.getPlec() == isMale.MALE)
                .mapToDouble(Person::getAge)
                .average();
        sredniaWiekuMezczyzn.ifPresent(System.out::println);


        Optional<Person> najstarszaOsoba = lista.stream()
//                .max(Comparator.comparingInt(Person::getAge))
                .max(Comparator.comparingInt(person -> person.getAge()));
//                .sorted ((o1, o2) -> o1.getAge() > o2.getAge() ? -1 : o2.getAge() > o1.getAge() ? 1 :0)
//                .findFirst();
        najstarszaOsoba.ifPresent(System.out::println);


    }


}
