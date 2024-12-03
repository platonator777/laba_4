import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {


        //ЗАДАНИЕ 1.1

//        Box<Integer> integerBox = new Box<>();
//
//        integerBox.put(3);
//
//        System.out.println("Коробка заполнена? " + !integerBox.isEmpty());
//
//        Integer value = integerBox.get();
//        System.out.println("Извлеченное значение: " + value);
//        Box<String> integerBox2 = new Box<>();
//
//        integerBox2.put("привет");
//
//        String value2 = integerBox2.get();
//        System.out.println("Попытка извлечь из пустой коробки");
//        try {
//            integerBox2.get();
//        } catch (IllegalStateException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//        System.out.println("Извлеченное значение: " + value);
//        System.out.println("Коробка заполнена? " + !integerBox2.isEmpty());
//        System.out.println("Заполнение коробки числом 10");
//        integerBox.put(10);
//        System.out.println("Попытка заполнить полную коробку");
//        try {
//            integerBox.put(10); // Снова кладем число
//        } catch (IllegalStateException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }



        // ЗАДАНИЕ 1.2

//        // Пример 1: Хранилище чисел с null и альтернативой 0
//        Storage<Integer> storageWithNullNumber = new Storage<>(null, 0);
//        processStorage(storageWithNullNumber); // Ожидается вывод 0
//
//        // Пример 2: Хранилище чисел со значением 99 и альтернативой -1
//        Storage<Integer> storageWithNumber = new Storage<>(99, -1);
//        processStorage(storageWithNumber); // Ожидается вывод 99
//
//        // Пример 3: Хранилище строк с null и альтернативой "default"
//        Storage<String> storageWithNullString = new Storage<>(null, "default");
//        processStorage(storageWithNullString); // Ожидается вывод "default"
//
//        // Пример 4: Хранилище строк со значением "hello" и альтернативой "hello world"
//        Storage<String> storageWithString = new Storage<>("hello", "hello world");
//        processStorage(storageWithString); // Ожидается вывод "hello"


        //ЗАДАНИЕ 2.2

//        Box<Integer> box1 = new Box<>();
//        Box<Double> box2 = new Box<>();
//        Box<Float> box3 = new Box<>();
//
//        // Заполняем коробки
//        box1.put(10);
//        box2.put(20.5);
//        box3.put(122.3433f);
//
//        // Добавляем коробки в список
//        List<Box<? extends Number>> boxes = new ArrayList<>();
//        boxes.add(box1);
//        boxes.add(box2);
//        boxes.add(box3);
//
//        // Ищем максимум
//        double max = findMax(boxes);
//        System.out.println("Максимальное значение: " + max);



        //ЗАДАНИЕ 3.1

//        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
//        List<Integer> lengths = applyToList(strings, String::length);
//        System.out.println("Длины строк: " + lengths);
//
//        // 2. Преобразование отрицательных чисел в положительные
//        List<Integer> numbers = Arrays.asList(1, -3, 7);
//        List<Integer> positiveNumbers = applyToList(numbers, Math::abs);
//        System.out.println("Положительные числа: " + positiveNumbers);
//
//        // 3. Максимальные значения в массивах
//        List<int[]> arrays = Arrays.asList(
//                new int[]{3, 5, 1},
//                new int[]{8, 2, 6},
//                new int[]{0, -1, 4}
//        );
//        List<Integer> maxValues = applyToList(arrays, arr -> Arrays.stream(arr).max().orElse(0));
//        System.out.println("Максимальные значения: " + maxValues);


        //ЗАДАНИЕ 3.2

//        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
//        List<String> longStrings = filterList(strings, s -> s.length() >= 3);
//        System.out.println("Строки длиной не менее 3 символов: " + longStrings);
//
//        // 2. Фильтрация положительных чисел
//        List<Integer> numbers = Arrays.asList(1, -3, 7);
//        List<Integer> nonPositiveNumbers = filterList(numbers, n -> n <= 0);
//        System.out.println("Неположительные числа: " + nonPositiveNumbers);
//
//        // 3. Фильтрация массивов, где есть положительные элементы
//        List<int[]> arrays = Arrays.asList(
//                new int[]{-3, -5, -1},
//                new int[]{8, -2, 6},
//                new int[]{0, -1, -4}
//        );
//        List<int[]> noPositiveArrays = filterList(arrays, arr -> Arrays.stream(arr).noneMatch(x -> x > 0));
//        System.out.println("Массивы без положительных элементов:");
//        noPositiveArrays.forEach(arr -> System.out.println(Arrays.toString(arr)));


        //ЗАДАНИЕ 3.3

        List<String> stringList = Arrays.asList("qwerty", "asdfg", "zx");
        String concatenated = reduceList(stringList, (a, b) -> a + b, "");
        System.out.println("Объединённая строка: " + concatenated);

        // Пример 2: Сумма чисел
        List<Integer> intList = Arrays.asList(1, -3, 7);
        Integer sum = reduceList(intList, Integer::sum, 0);
        System.out.println("Общее количество элементов: " + sum);

        // Пример 3: Количество элементов во вложенных списках
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList()
        );
        int totalElements = reduceList(
                nestedLists.stream().filter(Objects::nonNull).map(List::size).collect(Collectors.toList()),
                Integer::sum,
                0
        );
        System.out.println("Всего элементов: " + totalElements);


        //ЗАДАНИЕ 3.4

        List<Integer> numbers = Arrays.asList(1, -3, 7, -5, 2);
        Map<Boolean, List<Integer>> partitionedNumbers = collectValues(
                numbers,
                Collectors.partitioningBy(number -> number > 0) // Разделение по предикату
        );
        System.out.println("Разделение на положительные и нет: " + partitionedNumbers);

        // Пример 2: Разделение строк по длине
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw", "zxc");
        Map<Integer, List<String>> groupedByLength = collectValues(
                strings,
                Collectors.groupingBy(String::length) // Группировка по длине строки
        );
        System.out.println("группировка по длинне: " + groupedByLength);

        // Пример 3: Уникальные значения в Set
        List<String> duplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueValues = collectValues(
                duplicates,
                Collectors.toSet() // Преобразование в Set
        );
        System.out.println("Уникальные значения: " + uniqueValues);

    }

    public static <T> void processStorage(Storage<T> storage) {
        System.out.println("Извлеченное значение: " + storage.get());
    }

    public static double findMax(Collection<? extends Box<? extends Number>> boxes) {
        double max = Double.NEGATIVE_INFINITY; // Начальное значение для поиска максимума

        for (Box<? extends Number> box : boxes) {
            if (!box.isEmpty()) {
                Number value = box.get(); // Получаем значение из коробки
                double doubleValue = value.doubleValue(); // Преобразуем в double
                if (doubleValue > max) {
                    max = doubleValue;
                }
            }
        }

        if (max == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Список коробок не содержит значений!");
        }

        return max;
    }

    public static <T, P> List<P> applyToList(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> T reduceList(List<T> list, BinaryOperator<T> reducer, T defaultValue) {
        if (list == null || list.isEmpty()) {
            return defaultValue; // Возвращаем значение по умолчанию для пустого списка
        }
        return list.stream().reduce(reducer).orElse(defaultValue);
    }

    public static <T, P> P collectValues(List<T> sourceList, Collector<T, ?, P> collector) {
        return sourceList.stream().collect(collector);
    }
}