package frogjmp;

public class Solution {

    public int solution(int X, int Y, int D) {

        double distance = Y - X;
        double jumps = Math.ceil(distance / (double) D);

        return (int) jumps;

    }

}
