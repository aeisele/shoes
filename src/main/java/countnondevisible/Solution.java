package countnondevisible;

import java.util.*;

public class Solution {

    public int[] solution(int[] A) {

        int n = A.length;

        int maxNumber = 0;
        // max number is n * 2 according to limits given
        int[] occurrenceCounts = new int[n * 2 + 1];
        for (int number : A) {
            occurrenceCounts[number]++;
            maxNumber = Math.max(maxNumber, number);
        }

        // sieve of max to find also divisors of all before max
        int[] divisorCounts = new int[maxNumber + 1];
        for (int i = 2; i * i <= maxNumber; i++) {

            for (int j = i * i; j <= maxNumber; j += i) {
                divisorCounts[j] += occurrenceCounts[i];
                if (j / i != i) {
                    divisorCounts[j] += occurrenceCounts[j / i];
                }
            }
        }

        int[] nonDivisorCounts = new int[A.length];
        for (int k = 0; k < A.length; k++) {
            int number = A[k];
            nonDivisorCounts[k] = n - (divisorCounts[number] + occurrenceCounts[number]);

            // remove all occurrences of 1 for number != 1
            if (number != 1) {
                nonDivisorCounts[k] = nonDivisorCounts[k] - occurrenceCounts[1];
            }
        }
        return nonDivisorCounts;
    }

    public static void main(String[] args) {
        final int[] solution = new Solution().solution(new int[]{3, 1, 2, 3, 6});
        // 2, 4, 3, 2, 0
        System.out.println(Arrays.toString(solution));
    }

}
