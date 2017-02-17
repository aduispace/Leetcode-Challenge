/* 
   第一种解法：
   罗马数字一共有七个，分别是I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
   规则： 1. IV = 4 (-1), IX = 9 (-1), XL = 40(-10), XC = 90(-10), CD = 400(-100), CM = 900(-100);

   Thoughts: 1. don't forget how to write switch (char)
             2. this is too costy to loop for each of IV, IX, etc!
   
   Tricky parts and Notes: 1. s.substring(), 小写！！！ 
                           2. 注意minus时原来+1,现在为-1, 差值为 -2!
             
   Time Complexity:
   Space Complexity: 
*/

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int sum = 0; 
        char[] str = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            sum += sumHere(str[i]);
        } 
        /* don't forget to multiply with 2! */
        
        sum = sum - minus(s, "CM") * 100 * 2;
        sum = sum - minus(s, "CD") * 100 * 2;
        sum = sum - minus(s, "XC") * 10 * 2;
        sum = sum - minus(s, "XL") * 10 * 2;
        sum = sum - minus(s, "IX") * 2;
        sum = sum - minus(s, "IV") * 2;
        
        return sum;
    }
    
    private int sumHere(char s) {
        int i = 0;
        switch(s) {
            case 'I': i = 1; break;
            case 'V': i = 5; break;
            case 'X': i = 10; break;
            case 'L': i = 50; break;
            case 'C': i = 100; break;
            case 'D': i = 500; break;
            case 'M': i = 1000; break;
            default: i = 0;
        }
        return i;
    }
    
    private int minus(String s, String str) {
        int count = 0;
        /* scan the s from first to last */
        while (s.indexOf(str) != -1) {
            count++;
            int i = s.indexOf(str) + 2;
            if (i <= s.length() - 2) { // <= because i's last possible position is s.length() - 2;
                s = s.substring(i);
            } else {break;}
            
        }
        
        return count;
    }
    
}

/* 第二种解法：
罗马数字一共有七个，分别是I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
规则： 1. IV = 4 (-1), IX = 9 (-1), XL = 40(-10), XC = 90(-10), CD = 400(-100), CM = 900(-100);

Another optimized method, scan from back to front 

更加简洁
*/ 

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int sum = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
            /* there are only three possible cases that I,X,C will be in the front */
                case 'I' : sum += sum > 4? -1 : 1; break; 
                case 'X' : sum += sum > 40? -10 : 10; break;
                case 'C' : sum += sum > 400? -100 : 100; break;
                case 'V' : sum += 5; break;
                case 'L' : sum += 50; break;
                case 'D' : sum += 500; break;
                case 'M' : sum += 1000; break;
            }
            
        /* using if will exceed the time limit; */
        }
        
        return sum;
    }
}
