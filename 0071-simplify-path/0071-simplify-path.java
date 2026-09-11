class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // empty aur current directory "." ko ignore karo
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // ".." means ek directory piche jana
            if (part.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } 
            else {
                // normal directory
                st.push(part);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : st) {
            ans.append("/").append(dir);
        }

        // agar kuch bhi nahi hai
        if (ans.length() == 0) {
            return "/";
        }

        return ans.toString();
    }
}