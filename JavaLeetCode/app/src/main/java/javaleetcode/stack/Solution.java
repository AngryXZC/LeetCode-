package javaleetcode.stack;

import java.util.Stack;

/**
 * @author xzc
 * @date 2024/3/27 16 55:11
 * @description
 */
public class Solution {
    /**
     *20. 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * */
    public boolean isValid(String s) {
        if(s.length()<1) return false;
        Stack<Character> character_stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='[')
                character_stack.push(ch);
            else {
                if(character_stack.isEmpty())
                    return false;
                if (ch==')'||ch=='}'||ch==']'){
                    Character top_ch=character_stack.peek();
                    if (ch==')'&&top_ch=='('||ch=='}'&&top_ch=='{'||ch==']'&&top_ch=='[')
                        character_stack.pop();
                    else return false;
                }
                else return false;
            }
        }
        return character_stack.isEmpty();
    }
}
