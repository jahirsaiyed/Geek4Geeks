package com.geek4geeks.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class Dodge2021 {

    //TODO: Fix the failing challenge on codility - "The Doge 2021"

    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        int temp = 0;
        if(isCyclicRelation(A, B, null)) return false;
        Arrays.sort(A);
        Arrays.sort(B);
        int[] A1 = new int[P.length];
        int[] B1 = new int[P.length];

        Arrays.fill(A1, -1);
        Arrays.fill(B1, -1);

        for (int i = 0; i < A.length; i++) {
            if(A[i] < A1.length) {
                A1[A[i]] = A[i];
                B1[A[i]] = B[i];
            }
        }

        for (int i = 0; i < T.length; i++) {
            if (P[i] != T[i]) {
                int exchanged = searchInRelation(i, P[i], T, A1, B1);
                if (exchanged == -1) {
                    return false;
                } else {
                    temp = T[i];
                    T[i] = T[exchanged];
                    T[exchanged] = temp;
                }
            }
        }
        return true;
    }

    private boolean isCyclicRelation(int[] A, int[] B, int[] visited) {
        if(visited == null) {
            visited = new int[A.length];
            Arrays.fill(visited, -1);
        }
        boolean cycle = findVisited(A, B, visited);
        if(cycle) cycle = !isCycleContainsAllVisited(visited);
        return cycle;
    }

    private boolean findVisited(int[] A, int[] B, int[] visited) {
        boolean cycle = false;
        for (int i =0; i< A.length; i++) {
            int relation;
            if(A[i] < A.length) {
                relation = B[A[i]];
            } else {
                relation = A[i];
            }

            for (int j =0; j< i; j++) {
                if(visited[j] == relation) {
                    return true;
                }
            }
            visited[i] = A[i];
        }
        return cycle;
    }

    private boolean isCycleContainsAllVisited(int[] visited) {
        for (int i =0; i< visited.length; i++) {
            if(visited[i] == -1) {
                return false;
            }
        }
        return true;
    }

    private int searchInRelation(int toyIndex, int searchForToy, int T[], int[] A, int[] B) {
        if(toyIndex == -1 || A[toyIndex] == -1 || B[A[toyIndex]] == -1) {
            return -1;
        }
        int indexInRelation = B[A[toyIndex]];
        if (T[indexInRelation] == searchForToy) {
            return indexInRelation;
        }
        return searchInRelation(indexInRelation, searchForToy, T, A, B);
    }

    @Test
    public void testDodge2021() {
        int[] P = new int[]{2, 2, 2, 2, 1, 1, 1, 1};
        int[] T = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
        int[] A = new int[]{0, 1, 2, 3, 4, 5, 6};
        int[] B = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assertions.assertEquals(true, solution(P, T, A, B));

        P = new int[]{2, 2, 1, 1, 1};
        T = new int[]{1, 1, 1, 2, 2};
        A = new int[]{0, 1, 2, 3};
        B = new int[]{1, 2, 0, 4};
        Assertions.assertEquals(false, solution(P, T, A, B));

        P = new int[]{1, 1, 2, 2, 1, 1, 2, 2};
        T = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
        A = new int[]{0, 2, 4, 6};
        B = new int[]{1, 3, 5, 7};
        Assertions.assertEquals(false, solution(P, T, A, B));

        P = new int[]{1};
        T = new int[]{2};
        A = new int[]{};
        B = new int[]{};

        Assertions.assertEquals(false, solution(P, T, A, B));
    }

//
//    During an Animal Day event, N people (numbered from 0 to N−1) showed up. Each of them had either a dog or a cat. The organizers decided to give them a wonderful gift: a toy for each animal.
//
//        After the event, it turned out that some people who owned a dog had received a cat-toy, and some people who owned a cat received a dog-toy. People may exchange toys, but only if they know each other (otherwise they have no way to contact the other person). The pair of people can exchange toys multiple times.
//
//        Knowing who knows who, who owns which animal, and what kind of toy he or she received, can you determine whether it is possible for people to exchange toys in such a way that every dog ends up with a dog-toy and every cat gets a cat-toy?
//
//        Write a function:
//
//class Solution { public boolean solution(int[] P, int[] T, int[] A, int[] B); }
//
//    that returns true if it is possible to exchange toys in such a way that every animal receives an appropriate toy, or false otherwise. First two arrays describe the pets (array P) and toys (array T) that every person owns. The J-th person owns pet P[J] and toy T[J] (1 means dog or dog-toy and 2 means cat or cat-toy). The next two arrays, A and B, both of length M, describe the relationships between people. For each integer K from 0 to M−1, person A[K] knows person B[K].
//
//        Examples:
//
//        1. Given:
//
//        P = [1, 1, 2]
//        T = [2, 1, 1]
//        A = [0, 2]
//        B = [1, 1]
//        the function should return true. Person 0 can exchange toys with person 1 to obtain a dog-toy, and then person 1 can exchange toys with person 2.
//
//        2. Given:
//
//        P = [2, 2, 1, 1, 1]
//        T = [1, 1, 1, 2, 2]
//        A = [0, 1, 2, 3]
//        B = [1, 2, 0, 4]
//        the function should return false. There is no way for persons 3 and 4 to exchange toys with others.
//
//        3. Given:
//
//        P = [1, 1, 2, 2, 1, 1, 2, 2]
//        T = [1, 1, 1, 1, 2, 2, 2, 2]
//        A = [0, 2, 4, 6]
//        B = [1, 3, 5, 7]
//        the function should return false. There is no way for persons 2 and 3 and for persons 4 and 5 to exchange toys with others.
//
//        4. Given:
//
//        P = [2, 2, 2, 2, 1, 1, 1, 1]
//        T = [1, 1, 1, 1, 2, 2, 2, 2]
//        A = [0, 1, 2, 3, 4, 5, 6]
//        B = [1, 2, 3, 4, 5, 6, 7]
//        the function should return true.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        M is an integer within the range [0..200,000];
//        each element of array ('P', 'T') is an integer that can have one of the following values: 1, 2;
//        each element of arrays A, B is an integer within the range [0..N−1];
//        for each integer K from 0 to M−1, elements A[K] and B[K] are different;
//        there are no redundant elements in arrays A, B; more formally every unordered pair of persons a, b will appear as A[K], B[K] for at most one K.= 2, B = 3, C = [0,0,1,1,2] Then output is "NO"

}
