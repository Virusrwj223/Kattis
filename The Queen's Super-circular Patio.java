import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class theQueensSuperCircularPatio{
	public static void main(String[] args){

		try{
			File myObj = new File("theQueensSuperCircularPatio.txt");
			Scanner myReader = new Scanner(myObj);
			String firstline = myReader.nextLine();
			firstline.trim();
			int loops = Integer.parseInt(firstline);
			for (int i = 0; i < loops; i++){
				String line = myReader.nextLine();
				line.trim();
				String[] preamble = line.split(" ");
				int data_num = Integer.parseInt(preamble[0]);
				int stones = Integer.parseInt(preamble[1]);
				int rings = Integer.parseInt(preamble[2]);
				double rad = 1.0;
				double outer_rad = 1.0;
				for (int j = 0; j < rings; j++){
					System.out.println(rad);
					System.out.println(outer_rad);
					outer_rad = 0.5*(-(2-8*rad)+Math.sqrt(Math.pow(2-8*rad,2)-4*(1-4*Math.pow(rad,2))));
					rad = rad + 2*outer_rad;
				}

				double perimeter = 2*Math.PI*outer_rad+2*stones*outer_rad;
				System.out.printf("%d %.3f %.3f \n",data_num, outer_rad, perimeter);


			}

		}catch(FileNotFoundException e){
			System.out.println("An error");
			e.printStackTrace();
		}

	}
}






















