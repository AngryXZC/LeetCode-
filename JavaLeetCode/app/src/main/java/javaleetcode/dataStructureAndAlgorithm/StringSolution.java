package javaleetcode.dataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringSolution {
    /**
     * 路径加密
     * */
    public String pathEncryption(String path) {
        String res= path.replace("."," ");
        return  res;
    }
    /**
     * 字符串中的单词反转
     * */
    public String reverseMessage(String message) {
        String[] strs = message.trim().split(" ");    // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {  // 倒序遍历单词列表
            if(strs[i].equals("")) continue;          // 遇到空单词则跳过
            res.append(strs[i] + " ");                // 将单词拼接至 StringBuilder
        }
        return res.toString().trim();                 // 转化为字符串，删除尾部空格，并返回
    }

    /**
     * 动态口令
     * */
    public String dynamicPassword(String password, int target) {
        String tail= password.substring(0,target);
        String mid=password.substring(target,password.length());
        return  mid+tail;
    }
    /**
     * 不使用库函数的字符串转整数(判断越界的Nice)
     * */
    public int myAtoi(String str) {
        char[] c=str.trim().toCharArray();
        if(c.length<1) return 0;
        int i=0,res=0,sign=1,maxAbs=Integer.MAX_VALUE/10;
        //起始符号位判断
        if(c[0]=='-'){
            i=1;
            sign=-1;
        }
        if(c[0]=='+'){
            i=1;
        }
        for (int j = i; j <c.length ; j++) {
            if(c[j]<'0'||c[j]>'9') break;
            if(res>maxAbs||res==maxAbs&&c[j]>'7') return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            else {
                res=res*10+(c[j]-'0');
            }
        }
        return  sign*res;
    }

    /**
     * 有效数字
     * 有限自动状态机
     * TODO 撸撸编译再来闹
     * */
    public boolean validNumber(String s) {
        Map[] states = {
                new HashMap<Character,Integer>() {{  put('d',1); put('.', 2); put('s', 3); }},  // 0
                new HashMap<Character,Integer>(){{put('d',1);put('.',2);put('e',4);}},           //1
                new HashMap<Character,Integer>(){{put('d',2);}},                                 //2
                new HashMap<Character,Integer>(){{put('d',1);put('.',2);}},                      //3
                new HashMap<Character,Integer>(){{put('s',3);put('d',1);}}                       //4
        };
        //合法状态为2
        s=s.trim();
        char[] temp=s.toCharArray();
        if(temp.length<=0) return false;
        int p=0;
        for (char item:temp) {
            char t='?';
            if(item<='9'&&item>='0'){t='d';}
            else if(item=='.') t='.';
            else if(item=='e'||item=='E') t='e';
            else if(item=='+'||item=='-') t='s';
            if(!states[p].containsKey(t)) return false;
            p=(int)states[p].get(t);
        }
        if(p==1||p==2){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str= scanner.nextLine();
        System.out.println(new StringSolution().validNumber(str));
    }
}
