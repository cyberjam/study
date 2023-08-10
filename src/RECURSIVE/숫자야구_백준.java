package RECURSIVE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 숫자야구_백준 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("숫자야구.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		
		// 9*9*9
		int[][] arr = new int[729][3];
		int idx = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int j2 = 1; j2 < 10; j2++) {
					arr[idx][0]=i;
					arr[idx][1]=j;
					arr[idx][2]=j2;
					idx = idx + 1;
					
					
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] inputArr = new int[N][5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			inputArr[i][0] = num/100;
			inputArr[i][1] = (num-inputArr[i][0]*100)/10;
			inputArr[i][2] = num%10;
			inputArr[i][3] = Integer.parseInt(st.nextToken());
			inputArr[i][4] = Integer.parseInt(st.nextToken());
		}
		
		
		
		
		
//		print(inputArr);
		System.out.println(isStrike(arr, inputArr));
		System.out.println(arr[0][0]+" "+inputArr[0][0]);
		
//		print(arr);
	}

	private static int isStrike(int[][] arr, int[][] arr2) {
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if(arr[j]==arr2[j]) {
				count = count + 1;
			}
		}
		return count;
		
	}
	
	private static void isBall(int[][] arr, int[][] arr2) {
		
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
