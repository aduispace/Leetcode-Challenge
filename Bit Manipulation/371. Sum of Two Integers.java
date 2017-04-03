/**
 * Thoughts: Use bit operation: use an int to record carry; Use the logic of half adder: a & b gets carry; a ^ b gets sum without carry;
 * 
 * https://en.wikipedia.org/wiki/Adder_%28electronics%29#Half_adder
 * 
 * 
 */

public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}


**********************************************************
// Detailed explaination of this solution
int Add(int x, int y)
{
    // Iterate till there is no carry  
    while (y != 0)
    {
        // carry now contains common set bits of x and y
        int carry = x & y;  
 
        // Sum of bits of x and y where at least one of the bits is not set
        x = x ^ y; 
 
        // Carry is shifted by one so that adding it to x gives the required sum
        y = carry << 1;
    }
    return x;
}
