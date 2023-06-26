// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.
import java.util.*;


public class seminar_5_hw {

    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of entries:");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter data for entry #" + i + " (name and phone separated by space):");
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            String phone = tokens[1];
            Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
            phones.add(phone);
            phoneBook.put(name, phones);
        }
        
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort(Map.Entry.<String, Set<String>>comparingByValue().reversed());
        
        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " phones");
        }
    }
}