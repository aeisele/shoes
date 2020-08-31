package passingcars;

public class Solution2 {

    public int solution(int[] A) {
        int westCars = 0;
        int passingCars = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                passingCars += westCars;
                if (passingCars > 1_000_000_000) {
                    return -1;
                }
            } else {
                westCars++;
            }
        }
        return passingCars;
    }

    public static void main(String[] args) {
        int solution = new Solution2().solution(new int[]{0, 1, 0, 1, 1});
        System.out.println(solution);
    }

}
