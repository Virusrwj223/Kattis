//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class toiletSeat{
	public static void main(String[] args){
		
			//File myObj = new File("toiletSeat.txt");
			Scanner myReader = new Scanner(System.in);
			String firstline = myReader.nextLine();
			firstline.trim();
			char init = firstline.charAt(0);

			int counter_1 = 0;
			char current = init;
			for (int i = 1; i < firstline.length(); i++){
				char c = firstline.charAt(i);
				if (current != c){
					counter_1+=1;
					current = c;
				}
				if(current!="U".charAt(0)){
					counter_1 += 1;
					current = "U".charAt(0);
				}
			}
			
			int counter_2 = 0;
			char current_2 = init;
		       for (int i = 1; i < firstline.length(); i++){
				char c = firstline.charAt(i);
				if (current_2 != c){
					counter_2 +=1;
					current_2 = c;
				}
				if (current_2 != "D".charAt(0)){
					counter_2 +=1;
					current_2 = "D".charAt(0);
				}
			}

			int counter_3 = 0;
	 		char current_3 = init;
			for (int i = 1; i < firstline.length(); i++){
				char c = firstline.charAt(i);
				if (current_3!= c){
					counter_3 += 1;
					current_3 = c;
				}
			}

			System.out.printf("%d\n%d\n%d",counter_1,counter_2,counter_3);		
	

	}
}
