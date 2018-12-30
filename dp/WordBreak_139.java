class WordBreak_139{
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null) return false;
        int [] record = new int[s.length()];
        for(int i = 0; i < s.length(); ++i){
            record[i] = 0;
        }
        return wordFind(s, wordDict, s.length(), record);
    }
    
    private boolean wordFind(String s, List<String> wordDict, int len, int[] record){
        if (s.length() <= 0) return true;
        boolean flag = false;
        if(record[len - s.length()] != 0){
            return (record[len - s.length()] == 1) ? true : false;
        }
        
        for(int j = 0; !flag && j < wordDict.size(); ++j){
            String word = wordDict.get(j);
            if(!flag && word.length() <= s.length()){
                for(int i = 0; i < word.length(); ++i){
                    if(word.charAt(i) != s.charAt(i)){
                        break;
                    }
                    if(i == word.length() - 1){
                        flag = wordFind(s.substring(word.length(), s.length()), wordDict, len ,record);
                        record[len - s.length()] = flag ? 1 : 2;
                    }
                }
            }
        }
        return flag;
    }
}