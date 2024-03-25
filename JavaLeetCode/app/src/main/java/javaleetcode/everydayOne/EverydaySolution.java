package javaleetcode.everydayOne;

import javaleetcode.binaryTree.TreeNode;
import javaleetcode.dataStructureAndAlgorithm.TreeSolution;

import java.util.*;

public class EverydaySolution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (stringBuilder.charAt(start) != stringBuilder.charAt(end)) {
                if (s.charAt(end) > s.charAt(start))
                    stringBuilder.setCharAt(end, s.charAt(start));
                else
                    stringBuilder.setCharAt(start, s.charAt(end));
            }
            start++;
            end--;
        }
        return stringBuilder.toString();
    }

    /**
     * 2415. 反转二叉树的奇数层
     */
    //BFS
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return null;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<TreeNode> treeNodeList=new LinkedList<>();
            int levelSum= queue.size();
            for (int i = 0; i < levelSum; i++) {
                TreeNode node = queue.poll();
                //奇数层
                if(level%2!=0){
                    treeNodeList.offerLast(node);
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            //换值
            //判断该层奇数还是偶数
            while (!treeNodeList.isEmpty()){
                TreeNode front=treeNodeList.pollFirst();
                TreeNode back=treeNodeList.pollLast();
                if(front!=null&&back!=null){
                    int temp= front.val;;
                    front.val= back.val;;
                    back.val= temp;;
                }
            }
            level++;
        }
        return root;
    }
    //DFS
    public TreeNode reverseOddLevelsI(TreeNode root) {
        boolean isOdd=false;
        dfs(root.left,root.right,!isOdd);
        return root;
    }
    public void dfs(TreeNode left,TreeNode right,boolean isOdd){
        if(left==null)
            return;
        if(isOdd)
        {
            int temp = left.val;
            left.val= right.val;
            right.val=temp;
        }
        dfs(left.left,right.right,!isOdd);
        dfs(left.right,right.left,!isOdd);
    }
    /**
     * 下一个更大的数值平衡数
     * */
    public int nextBeautifulNumber(int n) {
        int res=0;
        while (true){
            if(isBeautifulNumber(++n)){
                res=n;
                break;
            }
        }
        return res;
    }
    boolean isBeautifulNumber(int number){
        int[] count=new int[10];
        while (number>0){
            count[number%10]++;
            number/=10;
        }
        for (int i = 0; i <10 ; i++) {
            if(count[i]!=0&&count[i]!=i)
                return false;
        }
        return true;

    }
    /**
     * 162. 寻找峰值
     * */
    public int findPeakElement(int[] nums) {
        int maxIndex=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[maxIndex])
                maxIndex=i;
        }
        return maxIndex;
    }
    /**
     *
     * 1901. 寻找峰值 II
     *
     * */
    public int[] findPeakGrid(int[][] mat) {

        int row = mat.length, col = mat[0].length;
        int low = 0, high = row - 1;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = -1, maxElement = -1;
            for (int k = 0; k < col; k++) {
                if (mat[i][k] > maxElement) {
                    j = k;
                    maxElement = mat[i][k];
                }
            }
            if (i - 1 >= 0 && mat[i][j] < mat[i - 1][j]) {
                high = i - 1;
                continue;
            }
            if (i + 1 < row && mat[i][j] < mat[i + 1][j]) {
                low = i + 1;
                continue;
            }
            return new int[]{i, j};
        }
        return new int[0]; // impossible
    }


    /**
    * 2828. 判别首字母缩略词*/
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length())
            return false;  //长度不一致
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).charAt(0)!=s.charAt(i))
                return false;
        }
        return true;
    }
    /**
     * 1671. 得到山形数组的最少删除次数
     * 我们定义 arr 是 山形数组 当且仅当它满足：
     *
     * arr.length >= 3
     * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
     * */
public int minimumMountainRemovals(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                left[i] = Math.max(left[i], left[j] + 1);
        }
    }
    for (int i = n - 2; i >= 0; i--) {
        for (int j = n - 1; j > i; j--) {
            if (nums[i] > nums[j])
                right[i] = Math.max(right[i], right[j] + 1);
        }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
        if (left[i] > 1 && right[i] > 1)
            res = Math.max(res, left[i] + right[i] - 1);
    }
    return n - res;
}
/**
 2866. 美丽塔 II
 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。

 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。

 如果以下条件满足，我们称这些塔是 美丽 的：

 1 <= heights[i] <= maxHeights[i]
 heights 是一个 山脉 数组。
 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：

 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 * */
public long maximumSumOfHeights(List<Integer> maxHeights) {
int n = maxHeights.size();
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (maxHeights.get(i) > maxHeights.get(j))
                left[i] = Math.max(left[i], left[j] + 1);
        }
    }
    for (int i = n - 2; i >= 0; i--) {
        for (int j = n - 1; j > i; j--) {
            if (maxHeights.get(i) > maxHeights.get(j))
                right[i] = Math.max(right[i], right[j] + 1);
        }
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
        if (left[i] > 1 && right[i] > 1)
            res = Math.max(res, left[i] + right[i] - 1);
    }
    return res;
}

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 * */
public int change(int amount, int[] coins) {
int n = coins.length;
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
        for (int j = coins[i]; j <= amount; j++) {
            dp[j] += dp[j - coins[i]];
        }
    }
    return dp[amount];
}


    public static void main(String[] a) {
        new EverydaySolution().isAcronym(Arrays.asList("apple", "banana", "cat"), "abc");
//        TreeNode root=new TreeNode(2);
//        root.left=new TreeNode(3);
//        root.right=new TreeNode(5);
//        root.left.left=new TreeNode(8);
//        root.left.right=new TreeNode(13);
//        root.right.left=new TreeNode(21);
//        root.right.right=new TreeNode(34);
//        new EverydaySolution().reverseOddLevels(root);
        //定义一个三行两列的整型二维数组intArray

    }

}
