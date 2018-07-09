package com.frenk.euler.solutions;

/*
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

import java.util.stream.IntStream;

public class Problem6 {
  private static class Solver {

    private int limit;

    Solver(int limit) {
      this.limit = limit;
    }

    public int solve() {
      return squareSum(limit) - sumSquares(limit) ;
    }

    private int sumSquares(int n) {
      return IntStream.rangeClosed(1, n).map(i -> i*i).sum();
    }

    private int squareSum(int n) {
      int sum = IntStream.rangeClosed(1, n).sum();
      return sum * sum;
    }

  }

  public static void main(String[] args) {

//    System.out.println(new Solver(10).solve()); // should be 385
//     System.out.println(new Solver(100).solve());
    
     long startTime = System.nanoTime();
     new Solver(100).solve();
     long endTime = System.nanoTime();
     System.out.println(String.format("Total runtime: %f ms", 1.0 / 1_000_000 * (endTime - startTime)));
  }

}
