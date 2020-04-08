package util;

import java.util.Scanner;

public class QuestionType {
    public static char TrueFalseAns() {
        char tfans = 'T';
        do{
            if(tfans != 'T' && tfans != 't' && tfans != 'F' && tfans != 'f'){
                System.out.println("You have entered an invalid character.  Please try again!");
            }
            Scanner tfObj = new Scanner(System.in);
            System.out.println("Enter T for True and F for False:");
            tfans = tfObj.next().charAt(0);
        }while(tfans != 'T' && tfans != 't' && tfans != 'F' && tfans != 'f');
        return tfans;
    }

    public static char MulChoiceAns(){
        char mcans = 'A';
        do{
            if(mcans != 'a' && mcans != 'A' && mcans != 'b' && mcans != 'B' &&
                    mcans != 'c' && mcans != 'C' && mcans != 'd' && mcans != 'D'){
                System.out.println("You have entered an invalid character.  Please try again!");
            }
            Scanner mcObj = new Scanner(System.in);
            System.out.println("Enter (a), (b), (c), or (d):");
            mcans = mcObj.next().charAt(0);
        }while(mcans != 'a' && mcans != 'A' && mcans != 'b' && mcans != 'B' &&
                mcans != 'c' && mcans != 'C' && mcans != 'd' && mcans != 'D');
        return mcans;
    }

}
