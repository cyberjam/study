package RECURSIVE;

import java.util.Scanner;
//조합
public class NM02 {
	public static Scanner sc = new Scanner(System.in);
	public static int N = sc.nextInt();
	public static int M = sc.nextInt();
	public static int[] output = new int[M];
	
	public static void main(String[] args) {
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = i+1; j <= N; j++) {
//				System.out.println(i + " " + j);
//			}	
//		}
		recursive(1, 0);
	}

	// idx : 시작 숫
	// number : output index
	private static void recursive(int idx, int number) {
		//basis
		if(number == M) {
			print(output);
			return;
		}
		//inductive
		for (int i = idx; i < N+1; i++) {
			output[number]=i;
			recursive(i+1, number+1);
			output[number]=0;
		}
	}

	private static void print(int[] output) {
		for (int i = 0; i < M; i++) {
			if(i==M-1) {
				System.out.print(output[i]);
			}else {
				System.out.print(output[i]+" ");
			}
		}
		System.out.println();
	}
}