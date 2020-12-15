package easy._0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by fzy at 22:57 on 2020/12/14.
 */
public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1)
            return false;
        Map<Character,Character> pairs = new HashMap<Character,Character>() {{
           put(')','(');
           put('}','{');
           put(']','[');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch))
                    return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
