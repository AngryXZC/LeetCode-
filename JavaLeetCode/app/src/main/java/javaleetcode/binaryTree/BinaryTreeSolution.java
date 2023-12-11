package javaleetcode.binaryTree;

import javax.print.attribute.standard.NumberUp;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeSolution {

/**
 * 先序遍历
 * */
    /**
     * 递归
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preOrderRecursion(root,res);
        return  res;
    }
    public void preOrderRecursion(TreeNode node,List<Integer> res)
    {
        if(node!=null)
        {
            res.add(node.val);
            preOrderRecursion(node.left,res);
            preOrderRecursion(node.right,res);
        }
    }

    //非递归
    /**
     * 一路向左式
     * */
    public List<Integer> preorderTraversalI(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> nodeStack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode!=null||!nodeStack.isEmpty()){
            if(treeNode!=null){
                res.add(treeNode.val);
                nodeStack.push(treeNode);
                treeNode=treeNode.left;
            }
            else {
                treeNode=nodeStack.pop();
                treeNode=treeNode.right;
            }
        }
        return  res;
    }

    /**
     * 边走边看式
     * */
    public List<Integer> preorderTraversalIII(TreeNode tree) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(tree==null) return new ArrayList<>();
        stack.push(tree);
        while (!stack.isEmpty()){
            TreeNode treeNode= stack.pop();
            //访问元素
            res.add(treeNode.val);
            if(treeNode.right!=null) stack.push(treeNode.right);
            if(treeNode.left!=null) stack.push(treeNode.left);
        }
        return res;
    }

/**
 * 中序遍历
 * */

public List<Integer> inorderTraversal(TreeNode root) {
List<Integer> res=new ArrayList<>();
inOrderRecursion(root,res);
return  res;
}
/**
 * 递归实现
 * */
public void  inOrderRecursion(TreeNode root,List<Integer> res){
        if(root!=null){
            inOrderRecursion(root.left,res);
            //访问根节点
            res.add(root.val);
            inOrderRecursion(root.right,res);
        }
}
/**
 * 非递归实现
 * */
/**
 * 一路向左式
 * */
public List<Integer> inOrderTraversalI(TreeNode root){

    if(root==null) return new ArrayList<>();
    //返回变量
    List<Integer> res=new ArrayList<>();
    //遍历逻辑
    Stack<TreeNode> stack=new Stack<>();
    TreeNode node=root;
    while (node!=null||!stack.isEmpty()){
        if(node!=null) {
            stack.push(node);
            node=node.left;
        }
        else {
            node= stack.pop();
            //访问
            res.add(node.val);
            node=node.right;
        }
    }
    return res;
}
/**
 * 另一种一路向左式
 * */

public List<Integer> inOrderTraversalII(TreeNode root){

    if(root==null) return new ArrayList<>();
    //返回变量
    List<Integer> res=new ArrayList<>();
    //遍历逻辑
    Stack<TreeNode> stack=new Stack<>();
    TreeNode node=root;
    while (node!=null||!stack.isEmpty()){
        while (node!=null){
            stack.push(node);
            node=node.left;
        }
        if(!stack.empty()){
            node=stack.pop();
            //访问
            res.add(node.val);
            node=node.right;
        }
    }
    return res;
}

/**
 * 后序遍历
 * */
/**
 * 递归式
 * */
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res=new ArrayList<>();
    postOrderRecursion(root,res);
    return res;
}
public void postOrderRecursion(TreeNode root,List<Integer> res){
    if(root!=null){
        postOrderRecursion(root.left,res);
        postOrderRecursion(root.right,res);
        //访问根节点
        res.add(root.val);
    }
}
/**
 * 非递归
 * */
/**
 * 一路向左式
 * 先序遍历为根-左-右
 * 后序遍历为左-右-根
 * 那么只需要一个逆序的根-右-左就可以得到逆序的迭代实现了
 */
public List<Integer> postorderTraversalI(TreeNode root){
    LinkedList<Integer> res=new LinkedList<>();
    TreeNode node=root;
    Stack<TreeNode> stack=new Stack<>();
    while (node!=null||!stack.empty()){
        if(node!=null){
            res.addFirst(node.val);
            stack.push(node);
            node=node.right;
        }
        else {
            node=stack.pop();
            node=node.left;
        }

    }
    return res;
}
/**
 * 二叉树最大深度
 * */
public int maxDepth(TreeNode root) {
    if(root==null)
        return 0;
    int left_depth=maxDepth(root.left);
    int right_depth=maxDepth(root.right);
    return Math.max(left_depth,right_depth) +1;
}
/**
 * 对称二叉树
 * */
//递归
public boolean isSymmetric(TreeNode root) {
    if(root==null)
        return true;
    return isLeftAndRightSame(root.left,root.right);
}
public  boolean isLeftAndRightSame(TreeNode leftTree,TreeNode rightTree){
    if(leftTree==null&&rightTree==null)
        return true;
    if(leftTree==null||rightTree==null||leftTree.val!= rightTree.val)
        return false;
    return isLeftAndRightSame(leftTree.left,rightTree.right)&&isLeftAndRightSame(leftTree.right,rightTree.left);
}
//非递归
// 栈式不好解决使用层式遍历
public boolean isSymmetricI(TreeNode root) {
    if(root==null)
        return true;
   Queue<TreeNode> queue=new LinkedList<>();
  queue.offer(root.left);
  queue.offer(root.right);
  while (!queue.isEmpty()){
      TreeNode left=queue.poll(),right=queue.poll();
      if(left==null&&right==null)
          continue;
      if(left==null||right==null)
          return false;
      if(left.val!=right.val)
          return false;
      queue.add(left.left);
      queue.add(right.right);
      queue.add(left.right);
      queue.add(right.left);
  }
  return true;
}

/**
 * 路径总和
 * */

public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root==null)
        return false;
    if(root.left==null&&root.right==null)
        return targetSum==root.val;
    return hasPathSum(root.left,targetSum- root.val)||hasPathSum(root.right,targetSum- root.val);
}
public static void main(String[] args){
        BinaryTreeSolution solution=new BinaryTreeSolution();
        TreeNode root=new TreeNode(){{val=1;}};
        root.right=new TreeNode(){{val=2;}};
        root.right.left=new TreeNode(){{val=3;}};
        solution.preorderTraversalI(root);
    }
}
