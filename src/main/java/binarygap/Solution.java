package binarygap;

public class Solution {

    public int solution(int N) {

        int gapSize = 0;
        boolean inGap = false;
        int currentGap = 0;

        char[] binary = Integer.toBinaryString(N).toCharArray();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '0') {
                if (i < binary.length - 1) {
                    if (!inGap) {
                        inGap = true;
                        currentGap = 1;
                    } else {
                        currentGap += 1;
                    }
                }
            } else {
                if (inGap) {
                    inGap = false;
                    if (gapSize < currentGap) {
                        gapSize = currentGap;
                    }
                }
            }
        }

        return gapSize;

    }

}
