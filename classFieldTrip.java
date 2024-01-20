import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class classFieldTrip{
	
	public static char[] merger(String s_1, String s_2, int c1, int c2, int counter, char[] a){
		if (c1>=s_1.length()){
			int cc = counter;
			for (int i = c2; i < s_2.length(); i++){
				a[cc] = s_2.charAt(i);
				cc+=1;
			}
			return a;
		}else if(c2>=s_2.length()){
			int cc = counter;
			for (int i = c1; i < s_1.length(); i++){
				a[cc] = s_1.charAt(i);
				cc+=1;
			}
			return a;
		}else if(s_1.charAt(c1)<=s_2.charAt(c2)){
			a[counter]=s_1.charAt(c1);
			return merger(s_1,s_2,c1+1,c2,counter+1,a);
		}else{
			a[counter] = s_2.charAt(c2);
			return merger(s_1,s_2,c1,c2+1,counter+1,a);
		}
		
	}
	
	public static void main(String[] args){
		try{
			File myObj = new File("classFieldTrip.txt");
			Scanner myReader = new Scanner(myObj);
			String firstLine = myReader.nextLine();
			firstLine.trim();
			/*
			char [] f_arr = new char[firstLine.length()];
			for (int i = 0; i < firstLine.length(); i++){
				f_arr[i] = firstLine.charAt(i);
			}
			*/
			String secondLine = myReader.nextLine();
			secondLine.trim();
			System.out.println(merger(firstLine,secondLine,0,0,0,new char[firstLine.length()+secondLine.length()]));
			/*
			char [] s_arr = new char[secondLine.length()];
			for (int i = 0; i < secondLine.length(); i++){
				s_arr[i] = secondLine.charAt(i);
			}
			char [] sorted_arr = new char[firstLine.length() + secondLine.length()];
			System.out.println(f_arr[1]);
			System.out.println(s_arr.length());
			*/
			//sorted_arr = merger(f_arr,s_arr,0,0,0,new char[f_arr.length() + s_arr.length()]);
			//String output = "";
			//for (int i = 0; i < sorted_arr.length; i++){
			//	output += sorted_arr[i];
			//}
			//System.out.println(output);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
