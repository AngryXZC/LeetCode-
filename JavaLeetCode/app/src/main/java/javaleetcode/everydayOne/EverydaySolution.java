package javaleetcode.everydayOne;

public class EverydaySolution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder stringBuilder=new StringBuilder(s);
        int start=0,end=s.length()-1;
        while (start<=end){
            if(stringBuilder.charAt(start)!=stringBuilder.charAt(end)){
                if(s.charAt(end)>s.charAt(start))
                    stringBuilder.setCharAt(end,s.charAt(start));
                else
                    stringBuilder.setCharAt(start,s.charAt(end));
            }
            start++;
            end--;
        }
        return stringBuilder.toString();
    }
    public static void main(String[] a){
        new EverydaySolution().makeSmallestPalindrome("abcd");
    }
}
