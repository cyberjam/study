package RECURSIVE;

import java.util.Arrays;

public class Basic {

	public static int N = 4;
	public static int M = 3;
	
	public static void main(String[] args) {
		
		recursive(0, new int[M]);
	}

	private static void recursive(int number, int[] output) {
		//basis
		if(number == M) {
			System.out.println(Arrays.toString(output));
			return;
		}
		//inductive
		for (int i = 1; i < N+1; i++) {
			output[number] = i;
			recursive(number+1, output);
			output[number] = 0;
		}
	}
}
