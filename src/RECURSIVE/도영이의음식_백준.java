package RECURSIVE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이의음식_백준 {
	static int answer = Integer.MAX_VALUE;
	static int[][] taste;
	static int N;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("도영이의음식.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		recursive(0, 1, 0, 0);
		System.out.println(answer);
//		print(taste);
	}
	private static void recursive(int i, int sour, int sweet, int use) {
		// basis
		if(i==N) {
			if(use==0) { // 아무 재료도 사용하지 않은 경우 연산 필요 없
				return;
			}
			int distance = Math.abs(sour-sweet);
			if(distance<answer) {
				answer = distance;
			}
			return;
		}
		
		
		// inductive
		
		// 해당 턴에서 사용할 것
		recursive(i+1, sour*taste[i][0], sweet+taste[i][1], use+1);
		// 해당 턴에서 사용하지 않을 
		recursive(i+1, sour, sweet, use);
	}
	private static void print(int[][] taste) {
		for (int i = 0; i < taste.length; i++) {
			for (int j = 0; j < taste[0].length; j++) {
				System.out.print(taste[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
