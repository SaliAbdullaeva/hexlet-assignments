package exercise;

import java.util.List;
import java.util.stream.Collectors;

public static List<String> buildApartmentsList(List<Home> homes, int n) {
    List<String> homesList = new ArrayList<>();

    // Сортируем список объектов по площади по возрастанию
    Collections.sort(homes);

    // Берем первые n элементов
    List<Home> firstHomes = homes.subList(0, Math.min(n, homes.size()));

    // Создаем список строковых представлений объектов
    for (Home home : firstHomes) {
        homesList.add(home.toString());
    }

    return homesList;

}
