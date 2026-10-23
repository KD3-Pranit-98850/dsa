import java.util.HashMap;

public class Ques_2 {
	  public static void main(String[] args) {
	        int[] arr = {1, 2, 2, 3, 3, 3, 4};

	        HashMap<Integer, Integer> map = new HashMap<>();

	        int mode = arr[0];
	        int maxCount = 0;

	        for (int num : arr) {
	            int count = map.getOrDefault(num, 0) + 1;
	            map.put(num, count);

	            if (count > maxCount) {
	                maxCount = count;
	                mode = num;
	            }
	        }

	        System.out.println("Mode: " + mode);
	        System.out.println("Frequency: " + maxCount);
	    }

}
