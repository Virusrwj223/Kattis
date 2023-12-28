//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class shopaholic {
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
{ return v>w; }
public static void main (String[] args){
	
		Scanner myReader = new Scanner(System.in);
		String firstLine = myReader.nextLine();
		firstLine.trim();
		int loops = Integer.parseInt(firstLine);
		String secondLine = myReader.nextLine();
		String[] items = secondLine.split(" ");
		int[] items_arr = new int[items.length];
		for (int i = 0; i < loops; i++){
			items_arr[i] = Integer.parseInt(items[i]);
		}
		sort(items_arr,0,items_arr.length-1);
		int counter = 0;
		for (int i = 2; i < loops; i = i + 3){
			counter += items_arr[i];
		}
		System.out.println(counter);
	}

}

