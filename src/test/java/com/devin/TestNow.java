package com.devin;

import org.junit.Test;

import java.util.Scanner;

public class TestNow {
    /*
     *  用于测试:hdu2602
     * */
    @Test
    public void test0() {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(), V = sc.nextInt();
        bones = new Bone[c];
//        dp[i][j] 定义为 当背包容量为j时,装前i个物品 所能获得的最大价值
        dp = new int[c + 1][V + 1];
        for (int i = 0; i < c; i++) bones[i].m = sc.nextInt();
        for (int i = 0; i < c; i++) bones[i].val = sc.nextInt();

        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= V; j++) {
                // 如果当前物品质量小于当前背包容量,判断装还是不装
                // dp[i-1][j]表示不装,仍保持上个的价值
                /*max(,?)表示装当前物品,装了前i-1个物品的背包所能装下的除当前物品以外
                        的最大价值,再加上当前价值*/
                // (j-bones[i]),如果要装当前物品,所能承受的最大容量.
                if (bones[i-1].m <= j) dp[i][j] = Math.max(dp[i-1][j],
                        dp[i-1][j-bones[i].m]+bones[i].val);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[c][V]);
    }

    int[][] dp;
    Bone[] bones;

    class Bone {
        int val;
        int m;

        public Bone(int val, int m) {
            this.val = val;
            this.m = m;
        }
    }

}
