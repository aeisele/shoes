package countsemiprimes;

import java.util.Arrays;

// semi prime = prime * prime (not necessarily the same prime)
public class Solution {

    public int[] solution(int N, int[] P, int[] Q) {
        // either a prime number or zero, then index is a prime
        int[] smallestPrimeFactor = new int[N + 1];

        for (int i = 2; i*i <= N; i++) {
            if (smallestPrimeFactor[i] == 0) {
                for (int j = i * i; j <= N; j += i) {
                    if (smallestPrimeFactor[j] == 0) {
                        smallestPrimeFactor[j] = i;
                    }
                }
            }
        }

        int[] semiPrimeCount = new int[N + 1];
        for (int i = 2, k = 0; i <= N; i++) {
            if (smallestPrimeFactor[i] != 0 && smallestPrimeFactor[i / smallestPrimeFactor[i]] == 0) {
                k++;
            }
            semiPrimeCount[i] = k;
        }

        int m = P.length;
        int[] result = new int[m];
        for (int s = 0; s < m; s++) {
            int count = semiPrimeCount[Q[s]];
            if (P[s] > 0) {
                count -= semiPrimeCount[P[s] - 1];
            }
            result[s] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        final int[] solution = new Solution().solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20});
        // [10, 4, 0]
        System.out.println(Arrays.toString(solution));
    }

}
