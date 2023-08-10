package RECURSIVE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Scanner;
import java.util.StringTokenizer;
// 순
public class NM04 {
	public static int N;
	public static int M;
	public static int[] output;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		br.close();
		
		output = new int[M];
		
		recursive(0, 1);
		bw.flush();
		bw.close();
	}

	private static void recursive(int number, int idx) throws IOException {
		//basis
		if(number == M) {
			print(output);
			return;
		}
		//inductive
		for (int i = idx; i < N+1; i++) {
			output[number]=i;
			recursive(number+1, i);
			output[number]=0;
		}
	}

	private static void print(int[] output) throws IOException {
		for (int i = 0; i < M; i++) {
			if(i==M-1) {
				bw.write(output[i]+"\n");
				
			}else {
				bw.write(output[i]+" ");
				
			}
		}
		
	}
}