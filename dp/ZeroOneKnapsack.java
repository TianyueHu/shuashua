import java.util.*;
/*
4
5
1500 1
2000 2
3000 4
3000 2
*/
class ZeroOneKnapsack {
	
	class Merchandise{
		private int value;
		private int weight;

		Merchandise(int value, int weight){
			this.value = value;
			this.weight = weight;
		}

		int getValue(){
			return value;
		}

		int getWeight(){
			return weight;
		}
	}

	public Merchandise getMerchandise(int value, int weight){
		return new Merchandise(value, weight);
	}

	public int knapsack(Merchandise[] merchandiseLst, int maxWeight){
		if(merchandiseLst.length < 1) return 0;

		int[][] status = new int[merchandiseLst.length][maxWeight + 1];
		for(int j = 0; j < maxWeight; ++j){
			if(merchandiseLst[0].getWeight() <= j){
				status[0][j] = merchandiseLst[0].getValue();
			}
		}
		for(int i = 1; i < merchandiseLst.length; ++i){
			for(int j = 0; j < maxWeight; ++j){
				getMaxValue(merchandiseLst, status, i, j);
			}
		}
		return status[merchandiseLst.length - 1][maxWeight - 1];
	}

	private int getMaxValue(Merchandise[] merchandiseLst, int[][] status, int number, int weight){
		if (weight - merchandiseLst[number].getWeight() >= 0){
			return status[number][weight] = max(status[number - 1][weight], 
				(status[number - 1][(weight - merchandiseLst[number].getWeight())] + merchandiseLst[number].getValue()));

		}
		return status[number][weight] = status[number - 1][weight];
	}

	private int max(int a, int b){
		return a > b ? a : b;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter the number of merchandises : ");
	    String nStr = sc.nextLine();
	    System.out.print("Enter max weight : ");
	    String wStr = sc.nextLine();

	    int size = Integer.valueOf(nStr);
	    int maxWeight = Integer.valueOf(wStr);

	    ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
	    Merchandise[] lst = new Merchandise[size];

	    for(int i = 0; i < size; ++i){
	      String[] strs = sc.nextLine().split(" ");
	      int value = Integer.valueOf(strs[0]);
	      int weight = Integer.valueOf(strs[1]);
	      ZeroOneKnapsack.Merchandise merchandise = zeroOneKnapsack.getMerchandise(value, weight);
	      lst[i] = merchandise;
		}
		System.out.println("Input finished, please wait...");
		System.out.println(zeroOneKnapsack.knapsack(lst, maxWeight));
	}

}