public class Solution {
    
    private String beginWord, endWord;
    private Map<String, List<String>> beginGraph, endGraph;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null || !wordList.contains(endWord)) return res;
        
        Set<String> dict = new HashSet<>(wordList);
        Set<String> fromStart = new HashSet<>();
        Set<String> fromEnd = new HashSet<>();
        fromStart.add(beginWord);
        fromEnd.add(endWord);
        this.beginWord = beginWord;
        this.endWord = endWord;
        boolean found = false;
        beginGraph = new HashMap<>();
        endGraph = new HashMap<>();
        Set<String> dfsStart = new HashSet<>();
        while (!fromStart.isEmpty() && !fromEnd.isEmpty()) {
            // decide which one we use in this iteration
            Set<String> using = fromStart.size() > fromEnd.size() ? fromEnd : fromStart;
            Set<String> another = using == fromStart ? fromEnd : fromStart;
            // for next level iteration
            Set<String> nextSet = new HashSet<>();
            // the current graph we are building
            Map<String, List<String>> graph = using == fromStart ? beginGraph : endGraph;
            for (String cur : using) {
                char[] ch = cur.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char tmp = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp != c) {
                            ch[i] = c;
                            String s = new String(ch);
                            // found shortest, or in dict, next candidate
                            if (dict.contains(s) || another.contains(s)) {
                                if (another.contains(s)) {
                                    dfsStart.add(s);
                                    found = true;
                                }
                                // this one will appear in next level, but do not remove it from dict now
                                nextSet.add(s);
                                if (!graph.containsKey(s)) {
                                    graph.put(s, new ArrayList<>());
                                }
                                // next -> cur, construct graph
                                graph.get(s).add(cur);
                            }
                        }
                    }
                    ch[i] = tmp;
                }
            }
            if (using == fromStart) {
                fromStart = nextSet;
            }
            else {
                fromEnd = nextSet;
            }
            // remove all here
            dict.removeAll(nextSet);
            if (found) break;
        }
        for (String cur : dfsStart) {
            LinkedList<String> path = new LinkedList<>();
            // start from middle, append to head/tail in two directions
            path.add(cur);
            // source -> end first, then source -> start
            dfs(res, path, cur, cur, true);
        }
        return res;
    }
    
    private void dfs(List<List<String>> res, LinkedList<String> path, String cur, String source, boolean beginToEnd) {
        if (cur.equals(beginWord) && !beginToEnd) {
            res.add(new LinkedList<>(path));
        }
        else if (cur.equals(endWord) && beginToEnd) {
            dfs(res, path, source, source, false);
        }
        else {
            List<String> nexts = beginToEnd ? endGraph.get(cur) : beginGraph.get(cur);
            // add next to path. we have current one; add it in main method
            for (String next : nexts) {
                if (beginToEnd) {
                    path.addLast(next);
                    dfs(res, path, next, source, beginToEnd);
                    path.removeLast();
                }
                else {
                    path.addFirst(next);
                    dfs(res, path, next, source, beginToEnd);
                    path.removeFirst();
                }
            }
        }
    }
}
​
