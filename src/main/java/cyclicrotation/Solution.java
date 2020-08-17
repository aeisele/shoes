package cyclicrotation;

/*
     0  1  2  3  4
A = [3, 8, 9, 7, 6]
K = 3
     0  1  2  3  4
->  [9, 7, 6, 3, 8]

i0 + 3 = 3 % 5 = 3
i1 + 3 = 4 % 5 = 4
i2 + 3 = 5 % 5 = 0
i3 + 3 = 6 % 5 = 1
i4 + 3 = 7 % 5 = 2

K = 18
[3, 8, 9, 7, 6]

i0 + 18 = 18 % 5 = 3
i1 + 18 = 19 % 5 = 4
i2 + 18 = 20 % 5 = 0
i3 + 18 = 21 % 5 = 1
i5 + 18 = 22 % 5 = 2
*/

public class Solution {

    public int[] solution(int[] A, int K) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int newIndex = (i + K) % A.length;
            result[newIndex] = A[i];
        }

        return result;
    }

}
