class ClimbingStairs_70{
	public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] records = new int[n];
        records[0] = 1;
        records[1] = 2;
        return climbWays(n - 1, records);
        
    }
    
    private int climbWays(int n, int[] records){
        if(records[n] == 0)
            records[n] = climbWays(n-1, records) + climbWays(n-2, records);
        
        return records[n];
    }
}