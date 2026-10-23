import java.util.*;
public class Ques_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a line:");
        String line = sc.nextLine().toLowerCase();

        String[] words = line.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            word = word.replaceAll("[^a-z0-9']", "");

            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(
                entry.getKey() + " : " + entry.getValue()
            );
        }

        sc.close();
    }

}
