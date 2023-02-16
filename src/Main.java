import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ex1();
    }

    /*
    Пусть дан список сотрудников:
    Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
    Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина,
    Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.

    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
     */

    public static void ex1() {
        String data = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, " +
                "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, " +
                "Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        String[] namesList = data.split(", ");

        TreeMap<String, Integer> treeMap = new TreeMap();
        for (String fullName: namesList) {
            String[] nameSplit = fullName.split(" ");
            String name = nameSplit[0];

            if (treeMap.containsKey(name)){
                Integer count = treeMap.get(name);
                treeMap.put(name, count + 1);
            } else {
                treeMap.put(name, 1);
            }
        }

        TreeMap<Integer, List<String>> treeMapSorted = new TreeMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for(String name: treeMap.keySet()) {
            if (treeMapSorted.containsKey(treeMap.get(name))){
                List<String> list = treeMapSorted.get(treeMap.get(name));
                list.add(name);
            } else {
                List<String> list = new ArrayList<>();
                list.add(name);
                treeMapSorted.put(treeMap.get(name), list);
            }
        }

        System.out.println(treeMapSorted);
    }
}