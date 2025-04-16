import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Max", 25));
        list.add(new Person("Ivan", 45));
        list.add(new Person("Anna", 43));

        String nameToFind = "Max";
        boolean found = isPersonWithNameExists(list, nameToFind);
        System.out.println("Найден ли " + nameToFind + "? " + found);

        String nameToFind2 = "Ivan";
        boolean found2 = isPersonWithNameExists2(list, nameToFind);
        System.out.println("Найден ли " + nameToFind2 + "? " + found2);

        String nameToFind3 = "Anna";
        boolean found3 = isPersonWithNameExists3(list, nameToFind);
        System.out.println("Найден ли " + nameToFind3 + "? " + found3);

    }

    public static boolean isPersonWithNameExists(List<Person> list, String name){
        for (Person person : list) {
            if (person.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPersonWithNameExists2(List<Person> list, String name) {
        return list.stream()
                .filter(p->p.getName().equalsIgnoreCase(name))
                .count() > 0;
    }


    public static boolean isPersonWithNameExists3(List<Person> list, String name) {
        return list.stream()
                .anyMatch(p->p.getName().equalsIgnoreCase(name));
    }
}