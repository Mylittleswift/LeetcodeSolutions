/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1 || primes == null || primes.length == 0) {
            return 1;
        }
         
        int k = primes.length;
        int[] index = new int[k];
         
        List<Integer> result = new ArrayList<>();
        result.add(1);
         
        for (int i = 1; i < n; i++) {
            int curr = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                curr = Math.min(curr, primes[j] * result.get(index[j]));
            }
             
            result.add(curr);
             
            // update the index
            for (int j = 0; j < k; j++) {
                if (primes[j] * result.get(index[j]) == curr) {
                    index[j]++;
                }
            }
        }
         
        return result.get(result.size() - 1);
    }
}

