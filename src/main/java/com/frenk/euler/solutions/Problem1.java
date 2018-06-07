package com.frenk.euler.solutions;

import java.util.stream.IntStream;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    private static class Solver {
        private final int[] factors;
        private final int limit;

        Solver(int[] factors, int limit) {
            this.factors = factors;
            this.limit = limit;
        }

        public int solve() {
            return this.sumAllMultiples();
        }

        private boolean isMultiple(int i) {
            for (int f : factors) {
                if (i % f == 0) {
                    return true;
                }
            }
            return false;
        }

        private int sumAllMultiples() {
            return IntStream.range(1, limit).filter(this::isMultiple).sum();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solver(new int[] { 3, 5 }, 10).solve());
        long startTime = System.nanoTime();
        System.out.println(new Solver(new int[] { 3, 5 }, 1000).solve());
        long endTime = System.nanoTime();
        System.out.println(String.format("Total runtime: %f ms", 1.0/1000000 * (endTime - startTime)));

    }
}
