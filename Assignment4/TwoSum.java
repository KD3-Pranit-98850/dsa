import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // store each number with its index, and for every new number
    // check if (target - number) is already seen
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                return new int[] { seen.get(need), i };
            }
            seen.put(nums[i], i);
        }
        return new int[] {}; // problem guarantees an answer, so we never reach here
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        System.out.println(Arrays.toString(obj.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // [0, 1]
        System.out.println(Arrays.toString(obj.twoSum(new int[] { 3, 2, 4 }, 6)));      // [1, 2]
        System.out.println(Arrays.toString(obj.twoSum(new int[] { 3, 3 }, 6)));         // [0, 1]
    }
}
