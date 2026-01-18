class Solution {
    public double power(double num, long n) {
        if (n == 0) return 1.0;
        double half = power(num, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * num;
        }
    }
    public double myPow(double x, int n) {
        long exp = n;  
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        return power(x, exp);
    }
}