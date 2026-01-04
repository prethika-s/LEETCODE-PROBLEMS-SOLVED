class Solution {
    public double average(int[] salaries) {
        int min = Integer.MAX_VALUE, max = 0, sum = 0;
        for(int salary : salaries) {
            sum += salary;
            if(salary < min) min = salary;
            if(salary > max) max = salary;
        }
        return ((double) (sum - max - min)) / (salaries.length - 2);
    }
}