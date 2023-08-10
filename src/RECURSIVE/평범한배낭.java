package RECURSIVE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
	static int[][] stuff;
	static int N,K;
	static int weight = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("평범한배낭.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		stuff = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		recursive(idx, w, v, use);
		recursive(0, 0, 0);
		sb.append(weight);
		System.out.println(sb.toString());
//		print(stuff);
	}

	private static void recursive(int idx, int w, int v) {
		if(idx==N||w>K) {
			if(w<=K) {
				if(v>weight) {
					weight = v;
				}
			}
			return;
		}
		
		recursive(idx+1, w+stuff[idx][0], v+stuff[idx][1]);
		recursive(idx+1, w, v);
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println();
	}

}
