// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.List;

public class seminar_3_hw {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(8);
        numbers.add(2);
        numbers.add(5);

        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("List after removing even numbers: " + numbers);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        float sum = 0;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            sum += number;
        }
        float average = sum / numbers.size();

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Average value: " + average);
    }
}