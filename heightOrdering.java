import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class heightOrdering{
    public static int move (int[] a, int height, int pos){
        int counter= 0;
        for (int i = pos; i < a.length; i++){
            int temp = a[i];
            a[i] = height;
            height = temp;
            if (height == 0){
                break;
            }else{
                counter+=1;
            }
        }
        return counter;
    }
    public static int sort (int[] a){
        int N = a.length;
        int[] final_arr = new int[20];
        int counter = 0;
        for (int i = 0; i < N; i++){
            int current_height = a[i];
            for (int j = 0; j < final_arr.length; j++){
                if (current_height > final_arr[j]){
                    int z = move(final_arr, current_height, j);
                    counter+=z;
                    break;
                }
            }
        }
        return counter;
    }
    public static void main (String[] args){
            Scanner myReader = new Scanner(System.in);
            String firstLine = myReader.nextLine();
            firstLine.trim();
            int loops = Integer.parseInt(firstLine);
            for (int i = 0; i < loops; i++){
                String nextLine = myReader.nextLine();
                nextLine.trim();
                String[] dataPoints = nextLine.split(" ");
                int[] heightArr = new int[20];
                for (int j = 0; j < dataPoints.length; j++){
                    if(j == 0){
                        continue;
                    }else{
                        heightArr[dataPoints.length-j-1] = Integer.parseInt(dataPoints[j]);
                    }
                }
                int steps = sort(heightArr);
                System.out.printf("%d %d\n",i+1,steps); 
            }
    }
}
