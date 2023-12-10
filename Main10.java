package December;

import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) {
        Main10 tool = new Main10();
        System.out.println(tool.minSubArrayLen(10,new int[]{1,4,4}));
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
        if (min == Integer.MAX_VALUE) {
            return 0;
        }else {
            return min;
        }
    }


    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int right = n - 1;
        int left = 0;
        int index = right;
        int[] result = new int[n];
        while (left <= right) {
            int x = nums[left] * nums[left];
            int y = nums[right] * nums[right];
            if (x < y) {
                result[index--] = y;
                right--;
            }else {
                result[index--] = x;
                left++;
            }
        }
        return result;
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) return 0;
        int dest = -1,cur = 0;
        while (cur < n) {
            if (nums[cur] != val) {
                dest++;
                nums[dest] = nums[cur];
            }
            cur++;
        }
        System.out.println(Arrays.toString(nums));
        return dest + 1;
    }
}
