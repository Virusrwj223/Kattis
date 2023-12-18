//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class whatDoesTheFoxSay{
    public static void main(String[] args){
                    
        Scanner myReader = new Scanner(System.in);
        String firstline = myReader.nextLine();
        firstline.trim();
        int loops = Integer.parseInt(firstline);
        for (int i = 0; i < loops; i++){
            String record = myReader.nextLine();
            String bank = myReader.nextLine();
            bank.trim();
            String[] bank_arr = bank.split(" ");
            String trigger = bank_arr[1];
            while (!trigger.equals("does")){
                String sound = bank_arr[2];
                record = record.replace(sound+" ","");
                record = record.replace(" "+sound,"");
                bank = myReader.nextLine();
                bank.trim();
                bank_arr = bank.split(" ");
                trigger = bank_arr[1];
            }
            System.out.println(record);
        }
    }
}
