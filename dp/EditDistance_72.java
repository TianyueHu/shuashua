class EditDistance_72{
	public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        
        int[][] editDist = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i < word2.length() + 1; ++i){
            editDist[0][i] = i;
        }
        for(int i = 0; i < word1.length() + 1; ++i){
            editDist[i][0] = i;
        }
        
        for(int i = 1; i < word1.length() + 1; ++i){
            for(int j = 1; j < word2.length() + 1; ++j){
                int equal = 1;
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    equal = 0;
                editDist[i][j] = min((editDist[i-1][j-1] + equal),
                                    (editDist[i][j-1] + 1),
                                    (editDist[i-1][j] + 1));
            }
        }
        
        return editDist[word1.length()][word2.length()];
    }
    
    private int min(int a, int b, int c){
        return a < b ? (a < c ? a : c ) : ( b < c ? b : c);
    }
}