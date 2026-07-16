class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;
                        String nextWord = new String(arr);

                        if (nextWord.equals(endWord))
                            return level + 1;

                        if (set.contains(nextWord)) {
                            queue.offer(nextWord);
                            set.remove(nextWord); // mark as visited
                        }
                    }

                    arr[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}