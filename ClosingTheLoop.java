import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class closingTheLoop{
	
	private static void sort(int[] a, int lo, int hi){
		if (hi <= lo) return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	private static int partition(int[] a, int lo, int hi){ 
	  int i = lo, j = hi+1;
	  int v = a[lo];
	  while (true){
	  	while (a[++i]>v) if (i == hi) break;
	  	while (v>a[--j]) if (j == lo) break;
	  	if (i >= j) break;
	 	int temp = a[i];
	  	a[i] = a[j];
	  	a[j] = temp;
	  }
	  int temp = a[lo];
	  a[lo] = a[j];
	  a[j] = temp;
	  return j;
	 }
	 
	public static void main(String[] args){

			Scanner myReader = new Scanner(System.in);
			String firstLine = myReader.nextLine();
			firstLine.trim();
			int loops = Integer.parseInt(firstLine);
			for (int j = 0; j < loops; j++){
				String secondLine = myReader.nextLine();
				secondLine.trim();
				int segments = Integer.parseInt(secondLine);
				String thirdLine = myReader.nextLine();
				thirdLine.trim();
				String[] rope_segments_arr = thirdLine.split(" ");
				int[] blue_rope_arr = new int[10];
				int[] red_rope_arr = new int[10];
				int bc = 0;
				int rc = 0;
				char R = 'R';
				for (int i = 0; i < rope_segments_arr.length; i++){
					if (rope_segments_arr[i].charAt(rope_segments_arr[i].length()-1) == R){
						red_rope_arr[rc] = Integer.parseInt(rope_segments_arr[i].substring(0,rope_segments_arr[i].length()-1));
						rc += 1;
					}else{
						blue_rope_arr[bc] = Integer.parseInt(rope_segments_arr[i].substring(0,rope_segments_arr[i].length()-1));
						bc += 1;
					}
				}
				int[] parsed_blue = new int[bc];
				int[] parsed_red = new int[rc];
				for (int i = 0; i < blue_rope_arr.length; i++){
					if (blue_rope_arr[i] == 0){
						break;
					}
					parsed_blue[i] = blue_rope_arr[i];
				}
				for (int i = 0; i < red_rope_arr.length; i++){
					if (red_rope_arr[i] == 0){
						break;
					}
					parsed_red[i] = red_rope_arr[i];
				}
				
				Arrays.sort(parsed_blue);
				Arrays.sort(parsed_red);
				//sort(parsed_blue,0,parsed_blue.length-1);
				//sort(parsed_red,0,parsed_red.length-1);
				int[] final_output_arr = new int [red_rope_arr.length + blue_rope_arr.length];
				for (int i = 0; i < parsed_red.length; i++){
					if (i>=parsed_blue.length){
						break;
					}
					final_output_arr[2*i] = parsed_blue[i];
					final_output_arr[2*i+1] = parsed_red[i];
				}
				int counter = 0;
				for (int i = 0; i < final_output_arr.length; i++){
					if (final_output_arr[i]==0){
						break;
					}
					counter += final_output_arr[i]-1;
				}
				System.out.printf("Case #%d: %d \n",j+1,counter);
				
			}


	}
}
