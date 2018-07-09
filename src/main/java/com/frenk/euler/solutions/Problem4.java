package com.frenk.euler.solutions;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
  private static class Solver {

    private int longestPalindrome;
    private int[][] lookupTable;
    private int start;
    private int end;

    Solver(int input) {
      if (input > 4) {
        throw new IllegalArgumentException("Please enter a number between 1 and 4");
      }
      this.start = (int) Math.pow(10, input - 1);
      this.end = (int) Math.pow(10, input) - 1;
      // System.out.println(this.start + "-" + this.end);
      int tableSize = end - start;
      this.lookupTable = new int[tableSize + 1][tableSize + 1];
    }

    public int solve() {

      for (int i = start; i <= end; i++) {
        for (int j = start; j <= end; j++) {
          if (lookupTable[j - start][i - start] == 0) {
            int product = i * j;
            lookupTable[i - start][j - start] = product;
            if (checkIsPalindrome(product) && product > longestPalindrome) {
              longestPalindrome = product;
            }
          }
        }
      }
      return longestPalindrome;
    }

    private boolean checkIsPalindrome(int num) {
      String stringRep = Integer.toString(num);
      int length = stringRep.length();
      int midpoint = (int) Math.floor(length / 2);
      for (int i = 0; i <= midpoint; i++) {
        if (stringRep.charAt(i) != stringRep.charAt(length - 1 - i)) {
          return false;
        }
      }
      return true;
    }

    public void testCheckIsPalindrome(int num, boolean expected) {
      boolean result = checkIsPalindrome(num);
      if (result != expected) {
        throw new AssertionError("expected checkIsPalindrome(" + num + ") to be " + expected + " but got " + result);
      }
    }
  }

  public static void main(String[] args) {

    // Solver testSolver = new Solver(3);
    // testSolver.testCheckIsPalindrome(9009, true);
    // testSolver.testCheckIsPalindrome(90009, true);
    // testSolver.testCheckIsPalindrome(9909, false);

    // System.out.println(new Solver(2).solve()); // should be 9009
    // System.out.println(new Solver(3).solve());

    long startTime = System.nanoTime();
    new Solver(3).solve();
    long endTime = System.nanoTime();
    System.out.println(String.format("Total runtime: %f ms", 1.0 / 1_000_000 * (endTime - startTime)));
  }

}
