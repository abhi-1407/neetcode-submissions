class Solution {
    List<Set<Integer>> graph = new ArrayList<>();

    Map<Integer, Integer> indegree = new HashMap<>();

    private boolean populateDict(String w1, String w2) {

        // invalid case

        // example: ["abc", "ab"]

        if (w1.length() > w2.length() && w1.startsWith(w2)) {

            return false;

        }

        int len = Math.min(w1.length(), w2.length());

        for (int i = 0; i < len; i++) {

            char c1 = w1.charAt(i);

            char c2 = w2.charAt(i);

            if (c1 != c2) {

                int u = c1 - 'a';

                int v = c2 - 'a';

                // avoid duplicate edges

                if (!graph.get(u).contains(v)) {

                    graph.get(u).add(v);

                    indegree.put(v, indegree.get(v) + 1);

                }

                // only first differing character matters

                break;

            }

        }

        return true;

    }

    private String makeOrdering() {

        Queue<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        // add all nodes with indegree 0

        for (int node : indegree.keySet()) {

            if (indegree.get(node) == 0) {

                q.offer(node);

            }

        }

        while (!q.isEmpty()) {

            int node = q.poll();

            sb.append((char) (node + 'a'));

            for (int neigh : graph.get(node)) {

                indegree.put(neigh, indegree.get(neigh) - 1);

                if (indegree.get(neigh) == 0) {

                    q.offer(neigh);

                }

            }

        }

        // cycle exists

        if (sb.length() != indegree.size()) {

            return "";

        }

        return sb.toString();

    }

    public String foreignDictionary(String[] words) {

        // initialize graph

        for (int i = 0; i < 26; i++) {

            graph.add(new HashSet<>());

        }

        // initialize all existing characters

        for (String word : words) {

            for (char ch : word.toCharArray()) {

                indegree.putIfAbsent(ch - 'a', 0);

            }

        }

        // build graph

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];

            String w2 = words[i + 1];

            if (!populateDict(w1, w2)) {

                return "";

            }

        }

        return makeOrdering();

    }
}
