package questions;
// Questions 14 - 19

import java.util.Scanner;

public class c_CodeEditorQuestions {

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


    static void Question14() {//14. C
        System.out.println("14. What will be the output of the following C++ code?\n\n" +

                "#include <iostream>\n"+
                "using namespace std;\n" +
                "int main()\n" + "{\n" +
                "int i, j;\n" +
                "j = 100;\n" +
                "i = (j++, j + 100, 999 + j); \n" +
                "cout << i;\n" +
                "return 0;\n" +
                "}\n\n" +
                "a. 1000\n" +
                "b. 11\n" +
                "c. 1010\n" +
                "d. 1001");

        char ans = MulChoiceAns();

        if(ans == 'C' || ans == 'c'){

            System.out.println("\nCorrect great job!\n");

        }else{

            System.out.println("\nSorry that is incorrect!\n");
        }

    }

    static void Question15() {//15. A
        System.out.println("15. What will be the output of the following C++ code?\n\n" +

                "#include <iostream>\n"+
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "int n;\n" +
                "for (n = 5, n > 0; n--) \n" +
                "}\n\n" +
                "cout << n; \n" +
                "if (n == 3) \n" +
                "break;\n" +
                "}\n\n" +
                "return 0;" +
                "}\n\n" +

                "a. 543\n" +
                "b. 54\n" +
                "c. 5432\n" +
                "d. 53\n");

        char ans = MulChoiceAns();

        if(ans == 'A' || ans == 'a'){

            System.out.println("\nCorrect great job!\n");
        }else{

            System.out.println("\nSorry that is incorrect!\n");
        }

    }

    static void Question16() {//16. A

        System.out.println("16. What will be the output of the following C++ code?\n\n" +

                "#include <iostream>\n"+
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "int i;\n" +
                "for (i = 0, i < 10; i++) \n" +
                "}\n\n" +
                "cout << i; \n" +
                "}\n\n" +
                "return 0;" +
                "}\n\n" +

                "a. 0123456789\n" +
                "b. 10\n" +
                "c. 012345678910\n" +
                "d. error\n");


        char ans = MulChoiceAns();

        if(ans == 'A' || ans == 'a'){

            System.out.println("\nCorrect great job!\n");

        }else{

            System.out.println("\nSorry that is incorrect\n");

        }

    }


    static void Question17() {//17. TRUE

        System.out.println("17. The following code snippet will produce this result.are equivalent.\n\n" +

                "Code Snippet:\n"+
                "cout <<a"+"\\"+"nb"+ "\\"+"nc;\n\n"+
                "Result:\n"+
                "a\n"+
                "b\n"+
                "c\n\n" +
                "a. true\n"+
                "b. False\n\n");

        char ans = TrueFalseAns();

        if(ans == 'T' || ans == 't'){

            System.out.println("\nCorrect great job!\n");

        }else{

            System.out.println("\nSorry that is incorrect\n");

        }

    }


    static void Question18() {//18. d.=

        System.out.println("18. Assigning a variable in C++ can be done using which of the following operators? \n\n" +
                "a. +\n" +
                "b. ==\n" +
                "c. //\n" +
                "d. =\n");

        char ans = MulChoiceAns();

        if(ans == 'D' || ans == 'd'){

            System.out.println("\nCorrect great job!\n");

        }else{

            System.out.println("\nSorry that is incorrect\n");

        }

    }


    static void Question19() {//19. d. ;

        System.out.println("19. What is the result of the following cout statement?\n\n" +

                "#include <iostream>\n"+
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "int a = 5;\n" +
                "a+ = 3;\n" +
                "cout << a; \n" +
                "}\n\n" +

                "a. Error\n" +
                "b. 5\n" +
                "c. 3\n" +
                "d. 8\n");

        char ans = MulChoiceAns();

        if(ans == 'D' || ans == 'd'){

            System.out.println("\nCorrect great job!\n\n");

        }else{

            System.out.println("\nSorry that is incorrect\n\n");

        }

    }


    public static void main(String[] args) {

        Question14();
        Question15();
        Question16();
        Question17();
        Question18();
        Question19();

    }

}