import java.util.Arrays;

class LongestCommonSubsequence{
	public static int getLongestCommonSubsequence(char[] strs1, char[] strs2){
		if(strs1.length > 0 && strs2.length > 0){
			int[][] record = new int[strs1.length][strs2.length];

			for(int i = 0; i < strs1.length; ++i){
				record[i][0] = (strs1[i] == strs2[0] ? 1 : 0);
			}

			for(int j = 0; j < strs2.length; ++j){
				record[0][j] = (strs1[0] == strs2[j] ? 1 : 0);
			}
			System.out.println(Arrays.toString(record[0]));
			for(int i = 1; i< strs1.length; ++i){
				for(int j = 1; j < strs2.length; ++j){
					record[i][j] = max((record[i - 1][j - 1] + match(strs1[i], strs2[j])),
						max(record[i-1][j], record[i][j-1]));
				}
				System.out.println(Arrays.toString(record[i]));
			}
			return record[strs1.length - 1][strs2.length - 1];
		}
		return 0;
	}

	private static int max(int a, int b){
		return a >= b ? a : b;
	}

	private static int match(char a, char b){
		return a == b ? 1 : 0;
	}

	public static void main(String[] args){
		if(args.length == 2){
			System.out.println(args[0]+ "," + args[1]);
			char[] strs1 = args[0].toCharArray();
			char[] strs2 = args[1].toCharArray();
			System.out.println(LongestCommonSubsequence.getLongestCommonSubsequence(strs1, strs2));
		}
	}
}