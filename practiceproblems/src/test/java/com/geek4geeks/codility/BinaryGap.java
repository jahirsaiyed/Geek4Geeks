package com.geek4geeks.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BinaryGap {

    //TODO: O(N log N) Need to improve to bring this down to O(N) or less.

    public int solution(int N) {
        int maxGap = 0, gap = 0;
        String binaryRep = toBinary(N);
        boolean gapInProgress = false;
        for (int i = 0; i < binaryRep.length(); i++) {
            char c = binaryRep.charAt(i);
            if (c == '1') {
                if (gapInProgress && gap > maxGap) {
                    maxGap = gap;
                }
                gap = 0;
                gapInProgress = true;
            }
            if (gapInProgress && c == '0') {
                gap++;
            }
        }
        return maxGap;
    }
//    18:10010. 18,9,4,2,1

    private String toBinary(int N) {
        StringBuilder binaryRep = new StringBuilder();
        while (N > 0) {
            binaryRep.append(N % 2);
            N /= 2;
        }
        return binaryRep.toString();
    }

    @Test
    public void testBinaryGap() {
        Assertions.assertEquals(4, solution(529));
        Assertions.assertEquals(2, solution(9));
        Assertions.assertEquals(0, solution(15));
        Assertions.assertEquals(0, solution(32));
    }

//    A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
//
//    For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
//
//    Write a function:
//
//    class Solution { public int solution(int N); }
//
//    that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
//
//    For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..2,147,483,647].

}
