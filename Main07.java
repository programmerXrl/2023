package December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main07 {
    public static void main(String[] args) {
        Main07 tool = new Main07();
        int[] nums = {1,2,3,4};
        tool.productExceptSelf(nums);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null) return ret;
        int m = matrix.length;
        int n = matrix[0].length;
        int u = 0;
        int l = 0;
        int r = n - 1; // 对应列
        int d = m - 1; // 对应行
        while(true) {
            //向右遍历
            for (int i = l; i <= r; i++) {
                ret.add(matrix[u][i]);
            }
            if (++u > d) break;

            //向下遍历
            for (int i = u; i <= d; i++) {
                ret.add(matrix[i][r]);
            }
            if (--r < l) break;

            //向左遍历
            for (int i = r; i >= l; i--){
                ret.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) {
                ret.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ret;
    }


    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] f = new boolean[m];
        boolean[] g = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    f[i] = true;
                    g[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (f[i] || g[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];// 前缀积
        int[] g = new int[n];// 后缀积
        int[] result = new int[n];
        f[0] = 1;
        g[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            g[i] = g[i + 1] * nums[i + 1];
        }
        result[0] = g[0];
        result[n - 1] = f[n - 1];
        for (int i = 1; i < n - 1; i++) {
            result[i] = f[i] * g[i];
        }
        return result;
    }


    // 1 2 3 4 5 6 7
    // 5 6 7 1 2 3 4
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = i + k;
            while (pos >= n) pos -= n;
            result[pos] = nums[i];
        }
        nums = Arrays.copyOf(result,result.length);
        System.out.println(Arrays.toString(nums));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum = Math.max(i,sum + i); // 判断是之前的和大还是当前值大
            max = Math.max(max,sum);
        }
        return max;
    }


    //和为k的子数组
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int pre = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return count;
    }


    // 字符串中所有字母的异位词
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int size = p.length();
        int n = s.length();
        char[] chars = new char[26];
        for (int i = 0; i < size; i++) {
            char ch = p.charAt(i);
            chars[ch - 'a']++;
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + size - 1 < n) {
                strings.add(s.substring(i,i + size));
            }
        }
        //对分隔好的字符串进行便利
        int x = 0;
        for (String str : strings) {
            char[] chars2 = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars2[str.charAt(i) - 'a']++;
            }
            int j = 0;
            while (j < 26) {
                if (chars[j] != chars2[j]) break;
                j++;
            }
            if (j == 26) {
                ret.add(x);
            }
            x++;
        }
        return ret;
    }

    //字符串中无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int left = 0,right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                if (left <= map.get(ch) + 1) {
                    left = map.get(ch) + 1;
                }
            }
            map.put(ch,right);
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}
