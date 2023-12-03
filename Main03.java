package December;

import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Main03 tool = new Main03();
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        int[] arr1 = {1,2,3};
        //System.out.println(tool.longestConsecutive(arr));
        System.out.println(tool.longestConsecutive(arr));
    }

    public int longestConsecutive(int[] nums) {
        // 有序数组 可以利用有序性 快慢指针 进行去重操作
        int max = 0;
        Arrays.sort(nums);
        List<Integer> list = helper(nums);
        System.out.println(list);
        int n = list.size();
        for (int i = 0; i < n;) {
            int next = i + 1;
            while (next < n && list.get(next) == list.get(next - 1) + 1) {
                next++;
            }
            max = Math.max(max,next - i);
            i = next;    //连续中
        }
        return max;
    }

    public List<Integer> helper(int[] arr) {
        // 1 2 2 3;
        //实现对有序数组的原地去重。
        int n = arr.length;
        int left = 0,right = 1;
        List<Integer> list = new ArrayList<>();
        while (right < n){
            if (arr[right] != arr[left]) {
                arr[++left] = arr[right];
            }
            right++;
        }
        for (int i = 0; i <= left; i++) {
            list.add(arr[i]);
        }
        return list;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (map.containsKey(target - val)) {
                return new int[]{map.get(target-val),i};
            }
            map.put(val,i);
        }
        return null;
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int n = s.length();
        for (int left = 0,right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                //todo
                if (left <= map.get(ch)) {
                    left = map.get(ch) + 1;
                }
            }
            map.put(ch,right);
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}
