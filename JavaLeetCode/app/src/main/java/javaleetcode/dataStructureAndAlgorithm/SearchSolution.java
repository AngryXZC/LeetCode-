package javaleetcode.dataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xzc
 * @date 2024/3/15 17 57:37
 * @description 查找
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
        int left = 0, right = scores.length - 1;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] == target) {
                count++;
                int temp = mid;
                while (temp > 0 && scores[temp - 1] == target) {
                    count++;
                    temp--;
                }
                temp = mid;
                while (temp < scores.length - 1 && scores[temp + 1] == target) {
                    count++;
                    temp++;
                }
                return count;
            } else if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
