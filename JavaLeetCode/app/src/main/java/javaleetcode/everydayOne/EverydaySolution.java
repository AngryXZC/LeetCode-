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
    public static void main(String[] a) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(8);
        root.left.right=new TreeNode(13);
        root.right.left=new TreeNode(21);
        root.right.right=new TreeNode(34);
        new EverydaySolution().reverseOddLevels(root);
    }
}
