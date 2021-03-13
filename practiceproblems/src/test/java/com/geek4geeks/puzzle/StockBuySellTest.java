package com.geek4geeks.puzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class StockBuySellTest {

    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> trades = new ArrayList<>();
        boolean buy = true;
        ArrayList<Integer> trade = null;
        int currentPrice = A[0];
        for(int i=0; i<n-1; i++) {
            currentPrice = A[i];
            if(!isTradeOpen(trade) && currentPrice < A[i+1] ) {
                trade = openTrade(i);
            } else if(currentPrice > A[i+1] && isTradeOpen(trade)){
                closeTradeAndAddToTrades(trades, trade, i);
                trade = null;
            }
        }
        if(isTradeOpen(trade) && currentPrice < A[n-1]) {
            closeTradeAndAddToTrades(trades, trade,  A[n-1]);
        }
        System.out.println(trades);
        return trades;
    }

    private ArrayList<Integer> openTrade(int price) {
        ArrayList<Integer> trade = new ArrayList<>();
        trade.add(price);
        return trade;
    }

    private ArrayList<Integer> closeTradeAndAddToTrades(ArrayList<ArrayList<Integer>> trades, ArrayList<Integer> trade, int price) {
        trade.add(price);
        trades.add(trade);
        return trade;
    }

    private boolean isTradeOpen(ArrayList<Integer> trade) {
        return trade != null && trade.size() > 0;
    }

    @Test
    public void testTrades() {
        Assertions.assertEquals(2, stockBuySell(new int[]{100,180,260,310,40,535,695}, 7).size());
        Assertions.assertEquals(4, stockBuySell(new int[]{92, 64, 90, 38, 78, 41, 12, 18, 48, 7, 8}, 11).size());

    }


}

//    The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
//
//        Example 1:
//
//        Input:
//        N = 7
//        A[] = {100,180,260,310,40,535,695}
//        Output:
//        (0 3) (4 6)
//        Explanation:
//        We can buy stock on day 0,
//        and sell it on 3rd day, which will
//        give us maximum profit. Now, we buy
//        stock on day 4 and sell it on day 6.
//        Example 2:
//
//        Input:
//        N = 5
//        A[] = {4,2,2,2,4}
//        Output:
//        (3 4)
//        Explanation:
//        We can buy stock on day 3,
//        and sell it on 4th day, which will
//        give us maximum profit.
//
//        Your Task:
//        The task is to complete the function stockBuySell() which takes an array A[] and N as input parameters and finds the days of buying and selling stock. The function must return a 2D list of integers containing all the buy-sell pairs. If there is No Profit, return an empty list.
//
