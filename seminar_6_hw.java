// Разработать программу, имитирующую поведение коллекции HashSet. 
// В программе содать метод add добавляющий элемент, метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
// *Реализовать все методы из семинара.
// Формат данных Integer.
import java.util.*;

public class seminar_6_hw<T> {

    private Map<T, Object> map;
    private static final Object PRESENT = new Object();
    
    public void MyHashSet() {
        map = new HashMap<>();
    }
    
    public boolean add(T element) {
        return map.put(element, PRESENT) == null;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T element : map.keySet()) {
            sb.append(element).append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public T get(int index) {
        if (index < 0 || index >= map.size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (T element : map.keySet()) {
            if (i == index) {
                return element;
            }
            i++;
        }
        // Unreachable statement because the index range is already checked
        return null;
    }
    
    public static void main(String[] args) {
        seminar_6_hw<Integer> set = new seminar_6_hw<>();
        set.add(3);
        set.add(5);
        set.add(7);
        System.out.println(set); // [3, 5, 7]
        System.out.println(set.get(1)); // 5
    }
}
