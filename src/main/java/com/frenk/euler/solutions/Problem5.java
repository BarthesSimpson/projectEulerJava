package com.frenk.euler.solutions;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {
  private static class Solver {

    private int start;
    private int end;

    Solver(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int solve() {
      int candidate = end * (end - 1);
      while (true) {
        if (isEvenlyDivisible(candidate)) {
          return candidate;
        } else {
          candidate += end;
        }
      }
    }

    public boolean isEvenlyDivisible(int n) {
      for (int i = end - 1; i >= start; i--)
        if (n % i != 0) return false;
      return true;
    }
  }

  public static void main(String[] args) {

    // System.out.println(new Solver(1, 10).solve()); // should be 2520
    // System.out.println(new Solver(11, 20).solve());

    long startTime = System.nanoTime();
    new Solver(11, 20).solve();
    long endTime = System.nanoTime();
    System.out.println(String.format("Total runtime: %f ms", 1.0 / 1_000_000 * (endTime - startTime)));
  }

}
