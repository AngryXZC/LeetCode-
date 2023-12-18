package javaleetcode.dataStructureAndAlgorithm;

import javaleetcode.binaryTree.Node;
import javaleetcode.binaryTree.TreeNode;

import java.util.*;

public class TreeSolution {

    /**
     * 彩灯装饰记录 I
     */
    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /**
     * 彩灯装饰记录 II
     */
    public List<List<Integer>> decorateRecordII(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) { //这里的i=queue.size只执行一遍
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(levelList);
        }
        return res;
    }

    /**
     * 彩灯装饰记录 III
     */
    public List<List<Integer>> decorateRecordIII(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            offerLast(root);
        }};
        boolean reverseFlag = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) { //这里的i=queue.size只执行一遍
                TreeNode treeNode = queue.poll();
                if (!reverseFlag)
                    levelList.addLast(treeNode.val);
                else
                    levelList.addFirst(treeNode.val);

                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);


            }
            res.add(levelList);
            reverseFlag = !reverseFlag;
        }
        return res;

    }

    /**
     * 子结构判断
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
/**
 翻转二叉树
 */
    /**
     * java、前序遍历
     * 时间O(N)：树的便利
     * 空间O(N): 最差情况下，退化为链表，栈的深度为树的结点数
     * 思路：对树进行递归前序遍历，并附带交换左右子树操作。(特别地,不存在子树也按交换位置)
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        else {
            swap(root);
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }

    public void swap(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    /**
     * 极度简便版
     */
    public TreeNode mirrorTreeI(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTreeI(root.right);
        root.right = mirrorTreeI(tmp);
        return root;
    }

    /**
     * 判断对称二叉树
     */
    public boolean checkSymmetricTree(TreeNode root) {
        return root == null || recurI(root.left, root.right);
    }

    public boolean recurI(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recurI(left.left, right.right) && recurI(left.right, right.left);
    }

    /**
     * 将二叉搜索树转化为排序的双向链表
     */
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        List<Node>nodeList=new ArrayList<>();
        inOrder(root,nodeList);
       //单独指定头结点和尾节点的前去和后继
        if(nodeList.size()>=2){
            nodeList.get(0).right=nodeList.get(1);
            nodeList.get(0).left=nodeList.get(nodeList.size()-1);
            nodeList.get(nodeList.size()-1).right= nodeList.get(0);
            nodeList.get(nodeList.size()-1).left= nodeList.get(nodeList.size()-2);
            for (int i = 1; i < nodeList.size()-1; i++) {
                nodeList.get(i).right=nodeList.get(i+1);
                nodeList.get(i).left=nodeList.get(i-1);
            }
            root=nodeList.get(0);
        }
        else {
            root.left=root;
            root.right=root;
        }
       return root;
    }

    //中序遍历
    public void inOrder(Node root,List<Node> list) {
        if (root == null)
            return;
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);

    }
    /**
     * 寻找二叉搜索树中的目标节点
     * */
    public int findTargetNode(TreeNode root, int cnt) {
        if(root==null)
            return -1;
        List<TreeNode>nodeList=new ArrayList<>();
        inOrderII(root,nodeList);
        return nodeList.get(nodeList.size()-cnt).val;
    }
    public void inOrderII(TreeNode root,List<TreeNode> list) {
        if (root == null)
            return;
        inOrderII(root.left,list);
        list.add(root);
        inOrderII(root.right,list);

    }
    /**
     * 二叉树的最大深度
     * */
    public int calculateDepth(TreeNode root) {
        if(root==null)
            return 0;
        int sum=0;
        List<TreeNode> levelList=new ArrayList<TreeNode>(){{add(root);}};
        while (!levelList.isEmpty()) {
            List<TreeNode> temp=new ArrayList<>();
            for (TreeNode node:levelList) {
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            levelList=temp;
            sum++;
        }
        return sum;
    }


    /**
     * 判断是否为平衡二叉树
     * */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    /**
     * 求二叉搜索树的最近公共祖先
     * */
    //迭代
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
    }
    //递归
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    /**
     * 寻找二叉树的最近公共祖先
     * */
    public TreeNode lowestCommonAncestorIII(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    /**
     * 序列化与反序列化二叉树
     * */
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args){
        Node root=new Node(4);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
        TreeSolution solution=new TreeSolution();
        solution.treeToDoublyList(root);
    }
}
