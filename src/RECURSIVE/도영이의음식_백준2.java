package RECURSIVE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 도영이의음식_백준2 {
	static int[][] arr;
	static int N;
	static int answer = Integer.MAX_VALUE;
	static int[] minArr;
	static boolean[] result;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("도영이의음식.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 식재료 수
		
		minArr = new int[4]; // 최대 섭취 영양
		result = new boolean[N]; // 최대 섭취 영양
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j<4; j++) {
			minArr[j] = Integer.parseInt(st.nextToken());
		}

		arr = new int[N][5];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// idx, 단백질, 지방, 탄수화물, 비타민, 가격, 사용했는지
		recursive(0, 0, 0, 0, 0, 0, new boolean[N]);
		

		ArrayList<Integer> result2 = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			if(result[i]==true) {
				result2.add(i+1);
			}
		}
		
		Collections.sort(result2);
		if(result2.size()==0) {
			System.out.println(-1);
			
		}else {
			System.out.println(answer);
			for (Integer r : result2) {
				System.out.print(r+" ");
			}
		}
		
		
	}

	

	private static void recursive(int idx, int protein, int fat, int kcal, int vita, int price, boolean[] use ) {
		// basis
		if(idx==N) {
			return;
		}
		
		if(protein>=minArr[0] && fat>=minArr[1] && kcal>=minArr[2] && vita>=minArr[3]) {
			if(price < answer) {
				answer = price;
				for (int i = 0; i < use.length; i++) {
					result[i] = use[i];
				}
			}
		}
			
		// inductive
		// 사용 했을 경우 
		use[idx]= true;
		recursive(idx+1, protein+arr[idx][0], fat+arr[idx][1], kcal+arr[idx][2], vita+arr[idx][3], price+arr[idx][4], use);
		use[idx]= false;
		
		// 사용하지 않았을 경우 
		recursive(idx+1, protein, fat, kcal, vita, price, use);
	}
	
	private static void print2(int[] maxArr2) {
		for (int j = 0; j < maxArr2.length; j++) {
			System.out.print(maxArr2[j]+" ");	
		}
		System.out.println();
	}

	private static void print(int[][] arr1) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				System.out.print(arr1[i][j]+" ");	
			}
			System.out.println();
		}
		System.out.println();
	}

}
