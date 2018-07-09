package com.frenk.euler.solutions;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
*/


public class Problem7 {
  private static class Solver {

    private int n;

    Solver(int n) {
      this.n = n;
    }

    public int solve() {
      int count = 1;
      int candidate = 3;
      while (count < n) {
        if (isPrime(candidate)) {
          count++;
        }
        candidate++;
      }
      return --candidate;
      
    }

    // maybe could parallelize this using actors?
    private boolean isPrime(int candidate) {
      int divisor = 2;
      while (divisor <= Math.sqrt(candidate)) {
        if (candidate % divisor == 0) {
          return false;
        }
        divisor++;
      }
      return true;
    }

  }

  public static void main(String[] args) {

   System.out.println(new Solver(6).solve()); // should be 13
     System.out.println(new Solver(10_001).solve());

      long startTime = System.nanoTime();
      new Solver(10_001).solve();
      long endTime = System.nanoTime();
      System.out.println(String.format("Total runtime: %f ms", 1.0 / 1_000_000 * (endTime - startTime)));
  }

}
