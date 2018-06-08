package com.frenk.euler.solutions;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    private static class Solver {

        private long input;

        Solver(long input) {
            this.input = input;
        }

        public long solve() {
            return factorize(input, 2);
        }

        public long factorize(long balance, long divisor) {

            while (balance % divisor == 0) {
                balance /= divisor;
            }
            return Math.pow(divisor, 2) >= balance ? balance : factorize(balance, ++divisor);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solver(13_195).solve()); // should be 29
        long startTime = System.nanoTime();
        // System.out.println(new Solver(600_851_475_143L).solve());
        new Solver(600_851_475_143L).solve();
        long endTime = System.nanoTime();
        System.out.println(String.format("Total runtime: %f ms", 1.0 / 1_000_000 * (endTime - startTime)));
    }

}
