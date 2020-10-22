package chocolatesbynumbers;

// eat chocolates and leave a wrapper start from 0 jump M - 1 chocolates forward in a circle
//
//  0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  0
//  1,  0,  0,  0,  1,  0,  0,  0,  1,  0,  0,  0,  1,  0,  0,  0,  1,  0,  0,  0,  1
//                                                                                  ^--- wrapped around to 0, can't eat
// --> kgv (10, 4) == where both number classes meat first time == 20
// kgv(a,b) = a * b / ggt(a,b)
// (kgv = lcm, ggt = gcd)
// if after 20 chocolates we land at a wrapper, we could have eaten 20 / M = 20 / 4 = 5 chocolates
public class Solution {

    public int solution(int N, int M) {
        final long ggt = ggt(N, M, 1);
        long kgv = (long) N * (long) M / ggt;
        return (int) (kgv / (long) M);
    }

    private long ggt(long a, long b, long res) {
        if (a == b) {
            return a * res;
        } else if (a % 2 == 0 && b % 2 == 0) {
            return ggt(a / 2, b / 2, res * 2);
        } else if (a % 2 == 0) {
            return ggt(a / 2, b, res);
        } else if (b % 2 == 0) {
            return ggt(a, b / 2, res);
        } else if (a < b) {
            return ggt(a, b - a, res);
        } else {
            return ggt(a - b, b, res);
        }
    }

    public static void main(String[] args) {
        // 5
        //final int solution = new Solution().solution(10, 4);
        // 947853
        final int solution = new Solution().solution(947853, 4453);
        System.out.println(solution);
    }

}
