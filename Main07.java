package December;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main07 {
    public static void main(String[] args) {
        Main07 tool = new Main07();
        String s = "abab";
        String p = "ab";
        System.out.println(tool.findAnagrams(s, p));
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
