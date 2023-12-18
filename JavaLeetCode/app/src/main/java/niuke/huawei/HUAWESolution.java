package niuke.huawei;

import java.util.*;

public class HUAWESolution {
    /**
     * HJ1 字符串最后一个单词的长度*/
    public  static   void lastWordLength(){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] res= s.split(" ");
        System.out.println(res[res.length-1].length());
//        int index=-1;
//        for (int i=s.length()-1;i>=0;i--){
//            if(s.charAt(i)==' '){
//                index=i;
//                break;
//            }
//        }
//        System.out.println(s.length()-index-1);
    }
    /**
     * HJ2 计算某字符出现次数
     * */
    static void lenOfLetter(){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        s=s.toUpperCase();
        int res=0;
        char  c=scanner.next().charAt(0);
        String te=String.valueOf(c).toUpperCase();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==te.charAt(0)){
                res++;
            }
        }
      System.out.println(res);
    }
    /**
     * HJ3 明明的随机数
     * */
    public static void mingmingRandNumber(){
        Scanner scanner=new Scanner(System.in);
        int sum=scanner.nextInt();
        List<Integer> inputList=new ArrayList<>();
        for (int i=0;i<sum;i++){
            int tem=scanner.nextInt();
            if(!inputList.contains(tem)){
                inputList.add(tem);
            }
        }
        int [] res=new int[inputList.size()];
        for (int i=0;i<inputList.size();i++){
            res[i]=inputList.get(i);
        }
        Arrays.sort(res);
        for (int tem:
             res) {
            System.out.println(tem);
        }
    }

    /**
     * HJ4 字符串分隔
     * */
    public  static void splitStringBy8(){
        Scanner sc =new Scanner(System.in);
        String str=sc.nextLine();
        int a=str.length()/8;
        int b=str.length()%8;
        for (int i = 0; i < a; i++) {
            System.out.println(str.substring(i*8,i*8+8));
        }
        if(b!=0){
            System.out.print( str.substring(a*8));
            for (int i = 0; i <8-b ; i++) {
                System.out.print(0);
            }
        }
    }
    /**
     * HJ5 进制转换*/
    public static void convertOfNumberSys(){
        Map<Character,Integer> stringMap=new HashMap<>();
        stringMap.put('A',10);
        stringMap.put('B',11);
        stringMap.put('C',12);
        stringMap.put('D',13);
        stringMap.put('E',14);
        stringMap.put('F',15);
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        Stack<Integer> integerStack=new Stack<>();
        for (int i = 2; i < str.length(); i++) {
            if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
                integerStack.push(str.charAt(i)-'0');
            }
            else {
                integerStack.push(stringMap.get(str.charAt(i)));
            }
        }
        int temp=0,sum=0;
        while (!integerStack.empty()){
            sum+=Math.pow(16,temp) *integerStack.pop();
            temp++;
        }
        System.out.println(sum);
    }
    public static void convertOfNumberSys2(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        str=str.substring(2);
        System.out.println( Integer.parseInt(str,16));

    }
    /**
     *HJ6 质数因子
     * */
    public static void  factorOfPrimeNumber(){
        Scanner scanner=new Scanner(System.in);
        long num=scanner.nextLong();
        double max=Math.sqrt(num);
        for (int i=2;i<=num;i++){
            if(num%i==0){
                System.out.print(i+" ");
                num=num/i;
                i--;
            }
            if(i>max){
                System.out.print(num+" ");
                break;
            }
        }
    }

    /**
     * HJ7 取近似值
     * */
    public  static  void round(){
        Scanner scanner=new Scanner(System.in);
        double d= scanner.nextDouble();
        System.out.print(Math.round(d));
    }
    /**
     * HJ8 合并表记录
     * */
    public static void combineRecord(){
        Map<Integer,Integer> map=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int key=scanner.nextInt();
            int value=scanner.nextInt();
            if(map.containsKey(key)){
                value=value+map.get(key);
            }
            map.put(key,value);
        }
        Object[] keyArray= map.keySet().toArray();
        Arrays.sort(keyArray);
        for (Object key:
                keyArray) {
            System.out.println(key+" "+map.get(key));
        }
    }

    /**
     * HJ9 提取不重复的整数
     * */
    public  static  void  extractNoRepeatNumber(){
        Scanner scanner=new Scanner(System.in);
        Integer str = scanner.nextInt();
        char[] inputArray=str.toString().toCharArray();
        Map<Character,Integer> resMap=new LinkedHashMap<>();
        for (int i = (inputArray.length-1); i >=0 ; i--) {
            resMap.put(inputArray[i],i);
        }
        for (char key:
                resMap.keySet()) {
            System.out.print(key);
        }
    }

    /**
     * HJ10 字符个数统计
     * */
    public  static  void characterSumStatics(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        char[] charArray=str.toCharArray();
        HashSet<Character> hashSet=new HashSet<>();
        int num=0;
        for (char val:
                charArray) {
            if(!hashSet.contains(val)){
                hashSet.add(val);
                num++;
            }
        }
        System.out.println(num);
    }
    /**
     * HJ11 数字颠倒
     * */
    public static void numberReverse(){
        Scanner scanner=new Scanner(System.in);
        Integer num=scanner.nextInt();
        char[] numArray=num.toString().toCharArray();
        for (int i = numArray.length-1; i >=0 ; i--) {
            System.out.print(numArray[i]);
        }
    }
    /**
     * HJ12 字符串反转
     * */
    public static  void stringConvert(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] numArray=str.toString().toCharArray();
        for (int i = numArray.length-1; i >=0 ; i--) {
            System.out.print(numArray[i]);
        }
    }

    /***
     * HJ13 句子逆序
     */
    public static void sentenceReverse(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] numArray=str.split(" ");
        for (int i = numArray.length-1; i >=0 ; i--) {
            if(i!=0)
                System.out.print(numArray[i]+" ");
            else
                System.out.print(numArray[i]);
        }
    }
    /**
     * HJ14 字符串排序
     * */
    public static  void stringOrder(){
        Scanner scanner = new Scanner(System.in);
        int inputSum = scanner.nextInt();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < inputSum; i++) {
            stringList.add(scanner.next());
        }
        Collections.sort(stringList);
        for (String val :
                stringList) {
            System.out.println(val);
        }
    }
    /**
     * HJ15 求int型正整数在内存中存储时1的个数
     * */
    public  static  void  countNumbersOfOne(){
        Scanner scanner=new Scanner(System.in);
        Integer inputNum=scanner.nextInt();
        String str= Integer.toString(inputNum,2);
        int res=0;
        for (char val:
                str.toCharArray()) {
            if(val=='1'){
                res++;
            }
        }

        System.out.println(res);
    }
    /**
     * HJ46 截取字符串
     * */
    public static void subStr(){
        Scanner scanner=new Scanner(System.in);
        String str= scanner.nextLine();
        int k= scanner.nextInt();
        System.out.println(str.substring(0,k));

    }
    /**
     * HJ58 输入n个整数，输出其中最小的k个
     * */
    public static void printMin(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),k=scanner.nextInt();
        int[] array=new int[n];
        int min=Integer.MIN_VALUE,secondMin=Integer.MIN_VALUE+1;
        for (int i = 0; i <n ; i++) {
           array[i]=scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i <k ; i++) {
            System.out.print(array[i]);
            if(i!=k)
                System.out.print(" ");
        }
    }
    /**
     * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
     * */
    public static void sort(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Integer[] arrays=new Integer[n];
        for (int i = 0; i <arrays.length ; i++) {
            arrays[i]=scanner.nextInt();
        }
        int flag=scanner.nextInt();
        switch (flag){
            case 0:
                Arrays.sort(arrays);
                break;
            case 1:
                Arrays.sort(arrays,((o1, o2) -> o2.compareTo(o1)));
                break;
            default:break;
        }
        for (int item:arrays) {
            System.out.print(item);
            if(item!=arrays[arrays.length-1])
                System.out.print(" ");
        }
    }
    /**
     * HJ21 简单密码
     * */
    public  static  void simplePassword(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] characters= str.toCharArray();
        for (int i=0;i<characters.length;i++) {
            if(characters[i]>='a'&&characters[i]<='r')
                characters[i]= (char) ((characters[i]-'a')/3+'2');
            if(characters[i]=='s')
                characters[i]= '7';
            if(characters[i]=='t'||characters[i]=='u'||characters[i]=='v')
                characters[i]='8';
            if(characters[i]=='w'||characters[i]=='y'||characters[i]=='x'||characters[i]=='z')
                characters[i]='9';
            if(characters[i]>='A'&&characters[i]<'Z')
                characters[i]= (char) (characters[i]+1+('A'-'a'));
            if(characters[i]=='Z')
                characters[i]='a';
        }
        System.out.println(String.valueOf(characters) );
    }
    /**
     * HJ22 汽水瓶
     * */
    public static void drink(){
        Scanner scanner=new Scanner(System.in);
        while (true){
            int n=scanner.nextInt();
            if(n==0)
                return;
            System.out.println( drinkSoda(n));
        }

    }
    public static int drinkSoda(int start){
        int drink=0;
        while (start>1){
            int a=start/3,b=start%3;
            drink+=a;
            start=a+b;
            if(start==2){
                drink++;
                break;
            }

        }
        return drink;
    }
    /**
     * HJ23 删除字符串中出现次数最少的字符
     * */
    public static void deleteCharacter(){
        Scanner scanner=new Scanner(System.in);
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        String str=scanner.nextLine();
        char[] chars=str.toCharArray();
        for (Character item:chars) {
            map.put(item,map.getOrDefault(item,0)+1);
        }
        // 快速找出最少次数
        int min = Integer.MAX_VALUE;
        for (int times : map.values()) {
            min = Math.min(min, times);
        }
        StringBuilder res = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (map.get(ch) != min) {
                res.append(ch);
            }
        }
        System.out.println(res);
    }
    /**
     * HJ31 单词倒排
     * */
    public static void letterReverse(){
        Scanner in = new Scanner(System.in);
        String st=in.nextLine();
        char[] chs=st.toCharArray();
        for (int i=0;i<chs.length;i++) {
            if(!(chs[i]<='z'&&chs[i]>='a'||chs[i]>='A'&&chs[i]<='Z')){
                chs[i]=' ';
            }
        }
        String s= String.valueOf(chs);
        String[] strings=s.split(" ");
        for (int i = strings.length-1; i >=0 ; i--) {
            System.out.print(strings[i]);
            if(1!=0)
                System.out.print(" ");
        }
    }
    /**
     * HJ34 图片整理
     * */
    public static void  organizeImage(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
    }
    /**
     * HJ35蛇形矩阵
     * */
    public static void serpentineMatrix(){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        for (int i = 0; i <n ; i++) {
            //TODO
        }
    }
    public static void main(String[] args) {
        drink();
//        int word=0,space=0,number=0,other=0;
//        Scanner in = new Scanner(System.in);
//        String str=in.nextLine();
//        str=str.toLowerCase();
//        char[] chars=str.toCharArray();
//        for (int i = 0; i <chars.length ; i++) {
//            if(chars[i]<='9'&&chars[i]>='0')
//                number++;
//            else if (chars[i]<='z'&&chars[i]>='a')
//                word++;
//            else if(chars[i]==' ')
//                space++;
//            else other++;
//
//        }
//
//        System.out.println(word);
//        System.out.println(space);
//        System.out.println(number);
//        System.out.println(other);
    }
}
