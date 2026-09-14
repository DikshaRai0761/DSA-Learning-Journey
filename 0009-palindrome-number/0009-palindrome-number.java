class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers palindrome nahi ho sakte
        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x > 0) {
            int digit = x % 10;          // last digit
            reverse = reverse * 10 + digit;
            x = x / 10;                  // last digit remove
        }

        return original == reverse;
    }
}