package RECURSIVE;

import java.util.Scanner;
// 순
public class NM01 {
	public static Scanner sc = new Scanner(System.in);
	public static int N = sc.nextInt();
	public static int M = sc.nextInt();
	public static int[] output = new int[M];
	public static boolean[] sel = new boolean[N];
	
	public static void main(String[] args) {
		
		recursive(0);
	}

	private static void recursive(int number) {
		//basis
		if(number == M) {
			print(output);
			return;
		}
		//inductive
		for (int i = 1; i < N+1; i++) {
			if(sel[i-1]==false) {
				sel[i-1]=true;
				output[number] = i;
				recursive(number+1);
				output[number] = 0;
				sel[i-1]=false;
			}
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