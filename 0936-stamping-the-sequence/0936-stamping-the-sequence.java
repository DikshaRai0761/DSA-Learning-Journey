import java.util.*;

class Solution {

    public int[] movesToStamp(String stamp, String target) {

        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();

        List<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[T.length];

        int stars = 0;

        while (stars < T.length) {

            boolean replaced = false;

            for (int i = 0; i <= T.length - S.length; i++) {

                if (!visited[i] && canReplace(T, i, S)) {

                    stars += doReplace(T, i, S.length);

                    visited[i] = true;

                    replaced = true;

                    ans.add(i);

                    if (stars == T.length)
                        break;
                }
            }

            if (!replaced)
                return new int[0];
        }

        Collections.reverse(ans);

        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);

        return res;
    }

    private boolean canReplace(char[] T, int pos, char[] S) {

        for (int i = 0; i < S.length; i++) {

            if (T[pos + i] != '?' && T[pos + i] != S[i])
                return false;
        }

        return true;
    }

    private int doReplace(char[] T, int pos, int len) {

        int cnt = 0;

        for (int i = 0; i < len; i++) {

            if (T[pos + i] != '?') {

                T[pos + i] = '?';

                cnt++;
            }
        }

        return cnt;
    }
}