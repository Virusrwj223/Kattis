import java.util.Scanner;
import java.util.Arrays;

public class theCalculusOfAda {
	public static int[] helper (int[] arr){
		int[] result_arr = new int[arr.length-1];
		for (int i = 1; i < arr.length; i++){
			result_arr[i-1] = arr[i]-arr[i-1];
		}
		if (result_arr.length==1 || result_arr[0] == result_arr[1]){
			int[] return_arr = {1,arr[arr.length-1]+result_arr[0]};
			return return_arr;
		}else{
			int[] call = helper(result_arr);
			int[] return_arr = {call[0]+1, arr[arr.length-1]+call[1]};
			return return_arr;
		}
	}
	public static void main (String[] args){
		
			Scanner myReader = new Scanner(System.in);
			String firstLine = myReader.nextLine();
			firstLine.trim();
			String[] items = firstLine.split(" ");
			int loops = Integer.parseInt(items[0]);
			int[] io = new int [items.length-1];
			for (int i = 1; i <= loops; i++){
				io[i-1] = Integer.parseInt(items[i]);
			}
			int []call = helper(io);
			System.out.printf("%d %d", call[0],call[1]);
	}


}
