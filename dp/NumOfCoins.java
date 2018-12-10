public class NumOfCoins{
	
	private static int[] typesOfCoin = {1, 2, 5, 10};
	enum Type{
		MAX,
		MIN
	}

	public int getNumOfCoins(int n, Type type){
		int[] results = new int[n + 1];
		for(int i = 0; i < n + 1; ++i){
			results[i] = -1;
		}
		return getNum(n, type, results);
	}

	private int getNum(int n, Type type, int[] results){
		if(results[n] == -1){
			int size = typesOfCoin.length;
			Record record = (type == Type.MAX ? new MAX() : new MIN());

			for(int i = 0; i < size; ++i){
				int result = 0;
				if(n < typesOfCoin[i])
					continue;
				if(n == typesOfCoin[i])
					record.record(1);
				else{
					record.record(1 + getNum(n - typesOfCoin[i], type, results));
				}
				
			}
			return results[n] = record.getRecord();
		}
		return results[n];
	}

	class MAX implements Record{
		int num = 0;

		public void record(int num){
			if(num > this.num)
				this.num = num;
		}

		public int getRecord(){
			return num;
		}
	}

	class MIN implements Record{
		int num = Integer.MAX_VALUE;
		public void record(int num){
			if(num < this.num)
				this.num = num;
		}

		public int getRecord(){
			return num;
		}
	}

	public static void main(String[] args){
		Type type = Type.MIN;
		int n = 0;
		if(args.length == 1){
			n = Integer.valueOf(args[0]);
		}
		else if(args.length == 2){
			n = Integer.valueOf(args[0]);
			type = (Integer.valueOf(args[0]) == 1 ? Type.MAX : Type.MIN);
		}
		NumOfCoins numOfCoins = new NumOfCoins();
		System.out.println(numOfCoins.getNumOfCoins(n, type));
	}

}