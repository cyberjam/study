// https://www.acmicpc.net/problem/19942

package RECURSIVE;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 다이어트_백준{
	static int[][] arr;
	static int N;
	static int answer = Integer.MAX_VALUE;
	static int[] minArr;
	static boolean[] result;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("다이어트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 식재료 수
		
		minArr = new int[4]; // 최대 섭취 영양
		result = new boolean[N]; // 최대 섭취 영양
		
		// 입력
		
		// 최소 영양성분 배열 
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j<4; j++) {
			minArr[j] = Integer.parseInt(st.nextToken());
		}
//		print2(minArr);
		
		// 식재료 배열 
		arr = new int[N][5];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(arr);
		
		// 재귀
		// idx, 단백질, 지방, 탄수화물, 비타민, 가격, 사용했는지
		recursive(0, 0, 0, 0, 0, 0, new boolean[N]);
		

		// 출력
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			if(result[i]==true) {
				result2.add(i+1);
			}
		}
		
		Collections.sort(result2);
		
		// -1와 마지막 띄어쓰기  처리를 안해줘서 처음에 틀렸습니다 떴음 
		if(result2.size()==0) {
			System.out.println(-1);
			
		}else {
			System.out.println(answer);
			for (int i = 0; i < result2.size(); i++) {
			
				if(i==result2.size()-1) {
					System.out.print(result2.get(i));
				}else {
					System.out.print(result2.get(i)+" ");
				}

				
			}
		}
		
		
	}
	
	private static void recursive(int idx, int protein, int fat, int kcal, int vita, int price, boolean[] use) {
		// basis
		
		if(protein>=minArr[0] && fat>=minArr[1] && kcal>=minArr[2] && vita>=minArr[3]) {
			if(price < answer) {
				answer = price;
				for (int i = 0; i < use.length; i++) {
					result[i] = use[i];
				}
			}
		}
		
		if(idx==N) {			
			return;
		}
		
		
		/*
		이전 코드
		
		if(idx==N) {
			if(protein>=minArr[0] && fat>=minArr[1] && kcal>=minArr[2] && vita>=minArr[3]) {
				if(price < answer) {
					answer = price;
					for (int i = 0; i < use.length; i++) {
						result[i] = use[i];
					}
				}
			}	
			return;
		}
		
		
		 */
		

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



/*
input 

2
0 0 0 10
0 0 0 10 1
0 0 0 5 0

output
1
1

input
6
100 70 90 10
30 55 10 8 100
60 10 10 2 70
10 80 50 0 50
40 30 30 8 60
60 10 70 2 120
20 70 50 4 4

output
134
2 4 6







*/