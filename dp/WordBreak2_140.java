class WordBreak2_140{
	public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<List<String>> record = new ArrayList<List<String>>();
        if(s == null || wordDict == null) return new ArrayList<String>();
        for(int i = 0; i < s.length(); ++i){
            record.add(null);
        }
        return wordFind(s, wordDict, s.length(), record);
    }
    
    private List<String> wordFind(String s, List<String> wordDict, int len, List<List<String>> record){
        
        List<String> lst = new ArrayList<String>();
        
        if(record.get(len - s.length()) != null){
            return record.get(len - s.length());
        }
        
        for(int j = 0; j < wordDict.size(); ++j){
            String word = wordDict.get(j);
            if(word.length() <= s.length()){
                for(int i = 0; i < word.length(); ++i){
                    if(word.charAt(i) != s.charAt(i)){
                        break;
                    }
                    if(i == word.length() - 1){
                        if(i == s.length() - 1){
                            lst .add(word);
                        }
                        else{
                            List<String> oldLst = wordFind(s.substring(word.length(), s.length()), wordDict, len ,record);
                            for(String ss : oldLst){
                                lst.add(word + " " + ss);
                            }
                        }
                    }
                }
            }
        }
        record.set(len - s.length(), lst);
        return lst;
    }
}