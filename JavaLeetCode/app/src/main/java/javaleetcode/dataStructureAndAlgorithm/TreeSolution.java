package javaleetcode.dataStructureAndAlgorithm;


import java.util.*;

public class TreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * 彩灯装饰记录 I
     *  */
    public int[] decorateRecord(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> resList=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{add(root);}};
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            resList.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        int[] res=new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i]=resList.get(i);
        }
        return  res;
    }
    /**
     * 彩灯装饰记录 II
     * */
    public List<List<Integer>> decorateRecordII(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{add(root);}};
        while (!queue.isEmpty()){
            List<Integer> levelList=new ArrayList<>();
            for (int i = queue.size(); i >0 ; i--) { //这里的i=queue.size只执行一遍
                TreeNode treeNode=queue.poll();
                levelList.add(treeNode.val);
                if(treeNode.left != null) queue.add(treeNode.left);
                if(treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(levelList);
        }
        return  res;
    }
    /**
     * 彩灯装饰记录 III
     * */
    public List<List<Integer>> decorateRecordIII(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{offerLast(root);}};
        boolean reverseFlag=false;
        while (!queue.isEmpty()){
            LinkedList<Integer> levelList=new LinkedList<>();
            for (int i = queue.size(); i >0 ; i--) { //这里的i=queue.size只执行一遍
                TreeNode treeNode=queue.poll();
                if(!reverseFlag)
                    levelList.addLast(treeNode.val);
                else
                    levelList.addFirst(treeNode.val);

                if(treeNode.left != null) queue.offer(treeNode.left);
                if(treeNode.right != null) queue.offer(treeNode.right);


            }
            res.add(levelList);
            reverseFlag=!reverseFlag;
        }
        return  res;

    }

    /**
     * 子结构判断
     * */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
}

}
