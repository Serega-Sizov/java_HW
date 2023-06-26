// Организовать вводи и хранение данных пользователей. ФИО возраст и пол
// вывод в формате Фамилия И.О. возраст пол
// добавить возможность выхода или вывода списка отсортированного по возрасту!)
// *реализовать сортировку по возрасту с использованием индексов
// *реализовать сортировку по возрасту и полу с использованием индексов
import java.util.*;

public class seminar_4_hw {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<User> users = new ArrayList<>();
            
            boolean exit = false;
            while (!exit) {
                System.out.println("Enter 1 to add user");
                System.out.println("Enter 2 to print sorted list by age");
                System.out.println("Enter 3 to print sorted list by age and gender");
                System.out.println("Enter 4 to exit");
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Enter name, age and gender (M/F) in one line separated by spaces:");
                        users.add(new User(scanner.next(), scanner.nextInt(), scanner.next().toUpperCase()));
                        break;
                    case 2:
                        Collections.sort(users, new AgeComparator());
                        printUsers(users);
                        break;
                    case 3:
                        Collections.sort(users, new AgeGenderComparator());
                        printUsers(users);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
    }
    
    private static void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user.format());
        }
    }
    
    private static class User {
        private String name;
        private int age;
        private char gender;
        
        public User(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender.charAt(0);
        }
        
        public String format() {
            String[] nameParts = name.split(" ");
            String formattedName = nameParts[0];
            for (int i = 1; i < nameParts.length; i++) {
                formattedName += " " + nameParts[i].charAt(0) + ".";
            }
            return formattedName + " " + age + " " + gender;
        }
        
        public int getAge() {
            return age;
        }
        
        public char getGender() {
            return gender;
        }
    }
    
    private static class AgeComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return Integer.compare(user1.getAge(), user2.getAge());
        }
    }
    
    private static class AgeGenderComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            int ageCompare = Integer.compare(user1.getAge(), user2.getAge());
            if (ageCompare == 0) {
                return Character.compare(user1.getGender(), user2.getGender());
            }
            return ageCompare;
        }
    }
}