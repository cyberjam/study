package RECURSIVE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//import java.util.Scanner;
import java.util.StringTokenizer;
// 순
public class NM05 {
	public static int N;
	public static int M;
	public static int[] output;
	public static int[] arr; //원본배열 
	public static boolean[] sel;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
	    for (int i = 0; i < N; i++) {	
	    	arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		output = new int[M];
		sel = new boolean[N];
		Arrays.sort(arr);
		recursive(0);
		bw.flush();
		bw.close();
	}

	private static void recursive(int number) throws IOException {
		//basis
		if(number == M) {
			print(output);
			return;
		}
		//inductive
		for (int i = 0; i < N; i++) {
			if(sel[i]==false) {
				sel[i]=true;
				output[number]=arr[i];
				recursive(number+1);
				output[number]=0;
				sel[i]=false;
			}
			
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