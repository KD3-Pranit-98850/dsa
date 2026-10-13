import java.util.Arrays;

public class TwoSumII {

    // array is already sorted so we can use two pointers
    // sum too small -> move left ahead, sum too big -> move right back
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // 1-indexed answer
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSumII obj = new TwoSumII();
        System.out.println(Arrays.toString(obj.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // [1, 2]
        System.out.println(Arrays.toString(obj.twoSum(new int[] { 2, 3, 4 }, 6)));      // [1, 3]
        System.out.println(Arrays.toString(obj.twoSum(new int[] { -1, 0 }, -1)));       // [1, 2]
    }
}
