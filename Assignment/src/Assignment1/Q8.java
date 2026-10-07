package Assignment1;
import java.util.LinkedHashMap;
import java.util.Map;
public class Q8{
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8};

        Map<Integer, Integer> count = new LinkedHashMap<>();

        for (int n : arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating element: " + entry.getKey());
                break;
            }
        }
    }
}
