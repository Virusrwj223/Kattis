
import java.util.Scanner;
import java.util.Arrays;

public class basicProgramming{
	public static void merge(int[] a, int lo, int mid, int hi){ 
			// Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid+1;
		int[] aux = new int[a.length];
		for (int k = lo; k <= hi; k++){ // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++){ // Merge back to a[lo..hi].
			if (i > mid){
				a[k]=aux[j++];
			}else if (j > hi ){
				a[k] = aux[i++];
			}else if (less(aux[j], aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
			}
		}
	}
	public static void sort(int[] a, int lo, int hi){ 
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	public static boolean less(int v, int w)
	{ return v<w; }

	public static String one(int[] a){
		String output = "No";
		for (int i = 0; i < a.length; i++){
			int finding_num = 7777 - a[i];
			for (int j = a.length - 1; j >= 0; j = j - 1){
				if(a[j]<finding_num){
					break;
				} else if (a[j]==finding_num){
					output = "Yes";
					break;
				}
			}
			if (output == "Yes"){
				break;
			}
		}
		return output;
	}
	public static String two (int[] a){
		String output = "Unique";
		for (int i = 0; i < a.length-1; i++){
			if (a[i] == a[i+1]){
				output = "contains duplicate";
				break;
			}
		}
		return output;
	}
	public static int three(int[] a){
		int output = -1;
		float half = a.length/2;
		int num = 0;
		int counter = 0;
		for (int i = 0; i < a.length; i++){
			if(a[i]!=num){
				num = a[i];
				counter = 1;
			}else{
				counter += 1;
			}
			if(counter > half){
				output = num;
				break;
			}
		}
		return output;
	}
	public static String four(int[] a){
		if (a.length%2==0){
			int left = a.length/2;
			int right = a.length/2 + 1;
			return Integer.toString(left) + " " + Integer.toString(right);
		}else{
			return Integer.toString(a[(a.length-1)/2]);

		}
	}
	public static String five(int[] a){
		String output = "";
		for (int i = 0; i < a.length; i++){
			if(a[i]>=100 && a[i]<=999){
				output = output + Integer.toString(a[i])+ " ";
			}
		}
		return output;
	}
	public static void main(String[] args){

			//File myObj = new File("basicProgramming.txt");
			Scanner myReader = new Scanner(System.in);
			String firstline = myReader.nextLine();
			firstline.trim();
			String[] raw_items = firstline.split(" ");
			int objects = Integer.parseInt(raw_items[0]);
			int scenario = Integer.parseInt(raw_items[1]);
			String secondline = myReader.nextLine();
			secondline.trim();
			String[] arr_raw_items = secondline.split(" ");
			int[] arr = new int[arr_raw_items.length];
			for (int i = 0; i < arr_raw_items.length; i++){
				arr[i] = Integer.parseInt(arr_raw_items[i]);
			}
			sort(arr, 0, arr.length-1);
			if (scenario == 1){
				System.out.println(one(arr));
			}else if (scenario == 2){
				System.out.println(two(arr));
			}else if(scenario == 3){
				System.out.println(three(arr));
			}else if(scenario == 4){
				System.out.println(four(arr));
			}else{
				System.out.println(five(arr));
			}
		}


	
}
