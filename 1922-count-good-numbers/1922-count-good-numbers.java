class Solution {
    public int countGoodNumbers(long n) {
        long MOD = 1_000_000_007;
        long odd_places = n / 2;
        long even_places = n - odd_places;
        long result = (binaryExp(5, even_places, MOD) * binaryExp(4, odd_places, MOD)) % MOD;
        return (int) result;
    }
    private long binaryExp(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}