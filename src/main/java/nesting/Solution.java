package nesting;

public class Solution {

    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return 1;
        }

        int open = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                open--;
                if (open < 0) {
                    return 0;
                }
            }
        }

        return open == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("(()(())())"));
        System.out.println(new Solution().solution("())"));
    }

}
