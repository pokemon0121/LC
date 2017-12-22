public class Solution {
    public String[] findWords(String[] words) {
        List<String> str = new ArrayList<>();
        Set<Character> firstRow = new HashSet<>(Arrays.asList(new Character[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'}));
        Set<Character> secondRow = new HashSet<>(Arrays.asList(new Character[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'}));
        Set<Character> thirdRow = new HashSet<>(Arrays.asList(new Character[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'}));
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            int[] letters = new int[26];
            for (char c : lowerWord.toCharArray()) {
                letters[c - 'a']++;
            }
            int flag = 0;
            for (int i = 0; i < 26; i++) {
                if (letters[i] > 0) {
                    if (firstRow.contains((char)(i + 'a'))) {
                        flag |= 1;
                    }
                    else if (secondRow.contains((char)(i + 'a'))) {
                        flag |= 2;
                    }
                    else if (thirdRow.contains((char)(i + 'a'))) {
                        flag |= 4;
                    }
                }
            }
            if (flag == 1 || flag == 2 || flag == 4) {
                str.add(word);
            }
        }
        String[] r = new String[str.size()];
        for (int i = 0; i < str.size(); i++) {
            r[i] = str.get(i);
        }
        return r;
    }
}
​
