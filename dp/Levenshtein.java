import java.util.Arrays;
class Levenshtein{
	public static int getDistance(char[] strs1, char[] strs2){

		if(strs1.length > 0 && strs2.length > 0){
			int[][] record = new int[strs1.length + 1][strs2.length + 1];
			distanceInit(strs1, strs2, record);
			for(int i = 1; i < strs1.length + 1; ++i){
				for(int j = 1; j < strs2.length + 1; ++j){
					record[i][j] = min((record[i-1][j-1] + match(strs1[i - 1],strs2[j - 1])), 
						min(record[i-1][j] + 1, record[i][j-1] + 1));
				}
			}
			for(int i = 0; i < strs1.length; ++i){
				System.out.println(Arrays.toString(record[i]));
			}
			
			return record[strs1.length - 1][strs2.length - 1];
		}
		return 0;
	}

	private static void distanceInit(char[] strs1, char[] strs2, int[][] record){
		record[0][0] = 0;

		for(int i = 1; i < strs1.length + 1; ++i){
			record[i][0] = record[i - 1][0] + 1;
		}

		for(int i = 1; i < strs2.length + 1; ++i){
			record[0][i] = record[0][i - 1] + 1;
		}
	}

	private static int min(int a, int b){
		return a < b ? a : b;
	}

	private static int match(char a, char b){
		return a == b ? 0 : 1;
	}

	public static void main(String[] args){
		if(args.length == 2){
			char[] strs1 = args[0].toCharArray();
			char[] strs2 = args[1].toCharArray();
			System.out.println(Levenshtein.getDistance(strs1, strs2));
		}
	}

}