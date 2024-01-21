import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class stackingCups{
    private static void sort(String[][] a, int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    private static int partition(String[][] a, int lo, int hi){ 
        int i = lo, j = hi+1;
        float v = Float.parseFloat(a[lo][0]);
        while (true){
            while (Float.parseFloat(a[++i][0])<v) if (i == hi) break;
            while (v<Float.parseFloat(a[--j][0])) if (j == lo) break;
            if (i >= j) break;
            String[] temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        String[] temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }
    public static void main(String[] args){
            Scanner myReader = new Scanner(System.in);
            String firstLine = myReader.nextLine();
            firstLine.trim();
            int loops = Integer.parseInt(firstLine);
            String [][] dictionary = new String[loops][2];
            for (int i = 0; i < loops; i++){
                String nextLine = myReader.nextLine();
                nextLine.trim();
                String[] unparsed = nextLine.split(" ");
                try{
                    float radii = Float.parseFloat(unparsed[0])/2;
                    dictionary[i] = new String[]{Float.toString(radii), unparsed[1]};
                }catch(Exception e){
                    dictionary[i] = new String[]{unparsed[1],unparsed[0]};
                }
            }
            sort(dictionary,0,dictionary.length-1);
            for (int i = 0; i < dictionary.length; i++){
                System.out.println(dictionary[i][1]);
            }
        
    }
}
