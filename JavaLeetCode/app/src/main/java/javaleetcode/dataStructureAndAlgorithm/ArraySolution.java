package javaleetcode.dataStructureAndAlgorithm;

import java.util.*;

public class ArraySolution {
    /**
     * 训练计划 I
     * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
     *
     * */
    public int[] trainingPlan(int[] actions) {
        int i=0,j=actions.length-1,temp;
        //这里不一定要相等
        while (i<j){
            if(actions[i]%2==1){
                i++;
            }
            else {
                temp=actions[i];
                actions[i]=actions[j];
                actions[j]=temp;
            }
            if(actions[j]%2==0){
                j--;
            }

        }
        return  actions;
    }

    /**
     * 文件组合
     * */
    //Method 1 等抽
    public static int[][] fileCombination(int target) {
        List<int[]> resList=new ArrayList<>();
        for (int i = 1; i <=target ; i++) {
            for (int j = 2; j <target-2 ; ) {
                if((2*i+(j-1))*j==2*target){
                    int[] tem=new int[j];
                    for (int k = i; k < i+j; k++) {
                        tem[k-i]=k;
                    }
                    resList.add(tem);
                    break;
                }
                if((2*i+(j-1))*j<2*target){
                    j++;
                }
                if((2*i+(j-1))*j>2*target){
                    break;
                }
            }
        }

        return resList.toArray(new int[0][]);
    }
    //Method 2 滑动窗口
    public static int[][] fileCombination2(int target){
        int sum=0;
        List<int[]> resList=new ArrayList<>();
        for (int i = 1; i <target ; i++) {
            sum=i;
            for (int j = i+1; j < target; ) {
                sum+=j;
                if(sum>target){
                    sum-=i;
                    break;
                }
                if(sum<target){
                    j++;
                }
                if(sum==target){
                    int[] tem=new int[j-i+1];
                    for (int k = i; k <=j ; k++) {
                        tem[k-i]=k;
                    }
                    resList.add(tem);
                }
            }
        }
        return resList.toArray(new int[0][]);
    }

    /**
     * 按规则计算统计结果
     * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
     *
     *  
     *
     * */
    public int[] statisticalResult(int[] arrayA) {
        if (arrayA.length<=0)
            return new int[0];
        int[] arrayB=new int[arrayA.length];
        int len=arrayA.length,temp=1;
        arrayB[0]=1;
        for (int i = 1; i < len; i++) {
            arrayB[i]=arrayB[i-1]*arrayA[i-1];
        }
        for (int i = len-2; i >=0 ; i--) {
            temp*=arrayA[i+1];
            arrayB[i]*=temp;
        }
        return arrayB;
    }

    /**
     * 寻找文件副本
     * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
     *
     *  
     * */
    public int findRepeatDocument(int[] documents) {
        if (documents.length<=0)
            return 0;
        HashSet set=new HashSet<>();
        for (int key:documents) {
            if(set.contains(key))
                return key;
            else
                set.add(key);
        }
        return 0;
    }
    /**
     * 螺旋遍历二维数组
     * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
     *
     * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
     *
     *  

     * */
    public int[] spiralArray(int[][] array) {
        if(array.length==0) return new int[0];
        int l=0,r=array[0].length-1,t=0,b=array.length-1,x=0;
        int res[]=new int[(r+1)*(b+1)];
        while (true){
            for (int i=l;i<=r;i++) res[x++]=array[t][i];      //left to right
            if(++t>b) break;
            for (int i = t; i <=b ; i++) res[x++]=array[i][r]; //top to bottom
                if(l>--r) break;
            for(int i=r;i>=l;i--)  res[x++]=array[b][i];       //right to left
                if(t>--b) break;
            for(int i=b;i>=t;i--)  res[x++]=array[i][l];       //bottom to top
                if(++l>r) break;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
