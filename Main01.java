package December;

import java.util.PriorityQueue;

public class Main01 {
    public static void main(String[] args) {
        Main01 tool = new Main01();
    }
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> b.compareTo(a)); // 大根堆
        double sum1 = 0.0;
        double sum2 = 0.0;
        int res = 0;
        for (int i : nums) {
            pq.offer((double)i);
            sum1 += i;
        }
        sum2 = sum1;
        while (sum1 > sum2 / 2) {
            double x = pq.poll() / 2;
            sum1 -= x;
            pq.offer(x);
            res++;
        }
        return res;
    }
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int n = bills.length;
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                five++;
            }else if (bills[i] == 10) {
                //需要找钱了
                if (five > 0) {
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else {
                //20元找零
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }else if (five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
