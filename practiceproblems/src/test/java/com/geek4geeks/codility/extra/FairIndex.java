package com.geek4geeks.codility.extra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FairIndex {

    public int solution(int[] A, int[] B) {
        int sumA = sum(A);
        int sumB = sum(B);
        int fairSumA = 0, fairSumB = 0;;
        for (int i = 0; i < A.length; i++) {
            fairSumA += A[i];
            fairSumB += B[i];
            sumA -= A[i];
            sumB -= B[i];
            if(fairSumA == sumA && fairSumB == sumB && fairSumA == fairSumB) {
                return i+1;
            }
        }
        return 0;
    }

    private int sum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+= A[i];
        }
        return sum;
    }

    @Test
    public void testFairIndex() {
        Assertions.assertEquals(3, solution(new int[]{0,4,-1,0,3}, new int[]{0,-2,5,0,3}));
        Assertions.assertEquals(2, solution(new int[]{2,-2,-3,3}, new int[]{0,0,4,-4}));
        Assertions.assertEquals(0, solution(new int[]{4,-1,0,3}, new int[]{-2,6,0,4}));
        Assertions.assertEquals(0, solution(new int[]{4,-1,0,3}, new int[]{-2,6,0,4}));
        Assertions.assertEquals(0, solution(new int[]{3,2,6}, new int[]{4,1,6}));
        Assertions.assertEquals(2, solution(new int[]{1,4,2,-2,5}, new int[]{7,-2,-2,2,5}));
    }

}
