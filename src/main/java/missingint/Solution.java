package missingint;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int solution(int[] A) {
        Set<Integer> ints = Arrays.stream(A)
                .filter(i -> i > 0)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 1; i < 1000000; i++) {
            if (!ints.contains(i)) {
                return i;
            }
        }

        return -1;
    }

}
