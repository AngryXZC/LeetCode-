package javaleetcode.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySolution {
    /**
     * 寻找数组的中心索引
     * */
    public int pivotIndex(int[] nums) {
        int rightTotalSum=0,leftSum=0;
        for (int num:nums) {
            rightTotalSum+=num;
        }
        for (int i = 0; i <nums.length ; i++) {
            rightTotalSum-=nums[i];
            if(leftSum==rightTotalSum)
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }
    /**
     * 搜索插入位置
     * */

    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                return  mid;
            else if (nums[mid]<target) {
                left=mid+1;
            }else {
                right =mid-1;
            }
        }
        return left;
    }
    /**
     * 合并区间
     * */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 按照区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // 检查当前区间和下一个区间是否有重叠
            if (currentInterval[1] >= nextInterval[0]) {
                // 有重叠，更新当前区间的结束位置
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // 没有重叠，将当前区间加入结果，并更新当前区间为下一个区间
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // 添加最后一个区间
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }


    /**
     * 旋转矩阵
     * */
    public static void rotate(int[][] matrix) {
        // 先进行矩阵转置
        transpose(matrix);
        // 再进行逆序操作
        reverseRows(matrix);
    }

    // 矩阵转置
    private static void transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 交换matrix[i][j]和matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 逆序每一行
    private static void reverseRows(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                // 交换matrix[i][left]和matrix[i][right]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    /**
     * 零矩阵
     * */

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 记录第一行和第一列是否需要置零
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 检查第一行是否有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 检查第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 使用第一行和第一列记录其他行列是否需要置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据第一行和第一列的记录，将其他行列置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行和第一列
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    /**
     * 对角线遍历
     * */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];

            // 根据当前遍历的方向，更新行和列的值
            if ((row + col) % 2 == 0) {  // 方向向上
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {  // 方向向下
                if (row == m - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }



    /**
     *
     * 最长公共前缀
     * */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        // 依次遍历字符串数组，更新最长公共前缀
        int length = strs.length;
        String prefix = strs[0];
        for(int i = 1; i < length; i++){
            prefix = calPrefix(prefix, strs[i]);
            if(prefix.length() == 0){
                return prefix;
            }
        }
        return prefix;
    }

    public String calPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        for(int i = 0; i < length; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                break;
            }
            index++;
        }
        return str1.substring(0, index);
    }


    /**
     * 翻转字符串里的单词
     * */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 将字符串按照空格分割成单词数组
        String[] words = s.split(" ");
        StringBuilder reversed = new StringBuilder();

        // 从最后一个单词开始遍历，逐个拼接到结果中
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                // 忽略空字符串
                reversed.append(words[i]).append(" ");
            }
        }

        // 删除最后多余的空格
        if (reversed.length() > 0) {
            reversed.deleteCharAt(reversed.length() - 1);
        }

        return reversed.toString();
    }


    /**
     * 实现 strStr()
     * */
    public  int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // 空字符串是任何字符串的子串，返回0
        }

        int hayLen = haystack.length();
        int needleLen = needle.length();

        // 如果 needle 的长度大于 haystack，不可能是子串，返回 -1
        if (needleLen > hayLen) {
            return -1;
        }

        // 遍历 haystack，尝试匹配 needle
        for (int i = 0; i <= hayLen - needleLen; i++) {
            int j;
            for (j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // 不匹配，跳出内层循环
                }
            }
            if (j == needleLen) {
                return i; // 匹配成功，返回子串的起始位置
            }
        }

        return -1; // 未找到子串，返回 -1
    }

    public static void main(String[] args){


    }

}
