package December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main06 {
    public static void main(String[] args) {
        Main06 tool = new Main06();
        int[] arr = {-1,0,1,2,-1,-4};
        // -4 -1 -1 0 1 2
        System.out.println(tool.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return list;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int cur = nums[i];
            int L = i + 1;
            int R = n - 1;
            while(L < R) {
                if (cur + nums[L] + nums[R] == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(cur);
                    result.add(nums[L]);
                    result.add(nums[R]);
                    list.add(result);
                    // 去重
                    while (L < R && nums[L + 1] == nums[L]) L++;
                    while (L < R && nums[R - 1] == nums[R]) R--;
                    L++;
                    R--;
                }else if (cur + nums[L] + nums[R] < 0) {
                    L++;
                }else {
                    R--;
                }
            }
        }
        return list;
    }

    // 盛水最多的容器，双指针，利用特性加速判断。
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0,right = n - 1,max = 0;
        while (left < right) {
            int v = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(max,v);
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    // 移动零，把一个数组中的零全部移到非零的右侧。
    public void moveZeroes(int[] nums) {
        int pre = -1,cur = 0;
        int n = nums.length;
        while (cur < n) {
            if (nums[cur] != 0) {
                pre++;
                swap(nums,pre,cur);
            }
            cur++;
        }
    }

    public void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
