package Questions;
// Questions 7 - 13

import java.util.Scanner;

class b_CodeEditorQuestions {

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

    static void Question7() {//7. FALSE
        System.out.println("\n\n7. The following is an appropriate way to declare a variable as an int.\n\n" +
                "int main()\n" + "{\n" + "int = a;\n" + "return 0;\n" + "}\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'F' || ans == 'f'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question8() {//8. TRUE
        System.out.println("8. The following is an appropriate way to declare a variable as an int.\n\n" +
                "int main()\n" + "{\n" + "int a;\n" + "return 0;\n" + "}\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question9() {//9. TRUE
        System.out.println("9. The following is an appropriate way to declare and initialize a variable as an " +
                "integer.\n\n" + "int main()\n" + "{\n" + "int a = 5;\n" + "return 0;\n" + "}\n\n" + "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question10() {//10. TRUE
        System.out.println("10. The two following codes are equivalent.\n\n" + "\tdouble a, b, c;\n\n" +
                "and\n\n" + "\tdouble a;\n" + "\tdouble b;\n" + "\tdouble c;\n\n" + "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question11() {//11. c. STRING
        System.out.println("11. Which of the following is the appropriate variable type to use with the word " +
                "“float”?\n\n" + "a. word\n" + "b. char\n" + "c. string\n" + "d. float\n\n");
        char ans = MulChoiceAns();
        if(ans == 'C' || ans == 'c'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question12() {//12. d. ;
        System.out.println("12. What is the correct statement ending character in c++?\n\n" +
                "a. :\n" + "b. #\n" + "c. /\n" + "d. ;\n\n");
        char ans = MulChoiceAns();
        if(ans == 'D' || ans == 'd'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question13() {//13. TRUE
        System.out.println("13. The following code will print Arnold Schwarzenegger to the screen.\n\n" +
                "#include <iostream>\n" + "#include <string>\n" + "using namespace std;\n" + "int main ()\n" +
                "{\n" + "string name;\n" + "name = \"Arnold Schwarzenegger\";\n" + "cout << name;\n" +
                "return 0;\n" + "}\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    public static void main(String[] args) {
        Question7();
        Question8();
        Question9();
        Question10();
        Question11();
        Question12();
        Question13();
    }
}
