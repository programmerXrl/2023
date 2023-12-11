package December;

public class Main11 {
    public static void main(String[] args) {
        Main11 tool = new Main11();
        System.out.println(tool.minSubArrayLen(4, new int[]{1,4,4}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int left = 0,right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                int len = right - left + 1;
                min = Math.min(min,len);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
