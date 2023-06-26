// Первый семинар.
// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

// Пункты реализовать в методе main
// *Пункты реализовать в разных методах

// int i = new Random().nextInt(k); //это кидалка случайных чисел!)

import java.util.Arrays;
import java.util.Random;

public class seminar_1_hw {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(2001);
        System.out.println("i = " + i);
        
        int n = 0;
        for (int j = 31; j >= 0; j--) {
            if ((i & (1 << j)) != 0) {
                n = j + 1;
                break;
            }
        }
        System.out.println("n = " + n);
        
        int[] m1 = new int[(Short.MAX_VALUE - i) / n + 1];
        int count1 = 0;
        for (int j = i; j <= Short.MAX_VALUE - n; j += n) {
            m1[count1] = j;
            count1++;
        }
        System.out.println("m1 = " + Arrays.toString(m1));
        
        int[] m2 = new int[(i - Short.MIN_VALUE) / n + 1];
        int count2 = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                m2[count2] = j;
                count2++;
            }
        }
        System.out.println("m2 = " + Arrays.toString(m2));
    }
}
