package com.geek4geeks.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CheckWordsInMagazine {

//    https://www.hackerrank.com/challenges/ctci-ransom-note/problem
    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static boolean checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        List<String> copyMagazine = new ArrayList<>(magazine);
        for (String word : note) {
            if(!copyMagazine.remove(word)) {
                System.out.println("No");
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Assertions.assertFalse(checkMagazine(Arrays.asList("two times three is not four".split(" ")),
                Arrays.asList("two times two is four".split(" "))));
        Assertions.assertTrue(checkMagazine(Arrays.asList("give me one grand today night".split(" ")),
                Arrays.asList("give one grand today".split(" "))));
    }
}
