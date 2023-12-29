
import java.util.Scanner;

public class beehives{
	public static void main(String[] args){

			Scanner myReader = new Scanner(System.in);
			String firstLine = myReader.nextLine();
			firstLine.trim();
			String[] items = firstLine.split(" ");
			float f_dist = Float.parseFloat(items[0]);
			int loops = Integer.parseInt(items[1]);
			while (f_dist!=0.0 && loops!=0){
				String secondLine = myReader.nextLine();
				secondLine.trim();
				String[] init_items = secondLine.split(" ");
				float x = Float.parseFloat(init_items[0]);
				float y = Float.parseFloat(init_items[1]);
				int sour = 0;
				int not_sour = 0;
				for (int i = 1; i < loops; i++){
					String thirdLine = myReader.nextLine();
					thirdLine.trim();
					String[] coords = thirdLine.split(" ");
					float new_x = Float.parseFloat(coords[0]);
					float new_y = Float.parseFloat(coords[1]);
					if(((new_x-x>f_dist)||(new_x-x<-f_dist))&&((new_y-y>f_dist)||(new_y-y<-f_dist))){
						if(sour==0 && not_sour==0){
							not_sour=1;
						}
						not_sour+=1;
					}else{
						if(sour==0 && not_sour==0){
							sour=1;
						}
						sour+=1;
					}
					x = new_x;
					y = new_y;	
				}
				System.out.printf("%d sour, %d sweet\n",sour,not_sour);
				String fourthLine = myReader.nextLine();
				fourthLine.trim();
				String[] n_items = fourthLine.split(" ");
				f_dist = Float.parseFloat(n_items[0]);
				loops = Integer.parseInt(n_items[1]);

			}



	}
}

