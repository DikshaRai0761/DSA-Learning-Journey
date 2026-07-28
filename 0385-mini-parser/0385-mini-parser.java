class Solution {
    public NestedInteger deserialize(String s) {

        // Single integer case
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> st = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '[') {
                st.push(new NestedInteger());
                i++;
            }
            else if (ch == ']') {
                NestedInteger curr = st.pop();

                if (st.isEmpty()) {
                    return curr;
                }

                st.peek().add(curr);
                i++;
            }
            else if (ch == ',') {
                i++;
            }
            else {
                // Parse number (handles negative numbers too)
                int sign = 1;
                if (ch == '-') {
                    sign = -1;
                    i++;
                }

                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                st.peek().add(new NestedInteger(sign * num));
            }
        }

        return new NestedInteger();
    }
}