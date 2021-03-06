package com.geek4geeks.puzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RectanglesOverlapTest {

    int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        // code here
        if(R1[0] < L2[0] || L1[0] > R2[0] || R1[1] > L2[1] || L1[1] < R2[1]) {
            return 0;
        }
        return 1;
    }

    @Test
    public void testRectangle() {
        Assertions.assertEquals(1, doOverlap(new int[]{0,10}, new int[]{10,0}, new int[]{5,5}, new int[]{15,0}));
        Assertions.assertEquals(0, doOverlap(new int[]{0,2}, new int[]{1,1}, new int[]{-2,-3}, new int[]{0,2}));
        //TODO: Fix the below
        Assertions.assertEquals(0, doOverlap(new int[]{-1, 9}, new int[]{-4, -5}, new int[]{-3, -2}, new int[]{1, 2}));
        Assertions.assertEquals(0, doOverlap(new int[]{-21441, 29566}, new int[]{-24700, -15962}, new int[]{-23016, -22697}, new int[]{21657, 22441}));

    }

//    Given two rectangles, find if the given two rectangles overlap or not. A rectangle is denoted by providing the x and y coordinates of two points: the left top corner and the right bottom corner of the rectangle. Two rectangles sharing a side are considered overlapping. (L1 and R1 are the extreme points of the first rectangle and L2 and R2 are the extreme points of the second rectangle).
//
//    Note: It may be assumed that the rectangles are parallel to the coordinate axis.
//
//            rectanglesOverlap
//
//    Example 1:
//
//    Input:
//    L1=(0,10)
//    R1=(10,0)
//    L2=(5,5)
//    R2=(15,0)
//    Output:
//            1
//    Explanation:
//    The rectangles overlap.
//            Example 2:
//
//    Input:
//    L1=(0,2)
//    R1=(1,1)
//    L2=(-2,-3)
//    R2=(0,2)
//    Output:
//            0
//    Explanation:
//    The rectangles do not overlap.
//
//    Your Task:
//    You don't need to read input or print anything. Your task is to complete the function doOverlap() which takes the points L1, R1, L2, and R2 as input parameters and returns 1 if the rectangles overlap. Otherwise, it returns 0.
}
