package brackets;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int solution(String S) {
        if (S.length() == 0) {
            return 1;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return 0;
                }
                final char open = stack.pop();
                if (open == '(' && c != ')') {
                    return 0;
                } else if (open == '{' && c != '}') {
                    return 0;
                } else if (open == '[' && c != ']') {
                    return 0;
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution("{[()()]}");
        System.out.println(solution);

        final int solution2 = new Solution().solution("([)()]");
        System.out.println(solution2);
    }

}
