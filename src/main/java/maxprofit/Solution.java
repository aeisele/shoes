package maxprofit;

public class Solution {

    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int minPriceSoFar = A[0];
        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            int price = A[i];
            if (price > minPriceSoFar) {
                maxProfit = Math.max(maxProfit, price - minPriceSoFar);
            } else {
                minPriceSoFar = price;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        final int solution = new Solution().solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367});
        System.out.println(solution);
    }

}
