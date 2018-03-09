class ValidWordAbbr {
    
    private Map<String, Set<String>> abbrToWords;
​
    public ValidWordAbbr(String[] dictionary) {
        abbrToWords = new HashMap<>();
        if (dictionary == null) return;
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (!abbrToWords.containsKey(abbr)) abbrToWords.put(abbr, new HashSet<>());
            abbrToWords.get(abbr).add(word);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        Set<String> words = abbrToWords.get(abbr);
        if (words == null) return true;
        if (words.contains(word)) {
            // this word is in dictionary
            return words.size() == 1;
        }
        return false;
    }
    
    private String getAbbr(String word) {
        if (word == null || word.length() < 3) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}
​
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
​
