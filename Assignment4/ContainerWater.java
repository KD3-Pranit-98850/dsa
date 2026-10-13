public class ContainerWater {

    // start with the widest container, then always move the shorter wall
    // because moving the taller one can never give a bigger area
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int best = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            best = Math.max(best, width * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        ContainerWater obj = new ContainerWater();
        System.out.println(obj.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
        System.out.println(obj.maxArea(new int[] { 1, 1 }));                      // 1
    }
}
