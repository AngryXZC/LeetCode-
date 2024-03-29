package javaleetcode.dataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xzc
 * @date 2024/3/15 17 57:37
 * @description 查找
 * TODO
 * 建议反复咀嚼
 */
public class SearchSolution {
    /**
     * 某套连招动作记作仅由小写字母组成的序列 arr，
     * 其中 arr[i] 第 i 个招式的名字。
     * 请返回第一个只出现一次的招式名称，如不存在请返回空格。
     */
    public char dismantlingAction(String arr) {
        HashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] ac = arr.toCharArray();
        for (char c : ac) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d : map.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }

    /**
     * 统计目标成绩的出现次数
     * 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。
     */
    public int countTarget(int[] scores, int target) {
        // 搜索右边界 right
        int i = 0, j = scores.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(scores[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && scores[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = scores.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(scores[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
    /**
     * 点名
     * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
     *
     * */
    public int takeAttendance(int[] nums) {
        int left = 0, right = nums.length - 1;
        //区间为：左闭右闭

        while(left <= right) {
            int m = left + (right - left) / 2;

            if(nums[m] == m)
                left = m + 1;
            else
                right = m - 1;
        }
        return left;
    }
}
