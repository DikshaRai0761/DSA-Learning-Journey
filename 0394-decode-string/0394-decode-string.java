class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0;
        String curr = "";

        for (char ch : s.toCharArray()) {

            // number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // '['
            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(curr);

                num = 0;
                curr = "";
            }

            // ']'
            else if (ch == ']') {
                int count = countStack.pop();
                String prev = stringStack.pop();

                String temp = "";

                for (int i = 0; i < count; i++) {
                    temp += curr;
                }

                curr = prev + temp;
            }

            // character
            else {
                curr += ch;
            }
        }

        return curr;
    }
}