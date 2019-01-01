class PerfectSquares_279{
	public int numSquares(int n) {
        if(n < 0) return 0;
        int i = (int)Math.sqrt(n);
        int[] preSquNum = new int[i];
        for(int j = 0; j < i; ++j){
            preSquNum[j] = (j + 1) * (j + 1);
        }
        int[] record = new int[n];
        for(int j = 0; j < n; ++j){
            record[j] = -1;
        }
        return findN(n, preSquNum, record);
    }
    
    public int findN(int n, int[] preSquNum, int[] record){
        if(n == 0) return 0;
        if(record[n - 1] != -1)
            return record[n - 1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < preSquNum.length; ++i){
            if(n - preSquNum[i] < 0)
                continue;
            min = Math.min(min, (findN((n - preSquNum[i]), preSquNum, record) + 1));
        }
        return record[n - 1] = min;
    }
}